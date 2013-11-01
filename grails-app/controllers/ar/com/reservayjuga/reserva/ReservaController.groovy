package ar.com.reservayjuga.reserva

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.complejo.Cancha
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.usuario.Jugador

class ReservaController {

	def index() {
		redirect(action: administrarReservas)
	}

	def administrarReservas = {
		
		render(view: "reservar-cancha", model: [])
	}
	
	def reservarCancha = {
		
		render(view: "reservar-cancha", model: [])
	}

}