package ar.com.reservayjuga.ubicacion

class Provincia {

	String nombre
	
	static hasMany = [localidades : Localidad]
	static belongsTo = [pais : Pais]
	
    static constraints = {
		nombre blank:false
		localidades display:false
    }

	static mapping = { 
		table "PROVINCIA" 
		pais lazy:false
	}
	
	@Override
	String toString() {
		this.nombre
	}

}