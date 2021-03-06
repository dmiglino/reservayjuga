package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.entity.RyJEntity
import ar.com.reservayjuga.reserva.Reserva
import ar.com.reservayjuga.ubicacion.Ubicacion

class Complejo extends RyJEntity {

	String nombre
	String webSite
	String telefono1
	String telefono2
	String telefono3
	String telefono4
	String mail
	String informacionExtra
	String porcentajeSenia
	Ubicacion ubicacion
	Servicios servicios
	Extras extras
	
	static hasMany = [horarios: Horario, imagenes: Imagen, canchas: Cancha, reservas: Reserva]
	
	static constraints = {
		nombre blank: false
		webSite blank: true
		telefono1 blank: false
		telefono2 nullable: true
		telefono3 nullable: true
		telefono4 nullable: true
		porcentajeSenia nullable: true
		mail email: true, nullable:false
		informacionExtra blank: true, maxSize:1000
		horarios nullable: true
		imagenes nullable: true
		canchas nullable: true
		extras nullable: true
	}

	static mapping = {
		table "COMPLEJO" 
	}
	
	void agregarReserva(Reserva reserva) {
		addToReservas(reserva)
	}
	
	void agregarCancha(Cancha cancha) {
		addToCanchas(cancha)
	}
	
	void agregarCancha(List canchas) {
		canchas.each {
			agregarCancha(it)
		}
	}
	
	/**
	 * Elimina la CANCHA del listado y ademas la borra de la BD
	 * @param cancha
	 */
	void eliminarCancha(Cancha cancha) {
		removeFromCanchas(cancha)
		cancha.delete()
	}
	
	/**
	 * Elimina la RESERVA del listado y ademas la borra de la BD
	 * @param cancha
	 */
	void eliminarReserva(Reserva reserva) {
		removeFromReservas(reserva)
		reserva.delete()
	}
	
	void agregarHorario(Horario horario) {
		this.addToHorarios(horario)
	}
	
	void agregarImagen(Imagen imagen) {
		this.addToImagenes(imagen)
	}
	
	void eliminarImagen(Imagen imagen) {
		removeFromImagenes(imagen)
		imagen.delete()
	}
	
	Boolean hasHorario(Horario horario) {
		this.horarios.contains(horario)
	}
	
	@Override
	String toString() {
		"${nombre}"
	}
	
	def getHorariosDelDia(Integer diaDeLaSemana) {
		horarios.findAll { it.dia == diaDeLaSemana }
	}
}