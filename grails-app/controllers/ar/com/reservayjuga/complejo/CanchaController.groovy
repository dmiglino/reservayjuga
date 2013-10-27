package ar.com.reservayjuga.complejo

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.usuario.Encargado

class CanchaController {
	
	CanchaService canchaService
	
	def index() {
		redirect(action: administrarCancha)
	}
	
//    def list = {
//		println params
//        params.max = Math.min(params.max ? params.max.intValue() : 10, 100)
//		Encargado encargado = Encargado.list().get(0)
//		Complejo complejo = encargado.complejo
//		def canchas = complejo.canchas.sort { i1, i2 -> 
//			if(params.order == "asc") {
//				i1."${params.sort}" <=> i2."${params.sort}" 
//			} else {
//				i2."${params.sort}" <=> i1."${params.sort}"
//			}
//		}
//		render(template: "tabla_canchas", model: [canchas:canchas, canchasTotal:canchas.size()])
//    }
	
	def administrarCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		Encargado encargado = Encargado.list().get(0)
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

//		if(!params.sort) {
			render(view: "administrar-cancha", model: [canchas:canchas, deportesDisponibles:deportesDisponibles, superficiesDisponibles:superficiesDisponibles])
//		} else {
//			render(template: "tabla_canchas", model: [canchas:canchas, canchasTotal:canchas.size()])
//		}
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