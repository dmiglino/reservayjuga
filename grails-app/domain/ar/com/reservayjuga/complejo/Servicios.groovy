package ar.com.reservayjuga.complejo

class Servicios {
	
	Boolean vestuario
	Boolean television
	Boolean bebida
	Boolean comida
	Boolean ayudaMedica
	Boolean torneo
	Boolean wifi
	Boolean gimnasio
	Boolean estacionamiento
	Float precioEstacionamiento
	
	static belongsTo = Complejo

    static constraints = {
		vestuario nullable: false
		television nullable: false
		bebida nullable: false
		comida nullable: false
		ayudaMedica nullable: false
		torneo nullable: false
		wifi nullable: false
		gimnasio nullable: false
		estacionamiento nullable: false
		precioEstacionamiento nullable: true
    }

	static mapping = {
		table "SERVICIOS"
	}

}