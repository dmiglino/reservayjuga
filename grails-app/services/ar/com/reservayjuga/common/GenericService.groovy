package ar.com.reservayjuga.common

import ar.com.reservayjuga.exception.EntityNotFoundException

abstract class GenericService<E> {
	
	/**
	 * Busca la entity segun el ID indicado
	 * @param id
	 * @return entity
	 */
	E findEntityById(def id) {
		id ? getDomain().get(id) : null
	}
	
	/**
	 * Busca la entity segun el ID indicado. Lanza EntityNotFoundException si no la encuentra.
	 * @param id
	 * @return entity
	 */
	E findEntityByIdAndValidate(def id) {
		E instance = findEntityById(id)
		if(!instance) {
			throw new EntityNotFoundException(getDomain().toString(), id)
		}
		return instance
	}
	
	abstract def getDomain()
	
}
