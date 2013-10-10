package ar.com.reservayjuga.complejo

class Complejo {

	String nombre
	String webSite
	String telefono1
	String telefono2
	String telefono3
	String telefono4
	String mail
	String informacionExtra
	Ubicacion ubicacion
	Servicios servicios
	List<Horario> horarios
	List<Imagen> imagenes
	List<Cancha> canchas
	
    static constraints = {
		nombre blank: false
		webSite blank: true
		telefono1 blank: false
		telefono2 blank: true
		telefono3 blank: true
		telefono4 blank: true
		mail blank: false
		informacionExtra blank: true
    
    }
}
