package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.reserva.ReservaService
import ar.com.reservayjuga.ubicacion.UbicacionService
import ar.com.reservayjuga.usuario.Encargado
import ar.com.reservayjuga.utils.DBUtils
import ar.com.reservayjuga.utils.Utils

class ComplejoService extends GenericService<Complejo> {
	
	UbicacionService ubicacionService
	ServiciosService serviciosService
	ExtrasService extrasService
	HorarioService horarioService
	ImagenService imagenService
	
	@Override
	def getDomain() {
		Complejo
	}
	
	/**
	 * Crea el complejo a partir de los datos pasados por parametro
	 * @param values, ubicacion, servicios, extras, horarios, imagenes
	 * @return complejo creado
	 */
    def createComplejo(def map, def ubicacion, def servicios, def extras, def horarios, def imagenes) {
		Complejo complejo = new Complejo(nombre:map.nombre, webSite:map.webSite, telefono1:map.telefono, mail:map.mail, informacionExtra:map.info, porcentajeSenia:map.porcSenia, ubicacion: ubicacion, servicios: servicios, extras: extras, horarios: horarios, imagenes: imagenes)
		DBUtils.validateAndSave(complejo)
		return complejo
    }

	/**
	 * Actualiza los datos del complejo
	 * @param complejo, datos
	 * @return complejo actualizado
	 */
	def actualizarDatosComplejo(Complejo complejo, def datos) {
		validate(complejo)

		// datos generales
		complejo.properties = datos

		// datos de ubicacion
		if(datos.ubicacion) {
			ubicacionService.guardarUbicacionDelComplejo(complejo, datos.ubicacion)
		}
		
		// datos de servicios
		if(complejo.servicios) {
			complejo.servicios.properties = datos.servicios
		}
		
		// datos de extras
		if(complejo.extras) {
			complejo.extras.properties = datos
		}
		
		//datos de horarios
		if(datos.horarios) {
			if(!complejo.horarios) {
				complejo.horarios = []
			}
			horarioService.guardarHorariosParaComplejo(complejo, datos.horarios)
		}
		
		DBUtils.validateAndSave(complejo)
	}
	
	/**
	 * Crea una nueva imagen y la guarda en el complejo
	 * @param complejo
	 * @param imagenData
	 */
	def crearImagenParaComplejo(complejo, imagenData) {
		validate(complejo)
		Imagen imagen
		if(imagenData) {
			if(!complejo.imagenes) {
				complejo.imagenes = []
			}
			imagen = imagenService.crearImagenParaComplejo(complejo, imagenData)
		}
		return imagen
	}
	
	/**
	 * Elimina la imagen indicada del complejo y de la BD 
	 * @param complejo
	 * @param imagenId
	 */
	void eliminarImagenDelComplejo(Complejo complejo, def imagenId) {
		validate(complejo)
		def imagenInstance = imagenService.findEntityById(imagenId)
		if(!imagenInstance) {
			throw new EntityNotFoundException("Imagen", imagenId)
		}
		complejo.eliminarImagen(imagenInstance)
	}
	
	/**
	 * Agrega una imagen al complejo
	 * @param complejo
	 * @param imagen
	 */
	void agregarImagen(Complejo complejo, Imagen imagen) {
		validate(complejo)
		if(imagen) {
			if(!complejo.imagenes) {
				complejo.imagenes = []
			}
			complejo.agregarImagen(imagen)
		}
	}
	
	/**
	 * Agrega una cancha al complejo
	 * @param complejo
	 * @param cancha
	 */
	void agregarCancha(Complejo complejo, Cancha cancha) {
		validate(complejo)
		if(cancha) {
			if(!complejo.canchas) {
				complejo.canchas = []
			}
			complejo.agregarCancha(cancha)
		}
	}
	
	/**
	 * Elimina la imagen indicada del complejo y de la BD
	 * @param complejo
	 * @param imagenId
	 */
	void eliminarCancha(Complejo complejo, Cancha cancha) {
		validate(complejo)
		complejo.eliminarCancha(cancha)
	}
	
	/**
	 * Elimina la imagen indicada del complejo y de la BD
	 * @param complejo
	 * @param imagenId
	 */
	void eliminarReserva(Complejo complejo, Reserva reserva) {
		validate(complejo)
		complejo.eliminarReserva(reserva)
	}
	
	void eliminarTodasLasImagenesDelComplejo(Complejo complejo) {
		validate(complejo)
		complejo.imagenes?.clear()
	}
	
	/**
	 * @param complejo
	 * @param params
	 * @return imagenes del complejo listas para paginacion
	 */
	def getImagenesDelComplejo(Complejo complejo, def params) {
		validate(complejo)
		imagenService.getImagenesDelComplejo(complejo, params)
	}
	
	/**
	 * @param complejo
	 * @return cantidad total de imagenes del complejo
	 */
	def countTotal(Complejo complejo) {
		validate(complejo)
		imagenService.countTotal(complejo)
	}
	
	/**
	 * Recupera las canchas del complejo para el listado y el numero total de ellas para el paginado
	 * @param complejo
	 * @return map [canchas, canchasTotal]
	 */
	def getImagenesYCantidad(Complejo complejo, def params, def encargadoId) {
		def imagenes, imagenesTotal
		
		if(complejo == null) {
			complejo = getComplejoDelEncargado(encargadoId)
		}
		
		if(complejo) {
			imagenes = getImagenesDelComplejo(complejo, params)
			imagenesTotal = countTotal(complejo)
		} else {
			throw new EntityNotFoundException("Complejo", encargadoId)
		}
		
		return [imagenes:imagenes, imagenesTotal:imagenesTotal]
	}
	
	void validate(Complejo complejo) {
		if(!complejo) {
			throw new EntityNotFoundException("Complejo", 0)
		}
	}
	
	def getComplejoDelEncargado(def encargadoId) {
		def complejo
		Encargado encargado = Encargado.get(encargadoId)
		if(encargado) {
			complejo = encargado.complejo
		} else {
			throw new EntityNotFoundException("Encargado", encargadoId)
		}
		return complejo
	}
	
	def getHorariosDisponiblesParaFecha(String fechaStr, def complejoId, ReservaService reservaService) {
//		parsear fecha en dd mm yyyy y crear Date con los datos parseados
		Date fecha = Utils.crearFechaByString(fechaStr)
		
//		obtener dia de la semana del date
		Integer diaDeLaSemana = Utils.getDayOfWeek(fechaStr)
		
//		obtener complejo segun id
		Complejo complejo = findEntityById(complejoId)
		
		def horariosOcupados = []
		def horariosConfigurados = []
		
		if(complejo) {
			//	obtener horarios configurados para ese complejo en ese dia de la semana
			def horarioConfiguradoComplejo = complejo.getHorariosDelDia(diaDeLaSemana)
			horariosConfigurados = splitearHorariosPorHora(horarioConfiguradoComplejo)
			
			//	obtener reservas que tiene el complejo confirmadas para esa fecha
			def reservasRealizadas = reservaService.getReservasConcretadasOSeniadasParaComplejoEnFecha(complejo, fecha)
			
			// si hay al menos 1 cancha libre, el horario no se tiene que marcar como ocupado
			if(complejo.canchas) {
				horariosOcupados = checkearHorariosOcupados(complejo.canchas.size(), reservasRealizadas)
			}
		}
		
//		devolver un map con todos los horarios y los horarios disponibles
		def resp = [horariosConfigurados: horariosConfigurados, horariosOcupados: horariosOcupados]
		return resp
	}

	protected def splitearHorariosPorHora(def horarioConfiguradoComplejo) {
		List horariosConfigurados = []
		horarioConfiguradoComplejo.each {
			def horarioApertura = it.horarioApertura ? it.horarioApertura.split(":")[0].toInteger() : -1 
			def horarioCierre = it.horarioCierre ? it.horarioCierre.split(":")[0].toInteger() : -1
			if(horarioApertura >= 0 && horarioCierre >= 0) {
				[horarioApertura..horarioCierre-1].each { horarioRange ->
					horarioRange.each { horario ->
						horariosConfigurados.add(formatearHorario(horario))
					}
				}
			}
		}
		return horariosConfigurados.sort { it }
	}
	
	protected def formatearHorario(List horarios) {
		List horariosFormateados
		horarios.each {
			horariosFormateados.add(formatearHorario(it))
		}
	}
	
	protected def formatearHorario(def horario) {
		(horario < 10 ? "0"+horario.toString() : horario.toString()) + ":00 - " + (horario+1).toString() + ":00"
	}
	
	def checkearHorariosOcupados(cantidadCanchas, reservasRealizadas) {
		def horariosOcupados = []
		reservasRealizadas.each {
			if(cantidadCanchas == it[2]) {
				println "El complejo tiene ${cantidadCanchas} canchas y hay ${it[2]} reservas para las ${it[0]} horas. El horario esta todo OCUPADO"
				horariosOcupados.add(it[0] + " - " + it[1])
			} else {
				println "El complejo tiene ${cantidadCanchas} canchas y hay ${it[2]} reservas para las ${it[0]} horas. El horario tiene cancha LIBRE"
			}
		}
		return horariosOcupados
	}
	
	def getCanchasDisponiblesParaHorario(String fechaStr, def complejoId, def horarioStr, ReservaService reservaService) {
//		parsear fecha en dd mm yyyy y crear Date con los datos parseados
		Date fecha = Utils.crearFechaByString(fechaStr)
		
		//parsear horario para obtener el string de la hora de inicio del mismo
		def horarioSplit = horarioStr.split(" - ")
		
//		obtener complejo segun id y las canchas que tiene
		Complejo complejo = findEntityById(complejoId)
		def canchas = complejo.canchas
		
//		obtener reservas que tiene el complejo confirmadas para esa fecha y horario
		def reservasRealizadas = reservaService.getReservasByComplejoFechaAndHora(complejo, fecha, horarioSplit[0])
		
//		matchear horarios con reservas para ver cual esta disponible y cual no
		def canchasReservadas = reservasRealizadas.collect { it.cancha }
		
		// me quedo solo con las canchas que no tienen reservas
		canchas.removeAll(canchasReservadas)
		
		// devuelvo solo una cancha por tipo
//		def tiposCanchas = getDiferentesTiposDeCanchas(canchasLibres)
		
//		devolver un map con todos los horarios y los horarios disponibles
		def resp = [canchas: canchas]
		return resp
	}
	
	def getDiferentesTiposDeCanchas(canchasLibres) {
		// TODO
		canchasLibres
	}
}