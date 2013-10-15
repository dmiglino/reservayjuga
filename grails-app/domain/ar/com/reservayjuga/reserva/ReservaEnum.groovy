package ar.com.reservayjuga.reserva;

import ar.com.reservayjuga.states.ReservaConcretadaState
import ar.com.reservayjuga.states.ReservaPendienteState
import ar.com.reservayjuga.states.ReservaSeniadaState
import ar.com.reservayjuga.states.ReservaState

public enum ReservaEnum {
	
	PENDIENTE(new ReservaPendienteState()),
	SENIADA(new ReservaSeniadaState()),
	CONCRETADA(new ReservaConcretadaState())
	
	private ReservaState value
	
	ReservaEnum(ReservaState rs) {
		this.value = rs
	}
	
	Boolean isPendiente() {
		this.value.isPendiente()
	}
	
	Boolean isSeniada() {
		this.value.isSeniada()
	}
	
	Boolean isConcretada() {
		this.value.isConcretada()
	}
} 