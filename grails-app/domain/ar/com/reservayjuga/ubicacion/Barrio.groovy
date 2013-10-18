package ar.com.reservayjuga.ubicacion

class Barrio {

	String nombre
	
	static belongsTo = [localidad : Localidad]
	
    static constraints = {
		nombre blank:false
		localidad nullable:false
    }

	static mapping = { 
		table "BARRIO" 
		localidad lazy:false
	}
	
	@Override
	String toString() {
		this.nombre
	}

}