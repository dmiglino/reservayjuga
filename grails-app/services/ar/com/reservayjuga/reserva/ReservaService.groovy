package ar.com.reservayjuga.reserva

import org.hibernate.criterion.Order
import org.hibernate.criterion.Restrictions

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.complejo.CanchaService
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.ComplejoService
import ar.com.reservayjuga.exception.EntityNotFoundException

class ReservaService extends GenericService<Reserva> {

	ComplejoService complejoService
	CanchaService canchaService
	
	@Override
	def getDomain() {
		Reserva
	}
	
	/**
	 * Obtiene la Reserva segun el id indicado
	 * @param id
	 * @return
	 */
	def getReservaById(id) {
		id ? Reserva.get(id) : null
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
			reservasTotal = countTotal(complejo)
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
		def sortProperty = params.sort ? params.sort : "cancha"

		def criter = Reserva.createCriteria()
			.add(Restrictions.eq("complejo", complejo))
			.addOrder(Order.asc(sortProperty))
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
			def canchaFilter = canchaService.getCanchaById(params.canchaReservaFilter)
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
	protected def countTotal(Complejo complejo) {
		Reserva.createCriteria().count {
			eq('complejo', complejo)
		}
	}
	
	/**
	 * Elimina la cancha indicada del complejo y de la BD
	 * @param complejo
	 * @param canchaId
	 */
	void eliminarReservaDelComplejo(Complejo complejo, def reservaId) {
		def reservaInstance = findEntityById(reservaId)
		if(!reservaInstance) {
			throw new EntityNotFoundException("Reserva", reservaId)
		}
		complejoService.eliminarReserva(complejo, reservaInstance)
	}
	
	/**
	 * Se pasa la reserva al estado SEÑADA
	 * @param reserva
	 */
	void seniar(Reserva reserva) {
		// TODO falta validar estados posibles
		reserva.seniar()
	}
	
	/**
	 * Se pasa la reserva al estado CONCRETADA
	 * @param reserva
	 */
	void concretar(Reserva reserva) {
		// TODO falta validar estados posibles
		reserva.concretar()
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
}