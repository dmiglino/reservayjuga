package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.ubicacion.UbicacionService

class ComplejoService {
	
	UbicacionService ubicacionService
	ServiciosService serviciosService
	ExtrasService extrasService
	HorarioService horarioService
	ImagenService imagenService
	
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
	void crearImagenParaComplejo(complejo, imagenData) {
		if(imagenData) {
			if(!complejo.imagenes) {
				complejo.imagenes = []
			}
			imagenService.crearImagenParaComplejo(complejo, imagenData)
		}
	}
	
	/**
	 * Elimina la imagen indicada del complejo y de la BD 
	 * @param complejo
	 * @param imagenId
	 */
	void eliminarImagenDelComplejo(Complejo complejo, def imagenId) {
		def imagenInstance = imagenService.findEntityById(imagenId)
		if(!imagenInstance) {
			throw new EntityNotFoundException("Imagen", imagenId)
		}
		complejo.eliminarImagen(imagenInstance)
	}
	
	void editarImagen(def datos) {
		imagenService.editarImagen(datos)
	}
}