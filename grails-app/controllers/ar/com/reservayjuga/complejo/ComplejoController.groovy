package ar.com.reservayjuga.complejo

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.exception.EntityNotFoundException
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.usuario.Encargado

class ComplejoController {

	ComplejoService complejoService
	
    def index() {
		redirect(action: administrarComplejo)
	}
	
	/**
	 * Carga la pagina principal de administracion de complejo
	 */
	def administrarComplejo = {
			// TODO autorizados admins y encargados
			// TODO recuperar el complejo del encargado
		Encargado encargado = Encargado.list().get(0)
		def imagenes = []
		if(encargado.complejo.imagenes) {
			imagenes = encargado.complejo.imagenes.sort { i1, i2 ->
				i1.nombre <=> i2.nombre
			}
		}
		render(view: "administrar-complejo", model: [complejo : encargado.complejo, imagenesList : imagenes])
	}
	
	/**
	 * Actualiza los datos del complejo
	 */
	def actualizarInformacionComplejo = {
			// TODO autorizados admins y encargados
			// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		try {
			complejoService.actualizarDatosComplejo(complejo, params) 
			flash.message = "Complejo <${complejo}> actualizado"
		} catch (InvalidEntityException e) {
			flash.message = "Error Actualizando el complejo <${complejo}>"
		} finally {
			redirect(action: administrarComplejo)
		}
	}
	
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
//		println "Imagen: " +params.foto2
		println "agregarImagen: " +params.foto2
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
		
			// TODO autorizados admins y encargados
			// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		complejoService.crearImagenParaComplejo(complejo, params.imagen)
		def imagenes = []
		if(encargado.complejo.imagenes) {
			imagenes = encargado.complejo.imagenes.sort { i1, i2 ->
				i1.nombre <=> i2.nombre
			}
		}
		render(template:"tabla-imagenes", model:[imagenes : imagenes])
	}
	
	
	/**
	 * Elimina la imagen indicada del complejo y de la BD 
	 */
	def deleteImagen() {
		// TODO autorizados admins y encargados
		// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		def imagenes = []
		
		try {
			complejoService.eliminarImagenDelComplejo(complejo, params.id)
			if(encargado.complejo.imagenes) {
				imagenes = encargado.complejo.imagenes.sort { i1, i2 ->
					i1.nombre <=> i2.nombre
				}
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} finally {
			render(template:"tabla-imagenes", model:[imagenes : imagenes])
		}
	}
	
	def deleteAllImagenes = {
		// TODO autorizados admins y encargados
		// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		def imagenes = []
		
		try {
			complejoService.eliminarTodasLasImagenesDelComplejo(complejo)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} catch (EntityNotFoundException e) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		}  catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'imagen.label', default: 'Imagen'), params.id])
		} finally {
			render(template:"tabla-imagenes", model:[imagenes : imagenes])
		}
	}
	
    def ordenarImagenes	= {
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		def listaOrdenada = []
		if(params.order == "asc") {
			listaOrdenada = complejo.imagenes.sort { i1, i2 -> i1."${params.sort}" <=> i2."${params.sort}" }
		} else {
			listaOrdenada = complejo.imagenes.sort { i1, i2 -> i2."${params.sort}" <=> i1."${params.sort}" }
		}
//		params.max = Math.min(max ?: 10, 100)
        render(view: "administrar-complejo", model: [complejo: complejo, imagenes: listaOrdenada, imagenesSize: listaOrdenada.size()])
    }
	
}