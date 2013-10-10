package ar.com.reservayjuga

import ar.com.reservayjuga.exception.InvalidEntityException


/**
 * Metodos utiles para persistencia
 * @author Diego Miglino
 */
class DBUtils {

	/**
	 * Valida la entidad antes de persistirla.
	 * @param flushValue
	 */
	static def validateAndSave(def entity, boolean flushValue) {
		if(entity.validate())
			entity.save(flush:flushValue)
		else
			throw new InvalidEntityException(entity.errors)

		return entity
	}
	
	static def validateAndSave(def entity) {
		validateAndSave(entity, true)
	}
	
	static def validateAndSave(List entities) {
		validateAndSave(entities, true)
	}
	
	static def validateAndSave(List entities, boolean flushValue) {
		entities.each {
			validateAndSave(it, flushValue)
		}
	}

}