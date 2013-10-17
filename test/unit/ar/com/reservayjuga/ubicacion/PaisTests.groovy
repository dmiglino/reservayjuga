package ar.com.reservayjuga.ubicacion



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Pais)
class PaisTests {

	void testConstraints() {
		Pais pais = new Pais(nombre:"")
		assertFalse pais.validate()
		assertTrue pais.hasErrors()
		assertNull pais.save()
		assertEquals "blank", pais.errors["nombre"].code
	}

	void testAtributes() {
		Pais pais = new Pais(nombre:"Argentina")
		assertTrue pais.validate()
		assertEquals "Argentina", pais.nombre
	}
	
	void testToString() {
		Pais pais = new Pais(nombre:"Argentina")
		assertEquals "Argentina", pais.toString()
	}
}
