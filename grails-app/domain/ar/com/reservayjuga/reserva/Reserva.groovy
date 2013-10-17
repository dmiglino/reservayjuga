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
	
	Boolean isPendiente() {
		this.estado.value.isPendiente()
	}
	
	Boolean isSeniada() {
		this.estado.value.isSeniada()
	}
	
	Boolean isConcretada() {
		this.estado.value.isConcretada()
	}
	
	void seniar() {
		this.estado = ReservaEnum.SENIADA
	}
	
	void concretar() {
		this.estado = ReservaEnum.CONCRETADA
	}
}