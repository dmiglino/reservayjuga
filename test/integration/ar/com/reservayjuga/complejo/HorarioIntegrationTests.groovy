package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class HorarioIntegrationTests extends GroovyTestCase {

	void testSave() {
		Horario horario1 = new Horario(horarioApertura:"10:00",horarioCierre:"12:00",dia:1)
		Horario horario2 = new Horario(horarioApertura:"21:00",horarioCierre:"22:00",dia:2)
		
		Horario horarioPersistido = DBUtils.validateAndSave(horario1)
		DBUtils.validateAndSave([horario2])
		assertEquals horario1, horarioPersistido
		assertEquals 2, Horario.findAll().size()
	}
	
	void testFailSave() {
		Horario horario = new Horario()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(horario)
		}
	}
}
