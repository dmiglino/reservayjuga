package ar.com.reservayjuga.ubicacion



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PaisService)
class PaisServiceTests {
	
	PaisService paisService = new PaisService()
	
	void testGetDomain() {
		assertEquals Pais, paisService.getDomain()
	}
	
}
