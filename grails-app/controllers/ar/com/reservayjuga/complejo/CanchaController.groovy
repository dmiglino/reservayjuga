package ar.com.reservayjuga.complejo

class CanchaController {
	
	def index() {
		redirect(action: administrarCancha)
	}

	def administrarCancha = {
		// TODO autorizados admins y encargados
		// TODO recuperar el complejo del encargado
	render(view: "administrar-cancha", model: [])
	}

	
}
