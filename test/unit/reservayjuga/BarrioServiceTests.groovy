package reservayjuga



import grails.test.mixin.*

import org.junit.*

import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.BarrioService

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BarrioService)
class BarrioServiceTests {
	
	BarrioService barrioService = new BarrioService()
	
	void testGetDomain() {
		assertEquals Barrio, barrioService.getDomain()
	}

}