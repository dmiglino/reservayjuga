package ar.com.reservayjuga.complejo



import grails.test.GrailsUnitTestCase;
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class ServiciosServiceTests extends GrailsUnitTestCase {

	ServiciosService serviciosService = new ServiciosService()
	
    void testCreataeUbicacion() {
        def serviciosMap = [vestuario:false,television:false,bebida:false,comida:false,ayudaMedica:true,torneo:true,wifi:false,gimnasio:true,estacionamiento:true]
		Servicios serviciosCreado = serviciosService.createServicios(serviciosMap)
		assertFalse serviciosCreado.vestuario
		assertFalse serviciosCreado.television
		assertFalse serviciosCreado.bebida
		assertFalse serviciosCreado.comida
		assertTrue serviciosCreado.ayudaMedica
		assertTrue serviciosCreado.torneo
		assertFalse serviciosCreado.wifi
		assertTrue serviciosCreado.gimnasio
		assertTrue serviciosCreado.estacionamiento
    }
}
