package ar.com.reservayjuga.complejo

class ExtrasService {

	/**
	 * Crea extras a partir de los datos pasados por parametro
	 * @param map
	 * @return extras
	 */
    def createExtras(def map) {
		Extras extras = new Extras(quiereArbitro: map.quiereArbitro, quierePechera: map.quierePechera, precioArbitro: map.precioArbitro, precioPechera: map.precioPechera)
		return extras
    }
}
