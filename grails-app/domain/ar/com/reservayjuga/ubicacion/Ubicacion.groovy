package ar.com.reservayjuga.ubicacion

import ar.com.reservayjuga.complejo.Complejo;

class Ubicacion {

	String direccion
	Barrio barrio
	
	static belongsTo = Complejo
	
	static constraints = {
		direccion blank: false
		barrio nullable: false
	}

	static mapping = { 
		table "UBICACION" 
		barrio lazy:false
	}

	@Override
	String toString() {
		"${direccion}, ${barrio}, ${getLocalidad()}"
	}
	
	Localidad getLocalidad() {
		this.barrio?.localidad
	}
	
	Provincia getProvincia() {
		getLocalidad()?.provincia
	}
	
	Pais getPais() {
		getProvincia()?.pais
	}
}