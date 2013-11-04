package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo;
import ar.com.seguridad.SecUser

class SistemaRyJ extends SecUser {
	
	String mail
//	String nombreUsuario
//	String clave

	static constraints = {
		mail email:true, blank: false
//		nombreUsuario blank: false
//		clave blank: false
	}

//	static mapping = { table "USUARIO" }
	
	@Override
	String toString() {
		"${username}"
	}
}