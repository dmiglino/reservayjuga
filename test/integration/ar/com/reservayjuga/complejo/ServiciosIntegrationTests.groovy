package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class ServiciosIntegrationTests extends GroovyTestCase {

	void testSave() {
		Servicios servicios1 = new Servicios(vestuario:true,television:true,bebida:true,comida:true,ayudaMedica:false,torneo:false,wifi:true,gimnasio:false,estacionamiento:false)
		Servicios servicios2 = new Servicios(vestuario:false,television:false,bebida:true,comida:true,ayudaMedica:true,torneo:false,wifi:false,gimnasio:true,estacionamiento:false)
		
		Servicios serviciosPersistido = DBUtils.validateAndSave(servicios1)
		DBUtils.validateAndSave([servicios2])
		assertEquals servicios1, serviciosPersistido
		assertEquals 2, Servicios.findAll().size()
	}
	
	void testFailSave() {
		Servicios servicios = new Servicios()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(servicios)
		}
	}

}