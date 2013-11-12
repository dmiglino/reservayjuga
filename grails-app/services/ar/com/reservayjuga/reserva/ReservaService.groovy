package ar.com.reservayjuga.reserva

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.complejo.Cancha

class ReservaService extends GenericService<Reserva> {

	@Override
	def getDomain() {
		Reserva
	}
	
	/**
	 * Obtiene la Reserva segun el id indicado
	 * @param id
	 * @return
	 */
	def getReservaById(id) {
		id ? Reserva.get(id) : null
	}
	
}