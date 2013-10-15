package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.reserva.Reserva

class Jugador {
	
	String nombre
	String apellido
	String telefono
	String mail
	String clave
	String sexo
	Date fechaNacimiento 
	
	static hasMany = [reservas : Reserva]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		telefono blank: false
		mail email:true, blank: false
		clave size: 6..8, blank: false
		sexo blank: true
		fechaNacimiento nullable: true
    }
	
	static mapping = { table "JUGADOR" }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
	
	void agregarReserva(Reserva reserva) {
		addToReservas(reserva)
	}
	
}