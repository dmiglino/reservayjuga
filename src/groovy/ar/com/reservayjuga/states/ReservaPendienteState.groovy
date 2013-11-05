package ar.com.reservayjuga.states

/**
 * Representa una reserva que todavia no se seño ni se pago
 */
class ReservaPendienteState extends ReservaState {
	
	Boolean isPendiente() {
		true
	}

}