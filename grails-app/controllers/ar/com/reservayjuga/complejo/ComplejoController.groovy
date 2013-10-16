package ar.com.reservayjuga.complejo

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
		render "<h1>pagina que muestra los datos del complejo que se podran modificar</h1>"
	}
	
	def actualizarInformacionComplejo = {
		// TODO autorizados admins y encargados
		Map resp = [:]
		try {
			Encargado encargado = Encargado.findById(1) // TODO obtener el usuario logueado
			def horariosMap = [[desde:params.lunesDesde, hasta:params.lunesHasta],
				[desde:params.martesDesde, hasta:params.martesHasta],
				[desde:params.miercolesDesde, hasta:params.miercolesHasta],
				[desde:params.juevesDesde, hasta:params.juevesHasta],
				[desde:params.viernesDesde, hasta:params.viernesHasta],
				[desde:params.sabadoDesde, hasta:params.sabadoHasta],
				[desde:params.domingoDesde, hasta:params.domingoHasta],
				[desde:params.feriadoDesde, hasta:params.feriadoHasta]]
			List horarios = horarioService.createHorarios(horariosMap)
			List imagenes = []
			complejoService.actualizarDatosComplejo(encargado.complejo, params, horarios, imagenes)
		} catch (Exception e) {
			resp?.content?.message = "Error al actualizar"
			resp.status = 400
		} finally {
			return [response:resp, status:resp.status]
		}
	}
	
	def crearComplejo = {
		// TODO autorizados solo admins
		Map resp = [:]
		try {
			def ubicacionMap = [pais:params.pais, provincia:params.provincia, localidad:params.localidad, barrio:params.barrio, direccion:params.direccion]
			Ubicacion ubicacion = ubicacionService.createUbicacion(ubicacionMap)
			
			def serviciosMap = [vestuario:params.vestuario, television:params.television, bebida:params.bebida,
				comida:params.comida, ayudaMedica:params.ayudaMedica, torneos:params.torneos, wifi:params.wifi,
				gimnasio:params.gimnasio, estacionamiento:params.estacionamiento, precioEstacionamiento: params.precioEstacionamiento]
			Servicios servicios = serviciosService.createServicios(serviciosMap)
			
			def extrasMap = [quiereArbitro:params.arbitro, quierePechera:params.pechera, precioArbitro:params.precioArbitro, precioPechera:params.precioPechera]
			Extras extras = extrasService.createExtras(extrasMap)
			
			def horariosMap = [[desde:params.lunesDesde, hasta:params.lunesHasta],
				[desde:params.martesDesde, hasta:params.martesHasta],
				[desde:params.miercolesDesde, hasta:params.miercolesHasta],
				[desde:params.juevesDesde, hasta:params.juevesHasta],
				[desde:params.viernesDesde, hasta:params.viernesHasta],
				[desde:params.sabadoDesde, hasta:params.sabadoHasta],
				[desde:params.domingoDesde, hasta:params.domingoHasta],
				[desde:params.feriadoDesde, hasta:params.feriadoHasta]]
			List horarios = horarioService.createHorarios(horariosMap)
			
			def imagenMap = [[nombre:params.nombreFoto1, extension:params.extFoto1, descripcion:params.descFoto1, portada:params.portadaFoto1],
				[nombre:params.nombreFoto2, extension:params.extFoto2, descripcion:params.descFoto2, portada:params.portadaFoto2],
				[nombre:params.nombreFoto3, extension:params.extFoto3, descripcion:params.descFoto3, portada:params.portadaFoto3]]
			List imagenes = imagenService.createImagenes(imagenMap)
			
			def datosComplejo = [nombre:params.nombre, webSite:params.webSite, mail:params.mail,
				telefono:params.telefono, info:params.info, porcSenia:params.porcSenia]
			Complejo complejo = complejoService.createComplejo(datosComplejo, ubicacion, servicios, extras, horarios, imagenes)
			
			resp?.content?.message = "Se ha actualizado el complejo con exito"
			resp.status = 200
		} catch (Exception e) {
			resp?.content?.message = "Error al actualizar"
			resp.status = 400
		} finally {
			return [response:resp, status:resp.status]
		}
	}

}