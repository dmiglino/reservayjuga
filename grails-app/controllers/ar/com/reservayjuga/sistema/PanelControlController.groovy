package ar.com.reservayjuga.sistema

import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.ComplejoService;
import ar.com.reservayjuga.usuario.Jugador
import grails.converters.JSON
import grails.web.JSONBuilder

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
		
//		render(contentType: "application/json") {
//			categories = ['a', 'b', 'c']
//			title = "Hello JSON"
//			information = {
//				pages = 10
//			}
//		}
//		
//		def mapOfStuff = [ "text":"Gromit", "value":1, "color":"#f58a8a" ]
//		render mapOfStuff as JSON
		
		def mapOfStuff = [ "text":"Gromit", "value":1, "color":"#f58a8a" ]
		
		def lista = [mapOfStuff]
				
		render lista as JSON;
		
//		render map as JSON
		
//		[myStringArray:map] as JSON
//		return [model:map]
//		
		
	}

}