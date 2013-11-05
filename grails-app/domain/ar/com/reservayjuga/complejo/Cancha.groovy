package ar.com.reservayjuga.complejo

class Cancha {
	
	String nombre
	DeporteEnum deporte
	SuperficieEnum superficie
	Integer cantidadJugadores
	Boolean cubierta
	
	static hasMany = [precios : Precio]
	static belongsTo = [complejo : Complejo]
	
    static constraints = {
		nombre blank: false
		deporte nullable: false
		superficie nullable: false
		cantidadJugadores nullable: false
		cubierta nullable: false
		complejo nullable: true //TODO falso
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
	
	/**
	 * Elimina el precio del listado y ademas lo borra de la BD
	 * @param cancha
	 */
	void eliminarPrecio(Precio precio) {
		removeFromPrecios(precio)
		precio.delete()
	}
}