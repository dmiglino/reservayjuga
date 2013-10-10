package ar.com.reservayjuga.complejo

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Precio)
class PrecioTests {

     void testConstraints() {
		 Precio precio = new Precio()
		 precio.horarioInicio = ""
		 assertFalse precio.validate()
		 assertTrue precio.hasErrors()
		 assertNull precio.save()
		 
		assertEquals "blank", precio.errors["horarioInicio"].code
		assertEquals "nullable", precio.errors["precio"].code
		assertEquals "nullable", precio.errors["dia"].code
    }
	
	void testAtributes() {
		Precio precio = new Precio(dia:1,precio:400.50f,horarioInicio:"13:00")
		assertTrue precio.validate()
		assertEquals 1, precio.dia
		assertEquals 400.50f, precio.precio
		assertEquals "13:00", precio.horarioInicio
	}
	
	void testToString() {
		Precio precio = new Precio(dia:1,precio:400.50f,horarioInicio:"13:00")
		assertEquals "400.5", precio.toString()
	}
	 
}