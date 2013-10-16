package ar.com.reservayjuga.complejo



import grails.test.mixin.*
import org.junit.*

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
		assertEquals "nullable", ubicacion.errors["localidad"].code
		assertEquals "nullable", ubicacion.errors["provincia"].code
		assertEquals "nullable", ubicacion.errors["pais"].code
	}

	void testAtributes() {
		Ubicacion ubicacion = new Ubicacion(direccion:"Escobar 666", barrio:"Villa Pueyrredon", localidad: "Capital Federal", provincia:"Buenos Aires", pais: "Argentina")
		assertTrue ubicacion.validate()
		assertEquals "Escobar 666", ubicacion.direccion
		assertEquals "Villa Pueyrredon", ubicacion.barrio
		assertEquals "Capital Federal", ubicacion.localidad
		assertEquals "Buenos Aires", ubicacion.provincia
		assertEquals "Argentina", ubicacion.pais
	}
	
	void testToString() {
		Ubicacion ubicacion = new Ubicacion(direccion:"Escobar 666", barrio:"Villa Pueyrredon", localidad: "Capital Federal", provincia:"Buenos Aires", pais: "Argentina")
		assertEquals "Escobar 666, Villa Pueyrredon, Capital Federal", ubicacion.toString()
	}
}
