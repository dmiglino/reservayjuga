package ar.com.reservayjuga.complejo;

public enum DeporteEnum {
	
	FUTBOL("enum.deporte.futbol",[
		SuperficieEnum.SINTETICO_CON_ARENA, 
		SuperficieEnum.SINTETICO_CON_CAUCHO, 
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.PARQUET, 
		SuperficieEnum.BALDOSA
	]), 
	TENIS("enum.deporte.tenis",[
		SuperficieEnum.CESPED, 
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.BALDOSA, 
		SuperficieEnum.GOMA, 
		SuperficieEnum.POLVO_DE_LADRILLO
	]), 
	PADEL("enum.deporte.padel",[
		SuperficieEnum.CESPED, 
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.BALDOSA, 
		SuperficieEnum.GOMA, 
	]), 
	SQUASH("enum.deporte.squash",[
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.PARQUET, 
		SuperficieEnum.BALDOSA, 
	])

	String textCode
	List superficies
	
	DeporteEnum(String text, List sups) {
		textCode = text
		superficies = sups
	}
}