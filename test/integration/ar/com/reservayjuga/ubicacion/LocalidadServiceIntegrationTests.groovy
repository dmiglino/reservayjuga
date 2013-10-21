package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils

class LocalidadServiceIntegrationTests extends GroovyTestCase {
	
	ProvinciaService provinciaService
	LocalidadService localidadService
	
	void testGetLocalidades() {
		Pais pais = new Pais(nombre:"Argentina")
		Provincia provincia = new Provincia(nombre:"Buenos Aires", pais: pais)
		DBUtils.validateAndSave([pais, provincia])
		
		Localidad localidad = new Localidad(nombre:"Capital Federal")
		provinciaService.agregarLocalidad(provincia, localidad)
		DBUtils.validateAndSave([localidad])
		
		Barrio barrio1 = new Barrio(nombre:"Villa Pueyrredon")
		Barrio barrio2 = new Barrio(nombre:"Saavedra")
		Barrio barrio3 = new Barrio(nombre:"Villa Urquiza")
		
		localidadService.agregarBarrio(localidad, barrio1)
		localidadService.agregarBarrios(localidad, [barrio2,barrio3])
		
		List barrios = localidadService.getBarrios(localidad.id)
		assertNotNull barrios
		assertEquals 3, barrios.size()
		
		barrios.each {
			assertEquals localidad, it.localidad
		}
	}
	
	void testFailGetLocalidades() {
		List barrios = localidadService.getBarrios(123123)
		assertNotNull barrios
		assertTrue barrios.isEmpty()
		
		barrios = localidadService.getBarrios(null)
		println barrios
		assertNotNull barrios
		assertTrue barrios.isEmpty()
	}

}