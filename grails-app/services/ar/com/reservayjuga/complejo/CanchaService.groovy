package ar.com.reservayjuga.complejo

import org.hibernate.criterion.Order
import org.hibernate.criterion.Restrictions

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.utils.DBUtils;

class CanchaService extends GenericService<Cancha> {
	
	ComplejoService complejoService
	PrecioService precioService
	
	@Override
	def getDomain() {
		Cancha
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
		Cancha canchaInstance = findEntityByIdAndValidate(datos.idCanchaEdit)
		
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
		def canchaInstance = findEntityByIdAndValidate(canchaId)
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
		
		criter = aplicarFiltros(criter, params)
		
		criter.list()
	}
	
	/**
	 * Aplica los filtros de busqueda al criteria
	 * @param criter
	 * @param params
	 * @return criter
	 */
	protected def aplicarFiltros(def criter, def params) {
		if(params.deporteCanchaFilter) {
			def deporteFilter = params.deporteCanchaFilter as DeporteEnum
			criter.add(Restrictions.eq("deporte", deporteFilter))
		}
		
		if(params.superficieCanchaFilter) {
			def superficieFilter = params.superficieCanchaFilter as SuperficieEnum
			criter.add(Restrictions.eq("superficie", superficieFilter))
		}
		
		return criter
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
	
	/**
	 * Obtiene el complejo del encargado logueado
	 * @param encargadoId
	 * @return
	 */
	def getComplejoDelEncargado(def encargadoId) {
		// TODO pasar a EncargadoService?
		complejoService.getComplejoDelEncargado(encargadoId)
	}
	
	def getPrecio(def dayOfWeek, def horaInicio, def cancha) {
		precioService.getPrecio(dayOfWeek, horaInicio, cancha)
	}
}