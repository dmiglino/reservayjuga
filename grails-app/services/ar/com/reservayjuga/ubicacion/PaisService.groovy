package ar.com.reservayjuga.ubicacion

import java.util.List;

import ar.com.reservayjuga.common.GenericService

class PaisService extends GenericService<Pais> {
	
	def agregarProvincias(Pais pais, List provincias) {
		provincias.each {
			agregarProvincia(pais, it)
		}
	}
	
	def agregarProvincia(Pais pais, Provincia provincia) {
		pais.addToProvincias(provincia)
	}
	
	/**
	 * Busca el pais segun el id pasado y devuelve sus provincias
	 * @param id pais
	 * @return provincias del pais
	 */
    List getProvincias(def id) {
		def provincias = []
		if(id) {
			def pais = Pais.get(id)
			provincias = pais ? pais.provincias : []
		}
		return provincias as List
    }

	@Override
	public Object getDomain() {
		return Pais;
	}

}