package ar.com.reservayjuga.ubicacion

import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion

class UbicacionService {

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

}