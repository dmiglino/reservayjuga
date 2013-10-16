package ar.com.reservayjuga.complejo



import grails.test.GrailsUnitTestCase;
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class UbicacionServiceTests extends GrailsUnitTestCase {

	UbicacionService ubicacionService = new UbicacionService()
	
    void testCreataeUbicacion() {
        def ubicacionMap = [pais:"Argentina", provincia:"Baires", localidad:"Caba", barrio:"VP", direccion:"casa 123"]
		Ubicacion ubicacionCreado = ubicacionService.createUbicacion(ubicacionMap)
		assertEquals "Argentina", ubicacionCreado.pais
		assertEquals "Baires", ubicacionCreado.provincia
		assertEquals "Caba", ubicacionCreado.localidad
		assertEquals "VP", ubicacionCreado.barrio
		assertEquals "casa 123", ubicacionCreado.direccion
    }
	
}