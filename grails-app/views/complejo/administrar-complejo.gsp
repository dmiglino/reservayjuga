<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8" />
	<meta name="layout" content="main" />
	<title><g:message code="complejo.titulo.label" default="Administracion de Complejo" /></title>
	<script src="../assets/js/jquery-ui-1.10.3.full.min.js"></script>
	<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
	<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.full.min.css" />
</head>

<body>

	<%-- inicio main-container --%>

	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
			try {
				ace.settings.check('breadcrumbs', 'fixed')
			} catch (e) {
			}
		</script>

		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i><a href="#"> 
				<g:message code="sidebar.panel.label" default="Panel de Control" />
			</a></li>

			<li><a href="#"> 
				<g:message code="sidebar.administrar.complejo.label" default="Administrar Complejo" />
			</a></li>
		</ul>
		<!-- .breadcrumb -->
	</div>


	<div class="page-content">

		<g:hasErrors>
			<div class="errors">
				<g:renderErrors bean="${complejo}" as="list" />
			</div>
		</g:hasErrors>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<g:form id="formUpdateComplejo" class="form-horizontal" action="actualizarInformacionComplejo" role="form">

					<div id="accordion" class="accordion-style2">
						<div class="group">
							<h3 class="accordion-header">Datos Generales</h3>
							<div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="nombre"> 
										<g:message code="common.nombre.label" default="Nombre" />
									</label>
									<div class="col-sm-3">
										<g:textField name="nombre" value="${complejo?.nombre}" class="col-sm-12" />
									</div>

									<label class="col-sm-1 control-label" for="webSite">
										<g:message code="common.website.label" default="Sitio Web" /> 
									</label>
									<div class="col-sm-3">
										<g:textField name="webSite" value="${complejo?.webSite}" class="col-sm-12" />
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="mail"> 
										<g:message code="common.email.label" default="Mail" />
									</label>
									<div class="col-sm-3">
										<g:textField name="mail" value="${complejo?.mail}" class="col-sm-12" />
									</div>

									<label class="col-sm-1 control-label" for=informacionExtra>
										<g:message code="common.info.extra.label" default="Informacion Extra" />
									</label>
									<div class="col-sm-3">
										<g:textArea name="informacionExtra" value="${complejo?.informacionExtra}" class="col-sm-12" />
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="telefono1">
										<g:message code="common.telefono.1.label" default="Telefono 1" />
									</label>
									<div class="col-sm-3">
										<g:textField name="telefono1" value="${complejo?.telefono1}" class="col-sm-12" />
									</div>
									<button type="button" class='btn btn-sm btn-primary' id="btn1">
										Agregar Telefono
									</button>
								</div>

								<div class="space-4"></div>

								<div id="tel2" class="form-group" style="display: none">
									<label class="col-sm-2 control-label" for="telefono2">
										<g:message code="common.telefono.2.label" default="Telefono 2" />
									</label>
									<div class="col-sm-3">
										<g:textField name="telefono2" value="${complejo?.telefono2}" class="col-sm-12" />
									</div>
								</div>

								<div class="space-4"></div>

								<div id="tel3" class="form-group" style="display: none">
									<label class="col-sm-2 control-label" for="telefono3">
										<g:message code="common.telefono.3.label" default="Telefono 3" />
									</label>
									<div class="col-sm-3">
										<g:textField name="telefono3" value="${complejo?.telefono3}" class="col-sm-12" />
									</div>
								</div>

								<div class="space-4"></div>

								<div id="tel4" class="form-group" style="display: none">
									<label class="col-sm-2 control-label" for="telefono4">
										<g:message code="common.telefono.4.label" default="Telefono 4" />
									</label>
									<div class="col-sm-3">
										<g:textField name="telefono4" value="${complejo?.telefono4}" class="col-sm-12" />
									</div>
								</div>
								<div class="space-4"></div>
							</div>
						</div>


						<div class="group">
							<h3 class="accordion-header">Ubicacion</h3>
							<div>

								<div id="paisesDiv" class="form-group">
									<label class="col-sm-2 control-label" for="pais"> 
										<g:message code="ubicacion.pais.label" default="Pais" />
									</label>
									<div class="col-sm-3">
										<g:select id="pais" name="pais.id"
											from="${ar.com.reservayjuga.ubicacion.Pais.list()}"
											optionKey="id" required=""
											noSelection="['':'Selecciona un Pais']" class="col-sm-12"
											onchange="${remoteFunction (
												controller: 'pais',
												action: 'getProvincias',
												params: '\'id=\' + this.value',
												update: 'provinciasDiv'
											)}"
											value="${complejo?.ubicacion?.pais?.id}" class="many-to-one" />
									</div>
								</div>

								<div id="provinciasDiv" class="">
									<g:if test="${complejo?.ubicacion?.pais}">
										<g:include controller="pais" action="getProvincias" id="${complejo?.ubicacion?.pais?.id}" />
									</g:if>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="direccion">
										<g:message code="ubicacion.direccion.label" default="Direccion" />
									</label>
									<div class="col-sm-3">
										<g:textField name="direccion" value="${complejo?.ubicacion?.direccion}" class="col-sm-12" />
									</div>
								</div>

							</div>
						</div>



						<div class="group">
							<h3 class="accordion-header">Servicios</h3>
							<div>
								<div class="checkbox col-sm-2">
									<label> 
										<g:checkBox name="servicios.vestuario"
											value="${complejo?.servicios?.vestuario}"
											class="ace col-sm-5-" /> 
											<span class="lbl">
												<g:message code="servicios.vestuario.label" default="Vestuario" />
											</span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> 
										<g:checkBox name="servicios.bebida" value="${complejo?.servicios?.bebida}" class="ace col-sm-5-" />
										<span class="lbl">
											<g:message code="servicios.bebida.label" default="Bebida" />
										</span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> 
										<g:checkBox name="servicios.ayudaMedica"
											value="${complejo?.servicios?.ayudaMedica}"
											class="ace col-sm-5-" /> 
											<span class="lbl">
												<g:message code="servicios.ayudamedica.label" default="Ayuda medica" />
											</span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> <g:checkBox name="servicios.wifi"
											value="${complejo?.servicios?.wifi}" class="ace col-sm-5-" />
										<span class="lbl"> <g:message
												code="servicios.wifi.label" default="Wifi" /></span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> <g:checkBox name="servicios.television"
											value="${complejo?.servicios?.television}"
											class="ace col-sm-5-" /> <span class="lbl"> <g:message
												code="servicios.tv.label" default="TV" /></span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> <g:checkBox name="servicios.comida"
											checked="${complejo?.servicios?.comida}"
											class="ace col-sm-5-" /> <span class="lbl"><g:message
												code="servicios.comida.label" default="Comida" /></span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> <g:checkBox name="servicios.torneo"
											checked="${complejo?.servicios?.torneo}"
											value="${complejo?.servicios?.torneo}" class="ace col-sm-5-" />
										<span class="lbl"><g:message
												code="servicios.torneos.label" default="Torneos" /></span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> <g:checkBox name="servicios.gimnasio"
											checked="${complejo?.servicios?.gimnasio}"
											value="${complejo?.servicios?.gimnasio}"
											class="ace col-sm-5-" /> <span class="lbl"><g:message
												code="servicios.gimnasio.label" default="Gimnasio" /></span>
									</label>
								</div>

								<div class="checkbox col-sm-2">
									<label> <g:checkBox name="servicios.estacionamiento"
											checked="${complejo?.servicios?.estacionamiento}"
											class="ace col-sm-5-" /> <span class="lbl"><g:message
												code="servicios.estacionamiento.label"
												default="Estacionamiento" /></span>
									</label>
								</div>
								<br /> <br /> <label> <span class="lbl"> <g:message
											code="servicios.estacionamiento.precio.label"
											default="Precio Estacionamiento" />
								</span> <g:textField name="servicios.precioEstacionamiento"
										value="${complejo?.servicios?.precioEstacionamiento}"
										class="input-mini" />
								</label>

							</div>
						</div>


						<div class="group">
							<h3 class="accordion-header">Configuracion de senia</h3>
							<div>

								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="porcentajeSenia">
										<g:message code="config.senia.label" default="Porcentaje de seña" /> </label>
									<div class="col-sm-9">
										<g:hiddenField name="porcentajeSeniaHidden" id="porcentajeSeniaHidden" value="${complejo?.porcentajeSenia}"/>
										<g:textField name="porcentajeSenia" id="spinner4" value="${complejo?.porcentajeSenia}" class="input-mini" />
									</div>
								</div>
							</div>
						</div>

						<div class="group">
							<h3 class="accordion-header">Horarios operativos</h3>
							<div>

								<g:each in="${[1,2,3,4,5,6,7,8]}" var="dia" status="i">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="horarioApertura">
											<g:message code="horario.dia.${dia.toString()}.label"
												default="Dia ${dia.toString()}" />
										</label>
										<g:select id="horarioApertura"
											name="horarios.${dia.toString()}.apertura"
											from="${["8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"]}"
											noSelection="['':'Selecciona un Horario']"
											class="col-xs-2 many-to-one"
											value="${complejo?.horarios.find{it.dia == dia}?.horarioApertura}" />
										<div class="col-xs-1"></div>
										<g:select id="horarioCierre"
											name="horarios.${dia.toString()}.cierre"
											from="${["9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"]}"
											noSelection="['':'Selecciona un Horario']"
											class="col-xs-2 many-to-one"
											value="${complejo?.horarios.find{it.dia == dia}?.horarioCierre}" />
									</div>
								</g:each>

							</div>
						</div>

						<div class="group">
							<h3 class="accordion-header">Imagenes</h3>
							<div>

								<div class="row">
									<div id="imagenesDiv">
										<g:render template="tabla-imagenes" model="[imagenes : imagenesList]" />
									</div>

									<!-- inicio selector de imagenes -->
									<%--									<g:uploadForm controller="complejo" action="agregarImagen">--%>
									<div class="col-sm-4">
										<div class="widget-box">
											<div class="widget-header">
												<h4>
													<g:message code="imagenes.carga.label" default="Carga de Imagenes" />
												</h4>

												<span class="widget-toolbar"> 
													<a href="#" data-action="collapse"> <i class="icon-chevron-up"></i></a> 
													<a href="#" data-action="close"> <i class="icon-remove"></i></a>
												</span>
											</div>

											<g:hiddenField name="imagen.foto" id="foto2" value="" />

											<div class="widget-body">
												<div class="widget-main">
													<div id="input-file">
														<input type="file" id="foto" name="foto" />
													</div>
													<label> 
														<input type="checkbox" name="file-format" id="id-file-format" class="ace" /> 
														<span class="lbl"> Allow only images</span>
													</label>
												</div>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<div class="form-group">
														<span class="col-sm-4 control-label"> <g:message
																code="comunes.nombre.label" default="Nombre" />
														</span>
														<g:textField name="imagen.nombre" class="col-sm-6" id="imagen.nombre" />
													</div>
													<div class="form-group">

														<span class="col-sm-4 control-label"> <g:message
																code="comunes.descripcion.label" default="Descripcion" />
														</span>
														<g:textArea name="imagen.descripcion" class="col-sm-6" id="imagen.descripcion" />
													</div>
												</div>
											</div>

											<div class="widget-body">
												<div align="center" class="widget-main">
													<g:submitToRemote class="btn btn-info"
														update="[success:'imagenesDiv']"
														after="cleanImageFields();"
														url="[controller:'complejo', action:'agregarImagen']"
														value="${message(code: 'button.subir.imagen.label',default: 'Subir Imagen')}" 
														before="setImagenToForm();" />
												</div>
											</div>
										</div>
									</div>
									<%-- </g:uploadForm>--%>
									<!-- fin selector de imagenes -->

								</div>
							</div>
						</div>

					</div>

					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<g:submitButton class="btn btn-info" name="actualizarInformacionComplejo" value="${message(code: 'button.actualizar.informacion.complejo.label',default: 'Actualizar')}" />
							&nbsp; &nbsp; &nbsp;
						</div>
					</div>
				</g:form>
			</div>
		</div>
		<!-- /.col -->
	</div>


	<!-- COMIENZO DEL MODAL PARA EDITAR IMAGENES -->
	<g:formRemote name="formEditImage"
		url="[controller:'complejo', action:'editarImagen']">
		<g:render template="edit_image_modal"
			model="[imagenes : imagenesList]" />
	</g:formRemote>
	<!-- FIN DEL MODAL PARA EDITAR IMAGENES -->


	<!-- fin main-container -->

	<%-- SCRIPTS DE LA PAGINA --%>
	<script src="../assets/js/fuelux/fuelux.spinner.min.js"></script>
	<script type="text/javascript">
	
		//jquery accordion
		$( "#accordion" ).accordion({
			collapsible: true ,
			heightStyle: "content",
			animate: 250,
			header: ".accordion-header"
		}).sortable({
			axis: "y",
			handle: ".accordion-header",
			stop: function( event, ui ) {
				// IE doesn't register the blur when sorting
				// so trigger focusout handlers to remove .ui-state-focus
				ui.item.children( ".accordion-header" ).triggerHandler( "focusout" );
			}
		});
	
			
			$("#btn1").click(function testeo()
			{	 
				if ($("#tel2").css("display") == 'none')  
				{
    				$("#tel2").css("display", "block");
				}
				else if ($("#tel3").css("display") == "none")
					 {
    					$("#tel3").css("display", "block");
					 }
					 else if ($("#tel4").css("display") == "none")
					 {
    					$("#tel4").css("display", "block");
					 }
			})

			function cleanImageFields() {
				document.getElementById("imagen.nombre").value = "";
				document.getElementById("imagen.descripcion").value = "";
			}
					
			$(document).on("click", ".open-EditImageModal", function () {
			     var imageId = $(this).data('id');
			     var nombre = document.getElementById("nombreImagen").value;
			     var descripcion = document.getElementById("descripcionImagen").value;
			     var portada = document.getElementById("portadaImagen").value;
			     var foto = document.getElementById("fotoImagen").value;
			     $(".modal-body #idImagenEdit").val(imageId);
			     $(".modal-body #nombreImagenEdit").val(nombre);
			     $(".modal-body #descripcionImagenEdit").val(descripcion);
			     $(".modal-body #portadaImagenEdit").val(portada);
	
			    	alert("fot: "+foto);
			     $(".input-file #fotoImagenEdit").val(foto);
				<%--			     document.getElementById("fotoImagenEdit").value = foto; 
			     document.getElementById("vista_previa").innerHTML='<img src="'+foto+'" width="100" height="75" >';--%>
				<%--			     alert("input: "+document.getElementById("fotoImagenEdit").value);--%>
			});
	
			function setImagenToForm() {
				var fot = document.getElementById("foto").value;
				document.getElementById("foto2").value = fot;
			}
			
			$('#spinner4').ace_spinner({value:$('#porcentajeSeniaHidden').val(),min:0,max:100,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
			
			.on('change', function(){
				//alert(this.value)
			});
				
		</script>

	</body>
</html>