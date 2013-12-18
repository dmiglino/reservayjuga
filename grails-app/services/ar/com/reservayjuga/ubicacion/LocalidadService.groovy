package ar.com.reservayjuga.ubicacion

import java.util.List;

import ar.com.reservayjuga.common.GenericService

class LocalidadService extends GenericService<Localidad> {
	
	@Override
	def getDomain() {
		Localidad
	}
	
	def agregarBarrios(Localidad localidad, List barrios) {
		barrios.each {
			agregarBarrio(localidad, it)
		}
	}
	
	def agregarBarrio(Localidad localidad, Barrio barrio) {
		localidad.addToBarrios(barrio)
	}
	
	/**
	 * Busca la localidad segun el id pasado y devuelve sus barrios
	 * @param id localidad
	 * @return barrios de la localidad
	 */
    List getBarrios(def id) {
		def barrios = []
		if(id) {
			def localidad = findEntityById(id)
			barrios = localidad ? localidad.barrios : []
		}
		return barrios as List
    }

}