package ar.com.reservayjuga.complejo

import grails.test.mixin.*
import org.junit.*

@TestFor(Imagen)
class ImagenTests {

    void testConstraints() {
		Imagen imagen = new Imagen()
		assertFalse imagen.validate()
		assertTrue imagen.hasErrors()
		assertNull imagen.save()
		
		assertEquals "nullable", imagen.errors["nombre"].code
		assertEquals "nullable", imagen.errors["extension"].code
		assertEquals "nullable", imagen.errors["portada"].code
		assertEquals "nullable", imagen.errors["descripcion"].code
		
		assertNull imagen.errors["fecha"]
		assertNull imagen.errors["foto"]
    }
	
	void testAtributes() {
		Imagen imagen = new Imagen(descripcion:"descripcion",nombre:"nombre",extension:"jpg",portada:true,fecha:new Date())
		assertTrue imagen.validate()
		assertEquals "descripcion", imagen.descripcion
		assertEquals "nombre", imagen.nombre
		assertEquals "jpg", imagen.extension
		assertTrue imagen.portada
	}
	
	void testToString() {
		Imagen imagen = new Imagen(descripcion:"descripcion gol",nombre:"gol simpa",extension:"jpg",portada:true,fecha:new Date())
		assertEquals "gol simpa", imagen.toString()
	}

}