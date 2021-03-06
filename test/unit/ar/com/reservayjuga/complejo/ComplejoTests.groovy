package ar.com.reservayjuga.complejo


import grails.test.mixin.*

import org.junit.*

import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion

@TestFor(Complejo)
class ComplejoTests {

    void testConstraints() {
		Complejo complejo = new Complejo ()
		complejo.webSite = ""
		complejo.nombre = ""
		assertFalse complejo.validate()
		assertTrue complejo.hasErrors()
		assertNull complejo.save()
		assertEquals "blank", complejo.errors["nombre"].code
	//	assertEquals "nullable", complejo.errors["webSite"].code
		assertEquals "nullable", complejo.errors["telefono1"].code
		assertEquals "nullable", complejo.errors["mail"].code
		assertEquals "nullable", complejo.errors["informacionExtra"].code
		assertEquals "nullable", complejo.errors["ubicacion"].code
		assertEquals "nullable", complejo.errors["servicios"].code
		assertNull complejo.errors["telefono2"]
		assertNull complejo.errors["telefono3"]
		assertNull complejo.errors["telefono4"]
		assertNull complejo.errors["webSite"]
		assertNull complejo.errors["horarios"]
		assertNull complejo.errors["imagenes"]
		assertNull complejo.errors["canchas"]
    }
	
	void testAtributes() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: hora)
		
		assertTrue complejo.validate()
		assertEquals "Garden Club", complejo.nombre
		assertEquals "", complejo.webSite
		assertEquals "4574-0077", complejo.telefono1
		assertEquals "garden@mail.com", complejo.mail
		assertEquals "Info garden", complejo.informacionExtra
		assertEquals "Pedro Moran 2379", complejo.ubicacion.direccion
		assertEquals "Agronomia", complejo.ubicacion.barrio.nombre
		assertEquals "Capital Federal", complejo.ubicacion.localidad.nombre
		assertEquals "Buenos Aires", complejo.ubicacion.provincia.nombre
		assertEquals "Argentina", complejo.ubicacion.pais.nombre
		assertEquals 1, complejo.horarios.size()
		assertTrue complejo.servicios.vestuario
		assertEquals false, complejo.servicios.television
		
		assertNull complejo.reservas
		complejo.agregarReserva(new Reserva())
		assertEquals 1, complejo.reservas.size()
	}

	
	void testToString() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: hora)		
		assertEquals "Garden Club", complejo.toString()
	}
	
	void testHorarios() {
		Horario lunes = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "22:00")
		Horario martes = new Horario (dia: 2, horarioApertura: "10:00", horarioCierre: "22:00")
		Horario miercoles = new Horario (dia: 3, horarioApertura: "10:00", horarioCierre: "22:00")
		Horario jueves = new Horario (dia: 4, horarioApertura: "10:00", horarioCierre: "22:00")
		Horario viernes = new Horario (dia: 5, horarioApertura: "10:00", horarioCierre: "22:00")
		Horario sabado = new Horario (dia: 6, horarioApertura: "10:00", horarioCierre: "24:00")
		Horario domingo = new Horario (dia: 7, horarioApertura: "9:00", horarioCierre: "24:00")
		Horario feriados = new Horario (dia: 8, horarioApertura: "11:00", horarioCierre: "19:00")
		Horario verga = new Horario (dia: 229, hoarioApertura: "11:00", horarioCierre:"14:00")
		
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [])
		
		complejo.agregarHorario(lunes);
		complejo.agregarHorario(martes);
		complejo.agregarHorario(miercoles);
		complejo.agregarHorario(jueves);
		complejo.agregarHorario(viernes);
		complejo.agregarHorario(sabado);
		complejo.agregarHorario(domingo);
		complejo.agregarHorario(feriados);
		
		assertEquals 8, complejo.horarios.size()
		assertTrue complejo.hasHorario(lunes)
		assertTrue complejo.hasHorario(martes)
		assertTrue complejo.hasHorario(miercoles)
		assertTrue complejo.hasHorario(jueves)
		assertTrue complejo.hasHorario(viernes)
		assertTrue complejo.hasHorario(sabado)
		assertTrue complejo.hasHorario(domingo)
		assertTrue complejo.hasHorario(feriados)
		assertFalse complejo.hasHorario(verga)
	}
	
	void testCanchas() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [], canchas: [])
		
		Cancha cancha1 = new Cancha(nombre:"Cancha 1", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[])
		Cancha cancha2 = new Cancha(nombre:"Cancha 2", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_CAUCHO, cantidadJugadores:5, cubierta: true, precios:[])
		Cancha cancha3 = new Cancha(nombre:"Cancha 3", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:8, cubierta: true, precios:[])
		
		complejo.agregarCancha(cancha1)
		complejo.agregarCancha([cancha2,cancha3])
		
		assertEquals 3, complejo.canchas.size()
	}
}