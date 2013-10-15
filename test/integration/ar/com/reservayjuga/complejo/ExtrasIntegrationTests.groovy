package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class ExtrasIntegrationTests extends GroovyTestCase {

	void testSave() {
		Extras extras1 = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		Extras extras2 = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		
		Extras extrasPersistido = DBUtils.validateAndSave(extras1)
		DBUtils.validateAndSave([extras2])
		assertEquals extras1, extrasPersistido
		assertEquals 2, Extras.findAll().size()
	}
	
	void testFailSave() {
		Extras extras = new Extras()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(extras)
		}
	}
}
