package ar.com.seguridad

class SecRole {

	String authority

	static mapping = {
		cache true
		table "SEC_ROLE"
	}
	
	static constraints = {
		authority blank: false, unique: true
	}
}
