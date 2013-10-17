package ar.com.reservayjuga.ubicacion

class Provincia {

	String nombre
	
	static hasMany = [localidades : Localidad]
	static belongsTo = [pais : Pais]
	
    static constraints = {
		nombre blank:false
		pais nullable:false
    }
	
	@Override
	String toString() {
		this.nombre
	}

}