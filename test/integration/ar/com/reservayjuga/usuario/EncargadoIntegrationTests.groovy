package ar.com.reservayjuga.usuario

import static org.junit.Assert.*

import org.junit.*

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.Horario
import ar.com.reservayjuga.complejo.Servicios
import ar.com.reservayjuga.complejo.Ubicacion
import ar.com.reservayjuga.exception.InvalidEntityException

class EncargadoIntegrationTests extends GroovyTestCase {
	
	void testSave() {
		Ubicacion ubi = new Ubicacion (direccion:"Pedro Mor�n 2379", barrio:"Agronom�a", localidad:"Capital Federal", provincia:"Buenos Aires", pais:"Argentina")
		Servicios servi = new Servicios (vestuario: true, television: false, ayudaMedica: true, bebida: true, comida: false, estacionamiento: true, precioEstacionamiento: 10, gimnasio: false, torneo: true, wifi: false)
		Horario hora = new Horario (dia: 1, horarioApertura: "10:00", horarioCierre: "18:00")
		Complejo complejo = new Complejo (nombre: "Garden Club", webSite: "", telefono1:"4574-0077", mail:"garden@mail.com", informacionExtra: "Info garden", ubicacion: ubi, servicios: servi, horarios: hora)
		DBUtils.validateAndSave(complejo)
				
		Encargado encargado1 = new Encargado(nombre:"Diego", apellido:"Miglino", nombreUsuario:"diegol", mail:"d@m.com", clave:"1234567", complejo:complejo)
		Encargado encargado2 = new Encargado(nombre:"Tomas", apellido:"Escamez", nombreUsuario:"tomase", mail:"d@m.com", clave:"7654321", complejo:complejo)
		
		Encargado encargadoPersistido = DBUtils.validateAndSave(encargado1)
		DBUtils.validateAndSave([encargado2])
		assertEquals encargado1, encargadoPersistido
		assertEquals 2, Encargado.findAll().size()
	}
	
	void testFailSave() {
		Encargado encargado = new Encargado()
		shouldFail(InvalidEntityException) {
			DBUtils.validateAndSave(encargado)
		}
    }

}