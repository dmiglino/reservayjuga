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
		assertEquals "nullable", imagen.errors["portada"].code
		assertEquals "nullable", imagen.errors["descripcion"].code
		assertEquals "nullable", imagen.errors["complejo"].code
		
		assertNull imagen.errors["extension"]
		assertNull imagen.errors["foto"]
    }
	
	void testAtributes() {
		Imagen imagen = new Imagen(descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true,fecha:new Date(), complejo:new Complejo())
		assertTrue imagen.validate()
		assertEquals "descripcionFoto", imagen.descripcion
		assertEquals "nombreFoto", imagen.nombre
		assertEquals "jpg", imagen.extension
		assertTrue imagen.portada
	}
	
	void testToString() {
		Imagen imagen = new Imagen(descripcion:"descripcion gol",nombre:"gol simpa",extension:"jpg",portada:true,fecha:new Date())
		assertEquals "gol simpa", imagen.toString()
	}

}