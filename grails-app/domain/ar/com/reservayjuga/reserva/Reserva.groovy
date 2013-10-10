package ar.com.reservayjuga.reserva

import ar.com.reservayjuga.complejo.Cancha
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.usuario.Jugador

class Reserva {

	Complejo complejo
	Jugador jugador
	Cancha cancha
	Date dia
	String horaInicio
	String horaFin
	Float senia
	Float precioTotal
	String tipoReserva //online o presencial
//	ReservaState estado // pendiente, señada, concretada
	
    static constraints = {
    }
}
