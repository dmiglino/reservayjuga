package ar.com.reservayjuga.utils

import java.util.concurrent.TimeUnit

import org.apache.commons.validator.EmailValidator

/**
 * Metodos utiles
 */
class Utils {

	static def isMail(String mail) {
		if(!mail)
			return false
		EmailValidator emailValidator = EmailValidator.getInstance()
		emailValidator.isValid(mail)
	}

	static def onlyNumbers(String numbers) {
		numbers ? numbers.isNumber() : false
	}
	
	static Date crearFechaByString(String fechaStr) {
		//	parsear fecha en dd mm yyyy
		def fechaSplit = fechaStr.split("-")
		
		//	crear Date con los datos parseados
		Date fecha
		if(fechaSplit.size() == 3) {
			Calendar cal = Calendar.getInstance()
			cal.set(fechaSplit[2].toInteger(), fechaSplit[1].toInteger()-1, fechaSplit[0].toInteger(), 0, 0, 0)
			Date fechaTemp = cal.getTime()
			fecha = new Date(fechaTemp.getTime() - + TimeUnit.SECONDS.toMillis(1))
		}
		
		return fecha
	}
	
	static Integer getDayOfWeek(String fechaStr) {
		//	parsear fecha en dd mm yyyy
		def fechaSplit = fechaStr.split("-")
		
		//	crear Calendar con los datos parseados
		Calendar cal = Calendar.getInstance()
		cal.set(fechaSplit[2].toInteger(), fechaSplit[1].toInteger()-1, fechaSplit[0].toInteger(), 0, 0, 0)
		return cal.get(Calendar.DAY_OF_WEEK)
	}
	
}