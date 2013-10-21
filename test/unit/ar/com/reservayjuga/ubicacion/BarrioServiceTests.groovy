package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class BarrioServiceTests {
	
	BarrioService barrioService = new BarrioService()
	
	void testGetDomain() {
		assertEquals Barrio, barrioService.getDomain()
	}

}
