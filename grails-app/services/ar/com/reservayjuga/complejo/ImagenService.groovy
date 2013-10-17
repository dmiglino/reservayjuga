package ar.com.reservayjuga.complejo

class ImagenService {

    def createImagenes(def params) {
		def imagenesMap = [[nombre:params.nombreFoto1, extension:params.extFoto1, descripcion:params.descFoto1, portada:params.portadaFoto1],
			[nombre:params.nombreFoto2, extension:params.extFoto2, descripcion:params.descFoto2, portada:params.portadaFoto2],
			[nombre:params.nombreFoto3, extension:params.extFoto3, descripcion:params.descFoto3, portada:params.portadaFoto3]]
		
		List imagenes = []
		
		int dia = 1
		imagenesMap.each {
			Imagen imagen = new Imagen(nombre:it.nombre, extension:it.extension, descripcion:it.descripcion, portada:it.portada)
			imagenes.add(imagen)
			dia++
		}

		return imagenes
    }
    
}