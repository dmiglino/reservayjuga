package ar.com.reservayjuga.complejo



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CanchaService)
class CanchaServiceTests {
	
	CanchaService canchaService = new CanchaService()
	
	void testGetDomain() {
		assertEquals Cancha, canchaService.getDomain()
	}

}