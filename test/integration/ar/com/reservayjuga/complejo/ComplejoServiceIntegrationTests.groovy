package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.reserva.TipoReservaEnum
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.usuario.Encargado
import ar.com.reservayjuga.usuario.Jugador
import ar.com.reservayjuga.utils.DBUtils

class ComplejoServiceIntegrationTests extends GroovyTestCase {
	
	ComplejoService complejoService
	Complejo complejo
	
	@Override
	protected void setUp() {
		def h1 = new Horario(dia:4,horarioApertura:"12:00",horarioCierre:"13:00").save()
		def h2 = new Horario(dia:4,horarioApertura:"13:00",horarioCierre:"14:00").save()
		def h3 = new Horario(dia:4,horarioApertura:"15:00",horarioCierre:"16:00").save()
		def h4 = new Horario(dia:6,horarioApertura:"16:00",horarioCierre:"16:00").save()
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios(vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		complejo = new Complejo(nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [h1,h2,h3,h4])
		DBUtils.validateAndSave(complejo)
	}
	
	void testGetById() {
		Complejo complejoPersistida = complejoService.findEntityById(complejo.id)
		assertEquals complejo, complejoPersistida
	}
	
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
		def imgCreada = complejoService.crearImagenParaComplejo(complejo,[descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true])
		
		assertEquals 1, complejo.imagenes.size()
		assertEquals 1, Imagen.list().size()
		
		Imagen img = Imagen.list().get(0)
		assertEquals imgCreada, img
		
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
		Imagen imagen1 = new Imagen(descripcion:"descripcionFoto1",nombre:"nombreFoto1",extension:"jpg",portada:true, complejo:complejo)
		Imagen imagen2 = new Imagen(descripcion:"descripcionFoto2",nombre:"nombreFoto2",extension:"jpg",portada:false, complejo:complejo)
		
		complejo.agregarImagen(imagen1)
		complejo.agregarImagen(imagen2)
		
		assertEquals 2, complejoService.countTotal(complejo)
	}
	
	void testGetImagenesDelComplejo() {
		Imagen imagen1 = new Imagen(descripcion:"descripcionFoto1",nombre:"nombreFoto1",extension:"jpg",portada:true, complejo:complejo)
		Imagen imagen2 = new Imagen(descripcion:"descripcionFoto2",nombre:"nombreFoto2",extension:"jpg",portada:false, complejo:complejo)
		
		complejo.agregarImagen(imagen1)
		complejo.agregarImagen(imagen2)
		
		List imagenes = complejoService.getImagenesDelComplejo(complejo, [])
		
		assertTrue imagenes.contains(imagen1)
		assertEquals 2, imagenes.size()
	}
	
	void testGetComplejoDelEncargado() {
		Encargado encargado = new Encargado(nombre:"Tomas", apellido:"Diego", username:"tomasdiego", mail:"d@t.com", password:"1234567", complejo:complejo)
		Encargado encargadoSinComplejo = new Encargado(nombre:"asd", apellido:"fgh", username:"asd", mail:"d@t.com", password:"3212321")
		DBUtils.validateAndSave([encargado, encargadoSinComplejo])
		
		Complejo complejoDelEncargado = complejoService.getComplejoDelEncargado(encargado.id)
		assertNotNull complejoDelEncargado
		assertEquals complejoDelEncargado, complejo
		
		assertNull complejoService.getComplejoDelEncargado(encargadoSinComplejo.id)
	}
	
	void testFailGetComplejoDelEncargado() {
		shouldFail(EntityNotFoundException) {
			complejoService.getComplejoDelEncargado(0)
		}
	}
	
	void testGetImagenesYCantidad() {
		Encargado encargado = new Encargado(nombre:"Tomas", apellido:"Diego", username:"tomasdiego", mail:"d@t.com", password:"1234567", complejo:complejo)
		DBUtils.validateAndSave([encargado])
		
		def imagen = complejoService.crearImagenParaComplejo(complejo,[descripcion:"descripcionFoto",nombre:"nombreFoto",extension:"jpg",portada:true])
		
		def results = complejoService.getImagenesYCantidad(complejo, [], encargado.id)
		
		assertNotNull results
		assertTrue results.imagenes.contains(imagen)
		assertEquals 1, results.imagenesTotal
	}
	
	void testFailGetImagenesYCantidad() {
		shouldFail(EntityNotFoundException) {
			complejoService.getImagenesYCantidad(null, [], 0)
		}
		
		Encargado encargado = new Encargado(nombre:"Tomas", apellido:"Diego", username:"notengocomplejo", mail:"d@t.com", password:"1234567")
		DBUtils.validateAndSave([encargado])
		
		shouldFail(EntityNotFoundException) {
			complejoService.getImagenesYCantidad(null, [], encargado.id)
		}
	}
	
	void testGetHorariosDisponiblesParaFecha() {
		Jugador jugador = new Jugador(nombre:"Diego", apellido:"Miglino", username:"dmiglino", password:"dmiglino", dni: 30303030, telefono:"12345678", mail:"d@m.com", clave:"1234567", sexo:"M")
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[], complejo: complejo)
		DBUtils.validateAndSave([jugador,cancha])
		
		def fecha = new Date(113,10,20)
		Reserva reserva1 = new Reserva (horaInicio: "11:00", horaFin: "12:00", tipoReserva:TipoReservaEnum.ONLINE, precioTotal:500, senia:50, dia: fecha, cancha: cancha, complejo: complejo, jugador: jugador)
		Reserva reserva2 = new Reserva (horaInicio: "12:00", horaFin: "13:00", tipoReserva:TipoReservaEnum.ONLINE, precioTotal:500, senia:50, dia: fecha, cancha: cancha, complejo: complejo, jugador: jugador)
		Reserva reserva3 = new Reserva (horaInicio: "13:00", horaFin: "14:00", tipoReserva:TipoReservaEnum.ONLINE, precioTotal:500, senia:50, dia: fecha+1, cancha: cancha, complejo: complejo, jugador: jugador)
		DBUtils.validateAndSave([reserva1,reserva2,reserva3])
		
		def resp = complejoService.getHorariosDisponiblesParaFecha("20-11-2013",complejo.id)
		
		assertEquals 3, resp.horariosConfigurados.size()
		assertEquals 2, resp.horariosOcupados.size() //1 q esta configurado y otro que no pero igual lo traigo		
	}
}