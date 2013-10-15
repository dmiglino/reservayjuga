package ar.com.reservayjuga.usuario

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class SistemaRyJIntegrationTests extends GroovyTestCase {

	void testSave() {
		SistemaRyJ sistemaRyJ1 = new SistemaRyJ(nombreUsuario: "Simpa", clave:"campeon", mail:"sistema@ryj.com")
		SistemaRyJ sistemaRyJ2 = new SistemaRyJ(nombreUsuario: "Asd", clave:"fghfgh", mail:"sistema@ryj.com")
		
		SistemaRyJ sistemaRyJPersistido = DBUtils.validateAndSave(sistemaRyJ1)
		DBUtils.validateAndSave([sistemaRyJ2])
		assertEquals sistemaRyJ1, sistemaRyJPersistido
		assertEquals 2, SistemaRyJ.findAll().size()
	}
	
	void testFailSave() {
		SistemaRyJ sistemaRyJ = new SistemaRyJ()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(sistemaRyJ)
		}
    }

}