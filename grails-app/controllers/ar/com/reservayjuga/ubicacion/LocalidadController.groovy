package ar.com.reservayjuga.ubicacion

class LocalidadController {
	
	def scaffold = true
	LocalidadService localidadService
	
    def getBarrios() {
		def barrios = localidadService.getBarrios(params.id)
		render(template:"selectBarrios", model:[barriosList:barrios])
	}

}