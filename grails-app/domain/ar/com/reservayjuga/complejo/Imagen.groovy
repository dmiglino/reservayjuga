package ar.com.reservayjuga.complejo

class Imagen {
	
	String nombre
	String extension
	String descripcion
	Date fecha = new Date()
	Boolean portada
	byte[] foto
	
	static belongsTo = [complejo:Complejo]
	
    static constraints = {
		nombre blank: false
		extension nullable: true
		descripcion blank: true
		fecha nullable: false
		portada nullable: false
		foto nullable: true
		complejo nullable: false
    }

	static mapping = {
		table "IMAGEN"
	}
	
	@Override
	String toString() {
		this.nombre
	}
}