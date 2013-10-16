package ar.com.reservayjuga.complejo

import grails.test.mixin.*

import org.junit.*

@TestFor(Horario)
class HorarioTests {

	void testConstraints() {
		Horario horario = new Horario()
		horario.horarioApertura = ""
		assertFalse horario.validate()
		assertTrue horario.hasErrors()
		assertNull horario.save()
		
		assertEquals "nullable", horario.errors["dia"].code
		assertEquals "blank", horario.errors["horarioApertura"].code
		assertEquals "nullable", horario.errors["horarioCierre"].code
    }
	
	void testAtributes() {
		Horario horario = new Horario(horarioApertura:"10:00",horarioCierre:"22:00",dia:1)
		assertTrue horario.validate()
		assertEquals "10:00", horario.horarioApertura
		assertEquals "22:00", horario.horarioCierre
		assertEquals 1, horario.dia
	}
	
	void testToString() {
		Horario horario = new Horario(horarioApertura:"10:00",horarioCierre:"22:00",dia:1)
		assertEquals "1: 10:00 - 22:00", horario.toString()
	}

}