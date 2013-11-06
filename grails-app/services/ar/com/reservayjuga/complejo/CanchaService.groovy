package ar.com.reservayjuga.complejo

import org.hibernate.criterion.Order
import org.hibernate.criterion.Restrictions

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.exception.EntityNotFoundException

class CanchaService extends GenericService<Cancha> {
	
	ComplejoService complejoService
	
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
	
	def editarCancha(def datos) {
		Cancha canchaInstance = findEntityById(datos.idCanchaEdit)
		
		if(!canchaInstance) {
			throw new EntityNotFoundException("Cancha", datos.idCanchaEdit)
		}
		
		canchaInstance.nombre = datos.nombreCanchaEdit
		canchaInstance.deporte = datos.deporteCanchaEdit
		canchaInstance.cubierta = datos.cubiertaCanchaEdit
		canchaInstance.superficie = datos.superficie
		canchaInstance.cantidadJugadores = new Integer(datos.cantidadJugadoresCanchaEdit)
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
	 * Elimina la cancha indicada del complejo y de la BD
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