package ar.com.reservayjuga.complejo



import grails.test.GrailsUnitTestCase;
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class ImagenServiceTests extends GrailsUnitTestCase {

	ImagenService imagenService = new ImagenService()
	
    void testCreateImagenes() {
		def horariosMap = [[nombre:"nombreFoto1", extension:"bmp", descripcion:"descFoto1", portada:true],
				[nombre:"nombreFoto2", extension:"jpg", descripcion:"descFoto2", portada:false],
				[nombre:"nombreFoto3", extension:"gif", descripcion:"descFoto3", portada:false]]
        List horarios = imagenService.createImagenes(horariosMap)
		assertEquals 3, horarios.size()
		assertEquals "bmp", horarios.find{it.nombre == "nombreFoto1"}.extension
		assertEquals "descFoto1", horarios.find{it.nombre == "nombreFoto1"}.descripcion
		assertTrue horarios.find{it.nombre == "nombreFoto1"}.portada
		assertEquals "jpg", horarios.find{it.nombre == "nombreFoto2"}.extension
		assertEquals "descFoto2", horarios.find{it.nombre == "nombreFoto2"}.descripcion
		assertFalse horarios.find{it.nombre == "nombreFoto2"}.portada
		assertEquals "gif", horarios.find{it.nombre == "nombreFoto3"}.extension
		assertEquals "descFoto3", horarios.find{it.nombre == "nombreFoto3"}.descripcion
		assertFalse horarios.find{it.nombre == "nombreFoto3"}.portada
    }

}