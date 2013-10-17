package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Ubicacion;

class UbicacionIntegrationTests extends GroovyTestCase {

	void testSave() {
		Barrio barrio1 = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubicacion1 = new Ubicacion(direccion:"Escobar 666", barrio:barrio1)
		Barrio barrio2 = new Barrio(nombre:"Saavedra", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubicacion2 = new Ubicacion(direccion:"Arias 111", barrio:barrio2)
		
		Ubicacion ubicacionPersistida = DBUtils.validateAndSave(ubicacion1)
		DBUtils.validateAndSave([ubicacion2])
		assertEquals ubicacion1, ubicacionPersistida
		assertEquals 2, Ubicacion.findAll().size()
	}
	
	void testFailSave() {
		Ubicacion ubicacion = new Ubicacion()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(ubicacion)
		}
	}
	
}