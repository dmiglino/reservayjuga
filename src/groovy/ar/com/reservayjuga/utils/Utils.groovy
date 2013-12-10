package ar.com.reservayjuga.utils

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
	
}