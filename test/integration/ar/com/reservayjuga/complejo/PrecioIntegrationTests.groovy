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

class PrecioIntegrationTests extends GroovyTestCase {

	Cancha cancha
	
	@Override
	protected void setUp() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi)
		cancha = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true)
		complejo.agregarCancha(cancha)
		DBUtils.validateAndSave(complejo)
	}
	
	void testSave() {
		Precio p1 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		Precio p2 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		
		cancha.agregarPrecio(p1)
		cancha.agregarPrecio(p2)
		
		DBUtils.validateAndSave(cancha)
		Precio precioPersistido = Precio.findAll().get(0) //DBUtils.validateAndSave(p1)
		DBUtils.validateAndSave([p2])
		assertEquals p1, precioPersistido
		assertEquals 2, Precio.findAll().size()
	}
	
	void testFailSave() {
		Precio precio = new Precio()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(precio)
		}
	}
}
