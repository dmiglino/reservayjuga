package ar.com.reservayjuga.complejo

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.usuario.Encargado

class ComplejoController {

	def authenticationService
	ComplejoService complejoService
	
    def index() {
		redirect(action: administrarComplejo)
	}
	
	/**
	 * Carga la pagina principal de administracion de complejo
	 */
	def administrarComplejo = {
		def results, complejo
		try {
			complejo = complejoService.getComplejoDelEncargado(authenticationService.getUserLoggedId())
			results = getImagenesYCantidad(complejo, params)
		} catch (EntityNotFoundException e) {
			// TODO mostrar error en pantalla
			println "ERROR: ${e}"
		}
		render(view: "administrar-complejo", model: [complejo : complejo, imagenesList : results.imagenes, imagenesTotal: results.imagenesTotal])
	}
	
	/**
	 * Actualiza los datos del complejo
	 */
	def actualizarInformacionComplejo = {
		Complejo complejo
		try {
			complejo = complejoService.getComplejoDelEncargado(authenticationService.getUserLoggedId())
			complejoService.actualizarDatosComplejo(complejo, params) 
			flash.message = "Complejo <${complejo}> actualizado"
		} catch (InvalidEntityException e) {
			flash.message = "Error Actualizando el complejo <${complejo}>"
		} finally {
			redirect(action: administrarComplejo)
		}
	}
	
	/**
	 * Crea un nuevo complejo
	 */
	def crearComplejo = {
		// TODO autorizados solo admins
		Map resp = [:]
		try {
//			def ubicacionMap = [pais:params.pais, provincia:params.provincia, localidad:params.localidad, barrio:params.barrio, direccion:params.direccion]
			Ubicacion ubicacion = ubicacionService.createUbicacion(params)
			
//			def serviciosMap = [vestuario:params.vestuario, television:params.television, bebida:params.bebida,
//				comida:params.comida, ayudaMedica:params.ayudaMedica, torneos:params.torneos, wifi:params.wifi,
//				gimnasio:params.gimnasio, estacionamiento:params.estacionamiento, precioEstacionamiento: params.precioEstacionamiento]
			Servicios servicios = serviciosService.createServicios(params)
			
//			def extrasMap = [quiereArbitro:params.arbitro, quierePechera:params.pechera, precioArbitro:params.precioArbitro, precioPechera:params.precioPechera]
			Extras extras = extrasService.createExtras(params)
			
//			def horariosMap = [[desde:params.lunesDesde, hasta:params.lunesHasta],
//				[desde:params.martesDesde, hasta:params.martesHasta],
//				[desde:params.miercolesDesde, hasta:params.miercolesHasta],
//				[desde:params.juevesDesde, hasta:params.juevesHasta],
//				[desde:params.viernesDesde, hasta:params.viernesHasta],
//				[desde:params.sabadoDesde, hasta:params.sabadoHasta],
//				[desde:params.domingoDesde, hasta:params.domingoHasta],
//				[desde:params.feriadoDesde, hasta:params.feriadoHasta]]
			List horarios = horarioService.createHorarios(params)
			
			List imagenes = imagenService.createImagenes(params)
			
//			def datosComplejo = [nombre:params.nombre, webSite:params.webSite, mail:params.mail,
//				telefono:params.telefono, info:params.info, porcSenia:params.porcSenia]
			Complejo complejo = complejoService.createComplejo(params, ubicacion, servicios, extras, horarios, imagenes)
			
			resp?.content?.message = "Se ha actualizado el complejo con exito"
			resp.status = 200
		} catch (Exception e) {
			resp?.content?.message = "Error al actualizar"
			resp.status = 400
		} finally {
			return [response:resp, status:resp.status]
		}
	}
	
	/**
	 * Crea una nueva imagen y la guarda en el complejo
	 */
	def agregarImagen = {
		println params
		println "Imagen: " +params.foto2
		println "agregarImagen: " +params.imagen.foto
//		println "input-file-2: "+ params.id_input_file_2
//		println "input-file-3: "+ params.id_input_file_3
//		def content = request.multiFileMap?.foto?.collect { file ->
//			def charset = (file.contentType =~ /charset=([^;]+)/).
//				collect { it[1].trim() }.join('') ?: 'ISO-8859-1'
//			new String(file.bytes, charset)
//		}?.join('\n') ?: ''
//	
//		println "content: "+content
//		
//		content = request.multiFileMap?.foto2?.collect { file ->
//			def charset = (file.contentType =~ /charset=([^;]+)/).
//				collect { it[1].trim() }.join('') ?: 'ISO-8859-1'
//			new String(file.bytes, charset)
//		}?.join('\n') ?: ''
//			
//		println "content2: "+content
//		
//		println "req1: "+request.getFile("id_input_file_2")
//		println "req2: "+request.getFile("id_input_file_3")
		
		def results, complejo
		try {
			complejo = complejoService.getComplejoDelEncargado(authenticationService.getUserLoggedId())
			complejoService.crearImagenParaComplejo(complejo, params.imagen)
			results = getImagenesYCantidad(complejo, params)
			flash.message = "Imagen <${complejo}> creada"
		} catch (InvalidEntityException e) {
			flash.message = "Error creando la imagen <${complejo}>"
		} finally {
			renderTablaImagenes(results)
		}

	}
	
	/**
	 * Elimina la imagen indicada del complejo y de la BD 
	 */
	def deleteImagen() {
		def results, complejo
		try {
			complejo = complejoService.getComplejoDelEncargado(authenticationService.getUserLoggedId())
			complejoService.eliminarImagenDelComplejo(complejo, params.id)
			results = getImagenesYCantidad(complejo, params)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} finally {
			renderTablaImagenes(results)
		}
	}
	
	/**
	 * Elimina todas las imagenes del complejo
	 */
	def deleteAllImagenes = {
		def results, complejo
		try {
			complejo = complejoService.getComplejoDelEncargado(authenticationService.getUserLoggedId())
			complejoService.eliminarTodasLasImagenesDelComplejo(complejo)
			results = getImagenesYCantidad(complejo, params)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} finally {
			renderTablaImagenes(results)
		}
	}
	
	def ordenarImagenes	= {
		def results = getImagenesYCantidad(null, params)
		renderTablaImagenes(results)
	}
	
	/**
	 * Refresca la tabla de imagenes para ver los cambios por ajax
	 * @param results
	 */
	def renderTablaImagenes(def results) {
		render(template:"tabla-imagenes", model: [imagenes: results.imagenes, imagenesTotal: results.imagenesTotal])
	}
	
	/**
	 * Recupera las imagenes del complejo para el listado y el numero total de ellas para el paginado
	 * @param complejo, params
	 * @return map [imagenes, imagenesTotal]
	 */
	def getImagenesYCantidad(Complejo complejo, def params) {
		complejoService.getImagenesYCantidad(complejo, params, authenticationService.getUserLoggedId())
	}
}