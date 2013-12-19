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
		jugador.nombre = params.nombre
		jugador.apellido = params.apellido
		jugador.telefono = params.telefono
		jugador.mail = params.mail
		jugador.sexo = params.sexo
		DBUtils.validateAndSave(jugador)
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