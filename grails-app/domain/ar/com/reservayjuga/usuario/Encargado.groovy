package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo

class Encargado extends Usuario {

	String nombre
	String apellido
	
	static belongsTo = [complejo : Complejo]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		complejo nullable: false
    }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
}