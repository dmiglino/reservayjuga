package ar.com.reservayjuga.ubicacion

class PaisService {
	
	/**
	 * Busca el pais segun el id pasado y devuelve sus provincias
	 * @param id pais
	 * @return provincias del pais
	 */
    def getProvincias(def id) {
		def provincias
		if(id) {
			def pais = Pais.get(id)
			provincias = pais.provincias
		}
		return provincias
    }
}
