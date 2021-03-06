package ar.com.reservayjuga.seguridad

import ar.com.reservayjuga.entity.RyJEntity

abstract class SecUser extends RyJEntity {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired 
	boolean accountLocked
	boolean passwordExpired

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password validator: {
			if (!it) return ['nullable']
			else if (it.size() < 6) return ['size.toosmall']
		}
	}

	static mapping = {
		table "USUARIO"
		password column: '`password`'
	}

	Set<SecRole> getAuthorities() {
		SecUserSecRole.findAllBySecUser(this).collect { it.secRole } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
