package ar.com.reservayjuga.ubicacion



import grails.test.mixin.*
import org.junit.*

import ar.com.reservayjuga.ubicacion.Ubicacion;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Ubicacion)
class UbicacionTests {

void testConstraints() {
		Ubicacion ubicacion = new Ubicacion()
		assertFalse ubicacion.validate()
		assertTrue ubicacion.hasErrors()
		assertNull ubicacion.save()
		assertEquals "nullable", ubicacion.errors["direccion"].code
		assertEquals "nullable", ubicacion.errors["barrio"].code
	}

	void testAtributes() {
		Barrio barrio = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		Ubicacion ubicacion = new Ubicacion(direccion:"Escobar 666", barrio:barrio)
		assertTrue ubicacion.validate()
		assertEquals "Escobar 666", ubicacion.direccion
		assertEquals "Villa Pueyrredon", ubicacion.barrio.nombre
		assertEquals "Capital Federal", ubicacion.localidad.nombre
		assertEquals "Buenos Aires", ubicacion.provincia.nombre
		assertEquals "Argentina", ubicacion.pais.nombre
	}
	
	void testToString() {
		Barrio barrio = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina"))))
		Ubicacion ubicacion = new Ubicacion(direccion:"Escobar 666", barrio:barrio)
		assertEquals "Escobar 666, Villa Pueyrredon, Capital Federal", ubicacion.toString()
	}
}
