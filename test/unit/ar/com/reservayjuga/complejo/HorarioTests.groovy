package ar.com.reservayjuga.complejo

import grails.test.mixin.*
import org.junit.*

@TestFor(Horario)
class HorarioTests {

	void testConstraints() {
		
		Horario horario = new Horario ()
		horario.horarioApertura = ""
		assertFalse horario.validate()
		assertTrue horario.hasErrors()
		assertNull horario.save()
		
		assertEquals "nullable", horario.errors["dia"].code
		assertEquals "blank", horario.errors["horarioApertura"].code
		assertEquals "nullable", horario.errors["horarioCierre"].code
    }

}
