package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion

class ComplejoServiceIntegrationTests extends GroovyTestCase {
	
	ComplejoService complejoService = new ComplejoService()
	
    void testCreateComplejo() {
        def complejoMap = [nombre:"Poli", webSite:"www.poli.com", mail:"poli@poli.com", telefono:"12345678", info:"info del poli", porcSenia:"40%"]
        		
		Barrio barrio = new Barrio(nombre:"Saavedra", localidad: new Localidad(nombre:"Provincia", provincia:new Provincia(nombre:"Baires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubicacion = new Ubicacion(direccion:"Nose", barrio:barrio)
		Servicios servicios = new Servicios(vestuario:true,television:true,bebida:true,comida:true,ayudaMedica:false,torneo:false,wifi:true,gimnasio:false,estacionamiento:false)
		Extras extras = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		
		Complejo complejoCreado = complejoService.createComplejo(complejoMap, ubicacion, servicios, extras, null, null)
		assertEquals "Poli", complejoCreado.nombre
		assertEquals "www.poli.com", complejoCreado.webSite
		assertEquals "poli@poli.com", complejoCreado.mail
		assertEquals "12345678", complejoCreado.telefono1
		assertEquals "info del poli", complejoCreado.informacionExtra
		
		assertEquals "Nose", complejoCreado.ubicacion.direccion
		assertEquals "Saavedra", complejoCreado.ubicacion.barrio.nombre
		assertEquals "Provincia", complejoCreado.ubicacion.localidad.nombre
		assertEquals "Baires", complejoCreado.ubicacion.provincia.nombre
		assertEquals "Argentina", complejoCreado.ubicacion.pais.nombre
		
		assertTrue complejoCreado.servicios.vestuario
		assertTrue complejoCreado.servicios.television
		assertTrue complejoCreado.servicios.bebida
		assertTrue complejoCreado.servicios.comida
		assertFalse complejoCreado.servicios.ayudaMedica
		assertFalse complejoCreado.servicios.torneo
		assertTrue complejoCreado.servicios.wifi
		assertFalse complejoCreado.servicios.gimnasio
		assertFalse complejoCreado.servicios.estacionamiento

		assertTrue complejoCreado.extras.quiereArbitro
		assertTrue complejoCreado.extras.quierePechera
		assertEquals 50, complejoCreado.extras.precioArbitro, 0.1
		assertEquals 3.5, complejoCreado.extras.precioPechera, 0.1
    }

	void testActualizarDatosComplejo() {
		def complejoMap = [nombre:"Poli", webSite:"www.poli.com", mail:"poli@poli.com", telefono:"56785678", info:"info del poli", porcSenia:"40%"]
		Barrio barrio = new Barrio(nombre:"Saavedra", localidad: new Localidad(nombre:"Provincia", provincia:new Provincia(nombre:"Baires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubicacion = new Ubicacion(direccion:"Nose", barrio:barrio)
		Servicios servicios = new Servicios(vestuario:true,television:true,bebida:true,comida:true,ayudaMedica:false,torneo:false,wifi:true,gimnasio:false,estacionamiento:false)
		Extras extras = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		Complejo complejoCreado = complejoService.createComplejo(complejoMap, ubicacion, servicios, extras, null, null)
		
		complejoMap = [nombre:"Garden", webSite:"www.garden.com", mail:"garden@garden.com", telefono1:"12345678", informacionExtra:"info del garden", porcentajeSenia:"50%", pais:"Argentina", provincia:"Buenos Aires", localidad:"Capital Federal", barrio:"Villa Pueyrredon", direccion:"Escobar 666", vestuario:false,television:false,bebida:false,comida:false,ayudaMedica:true,torneo:true,wifi:false,gimnasio:true,estacionamiento:true, quiereArbitro:true, quierePechera:false, precioArbitro:30f, precioPechera:0]
		complejoService.actualizarDatosComplejo(complejoCreado,complejoMap,null,null)
		
		assertEquals "Garden", complejoCreado.nombre
		assertEquals "www.garden.com", complejoCreado.webSite
		assertEquals "garden@garden.com", complejoCreado.mail
		assertEquals "12345678", complejoCreado.telefono1
		assertEquals "info del garden", complejoCreado.informacionExtra
		assertEquals "50%", complejoCreado.porcentajeSenia
		
		assertEquals "Escobar 666", complejoCreado.ubicacion.direccion
		assertEquals "Villa Pueyrredon", complejoCreado.ubicacion.barrio.nombre
		assertEquals "Capital Federal", complejoCreado.ubicacion.localidad.nombre
		assertEquals "Buenos Aires", complejoCreado.ubicacion.provincia.nombre
		assertEquals "Argentina", complejoCreado.ubicacion.pais.nombre
		
		assertFalse complejoCreado.servicios.vestuario
		assertFalse complejoCreado.servicios.television
		assertFalse complejoCreado.servicios.bebida
		assertFalse complejoCreado.servicios.comida
		assertTrue complejoCreado.servicios.ayudaMedica
		assertTrue complejoCreado.servicios.torneo
		assertFalse complejoCreado.servicios.wifi
		assertTrue complejoCreado.servicios.gimnasio
		assertTrue complejoCreado.servicios.estacionamiento
		
		assertTrue complejoCreado.extras.quiereArbitro
		assertFalse complejoCreado.extras.quierePechera
		assertEquals 30, complejoCreado.extras.precioArbitro, 0.1
		assertEquals 0, complejoCreado.extras.precioPechera, 0.1
	}

}