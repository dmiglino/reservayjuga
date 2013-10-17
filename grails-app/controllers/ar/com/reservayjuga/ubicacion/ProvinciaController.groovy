package ar.com.reservayjuga.ubicacion

class ProvinciaController {
	def scaffold = true

    def getLocalidades() {
		println "getLocalidades: " + params.id
		def localidades
		if(params.id) {
			def provincia = Provincia.get(params.id)
			println provincia
			localidades = provincia ? provincia.localidades : []
			println localidades
		}
		render(template:"selectLocalidades", model:[localidadesList:localidades])
	}

}