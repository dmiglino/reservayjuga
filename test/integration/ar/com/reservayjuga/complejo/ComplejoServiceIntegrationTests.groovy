package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion

class ComplejoServiceIntegrationTests extends GroovyTestCase {
	
	ComplejoService complejoService
	
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
		Barrio barrioVP = new Barrio(nombre:"Villa Pueyrredon", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Barrio barrioSaavedra = new Barrio(nombre:"Saavedra", localidad: new Localidad(nombre:"Provincia", provincia:new Provincia(nombre:"Baires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubicacion = new Ubicacion(direccion:"Nose", barrio:barrioSaavedra)
		Servicios servicios = new Servicios(vestuario:true,television:true,bebida:true,comida:true,ayudaMedica:false,torneo:false,wifi:true,gimnasio:false,estacionamiento:false)
		Extras extras = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		Complejo complejoCreado = complejoService.createComplejo(complejoMap, ubicacion, servicios, extras, null, null)
		
		complejoMap = [nombre:"Garden", webSite:"www.garden.com", mail:"garden@garden.com", telefono1:"12345678", informacionExtra:"info del garden", porcentajeSenia:"50%", 
			ubicacion: [barrio: [id: barrioVP.id.toString()], direccion:"Escobar 666"], 
			servicios: [vestuario:false,television:false,bebida:false,comida:false,ayudaMedica:true,torneo:true,wifi:false,gimnasio:true,estacionamiento:true], 
			quiereArbitro:true, quierePechera:false, precioArbitro:30f, precioPechera:0,
			horarios:["1":[apertura:"09:00",cierre:"21:00"], "3":[apertura:"10:00",cierre:"21:00"], "5":[apertura:"11:00",cierre:"21:00"], "7":[apertura:"09:00",cierre:"23:00"]]
		]
		complejoService.actualizarDatosComplejo(complejoCreado,complejoMap)
		
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

	void testAgregarYBorrarImagen() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		Imagen ima = new Imagen(nombre: "foto", extension: ".jpg", descripcion: "foto cancha 1", fecha: new Date(), portada: true)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi).save()
		
		complejoService.crearImagenParaComplejo(complejo,[descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true])
		
		assertEquals 1, complejo.imagenes.size()
		assertEquals 1, Imagen.list().size()
		
		Imagen img = Imagen.list().get(0)
		
		complejoService.eliminarImagenDelComplejo(complejo, img.id)
		
		assertEquals 0, complejo.imagenes.size()
		assertEquals 0, Imagen.list().size()
		
	}
	
	void testFailEliminarImagenDelComplejo() {
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		shouldFail(EntityNotFoundException) {
			complejoService.eliminarImagenDelComplejo(complejo, 123123)
		}
	}
	
	void testAgregarCancha() {
		Cancha cancha = new Cancha(nombre: "foto", extension: ".jpg", descripcion: "foto cancha 1", fecha: new Date(), portada: true)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		
		assertNull complejo.canchas
		complejoService.agregarCancha(complejo, cancha)
		assertEquals 1, complejo.canchas.size()
		
		complejoService.agregarCancha(complejo, null)
		assertEquals 1, complejo.canchas.size()
	}
	
	void testAgregarImagen() {
		Imagen imagen = new Imagen(nombre: "foto", extension: ".jpg", descripcion: "foto cancha 1", fecha: new Date(), portada: true)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		
		assertNull complejo.imagenes
		complejoService.agregarImagen(complejo, imagen)
		assertEquals 1, complejo.imagenes.size()
		
		complejoService.agregarImagen(complejo, null)
		assertEquals 1, complejo.imagenes.size()
	}
	
	void testEliminarImagenes() {
		Imagen imagen1 = new Imagen(nombre: "foto1", extension: ".jpg", descripcion: "foto cancha 1", fecha: new Date(), portada: true)
		Imagen imagen2 = new Imagen(nombre: "foto2", extension: ".jpg", descripcion: "foto cancha 2", fecha: new Date(), portada: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		
		assertNull complejo.imagenes
		complejoService.agregarImagen(complejo, imagen1)
		complejoService.agregarImagen(complejo, imagen2)
		assertEquals 2, complejo.imagenes.size()
		
		complejoService.eliminarTodasLasImagenesDelComplejo(complejo)
		
		assertEquals 0, complejo.imagenes.size()
	}
	
	void testCountTotal() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi)
		Imagen imagen1 = new Imagen(descripcion:"descripcionFoto1",nombre:"nombreFoto1",extension:"jpg",portada:true, complejo:complejo)
		Imagen imagen2 = new Imagen(descripcion:"descripcionFoto2",nombre:"nombreFoto2",extension:"jpg",portada:false, complejo:complejo)
		
		complejo.agregarImagen(imagen1)
		complejo.agregarImagen(imagen2)
		DBUtils.validateAndSave(complejo)
		
		assertEquals 2, complejoService.countTotal(complejo)
	}
	
	void testGetImagenesDelComplejo() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi)
		Imagen imagen1 = new Imagen(descripcion:"descripcionFoto1",nombre:"nombreFoto1",extension:"jpg",portada:true, complejo:complejo)
		Imagen imagen2 = new Imagen(descripcion:"descripcionFoto2",nombre:"nombreFoto2",extension:"jpg",portada:false, complejo:complejo)
		
		complejo.agregarImagen(imagen1)
		complejo.agregarImagen(imagen2)
		DBUtils.validateAndSave(complejo)
		
		List imagenes = complejoService.getImagenesDelComplejo(complejo, [])
		
		assertTrue imagenes.contains(imagen1)
		assertEquals 2, imagenes.size()
	}
	
}