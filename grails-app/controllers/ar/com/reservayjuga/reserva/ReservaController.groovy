package ar.com.reservayjuga.reserva

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.complejo.Cancha
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.usuario.Jugador

class ReservaController {


	def reservarCancha = {
		
		render(view: "reservar-cancha", model: [])
	}
	
	def administrarReservas = {
		
		render(view: "administrar-reservas", model: [])
	}


}