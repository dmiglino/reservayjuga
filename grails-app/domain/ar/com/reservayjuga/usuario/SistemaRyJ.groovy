package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo;
import ar.com.reservayjuga.seguridad.SecUser


/**
 * Nos representa a nosotros, los administradores del sistema.
 */
class SistemaRyJ extends SecUser {
	
	String mail

	static constraints = {
		mail email:true, blank: false
	}
	
	@Override
	String toString() {
		"${username}"
	}

}