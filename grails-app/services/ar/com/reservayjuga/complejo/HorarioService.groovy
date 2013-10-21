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
	
	/**
	 * Busca todos los horarios del complejo (del dia 1 al dia 8), y crea o actualiza segun corresponda.
	 * @param complejo
	 * @param horarios
	 */
	void guardarHorariosParaComplejo(Complejo complejo, def horarios) {
		println "complejo.horarios 1: ${complejo.horarios}"
		for(int eachDia = 1; eachDia <= 8; eachDia++) {
			println "horario del dia ${eachDia}: ${horarios[eachDia.toString()]}"
			Horario horario = complejo.horarios.find{it.dia == eachDia}
			def datosHorariosDia = horarios[eachDia.toString()]
			if(horario && datosHorariosDia) {
				horario.horarioApertura = datosHorariosDia.apertura
				horario.horarioCierre = datosHorariosDia.cierre
				println "horaro ${horario} ACTUALIZADO"
			} else if(!horario && datosHorariosDia) {
				horario = new Horario(dia:eachDia, horarioApertura: datosHorariosDia.apertura, horarioCierre: datosHorariosDia.cierre)
				println "horaro ${horario} CREADO"
				complejo.agregarHorario(horario)
			}
		}
		println "complejo.horarios 2: ${complejo.horarios}"
	}

}