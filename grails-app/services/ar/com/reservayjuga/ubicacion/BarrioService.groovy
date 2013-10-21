package ar.com.reservayjuga.ubicacion

import ar.com.reservayjuga.common.GenericService

class BarrioService extends GenericService<Barrio> {

	@Override
	public Object getDomain() {
		return Barrio;
	}
	
}