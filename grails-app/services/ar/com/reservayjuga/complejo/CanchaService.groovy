package ar.com.reservayjuga.complejo

import org.hibernate.criterion.Order
import org.hibernate.criterion.Restrictions

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.usuario.Encargado

class CanchaService extends GenericService<Cancha> {
	
	ComplejoService complejoService
	
	@Override
	def getDomain() {
		Cancha
	}
	
	/**
	 * Obtiene la Cancha segun el id indicado
	 * @param id
	 * @return
	 */
	def getCanchaById(id) {
		id ? Cancha.get(id) : null
	}
	
	/**
	 * Crea una nueva cancha con los parametros ingresados
	 * @param params
	 * @return cancha
	 */
    def crearCancha(def datos) {
		new Cancha(datos)
    }
	
	def editarCancha(def datos) {
		Cancha canchaInstance = findEntityById(datos.idCanchaEdit)
		
		if(!canchaInstance) {
			throw new EntityNotFoundException("Cancha", datos.idCanchaEdit)
		}
		
		canchaInstance.nombre = datos.cancha.nombre
		canchaInstance.deporte = datos.cancha.deporte
		canchaInstance.cubierta = datos.cancha.cubierta
		canchaInstance.superficie = datos.cancha.superficie
		canchaInstance.cantidadJugadores = new Integer(datos.cancha.cantidadJugadores)
		DBUtils.validateAndSave(canchaInstance)
	}
	
	/**
	 * Crea una nueva imagen y la guarda en el complejo
	 * @param complejo
	 * @param imagenData
	 */
	void crearCanchaParaComplejo(Complejo complejo, def canchaData) {
		Cancha cancha = crearCancha(canchaData)
		cancha.complejo = complejo
		DBUtils.validateAndSave(cancha) // TODO o se graba despues todo junto?
		complejoService.agregarCancha(complejo, cancha)
	}
	
	/**
	 * Elimina la CANCHA indicada del Complejo y de la BD
	 * @param complejo
	 * @param canchaId
	 */
	void eliminarCanchaDelComplejo(Complejo complejo, def canchaId) {
		def canchaInstance = findEntityById(canchaId)
		if(!canchaInstance) {
			throw new EntityNotFoundException("Cancha", canchaId)
		}
		complejoService.eliminarCancha(complejo, canchaInstance)
	}

	/**
	 * Recupera las canchas del complejo para el listado y el numero total de ellas para el paginado
	 * @param complejo
	 * @return map [canchas, canchasTotal]
	 */
	def getCanchasYCantidad(Complejo complejo, def params, def encargadoId) {
		def canchas, canchasTotal
		
		if(complejo == null) {
			complejo = complejoService.getComplejoDelEncargado(encargadoId)
		}
		
		if(complejo) {
			canchas = getCanchasDelComplejo(complejo, params)
			canchasTotal = countTotal(complejo)
		} else {
			throw new EntityNotFoundException("Complejo", encargadoId)
		}
		
		return [canchas:canchas, canchasTotal:canchasTotal]
	}
	
	/**
	 * @param complejo
	 * @param params
	 * @return canchas del complejo listas para paginacion
	 */
	def getCanchasDelComplejo(Complejo complejo, def params) {
		def max = Math.min(params.max ? params.int('max') : 10, 100)
		def offset = Math.min(params.offset ? params.int('offset') : 0, 100)
		def sortProperty = params.sort ? params.sort : "nombre"
		
		def criter = Cancha.createCriteria()
			.add(Restrictions.eq("complejo", complejo))
			.addOrder(Order.asc(sortProperty))
			.setFirstResult(offset)
			.setMaxResults(max)
		
		criter.list()
	}
	
	/**
	 * @param complejo
	 * @return cantidad total de canchas del complejo
	 */
	def countTotal(Complejo complejo) {
		Cancha.createCriteria().count {
			eq('complejo', complejo)
		}
	}
	
}