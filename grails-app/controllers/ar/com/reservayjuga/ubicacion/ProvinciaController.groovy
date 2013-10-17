package ar.com.reservayjuga.ubicacion

class ProvinciaController {
	def scaffold = true

    def getLocalidades() {
		println "getLocalidades"
		def provincia = Provincia.get(params.id)
		println provincia
		def localidades = provincia.localidades
		println localidades
		render(template:"selectLocalidades", model:[localidadesList:localidades])
	}

}