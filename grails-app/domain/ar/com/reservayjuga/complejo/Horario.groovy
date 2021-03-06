package ar.com.reservayjuga.complejo

class Horario {

	Integer dia
	String horarioApertura
	String horarioCierre
	
	static belongsTo = Complejo
	
    static constraints = {
		horarioApertura blank: false
		horarioCierre blank: false
		dia nullable: false
    }

	static mapping = {
		table "HORARIO"
	}
	
	@Override
	String toString() {
		"${dia}: ${horarioApertura} - ${horarioCierre}"
	}
}