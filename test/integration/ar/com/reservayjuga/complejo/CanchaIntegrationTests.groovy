package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.utils.DBUtils;

class CanchaIntegrationTests extends GroovyTestCase {
	
	Complejo complejo
	
	@Override
	protected void setUp() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi)
		DBUtils.validateAndSave(complejo)
	}
	
	// Agrego precios y se persisten. Borro la cancha y se borran los precios de la DB
	void testCanchas() {
		Precio l3 = new Precio(dia:1, horarioInicio: "12:00", precio: 300)
		Precio l4 = new Precio(dia:1, horarioInicio: "13:00", precio: 300)
		Precio m1 = new Precio(dia:2, horarioInicio: "17:00", precio: 300)
		Precio m2 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		Precio mi3 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo, precios:[])
		
		cancha.agregarPrecio(l3)
		cancha.agregarPrecio(l4)
		cancha.agregarPrecio(mi3)
		cancha.agregarPrecio(m1)
		
		DBUtils.validateAndSave(cancha)
		
		assertEquals 4, cancha.precios.size()
		assertEquals 4, Precio.list().size()
		
		cancha.eliminarPrecio(m1)
		
		assertEquals 3, cancha.precios.size()
		assertEquals 3, Precio.list().size()
		
		cancha.delete()
		
		assertEquals 0, Cancha.list().size()
		assertEquals 0, Precio.list().size()
	}
	
	void testSave() {
		Precio m2 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		Precio m3 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		Cancha cancha1 = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo)
		Cancha cancha2 = new Cancha(nombre:"Muni-1", deporte:DeporteEnum.FUTBOL_5, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo)
		
		cancha1.agregarPrecio(m2)
//		cancha1.agregarPrecio(m3) // no se puede porque el precio corresponde a una unica cancha
		cancha2.agregarPrecio(m3)
		
		Cancha canchaPersistida = DBUtils.validateAndSave(cancha1)
		DBUtils.validateAndSave([cancha2])
		assertEquals cancha1, canchaPersistida
		assertEquals 2, Cancha.findAll().size()
		assertEquals 2, Precio.findAll().size()
		
		cancha1.delete()
		
		assertEquals 1, Cancha.findAll().size()
		assertEquals 1, Precio.findAll().size() // se borro la m2 que solo la tenia cancha1
		
	}
	
	void testFailSave() {
		Cancha cancha = new Cancha()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(cancha)
		}
	}

}