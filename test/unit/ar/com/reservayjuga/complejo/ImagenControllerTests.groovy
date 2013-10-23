package ar.com.reservayjuga.complejo



import grails.test.ControllerUnitTestCase
import grails.test.mixin.*

import org.junit.*

import ar.com.reservayjuga.exception.EntityNotFoundException

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
class ImagenControllerTests extends ControllerUnitTestCase {

    void testEditarImagen() {
		def imagenServiceMockControl = mockFor(ImagenService)
		this.controller.imagenService = imagenServiceMockControl.createMock()
		
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",portada:true)
		
		imagenServiceMockControl.demand.editarImagen(1..1) { }
		imagenServiceMockControl.demand.findEntityById(1..1) { def params ->
			imagen
		}
		
        def model = controller.editarImagen() // todo ok
    }
	
	void testFailEditarImagen() {
		def imagenServiceMockControl = mockFor(ImagenService)
		this.controller.imagenService = imagenServiceMockControl.createMock()
		
		imagenServiceMockControl.demand.editarImagen(1..1) { throw new EntityNotFoundException("test",1)}
		
		def model = controller.editarImagen() // falla
	}
}