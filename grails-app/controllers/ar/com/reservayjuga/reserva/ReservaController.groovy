package ar.com.reservayjuga.reserva

import grails.converters.JSON

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.usuario.Encargado
import ar.com.reservayjuga.usuario.Jugador
import ar.com.reservayjuga.utils.Utils


class ReservaController {
	
	def authenticationService
	ReservaService reservaService
	
	def index() {
		redirect(action: administrarReservas)
	}
	
	def reservarCancha = {
		Complejo complejo = getComplejoDelEngargado()
		Reserva reserva = (complejo.reservas as List).get(0) // TODO sacar el hardcodeo // reservaService.crearReservaPresencial(complejo)
		session.data = reserva
		render(view: "reservar-cancha", model: [reserva:reserva, complejoId:complejo.id])
	}
	
	def agregarJugadorQueReserva = {
		println "params :: ${params}"
		def emailODni = params.emaildni
		List jugadores = Jugador.list()
		Jugador jugador
		
		if (Utils.isMail(emailODni)) {
			jugador = jugadores.find { it.mail.equals(emailODni) } // TODO sacar el hardcodeo
		} else if(Utils.onlyNumbers(emailODni)) {
			jugador = jugadores.find { it.dni.equals(emailODni) } // TODO sacar el hardcodeo
		} else {
			println "ERROR tipo de dato del parametro"
		}
		def data = session.data
		println "DATA :: ${data}"
		Reserva reserva = session.data // params.id as Reserva
		if(reserva && jugador) {
			reserva.jugador = jugador
		} else if(!jugador) {
			println "ERROR no se encontro ningun jugador"
		} else if(!reserva) {
			println "ERROR no tengo la reserva"
		} 
		println "jugador reserva : : ${reserva.jugador}"
		[reserva:reserva]
	}
	
	/**
	 * Muestra la pantalla de administracion de RESERVAS donde se ve el listado de estas
	 */
	def administrarReservas = {
		def result
		Complejo complejo
		
		try {
			complejo = getComplejoDelEngargado()
			result = getReservasYCantidad(complejo, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(view: "administrar-reservas", model: [canchas:complejo?.canchas, reservas:result?.reservas, reservasTotal:result?.reservasTotal])
		}	
	}
	
	/**
	 * Recupera las canchas del complejo para el listado y el numero total de ellas para el paginado
	 * @param complejo, params
	 * @return map [canchas, canchasTotal]
	 */
	def getReservasYCantidad(Complejo complejo, def params) {
		reservaService.getReservasYCantidad(complejo, params, authenticationService.getUserLoggedId())
	}
	
	/**
	 * Elimina la RESERVA indicada del Complejo y de la BD
	 */
	def deleteReserva = {
		def result
		Complejo complejo
		
		try {
			Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
			if(encargado) {
				complejo = encargado.complejo
				if(complejo) {
					reservaService.eliminarReservaDelComplejo(complejo, params.id)
					result = getReservasYCantidad(complejo, params)
				}
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'reserva.label', default: 'Reserva'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reserva.label', default: 'Reserva'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reserva.label', default: 'Reserva'), params.id])
		} finally {
			render(template: "tabla-reservas", model:[canchas:complejo?.canchas, reservas:result?.reservas, reservasTotal:result?.reservasTotal])
		}
	}
	
	/**
	 * Busca el jugador segun el id para mostrar en el modal panel
	 */
	def selectJugadorToShow = {
		Reserva reserva = reservaService.findEntityById(params.id)
		render(template:"modal-box-jugador", model:[jugador:reserva.jugador])
	}
	
	/**
	 * Busca la reserva segun el id para mostrar en el modal panel
	 */
	def selectToEdit = {
		Reserva reservaToEdit = reservaService.findEntityById(params.id)
		redirect(action: reservarCancha, model: reservaToEdit)
	}
	
	def searchHorariosParaFecha = {
		def fecha = params.fecha
		def complejoId = params.complejoId
		def modelResp = reservaService.getHorariosDisponiblesParaFecha(fecha, complejoId)
		modelResp.fecha = fecha
		modelResp.complejoId = complejoId
		render(template: "reserva_step_2_horarios", model:modelResp)
	}
	
	def searchCanchasParaHorario = {
		def fecha = params.fecha
		def complejoId = params.complejoId
		def horario = params.horario
		def horarios = ["11:00","12:00","13:00","14:00"]
		def canchas = ["c1","c2","c3","c4"]
		render(template: "reserva_step_2_canchas", model:[canchas:canchas, horarios:horarios, horario:horario, complejoId:complejoId, fecha:fecha])
	}
	
	/**
	 * Se seña una reserva cuando el jugador abona la seña de la misma
	 */
	def seniarReserva = {
		def result
		Complejo complejo
		try {
			Reserva reserva = reservaService.findEntityById(params.id)
			reservaService.seniar(reserva)
			complejo = getComplejoDelEngargado()
			result = getReservasYCantidad(complejo, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla-reservas", model:[canchas:complejo?.canchas, reservas:result?.reservas, reservasTotal:result?.reservasTotal])
		}
	}
	
	/**
	 * Se concreta una reserva cuando el jugador abona la totalidad de la misma
	 */
	def concretarReserva = {
		def result
		Complejo complejo
		try {
			Reserva reserva = reservaService.findEntityById(params.id)
			reservaService.concretar(reserva)
			complejo = getComplejoDelEngargado()
			result = getReservasYCantidad(complejo, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla-reservas", model:[canchas:complejo?.canchas, reservas:result?.reservas, reservasTotal:result?.reservasTotal])
		}
	}
	
	/**
	 * Se cancela una reserva 
	 */
	def cancelarReserva = {
		def result
		Complejo complejo
		try {
			Reserva reserva = reservaService.findEntityById(params.id)
			reservaService.cancelar(reserva)
			complejo = getComplejoDelEngargado()
			result = getReservasYCantidad(complejo, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla-reservas", model:[canchas:complejo?.canchas, reservas:result?.reservas, reservasTotal:result?.reservasTotal])
		}
	}
	
	def filtrarReservas = {
		def result
		Complejo complejo
		try {
			complejo = getComplejoDelEngargado()
			result = getReservasYCantidad(complejo, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(template: "tabla-reservas", model:[canchas:complejo?.canchas, reservas:result?.reservas, reservasTotal:result?.reservasTotal])
		}
	}
	
	def getComplejoDelEngargado() {
		reservaService.getComplejoDelEncargado(authenticationService.getUserLoggedId())
	}
	
	def generarReserva = {
		println "generarReserva : params : : ${params}"
	}
}