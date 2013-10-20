package ar.com.reservayjuga.complejo

import org.springframework.dao.DataIntegrityViolationException

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.ubicacion.UbicacionService
import ar.com.reservayjuga.usuario.Encargado

class ComplejoController {

	UbicacionService ubicacionService
	ServiciosService serviciosService
	ExtrasService extrasService
	HorarioService horarioService
	ImagenService imagenService
	ComplejoService complejoService
	
    def index() {
		redirect(action: administrarComplejo)
	}
	
	def administrarComplejo = {
			// TODO autorizados admins y encargados
			// TODO recuperar el complejo del encargado
		Encargado encargado = Encargado.list().get(0)
		List horariosApertura = ["9:00","10:00","11:00"]
		List horariosCierre = ["9:00","10:00","11:00"]
		def horariosComplejo
		render(view: "administrar-complejo", model: [complejo : encargado.complejo, horariosApertura : horariosApertura, horariosCierre : horariosCierre])
	}
	
	
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
	
	def agregarImagen = {
		println "agregarImagen: " +params.imagen
			// TODO autorizados admins y encargados
			// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		if(params.imagen) {
			if(!complejo.imagenes) {
				complejo.imagenes = []
			}
			//TODO pasar cosas a ImagenService
			Imagen imagen = new Imagen(nombre: params.imagen.nombre, descripcion: params.imagen.descripcion, fecha: new Date(), portada: false)
			DBUtils.validateAndSave(imagen) // TODO o se graba despues todo junto?
			complejo.agregarImagen(imagen)
		}
		render(template:"tabla-imagenes", model:[imagenes : complejo.imagenes])
//		redirect(action: administrarComplejo)
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
	
	def deleteImagen() {
		// TODO autorizados admins y encargados
		// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		Long idImagen = params.id
		def imagenInstance = Imagen.get(params.id)
		
		if (!imagenInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reserva.label', default: 'Reserva'), params.id])
			render(template:"tabla-imagenes", model:[imagenes : complejo.imagenes])
		}

		try {
			complejo.eliminarImagen(imagenInstance)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'reserva.label', default: 'Reserva'), params.id])
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reserva.label', default: 'Reserva'), params.id])
		} finally {
			render(template:"tabla-imagenes", model:[imagenes : complejo.imagenes])
		}
	}
}