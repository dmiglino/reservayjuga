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
	
	/**
	 * Muestra la pantalla de administracion de CANCHAS donde se ve el listado de estas
	 */
	def administrarCancha = {
		def result
		try {
			result = getCanchasYCantidad(null, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		}
		render(view: "administrar-cancha", model: [canchas:result?.canchas, canchasTotal:result?.canchasTotal])
    }
	
	/**
	 * Muestra la pantalla de creacion de una cancha
	 */
	def agregarCancha = {
		render(view: "agregar-cancha", model: [cancha:new Cancha()])
	}
	
	/**
	 * Crea una cancha con los parametros y la agrega al complejo
	 */
	def crearCancha = {
		try {
			Complejo complejo = getComplejoDelEngargado()
			canchaService.crearCanchaParaComplejo(complejo, params.cancha)
			redirect(action: administrarCancha)
		} catch(ReservaYJugaException e) {
			println "error ${e} - falta manejo de errores"
			flash.message = message(code: 'default.created.message', args: [message(code: 'cancha.label', default: 'Cancha'), params.cancha.nombre])
			redirect(action: agregarCancha)
		}
	}
	
	/**
	 * Edita la cancha segun los parametros
	 */
	def editarCancha = {
		def result
		try {
			canchaService.editarCancha(params)
			result = getCanchasYCantidad(null, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla_canchas", model:[canchas:result?.canchas, canchasTotal:result?.canchasTotal])
		}
	}
	
	/**
	 * Elimina la CANCHA indicada del Complejo y de la BD
	 */
	def deleteCancha = {
		def result

		try {
			Complejo complejo = getComplejoDelEngargado()
			if(complejo) {
				canchaService.eliminarCanchaDelComplejo(complejo, params.id)
				result = getCanchasYCantidad(complejo, params)
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'cancha.label', default: 'Cancha'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'cancha.label', default: 'Cancha'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cancha.label', default: 'Cancha'), params.id])
		} finally {
			render(template: "tabla_canchas", model:[canchas:result?.canchas, canchasTotal:result?.canchasTotal])
		}
	}
	
	def filtrarCanchas = {
		def result
		try {
			result = getCanchasYCantidad(null, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla_canchas", model:[canchas:result?.canchas, canchasTotal:result?.canchasTotal])
		}
	}
	
	def getComplejoDelEngargado() {
		canchaService.getComplejoDelEncargado(authenticationService.getUserLoggedId())
	}
	
	/**
	 * Obtiene las superficies correspondientes al deporte elegido
	 */
	def getSuperficies() {
		DeporteEnum deporte = params.id as DeporteEnum
		render(template:"selectSuperficies", model:[cancha:params.cancha, superficiesDisponibles:deporte?.superficies])
	}

	/**
	 * Busca la cancha segun el id para mostrar en el modal panel
	 */
	def selectToEdit = {
		Cancha canchaToEdit = canchaService.findEntityById(params.id)
		render(template:"modal-box", model:[cancha:canchaToEdit])
	}

	/**
	 * Recupera las canchas del complejo para el listado y el numero total de ellas para el paginado
	 * @param complejo, params
	 * @return map [canchas, canchasTotal]
	 */
	def getCanchasYCantidad(Complejo complejo, def params) {
		canchaService.getCanchasYCantidad(complejo, params, authenticationService.getUserLoggedId())
	}
}