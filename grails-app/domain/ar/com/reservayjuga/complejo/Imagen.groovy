package ar.com.reservayjuga.complejo

class Imagen {
	
	String nombre
	String extension
	String descripcion
	Date fecha
	Boolean portada
	byte[] foto
	
	static belongsTo = Complejo
	
    static constraints = {
		nombre blank: false
		extension nullable: true
		descripcion blank: true
		fecha nullable: true
		portada nullable: false
		foto nullable: true
    }

	static mapping = {
		table "IMAGEN"
	}
	
	@Override
	String toString() {
		"${nombre}"
	}
}