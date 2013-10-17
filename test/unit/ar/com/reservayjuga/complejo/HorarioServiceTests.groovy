package ar.com.reservayjuga.complejo

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class HorarioServiceTests extends GrailsUnitTestCase {

	HorarioService horarioService = new HorarioService()
	
    void testCreateHorarios() {
		def horariosMap = [[desde:"lunesDesde", hasta:"lunesHasta"],
			[desde:"martesDesde", hasta:"martesHasta"],
			[desde:"miercolesDesde", hasta:"miercolesHasta"],
			[desde:"juevesDesde", hasta:"juevesHasta"],
			[desde:"viernesDesde", hasta:"viernesHasta"],
			[desde:"sabadoDesde", hasta:"sabadoHasta"],
			[desde:"domingoDesde", hasta:"domingoHasta"],
			[desde:"feriadoDesde", hasta:"feriadoHasta"]]
        List horarios = horarioService.createHorarios(horariosMap)
		assertEquals 8, horarios.size()
		assertEquals "lunesDesde", horarios.find{it.dia == 1}.horarioApertura
		assertEquals "martesHasta", horarios.find{it.dia == 2}.horarioCierre
		assertEquals "miercolesDesde", horarios.find{it.dia == 3}.horarioApertura
		assertEquals "juevesHasta", horarios.find{it.dia == 4}.horarioCierre
		assertEquals "viernesDesde", horarios.find{it.dia == 5}.horarioApertura
		assertEquals "sabadoHasta", horarios.find{it.dia == 6}.horarioCierre
		assertEquals "domingoDesde", horarios.find{it.dia == 7}.horarioApertura
		assertEquals "feriadoHasta", horarios.find{it.dia == 8}.horarioCierre
    }
}
