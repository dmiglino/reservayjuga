package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.common.GenericService;
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.ubicacion.UbicacionService
import ar.com.reservayjuga.usuario.Encargado
import ar.com.reservayjuga.utils.DBUtils;

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
}