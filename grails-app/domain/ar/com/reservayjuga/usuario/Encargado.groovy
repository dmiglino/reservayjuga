package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.seguridad.SecUser;

class Encargado extends SecUser {

	String nombre
	String apellido
	
	static belongsTo = [complejo : Complejo]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		complejo nullable: true
    }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
	
}