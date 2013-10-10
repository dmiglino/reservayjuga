package ar.com.reservayjuga.complejo

class Cancha {
	
	String nombre
	String deporte
	SuperficieEnum superficie
	Integer cantidadJugadores
	Boolean cubierta
	List<Precio> precios
	
    static constraints = {
		nombre blank: false
		deporte blank: false
		superficie nullable: false
		cantidadJugadores nullable: false
		cubierta nullable: false
    }

}