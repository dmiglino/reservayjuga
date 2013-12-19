package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.utils.DBUtils
import ar.com.reservayjuga.utils.Utils

class JugadorService extends GenericService<Jugador> {

	@Override
	def getDomain() {
		Jugador
	}

	def actualizarDatosDelJugador(params) {
		Jugador jugador = findEntityById(params.jugadorId)
		jugador = setProperties(jugador, params)
		DBUtils.validateAndSave(jugador)
		println "Jugador ${jugador} actualizado correctamente."
	}

	def crearNuevoJugador(params) {
		Jugador jugador = new Jugador()
		jugador = setProperties(jugador, params)
		jugador.username = params.mail
		jugador.password = params.nombre + params.apellido + "123"
		DBUtils.validateAndSave(jugador)
		println "Jugador ${jugador} creado correctamente."
	}
	
	def setProperties(jugador, params) {
		jugador.nombre = params.nombre
		jugador.apellido = params.apellido
		jugador.telefono = params.telefono
		jugador.mail = params.mail
		jugador.sexo = params.sexo
		jugador.fechaNacimiento = Utils.crearFechaByString(params.datePicker)
		return jugador
	}
	
	def findByEMailOrDni(def emaildni) {
		Jugador jugador
		if (Utils.isMail(emaildni)) {
			jugador = Jugador.findByMail(emaildni)
		} else if(Utils.onlyNumbers(emaildni)) {
			jugador = Jugador.findByDni(emaildni)
		} else {
			println "ERROR tipo de dato del parametro"
		}
		return jugador
	}
}