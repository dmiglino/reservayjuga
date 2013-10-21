package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils

class BarrioServiceIntegrationTests {

    BarrioService barrioService

    @Test
    void testSomething() {
        Barrio barrio = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Barrio barrioDB = barrioService.findEntityById(barrio.id)
		assertNotNull barrioDB
		assertEquals barrio, barrioDB
    }
    
}