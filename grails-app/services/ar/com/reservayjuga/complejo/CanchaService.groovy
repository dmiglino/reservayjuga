package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.exception.EntityNotFoundException

class CanchaService extends GenericService<Cancha> {
	
	@Override
	public Object getDomain() {
		return Cancha;
	}
	
	/**
	 * Crea una nueva cancha con los parametros ingresados
	 * @param params
	 * @return cancha
	 */
    def crearCancha(def datos) {
		new Cancha(datos)
    }
	
	void editarCancha(def datos) {
		Cancha canchaInstance = findEntityById(datos.idCanchaEdit)
		
		if(!canchaInstance) {
			throw new EntityNotFoundException("Cancha", datos.idCanchaEdit)
		}
		
		canchaInstance.nombre = datos.nombreCanchaEdit
		canchaInstance.deporte = datos.deporteCanchaEdit
		canchaInstance.cubierta = datos.cubiertaCanchaEdit
		canchaInstance.superficie = datos.superficieCanchaEdit
		canchaInstance.cantidadJugadores = datos.cantidadJugadoresCanchaEdit
	}

}
