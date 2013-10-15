package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class PrecioIntegrationTests extends GroovyTestCase {

	void testSave() {
		Precio p1 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		Precio p2 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		
		Precio precioPersistido = DBUtils.validateAndSave(p1)
		DBUtils.validateAndSave([p2])
		assertEquals p1, precioPersistido
		assertEquals 2, Precio.findAll().size()
	}
	
	void testFailSave() {
		Precio precio = new Precio()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(precio)
		}
	}
}
