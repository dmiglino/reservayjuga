package ar.com.reservayjuga.ubicacion

class PaisController {
	def scaffold = true
	
    def getProvincias() {
		println "getProvincias"
		def pais = Pais.get(params.id)
		println pais
		def provincias = pais.provincias
		println provincias
		render(template:"selectProvincias", model:[provinciasList:provincias])
	}
}
