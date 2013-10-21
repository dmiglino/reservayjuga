package ar.com.reservayjuga.ubicacion

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.complejo.Complejo

class UbicacionServiceIntegrationTests extends GroovyTestCase {
	
	UbicacionService ubicacionService
	
    @Test
    void testFailGuardarUbicacionDelComplejo() {
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "www", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		shouldFail() {
			ubicacionService.guardarUbicacionDelComplejo(complejo, [direccion:"Casa 123", barrio:[id:123123]])
		}
	}
	
	@Test
	void testGuardarNuevaUbicacionDelComplejo() {
		Barrio barrio1 = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
				Ubicacion ubicacion1 = new Ubicacion(direccion:"Escobar 666", barrio:barrio1)
//		Barrio barrio2 = new Barrio(nombre:"Saavedra", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
//		Ubicacion ubicacion2 = new Ubicacion(direccion:"Arias 111", barrio:barrio2)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "www", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		
		ubicacionService.guardarUbicacionDelComplejo(complejo, [direccion:"Casa 123", barrio:[id:barrio1.id]])
		
		assertEquals "Casa 123", complejo.ubicacion.direccion
		assertEquals "Villa Pueyrredon", complejo.ubicacion.barrio.nombre
		assertEquals "Capital Federal", complejo.ubicacion.localidad.nombre
		assertEquals "Buenos Aires", complejo.ubicacion.provincia.nombre
		assertEquals "Argentina", complejo.ubicacion.pais.nombre
	}
	
	void testEditarUbicacionDelComplejo() {
		Barrio barrio1 = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubicacion2 = new Ubicacion(direccion:"Escobar 666", barrio:barrio1)
		Barrio barrio2 = new Barrio(nombre:"Saavedra", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubicacion3 = new Ubicacion(direccion:"Arias 111", barrio:barrio2)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "www", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubicacion3)
		
		ubicacionService.guardarUbicacionDelComplejo(complejo, [direccion:"Casa 123", barrio:[id:barrio1.id]])
		
		assertEquals "Casa 123", complejo.ubicacion.direccion
		assertEquals "Villa Pueyrredon", complejo.ubicacion.barrio.nombre
		assertEquals "Capital Federal", complejo.ubicacion.localidad.nombre
		assertEquals "Buenos Aires", complejo.ubicacion.provincia.nombre
		assertEquals "Argentina", complejo.ubicacion.pais.nombre
	}
	
}