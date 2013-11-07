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
 	
}