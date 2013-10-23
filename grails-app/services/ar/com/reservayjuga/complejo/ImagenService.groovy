package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.common.GenericService
import ar.com.reservayjuga.exception.EntityNotFoundException

class ImagenService extends GenericService<Imagen> {
	
	@Override
	def getDomain() {
		Imagen
	}
	
    def createImagenes(def params) {
		def imagenesMap = [[nombre:params.nombreFoto1, extension:params.extFoto1, descripcion:params.descFoto1, portada:params.portadaFoto1],
			[nombre:params.nombreFoto2, extension:params.extFoto2, descripcion:params.descFoto2, portada:params.portadaFoto2],
			[nombre:params.nombreFoto3, extension:params.extFoto3, descripcion:params.descFoto3, portada:params.portadaFoto3]]
		
		List imagenes = []
		
		int dia = 1
		params.each {
			Imagen imagen = new Imagen(nombre:it.nombre, extension:it.extension, descripcion:it.descripcion, portada:it.portada)
			imagenes.add(imagen)
			dia++
		}

		return imagenes
    }
	
	/**
	 * Crea una nueva imagen y la guarda en el complejo
	 * @param complejo
	 * @param imagenData
	 */
	void crearImagenParaComplejo(Complejo complejo, def imagenData) {
		Imagen imagen = new Imagen(nombre: imagenData.nombre, descripcion: imagenData.descripcion, extension: imagenData.extension, portada: (imagenData.portada ? imagenData.portada : false))
		DBUtils.validateAndSave(imagen) // TODO o se graba despues todo junto?
		complejo.agregarImagen(imagen)
	}
	
	void editarImagen(def datos) {
		def imagenInstance = findEntityById(datos.idImagenEdit)
		
		if(!imagenInstance) {
			throw new EntityNotFoundException("Imagen", datos.idImagenEdit)
		}
		
		imagenInstance.nombre = datos.nombreImagenEdit
		imagenInstance.descripcion = datos.descripcionImagenEdit
		imagenInstance.portada = datos.portadaImagenEdit
//		imagenInstance.foto = params.fotoImagenEdit
	}
	
}