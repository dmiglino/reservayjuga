package ar.com.reservayjuga.ubicacion

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Barrio)
class BarrioTests {

void testConstraints() {
		Barrio barrio = new Barrio()
		assertFalse barrio.validate()
		assertTrue barrio.hasErrors()
		assertNull barrio.save()
		assertEquals "nullable", barrio.errors["nombre"].code
		assertEquals "nullable", barrio.errors["localidad"].code
	}

	void testAtributes() {
		Barrio barrio = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		assertTrue barrio.validate()
		assertEquals "Villa Pueyrredon", barrio.nombre
		assertEquals "Capital Federal", barrio.localidad.nombre
		assertEquals "Buenos Aires", barrio.localidad.provincia.nombre
		assertEquals "Argentina", barrio.localidad.provincia.pais.nombre
	}
	
	void testToString() {
		Barrio barrio = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		assertEquals "Villa Pueyrredon", barrio.toString()
	}
}
