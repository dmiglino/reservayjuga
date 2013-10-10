package ar.com.reservayjuga.complejo

class Cancha {
	
	String nombre
	SuperficieEnum superficie
	String deporte
	Integer cantidadJugadores
	Boolean cubierta
	List<Precio> precios
	
    static constraints = {
    }

}