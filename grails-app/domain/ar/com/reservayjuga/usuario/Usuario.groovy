package ar.com.reservayjuga.usuario

abstract class Usuario {

	String mail
	String nombreUsuario
	String clave

	static constraints = {
		nombreUsuario blank: false
		mail email:true, blank: false
		clave size: 6..8, blank: false
	}
	
	static mapping = { table "USUARIO" }
	
	@Override
	String toString() {
		"${nombreUsuario}"
	}

}