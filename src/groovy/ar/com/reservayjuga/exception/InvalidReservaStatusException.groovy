package ar.com.reservayjuga.exception

import grails.validation.ValidationErrors

class InvalidReservaStatusException extends ReservaYJugaException {
	
	InvalidReservaStatusException(def estado) {
		super("Estado incorrecto. No se puede señar una reserva en estado ${estado}");
	}
	
	void setDefaultValues() {
		error = "invalid_reserva_status_error"
		status = 404
	}}