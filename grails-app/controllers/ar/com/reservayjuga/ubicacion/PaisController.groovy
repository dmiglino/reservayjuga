package ar.com.reservayjuga.ubicacion

class PaisController {
	def scaffold = true
	
    def getProvincias() {
		println "getProvincias: " + params.id
		def provincias
		if(params.id) {
			def pais = Pais.get(params.id)
			println pais
			provincias = pais.provincias
			println provincias
		}
		render(template:"selectProvincias", model:[provinciasList:provincias])
	}
}
