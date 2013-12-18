package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.usuario.Encargado
import ar.com.reservayjuga.utils.DBUtils;

class CanchaServiceIntegrationTests extends GroovyTestCase {

	CanchaService canchaService
	Complejo complejo
	
	@Override
	protected void setUp() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi).save()
	}
	
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
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo)
		cancha.agregarPrecio(precio)
		DBUtils.validateAndSave(cancha)
		
		assertEquals "Poli-1", cancha.nombre
		canchaService.editarCancha([idCanchaEdit : cancha.id, cancha : [nombre:"Poli-TENIS", deporte:DeporteEnum.TENIS, superficie: SuperficieEnum.POLVO_DE_LADRILLO, cantidadJugadores: 2, cubierta: false]])
		assertEquals "Poli-TENIS", cancha.nombre
		assertEquals DeporteEnum.TENIS, cancha.deporte
		assertEquals SuperficieEnum.POLVO_DE_LADRILLO, cancha.superficie
		assertEquals 2, cancha.cantidadJugadores
		assertFalse cancha.cubierta
	}
	
	void testFailEditarCancha() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, precios:[precio], complejo:complejo).save()
		assertEquals "Poli-1", cancha.nombre
		shouldFail(EntityNotFoundException) {
			canchaService.editarCancha([idCanchaEdit: 123123])
		}
	}
	
	void testGetById() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo)
		cancha.agregarPrecio(precio)
		DBUtils.validateAndSave(cancha)
		
		Cancha canchaPersistida = canchaService.findEntityById(cancha.id)
		assertEquals cancha, canchaPersistida
	}
	
	void testCountTotal() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo)
		cancha.agregarPrecio(precio)
		DBUtils.validateAndSave(cancha)
		
		assertEquals 1, canchaService.countTotal(complejo)
	}
	
	void testGetCanchasDelComplejo() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo)
		cancha.agregarPrecio(precio)
		DBUtils.validateAndSave(cancha)
		
		List canchas = canchaService.getCanchasDelComplejo(complejo, [])
		
		assertTrue canchas.contains(cancha)
		assertEquals 1, canchas.size()
	}
	
	void testGetCanchasYCantidad() {
		Precio precio = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo)
		cancha.agregarPrecio(precio)
		DBUtils.validateAndSave(cancha)
		
		Encargado encargado = new Encargado(nombre:"Tomas", apellido:"Diego", username:"tomasdiego", mail:"d@t.com", password:"1234567", complejo:complejo)
		DBUtils.validateAndSave([encargado])
		
		def results = canchaService.getCanchasYCantidad(complejo, [], encargado.id)
		
		assertNotNull results
		assertTrue results.canchas.contains(cancha)
		assertEquals 1, results.canchasTotal
	}
	
	void testFailGetCanchasYCantidad() {
		shouldFail(EntityNotFoundException) {
			canchaService.getCanchasYCantidad(null, [], 0)
		}
		
		Encargado encargado = new Encargado(nombre:"Tomas", apellido:"Diego", username:"notengocomplejo", mail:"d@t.com", password:"1234567")
		DBUtils.validateAndSave([encargado])
		
		shouldFail(EntityNotFoundException) {
			canchaService.getCanchasYCantidad(null, [], encargado.id)
		}
	}
	
}