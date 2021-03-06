package ar.com.reservayjuga.usuario



import grails.test.mixin.*

import org.junit.*

import ar.com.reservayjuga.reserva.Reserva

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Jugador)
class JugadorTests {

  void testConstraints() {
		Jugador jugador = new Jugador(password:"1", mail:"asd")
		assertFalse jugador.validate()
		assertTrue jugador.hasErrors()
		assertNull jugador.save()
		
		assertEquals "nullable", jugador.errors["nombre"].code
		assertEquals "nullable", jugador.errors["apellido"].code
		assertEquals "nullable", jugador.errors["username"].code
		assertEquals "nullable", jugador.errors["telefono"].code
		assertEquals "email.invalid", jugador.errors["mail"].code
		assertEquals "size.toosmall", jugador.errors["password"].code
		assertEquals "nullable", jugador.errors["sexo"].code
		
		assertNull jugador.errors["fechaNacimiento"]
    }
	
	void testAtributes() {
		Jugador jugador = new Jugador(nombre:"Diego", apellido:"Miglino", username:"dmiglino", telefono:"12345678", mail:"d@m.com", password:"1234567", sexo:"M")
		assertTrue jugador.validate()
		assertEquals "Diego", jugador.nombre
		assertEquals "Miglino", jugador.apellido
		assertEquals "dmiglino", jugador.username
		assertEquals "12345678", jugador.telefono
		assertEquals "d@m.com", jugador.mail
		assertEquals "1234567", jugador.password
		assertEquals "M", jugador.sexo
		
		assertNull jugador.reservas
		jugador.agregarReserva(new Reserva())
		assertEquals 1, jugador.reservas.size()
	}
	
	void testToString() {
		Jugador jugador = new Jugador(nombre:"Diego", apellido:"Miglino", username:"dmiglino", telefono:"12345678", mail:"d@m.com", password:"1234567", sexo:"M")
		assertEquals "Diego Miglino", jugador.toString()
	}

}
