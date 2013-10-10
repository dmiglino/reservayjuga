package ar.com.reservayjuga.complejo


import grails.test.mixin.*
import org.junit.*

@TestFor(Complejo)
class ComplejoTests {

    void testConstraints() {
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
		assertNull complejo.errors["telefono2"]
		assertNull complejo.errors["telefono3"]
		assertNull complejo.errors["telefono4"]
    }

}