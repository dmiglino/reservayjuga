package ar.com.reservayjuga.complejo



import grails.test.GrailsUnitTestCase;
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class ExtrasServiceTests extends GrailsUnitTestCase {

	ExtrasService extrasService = new ExtrasService()
	
    void testCreataeUbicacion() {
        def extrasMap = [quiereArbitro:true, quierePechera:false, precioArbitro:50f, precioPechera:0f]
		Extras extrasCreado = extrasService.createExtras(extrasMap)
		assertTrue extrasCreado.quiereArbitro
		assertFalse extrasCreado.quierePechera
		assertEquals 50f, extrasCreado.precioArbitro
		assertEquals 0f, extrasCreado.precioPechera
    }

}