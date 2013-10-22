package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

class HorarioServiceIntegrationTests extends GroovyTestCase {

	HorarioService horarioService
	
	@Test
	void testGuardarHorariosParaComplejo() {
		Complejo complejo = new Complejo (horarios: [new Horario(dia:3,horarioApertura:"12:12",horarioCierre:"21:21")], nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		def datos = ["1":[apertura:"09:00",cierre:"21:00"],
			"2":[apertura:"10:00",cierre:"22:00"],
			"3":[apertura:"10:00",cierre:"21:00"],
			"4":[apertura:"11:00",cierre:"22:00"],
			"5":[apertura:"11:00",cierre:"21:00"],
			"6":[apertura:"12:00",cierre:"23:00"],
			"7":[apertura:"09:00",cierre:"23:00"],
			"8":[apertura:"08:00",cierre:"22:00"]]
		
		assertFalse complejo.horarios.isEmpty()
		
		horarioService.guardarHorariosParaComplejo(complejo, datos)
		
		assertNotNull complejo.horarios
		assertEquals 8, complejo.horarios.size()
		
		Horario horario = complejo.horarios.find{it.dia == 1}
		assertEquals "09:00", horario.horarioApertura
		assertEquals "21:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 2}
		assertEquals "10:00", horario.horarioApertura
		assertEquals "22:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 3}
		assertEquals "10:00", horario.horarioApertura
		assertEquals "21:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 4}
		assertEquals "11:00", horario.horarioApertura
		assertEquals "22:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 5}
		assertEquals "11:00", horario.horarioApertura
		assertEquals "21:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 6}
		assertEquals "12:00", horario.horarioApertura
		assertEquals "23:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 7}
		assertEquals "09:00", horario.horarioApertura
		assertEquals "23:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 8}
		assertEquals "08:00", horario.horarioApertura
		assertEquals "22:00", horario.horarioCierre
	}
	
	@Test
	void testGuardarHorariosParaComplejoIncompletos() {
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		def datos = ["1":[apertura:"09:00",cierre:"21:00"],
			"3":[apertura:"10:00",cierre:"21:00"],
			"5":[apertura:"11:00",cierre:"21:00"],
			"7":[apertura:"09:00",cierre:"23:00"],
			"11":[apertura:"09:00",cierre:"23:00"]
		]
		
		assertNull complejo.horarios
		
		horarioService.guardarHorariosParaComplejo(complejo, datos)
		
		assertNotNull complejo.horarios
		assertEquals 4, complejo.horarios.size()
		
		Horario horario = complejo.horarios.find{it.dia == 1}
		assertEquals "09:00", horario.horarioApertura
		assertEquals "21:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 2}
		assertNull horario
		horario = complejo.horarios.find{it.dia == 3}
		assertEquals "10:00", horario.horarioApertura
		assertEquals "21:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 4}
		assertNull horario
		horario = complejo.horarios.find{it.dia == 5}
		assertEquals "11:00", horario.horarioApertura
		assertEquals "21:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 6}
		assertNull horario
		horario = complejo.horarios.find{it.dia == 7}
		assertEquals "09:00", horario.horarioApertura
		assertEquals "23:00", horario.horarioCierre
		horario = complejo.horarios.find{it.dia == 8}
		assertNull horario
		horario = complejo.horarios.find{it.dia == 11}
		assertNull horario
	}

}