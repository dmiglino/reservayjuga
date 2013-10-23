package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.EntityNotFoundException

class ImagenServiceIntegrationTests extends GroovyTestCase {
	
	ImagenService imagenService
	
    @Test
    void testFindImagenById() {
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true)
		DBUtils.validateAndSave(imagen)
		Imagen imgDB = imagenService.findEntityById(imagen.id)
		assertNotNull imgDB
		assertEquals "descripcionFoto", imgDB.descripcion
		assertEquals "nombreFoto", imgDB.nombre
		assertEquals "jpg", imgDB.extension
		assertTrue imgDB.portada
    }
	
	@Test
	void testFailFindImagenById() {
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true)
		DBUtils.validateAndSave(imagen)
		Imagen imgDB = imagenService.findEntityById(null)
		assertNull imgDB
		imgDB = imagenService.findEntityById(55)
		assertNull imgDB
	}
	
    @Test
    void testCrearImagenParaComplejo() {
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		imagenService.crearImagenParaComplejo(complejo, [descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true])
		
		def imagenes = complejo.imagenes as List
		println imagenes
		assertNotNull imagenes
		assertEquals 1, imagenes.size()
		
		Imagen imgComp = imagenes.get(0)
		
		assertNotNull imgComp
		assertEquals "descripcionFoto", imgComp.descripcion
		assertEquals "nombreFoto", imgComp.nombre
		assertEquals "jpg", imgComp.extension
		assertTrue imgComp.portada
    }
	
	@Test
	void testEditarImagen() {
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",portada:true)
		DBUtils.validateAndSave(imagen)
		
		def imagenes = Imagen.list()
		assertNotNull imagenes
		assertEquals 1, imagenes.size()
		
		imagenService.editarImagen([idImagenEdit: imagen.id, descripcionImagenEdit:"descEditada",nombreImagenEdit:"nomEditado",portadaImagenEdit:false])
		
		imagenes = Imagen.list()
		assertNotNull imagenes
		assertEquals 1, imagenes.size()
		Imagen img = imagenes.get(0)
		
		assertNotNull img
		assertEquals "descEditada", img.descripcion
		assertEquals "nomEditado", img.nombre
		assertFalse img.portada
	}
	
	@Test
	void testFailEditarImagen() {
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",portada:true).save()
		
		def imagenes = Imagen.list()
		assertNotNull imagenes
		assertEquals 1, imagenes.size()
		shouldFail(EntityNotFoundException) {
			imagenService.editarImagen([idImagenEdit: 123, descripcionImagenEdit:"descEditada",nombreImagenEdit:"nomEditado",portadaImagenEdit:false])
		}
	}
}