package ar.com.reservayjuga.complejo

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion

class CanchaIntegrationTests extends GroovyTestCase {
	
	Complejo complejo
	
	@Override
	protected void setUp() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi).save()
	}
	
	// Agrego precios y se persisten. Borro la cancha y se borran los precios de la DB
	void testCanchas() {
		Precio l3 = new Precio(dia:1, horarioInicio: "12:00", precio: 300)
		Precio l4 = new Precio(dia:1, horarioInicio: "13:00", precio: 300)
		Precio m1 = new Precio(dia:2, horarioInicio: "17:00", precio: 300)
		Precio m2 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		Precio mi3 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo, precios:[]).save()
		
		cancha.agregarPrecio(l3)
		cancha.agregarPrecio(l4)
		cancha.agregarPrecio(mi3)
		cancha.agregarPrecio(m1)
		
		assertEquals 4, cancha.precios.size()
		assertEquals 4, Precio.list().size()
		
		cancha.eliminarPrecio(m1)
		
		assertEquals 3, cancha.precios.size()
		assertEquals 3, Precio.list().size()
		
		cancha.delete()
		
		assertEquals 0, Precio.list().size()
	}
	
	void testSave() {
		Precio m2 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		Precio m3 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		Cancha cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo, precios:[m2,m3])
		Cancha cancha2 = new Cancha(nombre:"Muni-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true, complejo:complejo, precios:[m2])
		
		Cancha canchaPersistida = DBUtils.validateAndSave(cancha)
		DBUtils.validateAndSave([cancha2])
		assertEquals cancha, canchaPersistida
		assertEquals 2, Cancha.findAll().size()
		assertEquals 2, Precio.findAll().size()
	}
	
	void testFailSave() {
		Cancha cancha = new Cancha()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(cancha)
		}
	}

}