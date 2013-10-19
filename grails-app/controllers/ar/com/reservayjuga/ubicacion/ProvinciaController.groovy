package ar.com.reservayjuga.ubicacion

class ProvinciaController {
	
	def scaffold = true
	ProvinciaService provinciaService
	
    def getLocalidades() {
		def localidades = provinciaService.getLocalidades(params.id)
		render(template:"selectLocalidades", model:[localidadesList:localidades])
	}

}