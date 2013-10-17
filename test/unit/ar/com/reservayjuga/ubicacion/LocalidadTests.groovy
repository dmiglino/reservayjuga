package ar.com.reservayjuga.ubicacion



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Localidad)
class LocalidadTests {

void testConstraints() {
		Localidad localidad = new Localidad()
		assertFalse localidad.validate()
		assertTrue localidad.hasErrors()
		assertNull localidad.save()
		assertEquals "nullable", localidad.errors["nombre"].code
		assertEquals "nullable", localidad.errors["provincia"].code
	}

	void testAtributes() {
		Localidad localidad = new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina")))
		assertTrue localidad.validate()
		assertEquals "Capital Federal", localidad.nombre
		assertEquals "Buenos Aires", localidad.provincia.nombre
		assertEquals "Argentina", localidad.provincia.pais.nombre
	}
	
	void testToString() {
		Localidad localidad = new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina")))
		assertEquals "Capital Federal", localidad.toString()
	}
}
