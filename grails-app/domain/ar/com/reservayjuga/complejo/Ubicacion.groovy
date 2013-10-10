package ar.com.reservayjuga.complejo

class Ubicacion {

	String direccion
	String barrio
	String localidad
	String provincia
	String pais
	
	static belongsTo = Complejo
	
	static constraints = {
		direccion blank: false
		barrio blank: false
		localidad blank: false
		provincia blank: false
		pais blank: false
	}

	static mapping = { table "UBICACION" }
	
	@Override
	String toString() {
		"${direccion}, ${barrio}, ${localidad}"
	}
}