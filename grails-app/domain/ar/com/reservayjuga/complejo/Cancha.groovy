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
		complejo nullable: false
    }
	
	static mapping = { 
		table "CANCHA" 
		precios cascade: 'all-delete-orphan'
	}
	
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

	@Override
	int hashCode() {
		final int prime = 31
		int result = 1
		result = prime * result + ((cantidadJugadores == null) ? 0 : cantidadJugadores.hashCode())
		result = prime * result + ((cubierta == null) ? 0 : cubierta.hashCode())
		result = prime * result + ((deporte == null) ? 0 : deporte.hashCode())
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode())
		result = prime * result + ((superficie == null) ? 0 : superficie.hashCode())
		return result
	}

	@Override
	boolean equals(Object obj) {
		if (obj == null)
			return false
		Cancha other = (Cancha) obj
		if (id != other.id)
			return false
		if (!nombre.equals(other.nombre))
			return false
		return true
	}
	
}