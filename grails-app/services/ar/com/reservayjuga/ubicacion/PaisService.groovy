package ar.com.reservayjuga.ubicacion

class PaisService {
	
	/**
	 * Busca el pais segun el id pasado y devuelve sus provincias
	 * @param id pais
	 * @return provincias del pais
	 */
    def getProvincias(def id) {
		println "getProvincias: " + id
		def provincias
		if(id) {
			def pais = Pais.get(id)
			println pais
			provincias = pais.provincias
			println provincias
		}
		return provincias
    }
}
