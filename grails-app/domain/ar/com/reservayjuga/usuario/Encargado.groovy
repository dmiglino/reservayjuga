package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.complejo.Complejo

class Encargado {

	String nombre
	String apellido
	String mail
	String nombreUsuario
	String clave
	
	static belongsTo = [complejo : Complejo]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		nombreUsuario blank: false
		mail email:true, blank: false
		clave size: 6..8, blank: false
		complejo nullable: false
    }
	
	static mapping = { table "USUARIO" }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
}