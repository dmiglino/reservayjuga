package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.seguridad.SecUser

/**
 * Representa al jugador que utilizara el sistema para reservar canchas.
 */
class Jugador extends SecUser {
	
	String nombre
	String apellido
	String telefono
	String mail
	String sexo
	Long dni
	Date fechaNacimiento 
	
	static hasMany = [reservas : Reserva]
	
    static constraints = {
		nombre blank: false
		apellido blank: false
		telefono blank: false
		mail email:true, blank: false
		sexo blank: true
		dni nullable: true
		fechaNacimiento nullable: true
    }
	
	@Override
	String toString() {
		"${nombre} ${apellido}"
	}
	
	void agregarReserva(Reserva reserva) {
		addToReservas(reserva)
	}
	
	boolean isHombre() {
		sexo == "M"
	}
	
	boolean isMujer() {
		sexo == "F"
	}
	
	String getFechaNacimientoString() {
		fechaNacimiento.format("dd-MM-yyyy")
	}
}