package ar.com.reservayjuga.usuario

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class JugadorIntegrationTests extends GroovyTestCase {

	void testSave() {
		Jugador jugador1 = new Jugador(nombre:"Diego", apellido:"Miglino", telefono:"12345678", mail:"d@m.com", clave:"1234567", sexo:"M")
		Jugador jugador2 = new Jugador(nombre:"Tomas", apellido:"Escamez", telefono:"87654321", mail:"d@m.com", clave:"7654321", sexo:"F")
		
		Jugador jugadorPersistido = DBUtils.validateAndSave(jugador1)
		DBUtils.validateAndSave([jugador2])
		assertEquals jugador1, jugadorPersistido
		assertEquals 2, Jugador.findAll().size()
	}
	
	void testFailSave() {
		Jugador jugador = new Jugador()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(jugador)
		}
	}

}