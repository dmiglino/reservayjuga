package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion

class ImagenServiceIntegrationTests extends GroovyTestCase {
	
	ImagenService imagenService
	Complejo complejo
	
	@Override
	protected void setUp() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi).save()
	}
	
    @Test
    void testFindImagenById() {
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true, complejo:complejo)
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
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true, complejo:complejo)
		DBUtils.validateAndSave(imagen)
		Imagen imgDB = imagenService.findEntityById(null)
		assertNull imgDB
		imgDB = imagenService.findEntityById(55)
		assertNull imgDB
	}
	
    @Test
    void testCrearImagenParaComplejo() {
		imagenService.crearImagenParaComplejo(complejo, [descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true])
		
		def imagenes = complejo.imagenes as List
		assertNotNull imagenes
		assertEquals 1, imagenes.size()
		
		Imagen imgComp = imagenes.get(0)
		
		assertNotNull imgComp
		assertEquals "descripcionFoto", imgComp.descripcion
		assertEquals "nombreFoto", imgComp.nombre
		assertEquals "jpg", imgComp.extension
		assertTrue imgComp.portada
		assertEquals complejo, imgComp.complejo
    }
	
	@Test
	void testEditarImagen() {
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",portada:true, complejo:complejo)
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
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",portada:true, complejo:complejo).save()
		
		def imagenes = Imagen.list()
		assertNotNull imagenes
		assertEquals 1, imagenes.size()
		shouldFail(EntityNotFoundException) {
			imagenService.editarImagen([idImagenEdit: 123, descripcionImagenEdit:"descEditada",nombreImagenEdit:"nomEditado",portadaImagenEdit:false])
		}
	}
	
	void testCountTotal() {
		Imagen imagen1 = new Imagen(descripcion:"descripcionFoto1",nombre:"nombreFoto1",extension:"jpg",portada:true, complejo:complejo)
		Imagen imagen2 = new Imagen(descripcion:"descripcionFoto2",nombre:"nombreFoto2",extension:"jpg",portada:false, complejo:complejo)
		
		complejo.agregarImagen(imagen1)
		complejo.agregarImagen(imagen2)
		DBUtils.validateAndSave(complejo)
		
		assertEquals 2, imagenService.countTotal(complejo)
	}
	
	
	void testGetImagenesDelComplejo() {
		Imagen imagen1 = new Imagen(descripcion:"descripcionFoto1",nombre:"nombreFoto1",extension:"jpg",portada:true, complejo:complejo)
		Imagen imagen2 = new Imagen(descripcion:"descripcionFoto2",nombre:"nombreFoto2",extension:"jpg",portada:false, complejo:complejo)
		
		complejo.agregarImagen(imagen1)
		complejo.agregarImagen(imagen2)
		DBUtils.validateAndSave(complejo)
		
		List imagenes = imagenService.getImagenesDelComplejo(complejo, [])
		
		assertTrue imagenes.contains(imagen1)
		assertEquals 2, imagenes.size()
	}

}