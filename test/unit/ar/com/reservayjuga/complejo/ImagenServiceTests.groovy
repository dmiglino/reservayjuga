package ar.com.reservayjuga.complejo



import grails.test.GrailsUnitTestCase;
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class ImagenServiceTests extends GrailsUnitTestCase {

	ImagenService imagenService = new ImagenService()
	
	void testGetDomain() {
		assertEquals Imagen, imagenService.getDomain()
	}
	
    void testCreateImagenes() {
		def imagenesMap = [[nombre:"nombreFoto1", extension:"bmp", descripcion:"descFoto1", portada:true],
				[nombre:"nombreFoto2", extension:"jpg", descripcion:"descFoto2", portada:false],
				[nombre:"nombreFoto3", extension:"gif", descripcion:"descFoto3", portada:false]]
        List imagenes = imagenService.createImagenes(imagenesMap)
		assertEquals 3, imagenes.size()
		assertEquals "bmp", imagenes.find{it.nombre == "nombreFoto1"}.extension
		assertEquals "descFoto1", imagenes.find{it.nombre == "nombreFoto1"}.descripcion
		assertTrue imagenes.find{it.nombre == "nombreFoto1"}.portada
		assertEquals "jpg", imagenes.find{it.nombre == "nombreFoto2"}.extension
		assertEquals "descFoto2", imagenes.find{it.nombre == "nombreFoto2"}.descripcion
		assertFalse imagenes.find{it.nombre == "nombreFoto2"}.portada
		assertEquals "gif", imagenes.find{it.nombre == "nombreFoto3"}.extension
		assertEquals "descFoto3", imagenes.find{it.nombre == "nombreFoto3"}.descripcion
		assertFalse imagenes.find{it.nombre == "nombreFoto3"}.portada
    }

}