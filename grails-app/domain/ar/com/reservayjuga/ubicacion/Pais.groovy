package ar.com.reservayjuga.ubicacion

class Pais {

	String nombre
	
	static hasMany = [provincias : Provincia]
	
    static constraints = {
		nombre blank:false
		provincias display:false
    }
	
	static mapping = {
		table "PAIS"
	}
	
	@Override
	String toString() {
		this.nombre
	}

}