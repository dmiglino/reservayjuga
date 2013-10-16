package ar.com.reservayjuga.complejo

class HorarioService {
	
	/**
	 * Crea los horarios a partir de los datos pasados por parametro
	 * @param map
	 * @return list horarios
	 */
    def createHorarios(def horariosMap) {
		List horarios = []
		
		int dia = 1
		horariosMap.each {
			Horario horario = new Horario(dia:dia, horarioApertura: it.desde, horarioCierre: it.hasta)
			horarios.add(horario)
			dia++
		}

		return horarios
    }
}
