package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo

class Encargado {

	String nombre
	String apellido
	String nombreUsuario
	String clave
	
	static belongsTo = [complejo : Complejo]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		nombreUsuario blank: false
		clave blank: false
		complejo nullable: false
    }
	
	static mapping = { table "USUARIO" }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
}