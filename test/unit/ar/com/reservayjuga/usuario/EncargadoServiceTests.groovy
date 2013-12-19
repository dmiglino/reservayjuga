package ar.com.reservayjuga.usuario

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class EncargadoServiceTests extends GrailsUnitTestCase {
	
	EncargadoService encargadoService = new EncargadoService()
	
	void testGetDomain() {
		assertEquals Encargado, encargadoService.getDomain()
	}

}