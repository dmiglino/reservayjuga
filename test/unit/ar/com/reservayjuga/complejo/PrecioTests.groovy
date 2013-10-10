package ar.com.reservayjuga.complejo



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Precio)
class PrecioTests {

     void testConstraints() {
		
		 Precio precio = new Precio ()
		 precio.horarioInicio = ""
		 assertFalse precio.validate()
		 assertTrue precio.hasErrors()
		 assertNull precio.save()
		 
		assertEquals "blank", precio.errors["horarioInicio"].code
		assertEquals "nullable", precio.errors["precio"].code
		assertEquals "nullable", precio.errors["dia"].code
    }
	 
}
