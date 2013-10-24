package ar.com.reservayjuga.complejo



import grails.test.GrailsUnitTestCase;
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class CanchaServiceTests extends GrailsUnitTestCase {
	
	CanchaService canchaService = new CanchaService()
	
	void testGetDomain() {
		assertEquals Cancha, canchaService.getDomain()
	}

}