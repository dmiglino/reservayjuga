package ar.com.reservayjuga.utils

import java.util.concurrent.TimeUnit

import org.apache.commons.validator.EmailValidator

/**
 * Metodos utiles
 */
class Utils {

	static def isMail(def mail) {
		if(!mail || !(mail instanceof String))
			return false
		EmailValidator emailValidator = EmailValidator.getInstance()
		emailValidator.isValid(mail)
	}

	static def onlyNumbers(def numbers) {
		if(numbers instanceof Integer)
			return true
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
			fecha = cal.getTime()
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
	
	static String getCadenaAlfanumericaAleatoria(int longitud){
		String cadenaAleatoria = ""
		long milis = Calendar.getInstance().getTimeInMillis()
		Random r = new Random(milis)
		int i = 0;
		while(i < longitud) {
			char c = (char)r.nextInt(255)
			if ( (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ) {
				cadenaAleatoria += c
				i++
			}
		}
		return cadenaAleatoria
	}
}