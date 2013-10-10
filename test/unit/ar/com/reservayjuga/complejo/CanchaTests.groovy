package ar.com.reservayjuga.complejo

import grails.test.mixin.*

import org.junit.*

@TestFor(Cancha)
class CanchaTests {
	
	void testConstraints() {
		Cancha cancha = new Cancha()
		assertFalse cancha.validate()
		assertTrue cancha.hasErrors()
		assertNull cancha.save()
		assertEquals "nullable", cancha.errors["nombre"].code
		assertEquals "nullable", cancha.errors["deporte"].code
		assertEquals "nullable", cancha.errors["superficie"].code
		assertEquals "nullable", cancha.errors["cantidadJugadores"].code
		assertEquals "nullable", cancha.errors["cubierta"].code
		assertEquals "nullable", cancha.errors["complejo"].code
	}

	void testAtributes() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Servicios serv1 = new Servicios(vestuario: true, television: false, bebida: true, comida: true, ayudaMedica: false, torneo: false, wifi: true, gimnasio: false, estacionamiento: true)
		Ubicacion u1 = new Ubicacion(direccion: "Casa", barrio: "VP", localidad: "CABA", provincia: "BsAs", pais: "Argentina")
		Complejo poli = new Complejo(nombre: "Poli",webSite: "www.poli.com",telefono1: "41112222",mail: "poli@poli.com",informacionExtra: "soy el poli",ubicacion: u1,servicios:serv1)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[precio], complejo:poli)
		
		assertTrue cancha.validate()
		assertEquals "Poli-1", cancha.nombre
		assertEquals DeporteEnum.FUTBOL, cancha.deporte
		assertEquals SuperficieEnum.SINTETICO_CON_ARENA, cancha.superficie
		assertEquals 5, cancha.cantidadJugadores
		assertTrue cancha.cubierta
		assertEquals 1, cancha.precios.size()
		assertEquals "Poli", cancha.complejo.nombre
		assertEquals "Casa", cancha.complejo.ubicacion.direccion
		assertTrue cancha.complejo.servicios.vestuario
	}
	
	void testToString() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Servicios serv1 = new Servicios(vestuario: true, television: false, bebida: true, comida: true, ayudaMedica: false, torneo: false, wifi: true, gimnasio: false, estacionamiento: true)
		Ubicacion u1 = new Ubicacion(direccion: "Casa", barrio: "VP", localidad: "CABA", provincia: "BsAs", pais: "Argentina")
		Complejo poli = new Complejo(nombre: "Poli",webSite: "www.poli.com",telefono1: "41112222",mail: "poli@poli.com",informacionExtra: "soy el poli",ubicacion: u1,servicios:serv1)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[precio], complejo:poli)
		assertEquals "Poli-1 - FUTBOL (5)", cancha.toString()
	}
	
	void testPrecios() {
		Precio l3 = new Precio(dia:1, horarioInicio: "12:00", precio: 300)
		Precio l4 = new Precio(dia:1, horarioInicio: "13:00", precio: 300)
		Precio m1 = new Precio(dia:2, horarioInicio: "17:00", precio: 300)
		Precio m2 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		Precio mi3 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		Precio mi4 = new Precio(dia:3, horarioInicio: "13:00", precio: 300)
		Precio j1 = new Precio(dia:4, horarioInicio: "17:00", precio: 300)
		Precio j2 = new Precio(dia:4, horarioInicio: "18:00", precio: 300)
		
		Servicios serv1 = new Servicios(vestuario: true, television: false, bebida: true, comida: true, ayudaMedica: false, torneo: false, wifi: true, gimnasio: false, estacionamiento: true)
		Ubicacion u1 = new Ubicacion(direccion: "Casa", barrio: "VP", localidad: "CABA", provincia: "BsAs", pais: "Argentina")
		Complejo poli = new Complejo(nombre: "Poli",webSite: "www.poli.com",telefono1: "41112222",mail: "poli@poli.com",informacionExtra: "soy el poli",ubicacion: u1,servicios:serv1)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[], complejo:poli)
		
		cancha.agregarPrecio(l3)
		cancha.agregarPrecio(l4)
		cancha.agregarPrecio(m1)
		cancha.agregarPrecio(m2)
		cancha.agregarPrecio(mi3)
		cancha.agregarPrecio(mi4)
		
		assertEquals 6, cancha.precios.size()
		assertTrue cancha.hasPrecio(l3)
		assertTrue cancha.hasPrecio(l4)
		assertTrue cancha.hasPrecio(m1)
		assertTrue cancha.hasPrecio(m2)
		assertTrue cancha.hasPrecio(mi3)
		assertTrue cancha.hasPrecio(mi4)
		assertFalse cancha.hasPrecio(j1)
		assertFalse cancha.hasPrecio(j2)
	}
	
}