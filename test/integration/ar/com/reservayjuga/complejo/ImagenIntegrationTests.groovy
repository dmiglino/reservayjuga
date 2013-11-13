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

class ImagenIntegrationTests extends GroovyTestCase {

	void testSave() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi).save()
		
		Imagen imagen1 = new Imagen(descripcion:"fotito",nombre:"f1",extension:"jpg",portada:false,fecha:new Date(), complejo:complejo)
		Imagen imagen2 = new Imagen(descripcion:"descripcion",nombre:"nombre",extension:"jpg",portada:true,fecha:new Date(), complejo:complejo)
		
		Imagen imagenPersistida = DBUtils.validateAndSave(imagen1)
		DBUtils.validateAndSave([imagen2])
		assertEquals imagen1, imagenPersistida
		assertEquals 2, Imagen.findAll().size()
	}
	
	void testFailSave() {
		Imagen imagen = new Imagen()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(imagen)
		}
	}
}
