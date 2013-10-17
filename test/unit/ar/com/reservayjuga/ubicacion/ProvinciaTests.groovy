package ar.com.reservayjuga.ubicacion



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Provincia)
class ProvinciaTests {

	void testConstraints() {
		Provincia provincia = new Provincia()
		assertFalse provincia.validate()
		assertTrue provincia.hasErrors()
		assertNull provincia.save()
		assertEquals "nullable", provincia.errors["nombre"].code
		assertEquals "nullable", provincia.errors["pais"].code
	}

	void testAtributes() {
		Provincia provincia = new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))
		assertTrue provincia.validate()
		assertEquals "Buenos Aires", provincia.nombre
		assertEquals "Argentina", provincia.pais.nombre
	}
	
	void testToString() {
		Provincia provincia = new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))
		assertEquals "Buenos Aires", provincia.toString()
	}
}
