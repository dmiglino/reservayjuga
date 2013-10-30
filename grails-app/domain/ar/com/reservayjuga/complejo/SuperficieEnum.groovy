package ar.com.reservayjuga.complejo;

import java.util.List;

public enum SuperficieEnum {
	
	SINTETICO_CON_ARENA("enum.superficie.arena"),
	SINTETICO_CON_CAUCHO("enum.superficie.caucho"),
	CESPED("enum.superficie.cesped"), 
	CEMENTO("enum.superficie.cemento"), 
	PARQUET("enum.superficie.parquet"), 
	BALDOSA("enum.superficie.baldosa"), 
	GOMA("enum.superficie.goma"), 
	POLVO_DE_LADRILLO("enum.superficie.polvo")

	String textCode
	
	SuperficieEnum(String text) {
		textCode = text
	}
}