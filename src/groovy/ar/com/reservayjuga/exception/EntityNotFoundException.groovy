package ar.com.reservayjuga.exception

import grails.validation.ValidationErrors

class EntityNotFoundException extends ReservaYJugaException {
	
	EntityNotFoundException(def entityName, def id) {
		super("No se encontraron ningun/a <${entityName}> para el id <${id}>");
	}
	
	void setDefaultValues() {
		error = "entity_not_found_error"
		status = 404
	}}