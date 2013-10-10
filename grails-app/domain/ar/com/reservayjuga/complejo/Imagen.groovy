package ar.com.reservayjuga.complejo

class Imagen {
	
	String nombre
	String extension
	String descripcion
	Date fecha
	Boolean portada

    static constraints = {
		nombre blank: false
		extension blank: false
		descripcion blank: true
    }
}
