package ar.com.reservayjuga.complejo

class Precio {

	Integer dia
	String horarioInicio
	Float precio
	
    static constraints = {
		horarioInicio blank: false
		precio nullable: false
		dia nullable: false
    }

	static mapping = {
		table "PRECIO"
	}

	
	@Override
	String toString() {
		"${precio}"
	}
}