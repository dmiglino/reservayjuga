package ar.com.reservayjuga.ubicacion

import ar.com.reservayjuga.common.GenericService

class ProvinciaService extends GenericService<Provincia> {
	
	def agregarLocalidades(Provincia provincia, List localidades) {
		localidades.each {
			agregarLocalidad(provincia, it)
		}
	}
	
	def agregarLocalidad(Provincia provincia, Localidad localidad) {
		provincia.addToLocalidades(localidad)
	}
	
	/**
	 * Busca la provincia segun el id pasado y devuelve sus localidades
	 * @param id provincia
	 * @return localidades de la provincia
	 */
    List getLocalidades(def id) {
		def localidades = []
		if(id) {
			def provincia = Provincia.get(id)
			localidades = provincia ? provincia.localidades : []
		}
		return localidades as List
    }

	@Override
	public Object getDomain() {
		return Provincia;
	}

}