package ar.com.reservayjuga.complejo;

public enum DeporteEnum {
	
	FUTBOL_5("enum.deporte.futbol.5",[
		SuperficieEnum.SINTETICO_CON_ARENA, 
		SuperficieEnum.SINTETICO_CON_CAUCHO, 
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.PARQUET, 
		SuperficieEnum.BALDOSA
	]), 
	FUTBOL_6("enum.deporte.futbol.6",[
		SuperficieEnum.SINTETICO_CON_ARENA, 
		SuperficieEnum.SINTETICO_CON_CAUCHO, 
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.PARQUET, 
		SuperficieEnum.BALDOSA
	]), 
	FUTBOL_7("enum.deporte.futbol.7",[
		SuperficieEnum.SINTETICO_CON_ARENA, 
		SuperficieEnum.SINTETICO_CON_CAUCHO, 
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.PARQUET, 
		SuperficieEnum.BALDOSA, 
		SuperficieEnum.CESPED
	]), 
	FUTBOL_8("enum.deporte.futbol.8",[
		SuperficieEnum.SINTETICO_CON_ARENA, 
		SuperficieEnum.SINTETICO_CON_CAUCHO, 
		SuperficieEnum.CEMENTO, 
		SuperficieEnum.PARQUET, 
		SuperficieEnum.BALDOSA, 
		SuperficieEnum.CESPED
	]), 
	FUTBOL_9("enum.deporte.futbol.9",[
		SuperficieEnum.SINTETICO_CON_ARENA, 
		SuperficieEnum.SINTETICO_CON_CAUCHO, 
		SuperficieEnum.CESPED, 
	]), 
	FUTBOL_11("enum.deporte.futbol.11",[
		SuperficieEnum.SINTETICO_CON_ARENA, 
		SuperficieEnum.SINTETICO_CON_CAUCHO, 
		SuperficieEnum.CESPED, 
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
	]), 
	BASQUET("enum.deporte.basquet",[
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