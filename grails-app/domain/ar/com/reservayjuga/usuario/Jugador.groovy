package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.seguridad.SecUser;

class Jugador extends SecUser {
	
	String nombre
	String apellido
	String telefono
	String mail
	String sexo
	Date fechaNacimiento 
	
	static hasMany = [reservas : Reserva]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		telefono blank: false
		mail email:true, blank: false
		sexo blank: true
		fechaNacimiento nullable: true
    }
	
//	static mapping = { table "JUGADOR" }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
	
	void agregarReserva(Reserva reserva) {
		addToReservas(reserva)
	}
	
}