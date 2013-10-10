package ar.com.reservayjuga.complejo

class Cancha {
	
	String nombre
	DeporteEnum deporte
	SuperficieEnum superficie
	Integer cantidadJugadores
	Boolean cubierta
	
	static hasMany = [precios : Precio]
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
	
	@Override
	String toString() {
		"${nombre} - ${deporte} (${cantidadJugadores})"
	}
	
	void agregarPrecio(Precio precio) {
		this.addToPrecios(precio)
	}
	
	Boolean hasPrecio(Precio precio) {
		this.precios.contains(precio)
	}
}