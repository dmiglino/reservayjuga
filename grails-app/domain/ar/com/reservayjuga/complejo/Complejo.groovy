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
//	List<Horario> horarios
//	List<Imagen> imagenes
//	List<Cancha> canchas

//	static hasOne = [ubicacion: Ubicacion, servicios: Servicios]
	static hasMany = [horarios: Horario, imagenes: Imagen, canchas: Cancha]
	
	static constraints = {
		nombre blank: false
		webSite blank: true
		telefono1 blank: false
		telefono2 nullable: true
		telefono3 nullable: true
		telefono4 nullable: true
		mail blank: false
		informacionExtra blank: true, maxSize:1000
		horarios nullable: true
		imagenes nullable: true
		canchas nullable: true
	}

	static mapping = { table "COMPLEJO" }

	void agregarCancha(Cancha cancha) {
		addToCanchas(cancha)
	}
	
	void agregarCancha(List canchas) {
		canchas.each {
			agregarCancha(it)
		}
	}
	
	@Override
	String toString() {
		"${nombre}"
	}
}