package ar.com.reservayjuga.reserva

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.usuario.Encargado


class ReservaController {
	
	def authenticationService
	ReservaService reservaService
	
	def index() {
		redirect(action: administrarReservas)
	}
	
	def reservarCancha = {
		render(view: "reservar-cancha", model: [])
	}
	
	/**
	 * Muestra la pantalla de administracion de RESERVAS donde se ve el listado de estas
	 */
	def administrarReservas = {
		def result
		try {
			result = getReservasYCantidad(null, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		} finally {
			render(view: "administrar-reservas", model: [reservas:result.reservas, reservasTotal:result.reservasTotal])
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

		try {
			Encargado encargado = Encargado.get(authenticationService.getUserLoggedId())
			if(encargado) {
				Complejo complejo = encargado.complejo
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
			render(template: "tabla-reservas", model:[reservas:result.reservas, reservasTotal:result.reservasTotal])
		}
	}
	
	/**
	 * Busca el jugador segun el id para mostrar en el modal panel
	 */
	def selectJugadorToShow = {
		// TODO hacer jugadorService
		Reserva jugadorToShow = reservaService.getReservaById(params.id)
		render(template:"modal-box-jugador", model:[reserva:jugadorToShow])
	}
	
	/**
	 * Busca la reserva segun el id para mostrar en el modal panel
	 */
	def selectToEdit = {
		Reserva reservaToEdit = reservaService.getReservaById(params.id)
		redirect(action: administrarReservas, model: reservaToEdit)
	}
}