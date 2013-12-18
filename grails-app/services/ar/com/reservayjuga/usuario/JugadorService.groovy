package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.common.GenericService;
import ar.com.reservayjuga.complejo.Cancha;
import ar.com.reservayjuga.utils.DBUtils;

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

}