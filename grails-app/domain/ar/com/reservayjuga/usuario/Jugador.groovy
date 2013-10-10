package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo;

class Jugador {
	
	String nombre
	String apellido
	String telefono
	String mail
	String clave
	String sexo
	Date fechaNacimiento 
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		telefono blank: false
		mail blank: false
		clave blank: false
		sexo blank: true
		fechaNacimiento nullable: true
    }
	
	static mapping = { table "JUGADOR" }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
}