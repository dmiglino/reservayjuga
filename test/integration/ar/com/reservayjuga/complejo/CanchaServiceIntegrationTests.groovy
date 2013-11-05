package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion

class CanchaServiceIntegrationTests extends GroovyTestCase {

	CanchaService canchaService
	
	void testAgregarYBorrarCancha() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi).save()
		
		canchaService.crearCanchaParaComplejo(complejo, [nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true])
		
		assertEquals 1, complejo.canchas.size()
		assertEquals 1, Cancha.list().size()
		
		Cancha cancha = Cancha.list().get(0)
		assertEquals "Poli-1", cancha.nombre
		
		canchaService.eliminarCanchaDelComplejo(complejo, cancha.id)
		
		assertEquals 0, Cancha.list().size()
	}
	
	void testFailEliminarCanchaDelComplejo() {
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden")
		shouldFail(EntityNotFoundException) {
			canchaService.eliminarCanchaDelComplejo(complejo, 123123)
		}
	}
	
	void testEditarCancha() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[precio]).save()
		assertEquals "Poli-1", cancha.nombre
		canchaService.editarCancha([idCanchaEdit: cancha.id, nombreCanchaEdit:"Poli-TENIS", deporteCanchaEdit:DeporteEnum.TENIS, superficie: SuperficieEnum.POLVO_DE_LADRILLO, cantidadJugadoresCanchaEdit: 2, cubiertaCanchaEdit: false])
		assertEquals "Poli-TENIS", cancha.nombre
		assertEquals DeporteEnum.TENIS, cancha.deporte
		assertEquals SuperficieEnum.POLVO_DE_LADRILLO, cancha.superficie
		assertEquals 2, cancha.cantidadJugadores
		assertFalse cancha.cubierta
	}
	
	void testFailEditarCancha() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[precio]).save()
		assertEquals "Poli-1", cancha.nombre
		shouldFail(EntityNotFoundException) {
			canchaService.editarCancha([idCanchaEdit: 123123])
		}
	}
	
}