package ar.com.reservayjuga.reserva

import grails.converters.JSON

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.complejo.Cancha
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.usuario.Encargado
import ar.com.reservayjuga.usuario.Jugador
import ar.com.reservayjuga.utils.DBUtils
import ar.com.reservayjuga.utils.Utils


class ReservaController {
	
	def authenticationService
	ReservaService reservaService
	
	def index() {
		redirect(action: administrarReservas)
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
	
	def reservarCancha = {
		Complejo complejo = getComplejoDelEngargado()
		Reserva reserva = reservaService.crearReservaPresencial(complejo)
		session.data = reserva
		render(view: "reservar-cancha", model: [reserva:reserva, complejoId:complejo.id])
	}
	
	def buscarJugador = {
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
		render(template: "reserva_step_1_datos_jugador", model:[jugador:jugador])
	}
	
	def actualizarDatosDelJugador = {
		try {
			reservaService.actualizarDatosDelJugador(params)
		} catch(InvalidEntityException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		}
	}
	
	def agregarDatosALaReserva = {
		Reserva reserva = session.data
		reservaService.agregarDatosALaReserva(reserva, params)
		render(template: "reserva_step_3_resumen", model:[reserva:reserva])
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
		Reserva reservaToEdit = reservaService.findEntityByIdAndValidate(params.reservaId)
		session.data = reservaToEdit
		render(view: "reservar-cancha", model: [reserva:reservaToEdit, complejoId:reservaToEdit.complejo.id])
	}
	
	def searchHorariosParaFecha = {
		def modelResp = reservaService.getHorariosDisponiblesParaFecha(params.fecha, params.complejoId)
		render(template: "reserva_step_2_horarios", model:modelResp)
	}
	
	def searchCanchasParaHorario = {
		def modelResp = reservaService.getCanchasDisponiblesParaHorario(params.fecha, params.complejoId, params.horario)
		render(template: "reserva_step_2_canchas", model:modelResp)
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
		}  catch (Exception e) {
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
		Reserva reserva = session.data
		reservaService.generarReserva(reserva, params)
	}
}