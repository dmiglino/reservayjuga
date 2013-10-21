package ar.com.reservayjuga.ubicacion

import ar.com.reservayjuga.ubicacion.Barrio

class BarrioService {

	/**
	 * Busca el barrio segun el ID indicado
	 * @param id
	 * @return barrio
	 */
    def findBarrioById(id) {
		Barrio barrioSeleccionado
		if(id) {
			barrioSeleccionado = Barrio.findById(id)
			println "barrioSeleccionado: " + barrioSeleccionado
		}
		return barrioSeleccionado
    }

}