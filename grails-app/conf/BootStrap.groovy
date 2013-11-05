import grails.util.Environment
import ar.com.reservayjuga.DBUtils
import ar.com.reservayjuga.complejo.Cancha
import ar.com.reservayjuga.complejo.Complejo
import ar.com.reservayjuga.complejo.DeporteEnum
import ar.com.reservayjuga.complejo.Extras
import ar.com.reservayjuga.complejo.Horario
import ar.com.reservayjuga.complejo.Imagen
import ar.com.reservayjuga.complejo.Precio
import ar.com.reservayjuga.complejo.Servicios
import ar.com.reservayjuga.complejo.SuperficieEnum
import ar.com.reservayjuga.ubicacion.Barrio
import ar.com.reservayjuga.ubicacion.Localidad
import ar.com.reservayjuga.ubicacion.Pais
import ar.com.reservayjuga.ubicacion.Provincia
import ar.com.reservayjuga.ubicacion.Ubicacion
import ar.com.reservayjuga.usuario.Encargado
import ar.com.reservayjuga.usuario.Jugador
import ar.com.reservayjuga.usuario.SistemaRyJ
import ar.com.reservayjuga.seguridad.SecRole
import ar.com.reservayjuga.seguridad.SecUser
import ar.com.reservayjuga.seguridad.SecUserSecRole

class BootStrap {

	Complejo poli, terraza, muni
	Cancha p1,p2,p3,p4,p5,p6,p7,t1,t2,t3,t4,t5,t6,t7,muni1,muni2,muni3,muni4,muni5,muni6,muni7
	Precio l1,l2,l3,l4,m1,m2,m3,m4,mi1,mi2,mi3,mi4,j1,j2,j3,j4,v1,v2,v3,v4,s1,s2,s3,s4,d1,d2,d3,d4
	List precios = [l1,l2,l3,l4,m1,m2,m3,m4,mi1,mi2,mi3,mi4,j1,j2,j3,j4,v1,v2,v3,v4,s1,s2,s3,s4,d1,d2,d3,d4]
	Horario lu,ma,mi,ju,vi,sa,dom
	List horarios = [lu,ma,mi,ju,vi,sa,dom]
	Imagen f1,f2
	Servicios serv1
	Ubicacion u1,u2
	Pais argentina, brasil
	Provincia baires, saopaulo
	Localidad caba, vtelopez, morumbiloc
	Barrio pueyrre, saavedra, florida, olivos, morumbibar
	
	def init = { servletContext ->
		
		switch (Environment.current) {
			case Environment.DEVELOPMENT:
				println "Creando datos iniciales..."
				if(primeraVez()) {
					crearPrecio()
					crearHorarios()
					crearImagen()
					crearServicios()
					crearUbicaciones()
					crearComplejos()
					crearCancha()
					crearExtras()
					crearJugadores()
					crearEncargados()
					crearAdministrador()
					asociarCanchasAComplejos()
				}
				break;
			case Environment.PRODUCTION:
				println "No special configuration required"
				break;	
		}
	}

	def destroy = {
	}

	def crearCancha() {
		p1 = new Cancha(nombre:"Poli-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true,precios:precios, complejo:poli)
		p2 = new Cancha(nombre:"Poli-2", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_CAUCHO, cantidadJugadores:5, cubierta: true,precios:precios, complejo:poli)
		p3 = new Cancha(nombre:"Poli-3", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.CEMENTO, cantidadJugadores:5, cubierta: true,precios:precios, complejo:poli)
		p4 = new Cancha(nombre:"Poli-4", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.PARQUET, cantidadJugadores:7, cubierta: true,precios:precios, complejo:poli)
		p5 = new Cancha(nombre:"Poli-5", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:7, cubierta: false,precios:precios, complejo:poli)
		p6 = new Cancha(nombre:"Poli-6", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_CAUCHO, cantidadJugadores:8, cubierta: false,precios:precios, complejo:poli)
		p7 = new Cancha(nombre:"Poli-7", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.CESPED, cantidadJugadores:11, cubierta: false,precios:precios, complejo:poli)
		DBUtils.validateAndSave([p1,p2,p3,p4,p5,p6,p7])
		
		t1 = new Cancha(nombre:"Terr-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true,precios:precios, complejo:terraza)
		t2 = new Cancha(nombre:"Terr-2", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.PARQUET, cantidadJugadores:5, cubierta: true,precios:precios, complejo:terraza)
		t3 = new Cancha(nombre:"Terr-3", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.CEMENTO, cantidadJugadores:5, cubierta: true,precios:precios, complejo:terraza)
		t4 = new Cancha(nombre:"Terr-4", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:7, cubierta: true,precios:precios, complejo:terraza)
		t5 = new Cancha(nombre:"Terr-5", deporte:DeporteEnum.TENIS, superficie: SuperficieEnum.POLVO_DE_LADRILLO, cantidadJugadores:4, cubierta: true,precios:precios, complejo:terraza)
		t6 = new Cancha(nombre:"Terr-6", deporte:DeporteEnum.TENIS, superficie: SuperficieEnum.POLVO_DE_LADRILLO, cantidadJugadores:4, cubierta: false,precios:precios, complejo:terraza)
		t7 = new Cancha(nombre:"Terr-7", deporte:DeporteEnum.TENIS, superficie: SuperficieEnum.CEMENTO, cantidadJugadores:4, cubierta: false,precios:precios, complejo:terraza)
		DBUtils.validateAndSave([t1,t2,t3,t4,t5,t6,t7])
		
		muni1 = new Cancha(nombre:"Muni-1", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:5, cubierta: true,precios:precios, complejo:muni)
		muni2 = new Cancha(nombre:"Muni-2", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_CAUCHO, cantidadJugadores:5, cubierta: true,precios:precios, complejo:muni)
		muni3 = new Cancha(nombre:"Muni-3", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.CEMENTO, cantidadJugadores:5, cubierta: true,precios:precios, complejo:muni)
		muni4 = new Cancha(nombre:"Muni-4", deporte:DeporteEnum.FUTBOL, superficie: SuperficieEnum.SINTETICO_CON_ARENA, cantidadJugadores:7, cubierta: true,precios:precios, complejo:muni)
		muni5 = new Cancha(nombre:"Muni-5", deporte:DeporteEnum.PADEL, superficie: SuperficieEnum.CEMENTO, cantidadJugadores:4, cubierta: true,precios:precios, complejo:muni)
		muni6 = new Cancha(nombre:"Muni-6", deporte:DeporteEnum.PADEL, superficie: SuperficieEnum.CEMENTO, cantidadJugadores:4, cubierta: true,precios:precios, complejo:muni)
		muni7 = new Cancha(nombre:"Muni-7", deporte:DeporteEnum.TENIS, superficie: SuperficieEnum.POLVO_DE_LADRILLO, cantidadJugadores:4, cubierta: false,precios:precios, complejo:muni)
		DBUtils.validateAndSave([muni1,muni2,muni3,muni4,muni5,muni6,muni7])
	}
	
	def crearExtras() {
		Extras extras1 = new Extras(quiereArbitro: true, quierePechera: true, precioArbitro: 50f, precioPechera: 3.5f)
		Extras extras2 = new Extras(quiereArbitro: false, quierePechera: false, precioArbitro: 35f, precioPechera: 5.2f)
		DBUtils.validateAndSave([extras1, extras2])
	}
	
	def crearHorarios() {
		lu = new Horario(dia:1, horarioApertura: "11:00", horarioCierre: "20:00")
		ma = new Horario(dia:1, horarioApertura: "11:00", horarioCierre: "20:00")
		mi = new Horario(dia:1, horarioApertura: "11:00", horarioCierre: "20:00")
		ju = new Horario(dia:1, horarioApertura: "10:00", horarioCierre: "21:00")
		vi = new Horario(dia:2, horarioApertura: "10:00", horarioCierre: "21:00")
		sa = new Horario(dia:2, horarioApertura: "09:00", horarioCierre: "22:00")
		dom = new Horario(dia:2, horarioApertura: "09:00", horarioCierre: "23:00")
		DBUtils.validateAndSave([lu,ma,mi,ju,vi,sa,dom])
	}
	
	def crearImagen() {
		f1 = new Imagen(nombre: "foto 1" ,extension: ".jpg",descripcion:"foto 1", fecha:new Date(), portada: true)
		f2 = new Imagen(nombre: "foto 2" ,extension: ".jpg",descripcion:"foto 2", fecha: new Date(), portada: false)
		DBUtils.validateAndSave([f1,f2])
	}
	
	def crearPrecio() {
		l1 = new Precio(dia:1, horarioInicio: "10:00", precio: 300)
		l2 = new Precio(dia:1, horarioInicio: "11:00", precio: 300)
		l3 = new Precio(dia:1, horarioInicio: "12:00", precio: 300)
		l4 = new Precio(dia:1, horarioInicio: "13:00", precio: 300)
		m1 = new Precio(dia:2, horarioInicio: "17:00", precio: 300)
		m2 = new Precio(dia:2, horarioInicio: "18:00", precio: 300)
		m3 = new Precio(dia:2, horarioInicio: "19:00", precio: 300)
		m4 = new Precio(dia:2, horarioInicio: "20:00", precio: 300)
		mi1 = new Precio(dia:3, horarioInicio: "10:00", precio: 300)
		mi2 = new Precio(dia:3, horarioInicio: "11:00", precio: 300)
		mi3 = new Precio(dia:3, horarioInicio: "12:00", precio: 300)
		mi4 = new Precio(dia:3, horarioInicio: "13:00", precio: 300)
		j1 = new Precio(dia:4, horarioInicio: "17:00", precio: 300)
		j2 = new Precio(dia:4, horarioInicio: "18:00", precio: 300)
		j3 = new Precio(dia:4, horarioInicio: "19:00", precio: 300)
		j4 = new Precio(dia:4, horarioInicio: "20:00", precio: 300)
		v1 = new Precio(dia:5, horarioInicio: "10:00", precio: 400)
		v2 = new Precio(dia:5, horarioInicio: "11:00", precio: 400)
		v3 = new Precio(dia:5, horarioInicio: "12:00", precio: 400)
		v4 = new Precio(dia:5, horarioInicio: "13:00", precio: 400)
		s1 = new Precio(dia:6, horarioInicio: "17:00", precio: 400)
		s2 = new Precio(dia:6, horarioInicio: "18:00", precio: 400)
		s3 = new Precio(dia:6, horarioInicio: "19:00", precio: 400)
		s4 = new Precio(dia:6, horarioInicio: "20:00", precio: 400)
		d1 = new Precio(dia:7, horarioInicio: "10:00", precio: 500)
		d2 = new Precio(dia:7, horarioInicio: "11:00", precio: 500)
		d3 = new Precio(dia:7, horarioInicio: "12:00", precio: 500)
		d4 = new Precio(dia:7, horarioInicio: "13:00", precio: 500)
		DBUtils.validateAndSave([l1,l2,l3,l4,m1,m2,m3,m4,mi1,mi2,mi3,mi4,j1,j2,j3,j4,v1,v2,v3,v4,s1,s2,s3,s4,d1,d2,d3,d4])
	}
	
	def crearServicios() {
		serv1 = new Servicios(vestuario: true, television: false, bebida: true, comida: true, ayudaMedica: false, torneo: false, wifi: true, gimnasio: false, estacionamiento: true)
		DBUtils.validateAndSave(serv1)
	}
	
	def crearUbicaciones() {
		crearPaises()
		crearProvincias()
		crearLocalidades()
		crearBarrios()
		u1 = new Ubicacion(direccion: "Escobar", barrio: pueyrre)
		u2 = new Ubicacion(direccion: "OHiggins", barrio: florida)
		DBUtils.validateAndSave([u1,u2])
	}
	
	def crearPaises() {
		argentina = new Pais(nombre:"Argentina")
		brasil = new Pais(nombre:"Brasil")
		DBUtils.validateAndSave([argentina,brasil])
	}

	def crearProvincias() {
		baires = new Provincia(nombre:"Buenos Aires", pais:argentina)
		saopaulo = new Provincia(nombre:"Sao Paulo", pais:brasil)
		DBUtils.validateAndSave([baires,saopaulo])
	}

	def crearLocalidades() {
		caba = new Localidad(nombre:"CABA", provincia:baires)
		vtelopez = new Localidad(nombre:"Vte Lopez", provincia:baires)
		morumbiloc = new Localidad(nombre:"Morumbi", provincia:saopaulo)
		DBUtils.validateAndSave([caba,vtelopez,morumbiloc])
	}

	def crearBarrios() {
		pueyrre = new Barrio(nombre:"Villa Pueyrredon", localidad:caba)
		saavedra = new Barrio(nombre:"Saavedra", localidad:caba)
		florida = new Barrio(nombre:"Florida", localidad:vtelopez) 
 		olivos = new Barrio(nombre:"Olivos", localidad:vtelopez)
		morumbibar = new Barrio(nombre:"Morumbi", localidad:morumbiloc)
		DBUtils.validateAndSave([pueyrre,saavedra,florida,olivos,morumbibar])
	}

	def crearComplejos() {
		poli = new Complejo(nombre: "Poli",webSite: "www.poli.com",telefono1: "4111-2222",telefono2: "15-1324-3546",mail: "poli@poli.com",informacionExtra: "soy el poli",ubicacion: u1,servicios:serv1)
		terraza = new Complejo(nombre: "Terraza",webSite: "www.terraza.com",telefono1: "43334444",telefono2: "15-1234-4321",mail: "terraza@terraza.com",informacionExtra: "soy la terraza",ubicacion: u1,servicios:serv1)
		muni = new Complejo(nombre: "Muni",webSite: "www.muni.com",telefono1: "45556666",telefono2: "15-1928-3746",mail: "muni@muni.com",informacionExtra: "soy el muni",ubicacion: u2,servicios:serv1)
		DBUtils.validateAndSave([poli,terraza,muni])
	}
	
	def crearJugadores() {
		def role = SecRole.findByAuthority("JUGADOR_ROLE")
		
		if(!role)
			role = new SecRole(authority:"JUGADOR_ROLE").save(flush:true)
		
		def user = SecUser.findByUsername("jugadorTom")
		if(!user)
			user = new Jugador(apellido: "Esca",nombre: "Tom",username:"jugadorTom",password:"jugador",enable:true, telefono:"12345678", mail:"t@e.com").save(flush:true)
		SecUserSecRole.create(user,role,true)
		
		def user1 = SecUser.findByUsername("jugadorDie")
		if(!user1)
			user1 = new Jugador(apellido: "Mig",nombre: "Die",username:"jugadorDie",password:"jugador",enable:true, telefono:"12345678", mail:"d@m.com").save(flush:true)
		SecUserSecRole.create(user1,role,true)
	}
	
	def crearEncargados() {
		def role = SecRole.findByAuthority("ENCARGADO_ROLE")
		
		if(!role)
			role = new SecRole(authority:"ENCARGADO_ROLE").save(flush:true)
		
		def user = SecUser.findByUsername("encargadoTerraza")
		if(!user)
			user = new Encargado(apellido: "Cuevas",nombre: "Pipino",username:"encargadoTerraza",password:"encargado",enable:true,complejo:terraza).save(flush:true)
		SecUserSecRole.create(user,role,true)
		
		def user1 = SecUser.findByUsername("encargadoPoli")
		if(!user1)
			user1 = new Encargado(apellido: "Ricardo",nombre: "Rojas",username:"encargadoPoli",password:"encargado",enable:true,complejo:poli).save(flush:true)
		SecUserSecRole.create(user1,role,true)
	}
	
	def crearAdministrador() {
		def role = SecRole.findByAuthority("ADMIN_ROLE")
		
		if(!role)
			role = new SecRole(authority:"ADMIN_ROLE").save(flush:true)
		
		def user = SecUser.findByUsername("admin")
		if(!user)
			user = new SistemaRyJ(apellido: "Capo",nombre: "Admin",username:"admin",password:"admin",enable:true).save(flush:true)
		SecUserSecRole.create(user,role,true)
	}
	
	def asociarCanchasAComplejos() {
		poli.agregarCancha([p1,p2,p3,p4,p5,p6,p7])
		terraza.agregarCancha([t1,t2,t3,t4,t5,t6,t7])
		muni.agregarCancha([muni1,muni2,muni3,muni4,muni5,muni6,muni7])
		DBUtils.validateAndSave([poli,terraza,muni])
	}

	Boolean primeraVez() {
		Complejo.list()?.size() == 0
	}
}