package ar.com.reservayjuga.ubicacion



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ProvinciaService)
class ProvinciaServiceTests {
	
	ProvinciaService provinciaService = new ProvinciaService()
	
	void testGetDomain() {
		assertEquals Provincia, provinciaService.getDomain()
	}
	
}
