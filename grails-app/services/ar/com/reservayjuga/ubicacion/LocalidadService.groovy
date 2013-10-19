package ar.com.reservayjuga.ubicacion

class LocalidadService {

	/**
	 * Busca la localidad segun el id pasado y devuelve sus barrios
	 * @param id localidad
	 * @return barrios de la localidad
	 */
    def getBarrios(def id) {
		println "getBarrios: " + id
		def barrios
		if(id) {
			def localidad = Localidad.get(id)
			println localidad
			barrios = localidad ? localidad.barrios : []
			println barrios
		}
		return barrios
    }
}
