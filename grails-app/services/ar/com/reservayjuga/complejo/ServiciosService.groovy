package ar.com.reservayjuga.complejo

class ServiciosService {
	
	/**
	 * Crea un objeto servicios a partir de los datos pasados por parametro
	 * @param map
	 * @return servicios
	 */
    Servicios createServicios(def map) {
		Servicios servicios = new Servicios(vestuario:map.vestuario, television:map.television, bebida:map.bebida, comida:map.comida, ayudaMedica:map.ayudaMedica, torneo:map.torneo, wifi:map.wifi, gimnasio:map.gimnasio, estacionamiento:map.estacionamiento, precioEstacionamiento:map.precioEstacionamiento)
		return servicios
    }
}
