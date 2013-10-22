package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import grails.test.ControllerUnitTestCase;
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
class PaisControllerTests extends ControllerUnitTestCase {

    void testGetProvincias() {
		def paisServiceMockControl = mockFor(PaisService)
		this.controller.paisService = paisServiceMockControl.createMock()
		
		Provincia p1 = new Provincia(nombre:"Buenos Aires")
		Provincia p2 = new Provincia(nombre:"Santa Fe")
		
		paisServiceMockControl.demand.getProvincias(1..1) { def id ->
			[p1,p2]
		}
		
        def model = controller.getProvincias()
		def provinciasList = model.provinciasList
		
        assertNotNull provinciasList
		assertEquals 2, provinciasList.size()
    }

}