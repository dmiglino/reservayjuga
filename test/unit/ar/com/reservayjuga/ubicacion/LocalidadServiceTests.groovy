package ar.com.reservayjuga.ubicacion



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LocalidadService)
class LocalidadServiceTests {
	
	LocalidadService localidadService = new LocalidadService()
	
	void testGetDomain() {
		assertEquals Localidad, localidadService.getDomain()
	}
	
}
