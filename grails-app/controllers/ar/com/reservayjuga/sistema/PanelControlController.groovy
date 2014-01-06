package ar.com.reservayjuga.sistema

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.ComplejoService;
import ar.com.reservayjuga.usuario.Jugador
import grails.converters.JSON

import org.codehaus.groovy.grails.web.json.JSONObject


class PanelControlController {
	
	def authenticationService
	ComplejoService complejoService
	
    def index() { 
		render(view: "panel_control_new")
	}
	
	def getResources = {

//		render(contentType: "text/json") {
//		JSONObject json = new JSONObject();
//		// Put a simple element
//		json.put( "text", "cancha 1");
//		json.put("color", "#f58a8a" );
//		json.put("value", 1);
//		}
		
		
//		def map = [text:"Gromit", value:1, color:"#f58a8a"]		
//		
//		render map as JSON
		
		
	}

}