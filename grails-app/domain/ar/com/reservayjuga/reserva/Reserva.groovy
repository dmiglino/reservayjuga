package ar.com.reservayjuga.reserva

import ar.com.reservayjuga.complejo.Cancha
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.states.ReservaPendienteState
import ar.com.reservayjuga.states.ReservaState
import ar.com.reservayjuga.usuario.Jugador

class Reserva {

	Complejo complejo
	Jugador jugador
	Cancha cancha
	Date dia
	String horaInicio
	String horaFin
	Float senia
	Float precioTotal
	TipoReservaEnum tipoReserva //online o presencial
	ReservaEnum estado = ReservaEnum.PENDIENTE // pendiente, señada, concretada

	static constraints = {
		complejo nullable: false
		jugador nullable: false
		cancha nullable: false
		dia nullable: false
		horaInicio blank: false
		horaFin blank: false
		senia nullable: false
		precioTotal nullable: false
		tipoReserva blank: false
		estado nullable: false
	}

	static mapping = { table "RESERVA" }
	
	@Override
	String toString() {
		"Reserva del jugador ${jugador} para la cancha ${cancha}"
	}
	
	def faltaPagar() {
		precioTotal - senia
	}
	
	Boolean isPendiente() {
		this.estado.isPendiente()
	}
	
	Boolean isSeniada() {
		this.estado.isSeniada()
	}
	
	Boolean isConcretada() {
		this.estado.isConcretada()
	}
	
	Boolean isCancelada() {
		this.estado.isCancelada()
	}
	
	/**
	 * Se seña la reserva y se pasa a estado señada
	 */
	void seniar() {
		this.estado = ReservaEnum.SENIADA
	}
	
	/**
	 * Se paga la totalidad de la reserva y se pasa a estado concretada
	 */
	void concretar() {
		this.estado = ReservaEnum.CONCRETADA
	}
	
	/**
	 * Se cancela la reserva y se pasa a estado cancelada
	 */
	void cancelar() {
		this.estado = ReservaEnum.CANCELADA
	}
}