package ar.com.reservayjuga.ubicacion



import grails.test.GrailsUnitTestCase;
import grails.test.mixin.*
import org.junit.*

import ar.com.reservayjuga.ubicacion.Ubicacion;

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class UbicacionServiceTests extends GrailsUnitTestCase {

	UbicacionService ubicacionService = new UbicacionService()
	
    void testCreataeUbicacion() {
        def ubicacionMap = [pais:"Argentina", provincia:"Baires", localidad:"Caba", barrio:"VP", direccion:"casa 123"]
		Ubicacion ubicacionCreado = ubicacionService.createUbicacion(ubicacionMap)
		assertEquals "Argentina", ubicacionCreado.pais.nombre
		assertEquals "Baires", ubicacionCreado.provincia.nombre
		assertEquals "Caba", ubicacionCreado.localidad.nombre
		assertEquals "VP", ubicacionCreado.barrio.nombre
		assertEquals "casa 123", ubicacionCreado.direccion
    }
	
}