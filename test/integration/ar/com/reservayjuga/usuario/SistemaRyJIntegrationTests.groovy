package ar.com.reservayjuga.usuario

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.utils.DBUtils;

class SistemaRyJIntegrationTests extends GroovyTestCase {

	void testSave() {
		SistemaRyJ sistemaRyJ1 = new SistemaRyJ(username: "Simpa", password:"campeon", mail:"sistema@ryj.com")
		SistemaRyJ sistemaRyJ2 = new SistemaRyJ(username: "Asd", password:"fghfgh", mail:"sistema@ryj.com")
		
		SistemaRyJ sistemaRyJPersistido = DBUtils.validateAndSave(sistemaRyJ1)
		DBUtils.validateAndSave([sistemaRyJ2])
		assertEquals sistemaRyJ1, sistemaRyJPersistido
		assertEquals 2, SistemaRyJ.findAll().size()
	}
	
	void testUniqueConstraint() {
		SistemaRyJ sistemaRyJ1 = new SistemaRyJ(username: "Simpa", password:"campeon", mail:"sistema@ryj.com")
		DBUtils.validateAndSave(sistemaRyJ1)
		
		SistemaRyJ sistemaRyJ2 = new SistemaRyJ(username: "Simpa", password:"campeon", mail:"sistema@ryj.com")
		assertFalse sistemaRyJ2.validate()
		assertEquals "unique", sistemaRyJ2.errors["username"].code
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(sistemaRyJ2)
		}
	}
	
	void testFailSave() {
		SistemaRyJ sistemaRyJ = new SistemaRyJ()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(sistemaRyJ)
		}
    }

}