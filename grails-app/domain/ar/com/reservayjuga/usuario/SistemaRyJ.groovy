package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo;

class SistemaRyJ {

	String nombreUsuario
	String clave

	static constraints = {
		nombreUsuario blank: false
		clave blank: false
	}

	static mapping = { table "USUARIO" }
	
	@Override
	String toString() {
		"${nombreUsuario}"
	}
}