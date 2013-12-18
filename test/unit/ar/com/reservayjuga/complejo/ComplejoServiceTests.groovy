package ar.com.reservayjuga.complejo

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*

import org.junit.*

import ar.com.reservayjuga.exception.EntityNotFoundException

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class ComplejoServiceTests extends GrailsUnitTestCase {
	
	ComplejoService complejoService = new ComplejoService()
	
	void testGetDomain() {
		assertEquals Complejo, complejoService.getDomain()
	}
	
	void testValidate() {
		complejoService.validate(new Complejo())
		shouldFail(EntityNotFoundException) {
			complejoService.validate(null)
		}
	}
 	
	void testSplitearHorariosPorHora() {
		def h1 = new Horario(dia:1, horarioApertura: "9:00", horarioCierre: "12:00") // 3 horarios: 9, 10, 11 (12 no incluido)
		def h2 = new Horario(dia:1, horarioApertura: "14:00", horarioCierre: "16:00") // 2 horarios: 14, 15 (16 no incluido)
		def h3 = new Horario(dia:1, horarioApertura: "19:00", horarioCierre: "23:00") // 4 horarios: 19, 20, 21, 22 (23 no incluido)
		
		List result = complejoService.splitearHorariosPorHora([h1,h2,h3])
		assertNotNull result
		assertEquals 9, result.size()
		
		assertFalse result.contains("06:00 - 7:00")
		assertFalse result.contains("07:00 - 8:00")
		assertFalse result.contains("08:00 - 9:00")
		assertTrue result.contains("09:00 - 10:00")
		assertTrue result.contains("10:00 - 11:00")
		assertTrue result.contains("11:00 - 12:00")
		assertFalse result.contains("12:00 - 13:00")
		assertFalse result.contains("13:00 - 14:00")
		assertTrue result.contains("14:00 - 15:00")
		assertTrue result.contains("15:00 - 16:00")
		assertFalse result.contains("16:00 - 17:00")
		assertFalse result.contains("17:00 - 18:00")
		assertFalse result.contains("18:00 - 19:00")
		assertTrue result.contains("19:00 - 20:00")
		assertTrue result.contains("20:00 - 21:00")
		assertTrue result.contains("21:00 - 22:00")
		assertTrue result.contains("22:00 - 23:00")
		assertFalse result.contains("23:00 - 24:00")
	}
}