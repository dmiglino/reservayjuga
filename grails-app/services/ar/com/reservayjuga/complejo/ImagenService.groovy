package ar.com.reservayjuga.complejo

class ImagenService {

    def createImagenes(def imagenesMap) {
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