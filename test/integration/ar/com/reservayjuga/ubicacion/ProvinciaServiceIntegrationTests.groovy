package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils

class ProvinciaServiceIntegrationTests extends GroovyTestCase {

	ProvinciaService provinciaService
	
	void testGetLocalidades() {
		Pais pais = new Pais(nombre:"Argentina")
		Provincia provincia = new Provincia(nombre:"Buenos Aires", pais: pais)
		Localidad localidad1 = new Localidad(nombre:"Capital Federal")
		Localidad localidad2 = new Localidad(nombre:"Tandil")
		Localidad localidad3 = new Localidad(nombre:"GBA")
		DBUtils.validateAndSave([pais, provincia])
		provinciaService.agregarLocalidad(provincia, localidad1)
		provinciaService.agregarLocalidades(provincia, [localidad2, localidad3])
		DBUtils.validateAndSave([localidad1, localidad2, localidad3])
		
		List localidades = provinciaService.getLocalidades(provincia.id)
		assertNotNull localidades
		assertEquals 3, localidades.size()
		
		localidades.each {
			assertEquals provincia, it.provincia
		}
		
	}
	
	void testFailGetLocalidades() {
		List localidades = provinciaService.getLocalidades(123123)
		assertNotNull localidades
		assertTrue localidades.isEmpty()
		
		localidades = provinciaService.getLocalidades(null)
		assertNotNull localidades
		assertTrue localidades.isEmpty()
	}

}