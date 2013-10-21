package ar.com.reservayjuga.ubicacion

import ar.com.reservayjuga.complejo.Complejo

class UbicacionService {

	BarrioService barrioService
	
	/**
	 * Crea una ubicacion a partir de los datos pasados por parametro
	 * @param map
	 * @return ubicacion
	 */
    Ubicacion createUbicacion(def map) {
		Barrio barrio = new Barrio(nombre:map.barrio, localidad: new Localidad(nombre:map.localidad, provincia:new Provincia(nombre:map.provincia, pais: new Pais(nombre:map.pais))))
		Ubicacion ubicacion = new Ubicacion(direccion:map.direccion, barrio:barrio)
		return ubicacion
    }

	/**
	 * Actualiza la ubicacion del complejo
	 * @param complejo
	 * @param datos
	 */
	void guardarUbicacionDelComplejo(Complejo complejo, def datos) {
		def barrio = barrioService.findBarrioById(datos.barrio.id)
		if(!barrio) {
//			TODO throw new BarrioNoEncontradoException(datos.barrio.id)
		}
		def direccion = datos.direccion
		if(complejo.ubicacion) {
			complejo.ubicacion.barrio = barrio
			complejo.ubicacion.direccion = direccion
		} else {
			Ubicacion ubicacion = new Ubicacion(barrio: barrio, direccion: direccion)
			complejo.ubicacion = ubicacion
		}
	}

}