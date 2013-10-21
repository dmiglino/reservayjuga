package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils

class PaisServiceIntegrationTests extends GroovyTestCase {

	PaisService paisService
	
	void testGetProvincias() {
		Pais pais = new Pais(nombre:"Argentina")
		Provincia provincia1 = new Provincia(nombre:"Buenos Aires")
		Provincia provincia2 = new Provincia(nombre:"Cordoba")
		Provincia provincia3 = new Provincia(nombre:"Santa Fe")
		DBUtils.validateAndSave(pais)
		paisService.agregarProvincia(pais, provincia1)
		paisService.agregarProvincias(pais, [provincia2, provincia3])
		DBUtils.validateAndSave([provincia1, provincia2, provincia3])
		
		List provincias = paisService.getProvincias(pais.id)
		assertNotNull provincias
		assertEquals 3, provincias.size()
		
		provincias.each {
			assertEquals pais, it.pais
		}
	}
	
	void testFailGetProvincias() {
		List provincias = paisService.getProvincias(123123)
		assertNotNull provincias
		assertTrue provincias.isEmpty()
		
		provincias = paisService.getProvincias(null)
		assertNotNull provincias
		assertTrue provincias.isEmpty()
	}

}