package ar.com.reservayjuga.usuario



import grails.test.mixin.*

import org.junit.*

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.Horario
import ar.com.reservayjuga.complejo.Servicios
import ar.com.reservayjuga.ubicacion.Ubicacion;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Encargado)
class EncargadoTests {

  void testConstraints() {
		Encargado encargado = new Encargado(password:"1", mail:"asd")
		assertFalse encargado.validate()
		assertTrue encargado.hasErrors()
		assertNull encargado.save()
		
		assertEquals "nullable", encargado.errors["nombre"].code
		assertEquals "nullable", encargado.errors["apellido"].code
		assertEquals "email.invalid", encargado.errors["mail"].code
		assertEquals "size.toosmall", encargado.errors["password"].code
		assertEquals "nullable", encargado.errors["username"].code
		assertNull encargado.errors["complejo"]
    }
	
	void testAtributes() {
		Complejo complejo = new Complejo()
		Encargado encargado = new Encargado(nombre:"Tomas", apellido:"Escamez", username:"tomase", mail:"d@m.com", password:"1234567", complejo:complejo)
		assertTrue encargado.validate()
		assertEquals "Tomas", encargado.nombre
		assertEquals "Escamez", encargado.apellido
		assertEquals "tomase", encargado.username
		assertEquals "d@m.com", encargado.mail
		assertEquals "1234567", encargado.password
		assertEquals complejo, encargado.complejo
	}
	
	void testToString() {
		Encargado encargado = new Encargado(nombre:"Tomas", apellido:"Escamez", telefono:"12345678", mail:"d@m.com", password:"1234567")
		assertEquals "Tomas Escamez", encargado.toString()
	}

}
