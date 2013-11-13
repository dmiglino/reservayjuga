package ar.com.reservayjuga.usuario

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.utils.DBUtils;

class JugadorIntegrationTests extends GroovyTestCase {

	void testSave() {
		Jugador jugador1 = new Jugador(nombre:"Diego", apellido:"Miglino", username:"dmiglino", telefono:"12345678", mail:"d@m.com", password:"1234567", sexo:"M")
		Jugador jugador2 = new Jugador(nombre:"Tomas", apellido:"Escamez", username:"tomase", telefono:"87654321", mail:"d@m.com", password:"7654321", sexo:"F")
		
		Jugador jugadorPersistido = DBUtils.validateAndSave(jugador1)
		DBUtils.validateAndSave([jugador2])
		assertEquals jugador1, jugadorPersistido
		assertEquals 2, Jugador.findAll().size()
	}
	
	void testUniqueConstraint() {
		Jugador jugador = new Jugador(nombre:"Tomas", apellido:"Escamez", username:"tomase", telefono:"87654321", mail:"d@m.com", password:"7654321", sexo:"F")
		DBUtils.validateAndSave(jugador)
		
		jugador = new Jugador(nombre:"Tomas", apellido:"Escamez", username:"tomase", telefono:"87654321", mail:"d@m.com", password:"7654321", sexo:"F")
		assertFalse jugador.validate()
		assertEquals "unique", jugador.errors["username"].code
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(jugador)
		}
	}
	
	void testFailSave() {
		Jugador jugador = new Jugador()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(jugador)
		}
	}

}