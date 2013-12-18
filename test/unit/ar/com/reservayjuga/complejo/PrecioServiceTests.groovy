package ar.com.reservayjuga.complejo

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class PrecioServiceTests extends GrailsUnitTestCase {
	
	PrecioService precioService = new PrecioService()
	
	void testGetDomain() {
		assertEquals Precio, precioService.getDomain()
	}
	
}