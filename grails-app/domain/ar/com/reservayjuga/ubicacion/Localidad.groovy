package ar.com.reservayjuga.ubicacion

class Localidad {

	String nombre
	
	static hasMany = [barrios : Barrio]
	static belongsTo = [provincia : Provincia]
	
    static constraints = {
		nombre blank:false
		barrios display:false
    }

	static mapping = { 
		table "LOCALIDAD" 
		provincia lazy:false
	}
	
	@Override
	String toString() {
		this.nombre
	}

}