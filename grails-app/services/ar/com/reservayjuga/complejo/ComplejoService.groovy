package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.ubicacion.Barrio

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
	def actualizarDatosComplejo(Complejo complejo, def datos) {
		
//		// datos generales
		println "complejo.porcentajeSenia 1: " + complejo.porcentajeSenia
		complejo.properties = datos
		println "complejo.porcentajeSenia 2: " + complejo.porcentajeSenia
//		complejo.nombre = datos.nombre
//		complejo.webSite = datos.webSite
//		complejo.telefono1 = datos.telefono1
//		complejo.mail = datos.mail
//		complejo.informacionExtra = datos.info
//		complejo.porcentajeSenia = datos.porcSenia

		// datos de ubicacion
		if(complejo.ubicacion) {
			if(datos.barrio?.id) {
				Barrio barrioSeleccionado = Barrio.findById(datos.barrio.id)
				println "barrioSeleccionado: " + barrioSeleccionado
				complejo.ubicacion.barrio = barrioSeleccionado
			}
			complejo.ubicacion.direccion = datos.direccion
//			println "complejo.ubicacion.direccion: " +complejo.ubicacion.direccion
		}
		
		// datos de servicios
		if(complejo.servicios) {
			complejo.servicios.properties = datos.servicios
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
		if(datos.horarios) {
			if(!complejo.horarios) {
				complejo.horarios = []
			}
			println "complejo.horarios 1: ${complejo.horarios}"
			for(int eachDia = 1; eachDia <= 8; eachDia++) {
				println "horario del dia ${eachDia}: ${datos.horarios[eachDia.toString()]}"
				Horario horario = complejo.horarios.find{it.dia == eachDia}
				def datosHorariosDia = datos.horarios[eachDia.toString()]
				if(horario) {
					horario.horarioApertura = datosHorariosDia.apertura
					horario.horarioCierre = datosHorariosDia.cierre
					println "horaro ${horario} ACTUALIZADO"
				} else {
					horario = new Horario(dia:eachDia, horarioApertura: datosHorariosDia.apertura, horarioCierre: datosHorariosDia.cierre)
					println "horaro ${horario} CREADO"
					complejo.agregarHorario(horario)
				}
			}
			println "complejo.horarios 2: ${complejo.horarios}"
		}
		
//		
//		//datos de imagenes
//		if(complejo.imagenes) {
//			complejo.imagenes.clear()
//			complejo.imagenes.addAll(imagenes)
//		}
		
		DBUtils.validateAndSave(complejo)
	}
	
}