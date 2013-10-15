package ar.com.reservayjuga.complejo



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Extras)
class ExtrasTests {

  void testConstraints() {
		Extras extras = new Extras()
		assertFalse extras.validate()
		assertTrue extras.hasErrors()
		assertNull extras.save()
		 
		assertEquals "nullable", extras.errors["quiereArbitro"].code
		assertEquals "nullable", extras.errors["quierePechera"].code
		
		assertNull extras.errors["precioArbitro"]
		assertNull extras.errors["precioPechera"]
    }
	
	void testAtributes() {
		Extras extras = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		assertTrue extras.validate()
		assertTrue extras.quiereArbitro
		assertTrue extras.quierePechera
		assertEquals 50, extras.precioArbitro
		assertEquals 3.5, extras.precioPechera
	}
	
	void testToString() {
		Extras extras = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		assertEquals "Arbitro y Pecheras", extras.toString()
	}

}