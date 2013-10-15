package ar.com.reservayjuga.complejo

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException

class ImagenIntegrationTests extends GroovyTestCase {

	void testSave() {
		Imagen imagen1 = new Imagen(descripcion:"fotito",nombre:"f1",extension:"jpg",portada:false,fecha:new Date())
		Imagen imagen2 = new Imagen(descripcion:"descripcion",nombre:"nombre",extension:"jpg",portada:true,fecha:new Date())
		
		Imagen imagenPersistida = DBUtils.validateAndSave(imagen1)
		DBUtils.validateAndSave([imagen2])
		assertEquals imagen1, imagenPersistida
		assertEquals 2, Imagen.findAll().size()
	}
	
	void testFailSave() {
		Imagen imagen = new Imagen()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(imagen)
		}
	}
}
