package ar.com.reservayjuga.usuario



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SistemaRyJ)
class SistemaRyJTests {

  void testConstraints() {
		SistemaRyJ sistemaRyJ = new SistemaRyJ()
		assertFalse sistemaRyJ.validate()
		assertTrue sistemaRyJ.hasErrors()
		assertNull sistemaRyJ.save()
		 
		assertEquals "nullable", sistemaRyJ.errors["nombreUsuario"].code
		assertEquals "nullable", sistemaRyJ.errors["clave"].code
    }
	
	void testAtributes() {
		SistemaRyJ sistemaRyJ = new SistemaRyJ(nombreUsuario: "Simpa", clave:"campeon", mail:"sistema@ryj.com")
		assertTrue sistemaRyJ.validate()
		assertEquals "Simpa", sistemaRyJ.nombreUsuario
		assertEquals "campeon", sistemaRyJ.clave
	}
	
	void testToString() {
		SistemaRyJ sistemaRyJ = new SistemaRyJ(nombreUsuario: "Simpa", clave:"campeon", mail:"sistema@ryj.com")
		assertEquals "Simpa", sistemaRyJ.toString()
	}

}
