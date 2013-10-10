package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*
import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.usuario.Jugador

class ComplejoIntegrationTests extends GroovyTestCase {
    
	// Agrego canchas y se persisten. Borro el complejo y se borran las canchas de la DB
	void testCanchas() {
		Ubicacion ubi = new Ubicacion (direccion:"Pedro Moran 2379", barrio:"Agronomia", localidad:"Capital Federal", provincia:"Buenos Aires", pais:"Argentina")
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [], canchas: []).save()
		
		Cancha cancha1 = new Cancha(nombre:"Cancha 1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[])
		Cancha cancha2 = new Cancha(nombre:"Cancha 2", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_CAUCHO, cantidadJugadores:5, cubierta: true, precios:[])
		Cancha cancha3 = new Cancha(nombre:"Cancha 3", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:8, cubierta: true, precios:[])
		
		complejo.agregarCancha(cancha1)
		complejo.agregarCancha(cancha2)
		complejo.agregarCancha(cancha3)
		
		assertEquals 3, complejo.canchas.size()
		assertEquals 3, Cancha.list().size()
		
		complejo.eliminarCancha(cancha1)
		
		assertEquals 2, complejo.canchas.size()
		assertEquals 2, Cancha.list().size()
		
		complejo.delete()
		
		assertEquals 0, Cancha.list().size()
	}
	
	// Se borra el complejo y se borra todo de la DB
	void testServiciosUbicacionHorarioImagen() {
		Ubicacion ubi = new Ubicacion (direccion:"Pedro Moran 2379", barrio:"Agronomia", localidad:"Capital Federal", provincia:"Buenos Aires", pais:"Argentina")
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		Imagen ima = new Imagen(nombre: "foto", extension: ".jpg", descripcion: "foto cancha 1", fecha: new Date(), portada: true)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [], canchas: []).save()
		
		complejo.addToHorarios(hora)
		complejo.addToImagenes(ima)
		
		assertEquals ubi, complejo.ubicacion
		assertEquals servi, complejo.servicios
		assertEquals 1, complejo.horarios.size()
		assertEquals 1, complejo.imagenes.size()
		assertTrue complejo.horarios.contains(hora)
		assertTrue complejo.imagenes.contains(ima)
		
		assertEquals 1, Ubicacion.list().size()
		assertEquals 1, Servicios.list().size()
		assertEquals 1, Horario.list().size()
		assertEquals 1, Imagen.list().size()
		
		complejo.delete()
		
		assertEquals 0, Ubicacion.list().size()
		assertEquals 0, Servicios.list().size()
		assertEquals 0, Horario.list().size()
		assertEquals 0, Imagen.list().size()
	}
	
	//No se tiene que borrar la reserva de la DB aunque se borre el complejo
	void testReserva() {
		Ubicacion ubi = new Ubicacion (direccion:"Pedro Mor�n 2379", barrio:"Agronom�a", localidad:"Capital Federal", provincia:"Buenos Aires", pais:"Argentina")
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Cancha cancha = new Cancha(nombre:"Cancha 1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[]).save()
		Complejo complejo = new Complejo(nombre: "Poli Club", webSite: "", telefono1:"4574-0077", mail:"poli@mail.com", informacionExtra: "Info poli", ubicacion: ubi, servicios: servi, horarios: [], canchas: []).save()
		Jugador jugador = new Jugador(nombre: "Die", apellido: "Migli", telefono: "4534556", mail: "die@mail.com", clave: "1234567", sexo: "M", fechaNacimiento: new Date()).save()
		
		// creacion de reserva
		Reserva res = new Reserva(complejo:complejo, jugador: jugador, cancha: cancha, dia: new Date(), horaInicio: "11:00", horaFin: "12:00", senia: 99, precioTotal: 450, tipoReserva: "ONLINE")
		complejo.addToReservas(res)
		jugador.addToReservas(res)

		assertEquals 1, Reserva.list().size()
		
		DBUtils.markAsDeleted(complejo)
		DBUtils.markAsDeleted(jugador)
		DBUtils.markAsDeleted(cancha)
		assertEquals 1, Reserva.list().size()
		
//		shouldFail(DataIntegrityViolationException) {
			complejo.delete()
//		}
	}
	
	void testSave() {
		Ubicacion ubi = new Ubicacion (direccion:"Pedro Mor�n 2379", barrio:"Agronom�a", localidad:"Capital Federal", provincia:"Buenos Aires", pais:"Argentina")
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		
		Complejo complejo1 = new Complejo(nombre: "Poli Club", webSite: "", telefono1:"4574-0077", mail:"poli@mail.com", informacionExtra: "Info poli", ubicacion: ubi, servicios: servi, horarios: [], canchas: [])
		Complejo complejo2 = new Complejo(nombre: "Terraza Club", webSite: "", telefono1:"4574-1122", mail:"terraza@mail.com", informacionExtra: "Info terraza", ubicacion: ubi, servicios: servi, horarios: [], canchas: [])
		Complejo complejo3 = new Complejo(nombre: "Garden Club", webSite: "", telefono1:"4574-4546", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [], canchas: [])
		
		Complejo complejoPersistido = DBUtils.validateAndSave(complejo1)
		DBUtils.validateAndSave([complejo2,complejo3])
		assertEquals complejo1, complejoPersistido
		assertEquals 3, Complejo.findAll().size()
	}
	
	void testFailSave() {
		Complejo complejo = new Complejo()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(complejo)
		}
	}
}