package ar.com.reservayjuga

import static org.junit.Assert.*
import grails.plugin.springsecurity.SpringSecurityService
import grails.test.GrailsUnitTestCase

import org.junit.*

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.Servicios
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.usuario.Encargado

class AuthenticationServiceIntegrationTests extends GrailsUnitTestCase {

	AuthenticationService authenticationService
	def springSecurityService
	Encargado encargado

	@Override
	protected void setUp() {
		authenticationService = new AuthenticationService()
		springSecurityService = mockFor(SpringSecurityService)
		authenticationService.springSecurityService = springSecurityService.createMock()
		
		if(!encargado) {
			Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
			Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
			Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
			Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi)
			DBUtils.validateAndSave(complejo)
				
			encargado = new Encargado(nombre:"Tomas", apellido:"Escamez", username:"tomase", mail:"d@m.com", password:"1234567", complejo:complejo)
			DBUtils.validateAndSave(encargado)
		}
		
		super.setUp()
	}
	
    void testGetUserLogged() {
		springSecurityService.demand.getPrincipal(1) { encargado }
		def enc = authenticationService.getUserLogged()
		assertNotNull enc
    }
	
//    void testGetUserLoggedId() {
//		springSecurityService.demand.getPrincipal(1) { encargado }
//		def encId = authenticationService.getUserLoggedId()
//		assertEquals encargado.id, encId
//    }
}
