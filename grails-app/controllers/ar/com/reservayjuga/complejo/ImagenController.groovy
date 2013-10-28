package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.exception.EntityNotFoundException

class ImagenController {

	ImagenService imagenService
	
	def editarImagen() {
		try {
			imagenService.editarImagen(params)
		} catch (EntityNotFoundException e) {
			println "ERROR: ${e}"
			// TODO mostrar error en pantalla
		}
	}
	
}