package ar.com.reservayjuga.ubicacion

class PaisController {
	
	def scaffold = true
	PaisService paisService
	
    def getProvincias() {
		def provincias = paisService.getProvincias(params.id)
		render(template:"selectProvincias", model:[provinciasList:provincias])
	}
}
