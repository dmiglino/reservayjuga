package ar.com.reservayjuga.ubicacion

class LocalidadService {

	/**
	 * Busca la localidad segun el id pasado y devuelve sus barrios
	 * @param id localidad
	 * @return barrios de la localidad
	 */
    def getBarrios(def id) {
		def barrios
		if(id) {
			def localidad = Localidad.get(id)
			barrios = localidad ? localidad.barrios : []
		}
		return barrios
    }
}
