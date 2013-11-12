package ar.com.reservayjuga.reserva


class ReservaController {
	
	def authenticationService
	ReservaService reservaService
	
	def index() {
		redirect(action: administrarReservas)
	}
	
	def reservarCancha = {
		render(view: "reservar-cancha", model: [])
	}
	
	def administrarReservas = {
		render(view: "administrar-reservas", model: [])
	}
	
	/**
	 * Busca el jugador segun el id para mostrar en el modal panel
	 */
	def selectJugadorToShow = {
		// TODO hacer jugadorService
		Reserva jugadorToShow = reservaService.getReservaById(params.id)
		render(template:"modal-box-jugador", model:[reserva:jugadorToShow])
	}
	
	/**
	 * Busca la reserva segun el id para mostrar en el modal panel
	 */
	def selectToEdit = {
		Reserva reservaToEdit = reservaService.getReservaById(params.id)
		redirect(action: administrarReservas, model: reservaToEdit)
	}
}