package ar.com.reservayjuga.complejo

class Cancha {
	
	String nombre
	DeporteEnum deporte
	SuperficieEnum superficie
	Integer cantidadJugadores
	Boolean cubierta
	List<Precio> precios
	
	static belongsTo = [complejo: Complejo]
	
    static constraints = {
		nombre blank: false
		deporte blank: false
		superficie nullable: false
		cantidadJugadores nullable: false
		cubierta nullable: false
		complejo nullable: false
    }
	
	static mapping = { table "CANCHA" }
	
}