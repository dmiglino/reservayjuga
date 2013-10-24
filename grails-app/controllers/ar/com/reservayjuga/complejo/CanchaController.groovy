package ar.com.reservayjuga.complejo

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.usuario.Encargado

class CanchaController {
	
	CanchaService canchaService
//	ComplejoService complejoService
	
	def index() {
		redirect(action: administrarCancha)
	}

	def administrarCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		def canchas = complejo.canchas as List
		def deportesDisponibles = DeporteEnum.values()
		def superficiesDisponibles = SuperficieEnum.values()
		render(view: "administrar-cancha", model: [canchas:canchas, deportesDisponibles:deportesDisponibles, superficiesDisponibles:superficiesDisponibles])
	}
	
	def agregarCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		def deportesDisponibles = DeporteEnum.values()
		def superficiesDisponibles = SuperficieEnum.values()
		render(view: "agregar-cancha", model: [deportesDisponibles:deportesDisponibles, superficiesDisponibles:superficiesDisponibles])
	}
	
	def crearCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		canchaService.crearCanchaParaComplejo(complejo, params.cancha)
		redirect(action: administrarCancha)
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
		Encargado encargado = Encargado.list().get(0)
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
}