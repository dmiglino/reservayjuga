package ar.com.reservayjuga.complejo


import grails.test.mixin.*
import org.junit.*

@TestFor(Complejo)
class ComplejoTests {

    void testConstraints() {
//		Cancha cancha = new Cancha()
//		assertFalse cancha.validate()
//		assertTrue cancha.hasErrors()
//		assertNull cancha.save()
//		assertEquals "nullable", cancha.errors["nombre"].code
//		assertEquals "nullable", cancha.errors["deporte"].code
//		assertEquals "nullable", cancha.errors["superficie"].code
//		assertEquals "nullable", cancha.errors["cantidadJugadores"].code
//		assertEquals "nullable", cancha.errors["cubierta"].code
//		assertEquals "nullable", cancha.errors["complejo"].code
		Complejo complejo = new Complejo ()
		assertFalse complejo.validate()
		assertTrue complejo.hasErrors()
		assertNull complejo.save()
		assertEquals "nullable", complejo.errors["nombre"].code
		assertEquals "nullable", complejo.errors["webSite"].code
		assertEquals "nullable", complejo.errors["telefono1"].code
		assertEquals "nullable", complejo.errors["mail"].code
		assertEquals "nullable", complejo.errors["informacionExtra"].code
		assertEquals "nullable", complejo.errors["ubicacion"].code
		assertEquals "nullable", complejo.errors["servicios"].code
    }
}
