package ar.com.reservayjuga.complejo



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Servicios)
class ServiciosTests {

     void testConstraints() {
		Servicios servicios = new Servicios()
		assertFalse servicios.validate()
		assertTrue servicios.hasErrors()
		assertNull servicios.save()
		 
		assertEquals "nullable", servicios.errors["vestuario"].code
		assertEquals "nullable", servicios.errors["television"].code
		assertEquals "nullable", servicios.errors["bebida"].code
		assertEquals "nullable", servicios.errors["comida"].code
		assertEquals "nullable", servicios.errors["ayudaMedica"].code
		assertEquals "nullable", servicios.errors["torneo"].code
		assertEquals "nullable", servicios.errors["wifi"].code
		assertEquals "nullable", servicios.errors["gimnasio"].code
		assertEquals "nullable", servicios.errors["estacionamiento"].code
    }
	
	void testAtributes() {
		Servicios servicios = new Servicios(vestuario:true,television:true,bebida:true,comida:true,ayudaMedica:false,torneo:false,wifi:true,gimnasio:false,estacionamiento:false)
		assertTrue servicios.validate()
		assertTrue servicios.vestuario
		assertTrue servicios.television
		assertTrue servicios.bebida
		assertTrue servicios.comida
		assertFalse servicios.ayudaMedica
		assertFalse servicios.torneo
		assertFalse servicios.gimnasio
		assertFalse servicios.estacionamiento
	}
	
	void testToString() {
		Servicios servicios = new Servicios(vestuario:true,television:true,bebida:true,comida:true,ayudaMedica:false,torneo:false,wifi:true,gimnasio:false,estacionamiento:false)
		assertEquals "Vestuario, Television, Bebida, Comida, Wifi, ", servicios.toString()
	}
	 
}