package ar.com.reservayjuga.ubicacion

class LocalidadController {
	def scaffold = true

    def getBarrios() {
		println "getBarrios: " + params.id
		def barrios
		if(params.id) {
			def localidad = Localidad.get(params.id)
			println localidad
			barrios = localidad.barrios
			println barrios
		}
		render(template:"selectBarrios", model:[barriosList:barrios])
	}

}