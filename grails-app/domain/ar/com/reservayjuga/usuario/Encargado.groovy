package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.seguridad.SecUser

/**
 * Representa al encargado del complejo
 */
class Encargado extends SecUser {

	String nombre
	String apellido
	String mail
	
	static belongsTo = [complejo : Complejo]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		mail email:true, blank: false
		complejo nullable: true
    }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
	
}