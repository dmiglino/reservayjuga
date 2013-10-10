package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo

class Encargado {

	String nombre
	String apellido
	Complejo complejo
	String nombreUsuario
	String clave
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		nombreUsuario blank: false
		clave blank: false
		complejo nullable: false
    }
}
