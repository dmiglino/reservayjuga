package ar.com.reservayjuga.ubicacion

class Barrio {

	String nombre
	
	static belongsTo = [localidad : Localidad]
	
    static constraints = {
		nombre blank:false
		localidad nullable:false
    }
	
	@Override
	String toString() {
		this.nombre
	}

}