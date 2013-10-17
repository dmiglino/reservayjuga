package ar.com.reservayjuga.reserva



import grails.test.mixin.*

import org.junit.*

import ar.com.reservayjuga.complejo.Cancha
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.DeporteEnum
import ar.com.reservayjuga.complejo.SuperficieEnum
import ar.com.reservayjuga.usuario.Jugador

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Reserva)
class ReservaTests {

    void testConstraints() {
		Reserva reserva = new Reserva()
		assertFalse reserva.validate()
		assertTrue reserva.hasErrors()
		assertNull reserva.save()
		assertEquals "nullable", reserva.errors["horaInicio"].code
		assertEquals "nullable", reserva.errors["horaFin"].code
		assertEquals "nullable", reserva.errors["tipoReserva"].code
		assertEquals "nullable", reserva.errors["precioTotal"].code
		assertEquals "nullable", reserva.errors["senia"].code
		assertEquals "nullable", reserva.errors["cancha"].code
		assertEquals "nullable", reserva.errors["jugador"].code
		assertEquals "nullable", reserva.errors["complejo"].code
		assertEquals "nullable", reserva.errors["dia"].code
    }
	
	void testAtributes() {
		Jugador jugador = new Jugador(nombre:"Diego", apellido:"Miglino", telefono:"12345678", mail:"d@m.com", clave:"1234567", sexo:"M")
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[])
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		
		Reserva reserva = new Reserva (horaInicio: "10:00", horaFin: "22:00", tipoReserva:TipoReservaEnum.ONLINE, precioTotal:500, senia:50, dia: new Date(), cancha: cancha, complejo: complejo, jugador: jugador)
		assertTrue reserva.validate()
		assertEquals "10:00", reserva.horaInicio
		assertEquals "22:00", reserva.horaFin
		assertEquals TipoReservaEnum.ONLINE, reserva.tipoReserva
		assertEquals 500, reserva.precioTotal
		assertEquals 50, reserva.senia
		assertEquals "Diego Miglino", reserva.jugador.toString()
		assertEquals "Poli-1 - FUTBOL (5)", reserva.cancha.toString()
		assertEquals "Garden Club", reserva.complejo.toString()
		assertTrue reserva.estado.isPendiente()
		assertFalse reserva.estado.isSeniada()
		assertFalse reserva.estado.isConcretada()
	}

	void testToString() {
		Jugador jugador = new Jugador(nombre:"Diego", apellido:"Miglino", telefono:"12345678", mail:"d@m.com", clave:"1234567", sexo:"M")
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[])
		Complejo complejo = new Complejo(nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		
		Reserva reserva = new Reserva(horaInicio: "10:00", horaFin: "22:00", tipoReserva:"Online", precioTotal:500, senia:50, dia: new Date(), cancha: cancha, complejo: complejo, jugador: jugador)
		assertEquals "Reserva del jugador Diego Miglino para la cancha Poli-1 - FUTBOL (5)", reserva.toString()
	}
	
	void testStates() {
		Jugador jugador = new Jugador(nombre:"Diego", apellido:"Miglino", telefono:"12345678", mail:"d@m.com", clave:"1234567", sexo:"M")
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[])
		Complejo complejo = new Complejo(nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		Reserva reserva = new Reserva(horaInicio: "10:00", horaFin: "22:00", tipoReserva:"Online", precioTotal:500, senia:50, dia: new Date(), cancha: cancha, complejo: complejo, jugador: jugador)
		
		assertTrue reserva.isPendiente()
		assertFalse reserva.isSeniada()
		assertFalse reserva.isConcretada()
		
		reserva.seniar()
		
		assertFalse reserva.isPendiente()
		assertTrue reserva.isSeniada()
		assertFalse reserva.isConcretada()
		
		reserva.concretar()
		
		assertFalse reserva.isPendiente()
		assertFalse reserva.isSeniada()
		assertTrue reserva.isConcretada()
	}
}