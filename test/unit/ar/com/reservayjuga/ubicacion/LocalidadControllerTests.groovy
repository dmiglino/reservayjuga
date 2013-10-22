package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import grails.test.ControllerUnitTestCase;
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
class LocalidadControllerTests extends ControllerUnitTestCase {

    void testGetBarrios() {
		def localidadServiceMockControl = mockFor(LocalidadService)
		this.controller.localidadService = localidadServiceMockControl.createMock()
		
		Barrio b1 = new Barrio(nombre:"CABA")
		Barrio b2 = new Barrio(nombre:"GBA")
		
		localidadServiceMockControl.demand.getBarrios(1..1) { def id ->
			[b1,b2]
		}
		
        def model = controller.getBarrios()
		def barriosList = model.barriosList
		
        assertNotNull barriosList
		assertEquals 2, barriosList.size()
    }

}