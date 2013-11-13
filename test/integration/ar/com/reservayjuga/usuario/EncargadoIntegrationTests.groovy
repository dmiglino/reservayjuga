package ar.com.reservayjuga.usuario

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.Horario
import ar.com.reservayjuga.complejo.Servicios
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.utils.DBUtils;

class EncargadoIntegrationTests extends GroovyTestCase {
	
	void testSave() {
		Barrio barrio = new Barrio(nombre:"Agronomia", localidad: new Localidad(nombre:"Capital Federal", provincia:new Provincia(nombre:"Buenos Aires", pais: new Pais(nombre:"Argentina").save()).save()).save()).save()
		Ubicacion ubi = new Ubicacion(direccion:"Pedro Moran 2379", barrio:barrio)
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: hora)
		DBUtils.validateAndSave(complejo)
				
		Encargado encargado1 = new Encargado(nombre:"Diego", apellido:"Miglino", username:"diegol", mail:"d@m.com", password:"1234567", complejo:complejo)
		Encargado encargado2 = new Encargado(nombre:"Tomas", apellido:"Escamez", username:"tomase", mail:"d@m.com", password:"7654321", complejo:complejo)
		
		Encargado encargadoPersistido = DBUtils.validateAndSave(encargado1)
		DBUtils.validateAndSave([encargado2])
		assertEquals encargado1, encargadoPersistido
		assertEquals 2, Encargado.findAll().size()
	}
	
	void testUniqueConstraint() {
		Encargado encargado = new Encargado(nombre:"Diego", apellido:"Miglino", username:"diegol", mail:"d@m.com", password:"1234567")
		DBUtils.validateAndSave(encargado)
		
		Encargado encargado1 = new Encargado(nombre:"Diego", apellido:"Miglino", username:"diegol", mail:"d@m.com", password:"1234567")
		assertFalse encargado1.validate()
		assertEquals "unique", encargado1.errors["username"].code
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(encargado1)
		}
	}
	
	void testFailSave() {
		Encargado encargado = new Encargado()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(encargado)
		}
    }

}