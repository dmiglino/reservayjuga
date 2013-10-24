package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.usuario.Encargado

class CanchaController {
	
	CanchaService canchaService
	ComplejoService complejoService
	
	def index() {
		redirect(action: administrarCancha)
	}

	def administrarCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		def canchas = complejo.canchas. as List
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
		println "params.cancha: "+params.cancha
		Cancha cancha = canchaService.crearCancha(params.cancha)
		DBUtils.validateAndSave(cancha)
		complejoService.agregarCancha(complejo,cancha)
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
	
}