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
		 
		assertEquals "nullable", sistemaRyJ.errors["username"].code
		assertEquals "nullable", sistemaRyJ.errors["password"].code
    }
	
	void testAtributes() {
		SistemaRyJ sistemaRyJ = new SistemaRyJ(username: "Simpa", password:"campeon", mail:"sistema@ryj.com")
		assertTrue sistemaRyJ.validate()
		assertEquals "Simpa", sistemaRyJ.username
		assertEquals "campeon", sistemaRyJ.password
	}
	
	void testToString() {
		SistemaRyJ sistemaRyJ = new SistemaRyJ(username: "Simpa", password:"campeon", mail:"sistema@ryj.com")
		assertEquals "Simpa", sistemaRyJ.toString()
	}

}
