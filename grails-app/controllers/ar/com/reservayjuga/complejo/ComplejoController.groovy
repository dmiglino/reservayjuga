package ar.com.reservayjuga.complejo

import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.exception.InvalidEntityException
import ar.com.reservayjuga.ubicacion.Ubicacion;
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
		render(view: "administrar-complejo", model: [complejo : encargado.complejo])
	}
	
	def actualizarInformacionComplejo = {
			// TODO autorizados admins y encargados
			// TODO recuperar el encargado logueado
		Encargado encargado = Encargado.list().get(0)
		Complejo complejo = encargado.complejo
		try {
//			List horarios = horarioService.createHorarios(params)
//			List imagenes = imagenService.createImagenes(params)
			complejoService.actualizarDatosComplejo(complejo, params, [], []) 
			flash.message = "Complejo <${complejo}> actualizado"
		} catch (InvalidEntityException e) {
			flash.message = "Error Actualizando el complejo <${complejo}>"
		} finally {
			render(view: "administrar-complejo", model: [ complejo: complejo ])
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

}