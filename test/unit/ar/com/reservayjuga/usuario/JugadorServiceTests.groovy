package ar.com.reservayjuga.usuario

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class JugadorServiceTests extends GrailsUnitTestCase {
	
	JugadorService jugadorService = new JugadorService()
	
	void testGetDomain() {
		assertEquals Jugador, jugadorService.getDomain()
	}

}