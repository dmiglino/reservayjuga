package ar.com.reservayjuga.complejo

class Extras {

	Boolean quiereArbitro
	Boolean quierePechera
	Float precioArbitro
	Float precioPechera
	
	static belongsTo = Complejo
	
	static constraints = {
		quiereArbitro nullable : false
		quierePechera nullable : false
		precioArbitro nullable : true
		precioPechera nullable : true
	}

	static mapping = { table "EXTRAS" }
	
	@Override
	String toString() {
		"" + (quiereArbitro ? "Arbitro" : "") + (quierePechera  && quiereArbitro ? " y " : "") + (quierePechera ? "Pecheras" : "") 
	}
}