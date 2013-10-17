package ar.com.reservayjuga.ubicacion

class LocalidadController {
	def scaffold = true

    def getBarrios() {
		println "getBarrios"
		def localidad = Localidad.get(params.id)
		println localidad
		def barrios = localidad.barrios
		println barrios
		render(template:"selectBarrios", model:[barriosList:barrios])
	}

}