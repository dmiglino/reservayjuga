package ar.com.reservayjuga.usuario

import ar.com.reservayjuga.common.GenericService;
import ar.com.reservayjuga.complejo.Cancha;
import ar.com.reservayjuga.utils.DBUtils;

class EncargadoService extends GenericService<Encargado> {

	@Override
	def getDomain() {
		Encargado
	}

}