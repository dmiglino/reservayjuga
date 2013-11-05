package ar.com.reservayjuga.complejo

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.exception.ReservaYJugaException
import ar.com.reservayjuga.usuario.Encargado

class CanchaController {
	def authenticationService
	CanchaService canchaService
	
	def index() {
		redirect(action: administrarCancha)
	}
	
	def administrarCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		//Encargado encargado = Encargado.list().get(0)
		Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
		Complejo complejo = encargado.complejo
		def canchas = complejo.canchas as List
		def deportesDisponibles = DeporteEnum.values()
		def superficiesDisponibles = SuperficieEnum.values()
		
		def sortProperty = params.sort ? params.sort : "nombre"
		canchas.sort { i1, i2 ->
			if(params.order == "desc") {
				i2."${sortProperty}" <=> i1."${sortProperty}"
			} else {
				i1."${sortProperty}" <=> i2."${sortProperty}"
			}
		}

		render(view: "administrar-cancha", model: [canchas:canchas, canchasTotal:canchas.size(), deportesDisponibles:deportesDisponibles, superficiesDisponibles:superficiesDisponibles])
    }
	
	def agregarCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		def deportesDisponibles = DeporteEnum.values()
		def superficiesDisponibles = SuperficieEnum.values()
		render(view: "agregar-cancha", model: [cancha:new Cancha(), deportesDisponibles:deportesDisponibles, superficiesDisponibles:superficiesDisponibles])
	}
	
	def crearCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		try {
			Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
			Complejo complejo = encargado.complejo
			canchaService.crearCanchaParaComplejo(complejo, params.cancha)
			redirect(action: administrarCancha)
		} catch(ReservaYJugaException e) {
			println "error ${e} - falta manejo de errores"
			flash.message = message(code: 'default.created.message', args: [message(code: 'cancha.label', default: 'Cancha'), params.cancha.nombre])
			redirect(action: agregarCancha)
		}
	}
	
	def editarCancha = {
		try {
			canchaService.editarCancha(params)
		} catch (EntityNotFoundException e) {
			println "ERROR: ${e}"
			// TODO mostrar error en pantalla
		}
	
	}
	
	/**
	 * Elimina la cancha indicada del complejo y de la BD
	 */
	def deleteCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
		Complejo complejo = encargado.complejo
		
		try {
			canchaService.eliminarCanchaDelComplejo(complejo, params.id)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} finally {
			redirect(action: administrarCancha)
		}
	}
	
	def getSuperficies() {
		DeporteEnum deporte = params.id as DeporteEnum
		def superficiesDisponibles = deporte?.superficies
		render(template:"selectSuperficies", model:[superficiesDisponibles:superficiesDisponibles])
	}
	
	def selectToEdit = {
		Cancha cancha = Cancha.get(params.id)
		[cancha:cancha]
	}
}