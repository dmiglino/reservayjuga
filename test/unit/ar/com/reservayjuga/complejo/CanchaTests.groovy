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
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:new Complejo(), precios:[precio])
		
		assertTrue cancha.validate()
		assertEquals "Poli-1", cancha.nombre
		assertEquals DeporteEnum.FUTBOL, cancha.deporte
		assertEquals SuperficieEnum.SINTETICO_CON_ARENA, cancha.superficie
		assertEquals 5, cancha.cantidadJugadores
		assertTrue cancha.cubierta
		assertEquals 1, cancha.precios.size()
	}
	
	void testToString() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[precio])
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
		
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[])
		
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