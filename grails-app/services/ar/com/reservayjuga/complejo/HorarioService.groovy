package ar.com.reservayjuga.complejo

class HorarioService {
	
	/**
	 * Crea los horarios a partir de los datos pasados por parametro
	 * @param map
	 * @return list horarios
	 */
    def createHorarios(def params) {
		def horariosMap = [[desde:params.lunesDesde, hasta:params.lunesHasta],
			[desde:params.martesDesde, hasta:params.martesHasta],
			[desde:params.miercolesDesde, hasta:params.miercolesHasta],
			[desde:params.juevesDesde, hasta:params.juevesHasta],
			[desde:params.viernesDesde, hasta:params.viernesHasta],
			[desde:params.sabadoDesde, hasta:params.sabadoHasta],
			[desde:params.domingoDesde, hasta:params.domingoHasta],
			[desde:params.feriadoDesde, hasta:params.feriadoHasta]]
		
		List horarios = []
		
		int dia = 1
		params.each {
			Horario horario = new Horario(dia:dia, horarioApertura: it.desde, horarioCierre: it.hasta)
			horarios.add(horario)
			dia++
		}

		return horarios
    }
}
