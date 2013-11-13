package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*
import groovy.util.GroovyTestCase;

import org.junit.*

import ar.com.reservayjuga.utils.DBUtils;

class BarrioServiceIntegrationTests extends GroovyTestCase {

    BarrioService barrioService

    void testFindEntityById() {
    	Pais pais = new Pais(nombre:"Argentina")
		DBUtils.validateAndSave(pais)
    	Provincia provincia = new Provincia(nombre:"Buenos Aires", pais: pais)
		DBUtils.validateAndSave(provincia)
		Localidad localidad = new Localidad(nombre:"Capital Federal", provincia:provincia)
		DBUtils.validateAndSave(localidad)
    	Barrio barrio = new Barrio(nombre:"Villa Pueyrredon", localidad: localidad)
		DBUtils.validateAndSave(barrio)
		Barrio barrioDB = barrioService.findEntityById(barrio.id)
		assertNotNull barrioDB
		assertEquals barrio, barrioDB
    }
    
}