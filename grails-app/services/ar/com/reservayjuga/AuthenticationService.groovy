package ar.com.reservayjuga

class AuthenticationService {
	
	def springSecurityService
	
	/**
	 * Get the currently logged in user's principal.
	 *
	 * @return the principal
	 */
    def getUserLogged() {
		springSecurityService.getPrincipal()
    }
	
	/**
	 * Get the ID of the currently logged in user's principal. 
	 * 
	 * @return the principal's ID
	 */
    def getUserLoggedId() {
		def user = getUserLogged()
		if(user) {
			return user.id.toLong()
		}
    }
    
}