package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.usuario.Jugador
import ar.com.reservayjuga.utils.DBUtils;

class ComplejoIntegrationTests extends GroovyTestCase {
    
	// Agrego canchas y se persisten. Borro el complejo y se borran las canchas de la DB
	void testCanchas() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [], canchas: []).save()
		
		Cancha cancha1 = new Cancha(nombre:"Cancha 1", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[])
		Cancha cancha2 = new Cancha(nombre:"Cancha 2", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_CAUCHO, cantidadJugadores:5, cubierta: true, precios:[])
		Cancha cancha3 = new Cancha(nombre:"Cancha 3", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:8, cubierta: true, precios:[])
		
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
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		Imagen ima = new Imagen(nombre: "foto", extension: ".jpg", descripcion: "foto cancha 1", fecha: new Date(), portada: true)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: [], canchas: []).save()
		
		complejo.agregarHorario(hora)
		complejo.agregarImagen(ima)
		
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
		
		complejo.eliminarImagen(ima)
		assertTrue complejo.imagenes.isEmpty()
		assertEquals 0, Imagen.list().size()
		
		complejo.delete()
		
		assertEquals 0, Ubicacion.list().size()
		assertEquals 0, Servicios.list().size()
		assertEquals 0, Horario.list().size()
		assertEquals 0, Imagen.list().size()
	}
	
	//No se tiene que borrar la reserva de la DB aunque se borre el complejo
	void testReserva() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo(nombre: "Poli Club", webSite: "", telefono1:"4574-0077", mail:"poli@mail.com", informacionExtra: "Info poli", ubicacion: ubi, servicios: servi, horarios: [], canchas: []).save()
		Cancha cancha = new Cancha(nombre:"Cancha 1", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[], complejo:complejo).save()
		Jugador jugador = new Jugador(nombre: "Die", apellido: "Migli", username:"dmiglino", telefono: "4534556", mail: "die@mail.com", password: "1234567", sexo: "M", fechaNacimiento: new Date()).save()
		
		// creacion de reserva
		Reserva res = new Reserva(complejo:complejo, jugador: jugador, cancha: cancha, dia: new Date(), horaInicio: "11:00", horaFin: "12:00", senia: 99, precioTotal: 450, tipoReserva: "ONLINE")
		complejo.agregarReserva(res)
		jugador.agregarReserva(res)

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
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
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