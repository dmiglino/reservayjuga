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
	 * Muestra la pantalla de administracion de canchas donde se ve el listado de estas
	 */
	def administrarCancha = {
		def canchas
		def canchasTotal
		def deportesDisponibles
		def superficiesDisponibles
		Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
		if(encargado) {
			Complejo complejo = encargado.complejo
			if(complejo) {
				canchas = canchaService.getCanchasDelComplejo(complejo, params)
				canchasTotal = canchaService.countTotal(complejo)
				
				deportesDisponibles = DeporteEnum.values()
				superficiesDisponibles = SuperficieEnum.values()
			} else {
				println "Complejo no encontrado.."
			}
		} else {
			println "Encargado no encontrado.."
		}
		render(view: "administrar-cancha", model: [canchas:canchas, canchasTotal:canchasTotal, deportesDisponibles:deportesDisponibles, superficiesDisponibles:superficiesDisponibles])
    }
	
	/**
	 * Muestra la pantalla de creacion de una cancha
	 */
	def agregarCancha = {
		def deportesDisponibles = DeporteEnum.values()
		def superficiesDisponibles = SuperficieEnum.values()
		render(view: "agregar-cancha", model: [cancha:new Cancha(), deportesDisponibles:deportesDisponibles, superficiesDisponibles:superficiesDisponibles])
	}
	
	/**
	 * Crea una cancha con los parametros y la agrega al complejo
	 */
	def crearCancha = {
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
	
	/**
	 * Edita la cancha segun los parametros
	 */
	def editarCancha = {
		def canchas
		def canchasTotal
		try {
			Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
			if(encargado) {
				canchaService.editarCancha(params)
				Complejo complejo = encargado.complejo
				if(complejo) {
					canchas = canchaService.getCanchasDelComplejo(complejo, params)
					canchasTotal = canchaService.countTotal(complejo)
				}
			}
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla_canchas", model:[canchas:canchas, canchasTotal:canchasTotal])
		}
	}
	
	/**
	 * Elimina la cancha indicada del complejo y de la BD
	 */
	def deleteCancha = {
		def canchas
		def canchasTotal

		try {
			Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
			if(encargado) {
				Complejo complejo = encargado.complejo
				canchaService.eliminarCanchaDelComplejo(complejo, params.id)
				if(complejo) {
					canchas = canchaService.getCanchasDelComplejo(complejo, params)
					canchasTotal = canchaService.countTotal(complejo)
				}
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} finally {
			render(template: "tabla_canchas", model:[canchas:canchas, canchasTotal:canchasTotal])
		}
	}

	/**
	 * Obtiene las superficies correspondientes al deporte elegido
	 */
	def getSuperficies() {
		DeporteEnum deporte = params.id as DeporteEnum
		def superficiesDisponibles = deporte?.superficies
		render(template:"selectSuperficies", model:[cancha:params.cancha, superficiesDisponibles:superficiesDisponibles])
	}

	/**
	 * Busca la cancha segun el id para mostrar en el modal panel
	 */
	def selectToEdit = {
		Cancha canchaToEdit = canchaService.getCanchaById(params.id)
		def deportesDisponibles = DeporteEnum.values()
		render(template:"modal-box", model:[cancha:canchaToEdit, deportesDisponibles:deportesDisponibles])
	}

}