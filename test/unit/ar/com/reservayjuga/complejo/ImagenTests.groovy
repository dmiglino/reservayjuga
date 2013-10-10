package ar.com.reservayjuga.complejo

import grails.test.mixin.*
import org.junit.*

@TestFor(Imagen)
class ImagenTests {

    void testConstraints() {
		
		Imagen imagen = new Imagen ()
		assertFalse imagen.validate()
		assertTrue imagen.hasErrors()
		assertNull imagen.save()
		
		assertEquals "nullable", imagen.errors["nombre"].code
		assertEquals "nullable", imagen.errors["extension"].code
		assertEquals "nullable", imagen.errors["portada"].code
		
		assertNull imagen.errors["descripcion"]
		assertNull imagen.errors["fecha"]
		assertNull imagen.errors["foto"]
    }
}
