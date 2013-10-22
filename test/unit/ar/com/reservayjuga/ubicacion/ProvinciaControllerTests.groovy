package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import grails.test.ControllerUnitTestCase;
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
class ProvinciaControllerTests extends ControllerUnitTestCase {

    void testGetProvincias() {
		def provinciaServiceMockControl = mockFor(ProvinciaService)
		this.controller.provinciaService = provinciaServiceMockControl.createMock()
		
		Localidad l1 = new Localidad(nombre:"CABA")
		Localidad l2 = new Localidad(nombre:"GBA")
		
		provinciaServiceMockControl.demand.getLocalidades(1..1) { def id ->
			[l1,l2]
		}
		
        def model = controller.getLocalidades()
		def localidadesList = model.localidadesList
		
        assertNotNull localidadesList
		assertEquals 2, localidadesList.size()
    }

}