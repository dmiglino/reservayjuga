package ar.com.reservayjuga.reserva

import org.hibernate.Criteria
import org.hibernate.criterion.Order
import org.hibernate.criterion.Projections
import org.hibernate.criterion.Restrictions

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.complejo.CanchaService
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.ComplejoService
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.exception.InvalidReservaStatusException
import ar.com.reservayjuga.usuario.Jugador
import ar.com.reservayjuga.usuario.JugadorService
import ar.com.reservayjuga.utils.DBUtils
import ar.com.reservayjuga.utils.Utils

class ReservaService extends GenericService<Reserva> {

	ComplejoService complejoService
	CanchaService canchaService
	JugadorService jugadorService
	
	@Override
	def getDomain() {
		Reserva
	}

	def crearReservaPresencial(Complejo complejo) {
		new Reserva(complejo:complejo, tipoReserva:TipoReservaEnum.PRESENCIAL)
	}	
	
	/**
	 * Recupera las canchas del complejo para el listado y el numero total de ellas para el paginado
	 * @param complejo
	 * @return map [canchas, canchasTotal]
	 */
	def getReservasYCantidad(Complejo complejo, def params, def encargadoId) {
		def reservas, reservasTotal
		
		if(complejo == null) {
			complejo = complejoService.getComplejoDelEncargado(encargadoId)
		}
		
		if(complejo) {
			reservas = getReservasDelComplejo(complejo, params)
			reservasTotal = reservas.size() < 10 ? reservas.size() : countTotal(complejo, params)
		} else {
			throw new EntityNotFoundException("Complejo", encargadoId)
		}
		
		return [reservas:reservas, reservasTotal:reservasTotal]
	}
	
	/**
	 * @param complejo
	 * @param params
	 * @return canchas del complejo listas para paginacion
	 */
	protected def getReservasDelComplejo(Complejo complejo, def params) {
		def max = Math.min(params.max ? params.int('max') : 10, 100)
		def offset = Math.min(params.offset ? params.int('offset') : 0, 100)
		def sortProperty = params.sort ? params.sort : "dia"

		def criter = Reserva.createCriteria()
			.add(Restrictions.eq("complejo", complejo))
			.addOrder(Order.desc(sortProperty))
			.setFirstResult(offset)
			.setMaxResults(max)
			
		criter = aplicarFiltros(criter, params)
		
		criter.list()
	}
	
	/**
	 * Aplica los filtros de busqueda al criteria
	 * @param criter
	 * @param params
	 * @return criter
	 */
	protected def aplicarFiltros(def criter, def params) {
		if(params.tipoReservaFilter) {
			def tipoReservaFilter = params.tipoReservaFilter as TipoReservaEnum
			criter.add(Restrictions.eq("tipoReserva", tipoReservaFilter))
		}
		
		if(params.estadoReservaFilter) {
			def estadoFilter = params.estadoReservaFilter as ReservaEnum
			criter.add(Restrictions.eq("estado", estadoFilter))
		}
		
		if(params.canchaReservaFilter) {
			def canchaFilter = canchaService.findEntityById(params.canchaReservaFilter)
			criter.add(Restrictions.eq("cancha", canchaFilter))
		}
		
		if(params.hour && params.minute) {
			criter.add(Restrictions.eq("horaInicio", params.hour+":"+params.minute))
		}
		
		if(params.dateRangePicker) {
			def split = params.dateRangePicker.split(" - ")
			def fechaDesde = new Date().parse("MM/dd/yyyy", split[0])
			def fechaHasta = new Date().parse("MM/dd/yyyy", split[1])
			criter.add(Restrictions.ge("dia", fechaDesde))
			criter.add(Restrictions.lt("dia", fechaHasta))
		}
		
		return criter
	}
	
	/**
	 * @param complejo
	 * @return cantidad total de canchas del complejo
	 */
	protected def countTotal(Complejo complejo, def params) {
		Criteria criter = Reserva.createCriteria()
			.add(Restrictions.eq("complejo", complejo))
		
		criter = aplicarFiltros(criter, params)
		
		criter.list().size()
	}
	
	/**
	 * Elimina la cancha indicada del complejo y de la BD
	 * @param complejo
	 * @param canchaId
	 */
	void eliminarReservaDelComplejo(Complejo complejo, def reservaId) {
		def reservaInstance = findEntityByIdAndValidate(reservaId)
		complejoService.eliminarReserva(complejo, reservaInstance)
	}
	
	/**
	 * Busca un jugador por su email o su dni
	 * @param emaildni
	 * @return jugador
	 */
	def buscarJugador(emaildni) {
		Jugador jugador = jugadorService.findByEMailOrDni(emaildni)
		if(!jugador) {
			throw new EntityNotFoundException("Jugador", emaildni)
		}
		return jugador
	}
	
	/**
	 * Se pasa la reserva al estado SEÑADA
	 * @param reserva
	 */
	void seniar(Reserva reserva) {
		if(reserva.isPendiente()) {
			reserva.seniar()
		} else {
			throw new InvalidReservaStatusException(reserva.estado)
		}
	}
	
	/**
	 * Se pasa la reserva al estado CONCRETADA
	 * @param reserva
	 */
	void concretar(Reserva reserva) {
		if(reserva.isPendiente() || reserva.isSeniada()) {
			reserva.concretar()
			reserva.senia = reserva.precioTotal
		} else {
			throw new InvalidReservaStatusException(reserva.estado)
		}
	}
	
	/**
	 * Se pasa la reserva al estado CANCELADA
	 * @param reserva
	 */
	void cancelar(Reserva reserva) {
		// TODO falta validar estados posibles
		reserva.cancelar()
	}
	
	/**
	 * Obtiene el complejo del encargado logueado
	 * @param encargadoId
	 * @return
	 */
	def getComplejoDelEncargado(def encargadoId) {
		// TODO pasar a EncargadoService? 
		complejoService.getComplejoDelEncargado(encargadoId)
	}
	
	def getHorariosDisponiblesParaFecha(String fecha, def complejoId) {
		complejoService.getHorariosDisponiblesParaFecha(fecha, complejoId, this)
	}
	
	def getCanchasDisponiblesParaHorario(String fecha, def complejoId, def horario) {
		complejoService.getCanchasDisponiblesParaHorario(fecha, complejoId, horario, this)
	}
	
	/**
	 * obtener reservas que tiene el complejo confirmadas para esa fecha
	 * @param complejo
	 * @param fecha
	 * @return reservas
	 */
	def getReservasConcretadasOSeniadasParaComplejoEnFecha(Complejo complejo, Date fecha) {
		def criter = Reserva.createCriteria()
			.add(Restrictions.eq("complejo", complejo))
			.add(Restrictions.ge("dia", fecha))
			.add(Restrictions.lt("dia", fecha+1))
			.add(Restrictions.or(
				Restrictions.eq("estado", ReservaEnum.CONCRETADA),
				Restrictions.eq("estado", ReservaEnum.SENIADA)
			))
			.setProjection( Projections.projectionList()
				.add( Projections.groupProperty("horaInicio"), "horaInicio" )
				.add( Projections.property("horaFin"), "horaFin" )
				.add( Projections.rowCount(), "cantidadReservas" )
			)
			
		criter.list()
	}
	
	/**
	 * obtener reservas que tiene el complejo confirmadas para esa fecha y horario
	 * @param complejo
	 * @param fecha
	 * @param hora
	 * @return reservas
	 */
	def getReservasByComplejoFechaAndHora(complejo, fecha, hora) {
		def criter = Reserva.createCriteria()
			.add(Restrictions.eq("complejo", complejo))
			.add(Restrictions.eq("horaInicio", hora))
			.add(Restrictions.ge("dia", fecha))
			.add(Restrictions.lt("dia", fecha+1))
			.add(Restrictions.or(
				Restrictions.eq("estado", ReservaEnum.CONCRETADA),
				Restrictions.eq("estado", ReservaEnum.SENIADA)
			))
			
		criter.list()
	}
	
	def actualizarDatosDelJugador(params) {
		jugadorService.actualizarDatosDelJugador(params)
	}
	
	def agregarDatosALaReserva(Reserva reserva, def params) {
		if(reserva) {
			def jugadorId = params.jugadorId
			if(jugadorId) {
				reserva.jugador = jugadorService.findEntityById(jugadorId)
			}
			
			def reservaDateText = params.reservaDateText
			if(reservaDateText) {
				reserva.dia = Utils.crearFechaByString(reservaDateText)
			}
			
			def reservaHorario = params.reservaHorario
			if(reservaHorario) {
				def horarios = reservaHorario.split(" - ")
				reserva.horaInicio = horarios[0]
				reserva.horaFin = horarios[1]
			}
			
			def reservaCanchaId = params.reservaCanchaId
			if(reservaCanchaId) {
				reserva.cancha = canchaService.findEntityById(reservaCanchaId)
			}

			if(reserva.cancha && reserva.horaInicio && reservaDateText) {
				def dayOfWeek = Utils.getDayOfWeek(reservaDateText)
				reserva.precioTotal = canchaService.getPrecio(dayOfWeek, reserva.horaInicio, reserva.cancha)
			}
			
			def reservaSenia = params.reservaSenia
			if(reservaSenia) {
				reserva.senia = reservaSenia.toFloat()
			} else {
				reserva.senia = 0
			}
			
		}
	}

	def	generarReserva(reserva, params) {
		if(reserva) {
			def reservaSenia = params.reservaSenia
			if(reservaSenia) {
				reserva.senia = reservaSenia.toFloat()
			} else {
				reserva.senia = 0
			}
			
			//TODO chequear que la cancha siga disponible para este horario
			reserva.seniar();
			DBUtils.validateAndSave(reserva)
			println "Se ha generado la ${reserva} y marcado como señada."
		}
	}
	
}