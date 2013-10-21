package ar.com.reservayjuga.ubicacion

class ProvinciaService {

	/**
	 * Busca la provincia segun el id pasado y devuelve sus localidades
	 * @param id provincia
	 * @return localidades de la provincia
	 */
    def getLocalidades(def id) {
		def localidades
		if(id) {
			def provincia = Provincia.get(id)
			localidades = provincia ? provincia.localidades : []
		}
		return localidades
    }
}
