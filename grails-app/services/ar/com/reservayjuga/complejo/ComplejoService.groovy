package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.DBUtils

class ComplejoService {

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
	def actualizarDatosComplejo(Complejo complejo, def datos, def horarios, def imagenes) {
		
//		// datos generales
		complejo.properties = datos
//		complejo.nombre = datos.nombre
//		complejo.webSite = datos.webSite
//		complejo.telefono1 = datos.telefono
//		complejo.mail = datos.mail
//		complejo.informacionExtra = datos.info
//		complejo.porcentajeSenia = datos.porcSenia

		// datos de ubicacion
		if(complejo.ubicacion) {
			complejo.ubicacion.barrio.localidad.provincia.pais.nombre = datos.pais
			complejo.ubicacion.barrio.localidad.provincia.nombre = datos.provincia
			complejo.ubicacion.barrio.localidad.nombre = datos.localidad
			complejo.ubicacion.barrio.nombre = datos.barrio
			complejo.ubicacion.direccion = datos.direccion
		}
		
		// datos de servicios
		if(complejo.servicios) {
			complejo.servicios.properties = datos
//			complejo.servicios.vestuario = datos.vestuario
//			complejo.servicios.television = datos.television
//			complejo.servicios.bebida = datos.bebida
//			complejo.servicios.comida = datos.comida
//			complejo.servicios.ayudaMedica = datos.ayudaMedica
//			complejo.servicios.torneo = datos.torneo
//			complejo.servicios.wifi = datos.wifi
//			complejo.servicios.gimnasio = datos.gimnasio
//			complejo.servicios.estacionamiento = datos.estacionamiento
//			complejo.servicios.precioEstacionamiento = datos.precioEstacionamiento
		}
		
		// datos de extras
		if(complejo.extras) {
			complejo.extras.properties = datos
//			complejo.extras.quiereArbitro = datos.quiereArbitro
//			complejo.extras.quierePechera = datos.quierePechera
//			complejo.extras.precioArbitro = datos.precioArbitro
//			complejo.extras.precioPechera = datos.precioPechera
		}
		
//		//datos de horarios
//		if(complejo.horarios) {
//			complejo.horarios.clear()
//			complejo.horarios.addAll(horarios)
//		}
//		Horario horario = complejo.horarios.find{dia == 1}
//		if(horario) {
//			horario.horarioApertura = datos.lunesDesde
//			horario.horarioCierre = datos.lunesHasta
//		}
//		horario = complejo.horarios.find{dia == 2}
//		if(horario) {
//			horario.horarioApertura = datos.martesDesde
//			horario.horarioCierre = datos.martesHasta
//		}
//		horario = complejo.horarios.find{dia == 3}
//		if(horario) {
//			horario.horarioApertura = datos.miercolesDesde
//			horario.horarioCierre = datos.miercolesHasta
//		}
//		horario = complejo.horarios.find{dia == 4}
//		if(horario) {
//			horario.horarioApertura = datos.juevesDesde
//			horario.horarioCierre = datos.juevesHasta
//		}
//		horario = complejo.horarios.find{dia == 5}
//		if(horario) {
//			horario.horarioApertura = datos.viernesDesde
//			horario.horarioCierre = datos.viernesHasta
//		}
//		horario = complejo.horarios.find{dia == 6}
//		if(horario) {
//			horario.horarioApertura = datos.sabadoDesde
//			horario.horarioCierre = datos.sabadoHasta
//		}
//		horario = complejo.horarios.find{dia == 7}
//		if(horario) {
//			horario.horarioApertura = datos.domingoDesde
//			horario.horarioCierre = datos.domingoHasta
//		}
//		horario = complejo.horarios.find{dia == 8}
//		if(horario) {
//			horario.horarioApertura = datos.feriadoDesde
//			horario.horarioCierre = datos.feriadoHasta
//		}
//		
//		//datos de imagenes
//		if(complejo.imagenes) {
//			complejo.imagenes.clear()
//			complejo.imagenes.addAll(imagenes)
//		}
		
		DBUtils.validateAndSave(complejo)
	}
	
}