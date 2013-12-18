package ar.com.reservayjuga.complejo

import org.hibernate.criterion.Restrictions

import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.utils.DBUtils

class PrecioService extends GenericService<Precio> {

	@Override
	def getDomain() {
		Precio
	}
	
	Float getPrecio(def dayOfWeek, def horaInicio, def cancha) {
		def criter = Precio.createCriteria()
			.add(Restrictions.eq("dia", dayOfWeek))
			.add(Restrictions.eq("horarioInicio", horaInicio))
			.add(Restrictions.eq("cancha", cancha))
			
		def resultado = criter.list()
		def precio
		if(resultado.size() == 1) {
			precio = resultado[0]
		} else {
			println "ERROR: Se encontraron ${resultado.size()} precios para la cancha ${cancha} en el horario de ${horaInicio} del dia ${dayOfWeek}"
		}
		return precio.precio
	}

	void setPrecioParaComplejo(Float precio, Complejo complejo) {
		for(int dia = 1; dia <= 8; dia++) {
			complejo.canchas.each { cancha ->
				["8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"].each { hora ->
					Precio precioInstance = new Precio(dia:dia, cancha:cancha, horarioInicio:hora, precio: precio)
					DBUtils.validateAndSave(precioInstance)
				}
			}
		}
	}

}