package ar.com.reservayjuga.complejo


import grails.test.mixin.*

import org.junit.*

@TestFor(Complejo)
class ComplejoTests {

    void testConstraints() {
		Complejo complejo = new Complejo ()
		complejo.webSite = ""
		complejo.nombre = ""
		assertFalse complejo.validate()
		assertTrue complejo.hasErrors()
		assertNull complejo.save()
		assertEquals "blank", complejo.errors["nombre"].code
	//	assertEquals "nullable", complejo.errors["webSite"].code
		assertEquals "nullable", complejo.errors["telefono1"].code
		assertEquals "nullable", complejo.errors["mail"].code
		assertEquals "nullable", complejo.errors["informacionExtra"].code
		assertEquals "nullable", complejo.errors["ubicacion"].code
		assertEquals "nullable", complejo.errors["servicios"].code
		assertNull complejo.errors["telefono2"]
		assertNull complejo.errors["telefono3"]
		assertNull complejo.errors["telefono4"]
		assertNull complejo.errors["webSite"]
		assertNull complejo.errors["horarios"]
		assertNull complejo.errors["imagenes"]
		assertNull complejo.errors["canchas"]
    }
	
	void testAtributes() {
		
		Ubicacion ubi = new Ubicacion (direccion:"Pedro Morán 2379", barrio:"Agronomía", localidad:"Capital Federal", provincia:"Buenos Aires", pais:"Argentina")
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: hora)
		
		assertTrue complejo.validate()
		assertEquals "Garden Club", complejo.nombre
		assertEquals "", complejo.webSite
		assertEquals "4574-0077", complejo.telefono1
		assertEquals "garden@mail.com", complejo.mail
		assertEquals "Info garden", complejo.informacionExtra
		assertEquals "Pedro Morán 2379", complejo.ubicacion.direccion
		assertEquals "Agronomía", complejo.ubicacion.barrio
		assertEquals "Capital Federal", complejo.ubicacion.localidad
		assertEquals "Buenos Aires", complejo.ubicacion.provincia
		assertEquals "Argentina", complejo.ubicacion.pais
		assertEquals 1, complejo.horarios.size()
		assertTrue complejo.servicios.vestuario
		assertEquals false, complejo.servicios.television
	}

	
	

}