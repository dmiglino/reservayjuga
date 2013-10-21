package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils

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

}