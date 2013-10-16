package ar.com.reservayjuga.complejo

class UbicacionService {

	/**
	 * Crea una ubicacion a partir de los datos pasados por parametro
	 * @param map
	 * @return ubicacion
	 */
    Ubicacion createUbicacion(def map) {
		Ubicacion ubicacion = new Ubicacion(direccion:map.direccion, barrio:map.barrio, localidad:map.localidad, provincia:map.provincia, pais:map.pais)
		return ubicacion
    }

}