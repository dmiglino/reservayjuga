package ar.com.reservayjuga.reserva

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class ReservaServiceTests extends GrailsUnitTestCase {
	
	ReservaService reservaService = new ReservaService()
	
	void testGetDomain() {
		assertEquals Reserva, reservaService.getDomain()
	}
	
}