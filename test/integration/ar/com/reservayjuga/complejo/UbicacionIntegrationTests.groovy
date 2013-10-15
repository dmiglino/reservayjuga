package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class UbicacionIntegrationTests extends GroovyTestCase {

	void testSave() {
		Ubicacion ubicacion1 = new Ubicacion(direccion:"Escobar 666", barrio:"Villa Pueyrredon", localidad: "Capital Federal", provincia:"Buenos Aires", pais: "Argentina")
		Ubicacion ubicacion2 = new Ubicacion(direccion:"Arias 111", barrio:"Saavedra", localidad: "Capital Federal", provincia:"Buenos Aires", pais: "Argentina")
		
		Ubicacion ubicacionPersistida = DBUtils.validateAndSave(ubicacion1)
		DBUtils.validateAndSave([ubicacion2])
		assertEquals ubicacion1, ubicacionPersistida
		assertEquals 2, Ubicacion.findAll().size()
	}
	
	void testFailSave() {
		Ubicacion ubicacion = new Ubicacion()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(ubicacion)
		}
	}
	
}