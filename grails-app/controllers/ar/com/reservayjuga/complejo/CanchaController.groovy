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
		def result = getCanchasYCantidad(null)
		render(view: "administrar-cancha", model: [canchas:result.canchas, canchasTotal:result.canchasTotal, deportesDisponibles:DeporteEnum.values()])
    }
	
	/**
	 * Muestra la pantalla de creacion de una cancha
	 */
	def agregarCancha = {
		render(view: "agregar-cancha", model: [cancha:new Cancha(), deportesDisponibles:DeporteEnum.values()])
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
		def result
		try {
			canchaService.editarCancha(params)
			result = getCanchasYCantidad(null)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla_canchas", model:[canchas:result.canchas, canchasTotal:result.canchasTotal])
		}
	}
	
	/**
	 * Elimina la cancha indicada del complejo y de la BD
	 */
	def deleteCancha = {
		def result

		try {
			Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
			if(encargado) {
				Complejo complejo = encargado.complejo
				if(complejo) {
				canchaService.eliminarCanchaDelComplejo(complejo, params.id)
				result = getCanchasYCantidad(complejo)
				}
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} finally {
			render(template: "tabla_canchas", model:[canchas:result.canchas, canchasTotal:result.canchasTotal])
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
		render(template:"modal-box", model:[cancha:canchaToEdit, deportesDisponibles:DeporteEnum.values()])
	}

	/**
	 * Recupera las canchas del complejo para el listado y el numero total de ellas para el paginado
	 * @param complejo
	 * @return map [canchas, canchasTotal]
	 */
	def getCanchasYCantidad(Complejo complejo) {
		def canchas, canchasTotal
		
		if(complejo == null) {
			Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
			if(encargado) {
				complejo = encargado.complejo
			} else {
				// TODO tirar exception
				println "Encargado no encontrado.."
			}
		}
		
		if(complejo) {
			canchas = canchaService.getCanchasDelComplejo(complejo, params)
			canchasTotal = canchaService.countTotal(complejo)
		} else {
			// TODO tirar exception
			println "Complejo no encontrado.."
		} 
		
		return [canchas:canchas, canchasTotal:canchasTotal]
	}
}