package ar.com.reservayjuga.common

import ar.com.reservayjuga.complejo.Imagen;

abstract class GenericService<E> {
	
	/**
	 * Busca la entity segun el ID indicado
	 * @param id
	 * @return entity
	 */
	E findEntityById(def id) {
		getDomain().get(id)
	}
	
	abstract def getDomain()
	
}
