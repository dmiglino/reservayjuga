<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Encargado del complejo</title>

<meta name="description" content="Common form elements and layouts" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->

<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="../assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="../assets/css/chosen.css" />
<link rel="stylesheet" href="../assets/css/datepicker.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-timepicker.css" />
<link rel="stylesheet" href="../assets/css/daterangepicker.css" />
<link rel="stylesheet" href="../assets/css/colorpicker.css" />

<!-- fonts -->

<link rel="stylesheet" href="../assets/css/ace-fonts.css" />

<!-- ace styles -->

<link rel="stylesheet" href="../assets/css/ace.min.css" />
<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="../assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="../assets/js/html5shiv.js"></script>
		<script src="../assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body>
			
	<g:render template="/layouts/navigation_bar" model="['tituloPagina':'Encargado del complejo', 'tipoUsuario':'Encargado']" />

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">

			<g:render template="/layouts/sidebar_panel" />

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">Panel
								de control</a></li>

						<li><a href="#">Administrar Complejo</a></li>
					</ul>
					<!-- .breadcrumb -->
				</div>
				

				<div class="page-content">
					<div class="page-header">
						<h1>
							<small> Datos Generales </small>
						</h1>
					</div>
					<!-- /.page-header -->

					<g:hasErrors>
						<div class="errors">
						<g:renderErrors bean="${complejo}" as="list" /> </div>
					</g:hasErrors>

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<g:form id="formUpdateComplejo" action="actualizarInformacionComplejo" class="form-horizontal" role="form"  enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="nombre"> Nombre </label>

									<div class="col-sm-9">
										<g:textField name="nombre" value="${complejo?.nombre}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="webSite">Sitio Web </label>

									<div class="col-sm-9">
										<g:textField name="webSite" value="${complejo?.webSite}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="mail">Mail </label>

									<div class="col-sm-9">
										<g:textField name="mail" value="${complejo?.mail}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="telefono1">Telefono 1 </label>

									<div class="col-sm-9">
										<g:textField name="telefono1" value="${complejo?.telefono1}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="telefono2">Telefono 2 </label>

									<div class="col-sm-9">
										<g:textField name="telefono2" value="${complejo?.telefono2}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="telefono3">Telefono 3 </label>

									<div class="col-sm-9">
										<g:textField name="telefono3" value="${complejo?.telefono3}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="telefono4">Telefono 4 </label>

									<div class="col-sm-9">
										<g:textField name="telefono4" value="${complejo?.telefono4}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label"
										for=informacionExtra> Informacion Extra </label>
									<g:textArea name="informacionExtra" value="${complejo?.informacionExtra}" class="col-xs-4 col-sm-5-"/>
								</div>

								<div class="space-4"></div>

								
							<div class="page-header">
								<h1>
									<small> Ubicacion </small>
								</h1>
							</div>
								

								<div id="paisesDiv" class="form-group">
									<label class="col-sm-3 control-label" for="pais">
										<g:message code="ubicacion.pais.label" default="Pais" />
									</label>
									<g:select id="pais" name="pais.id" from="${ar.com.reservayjuga.ubicacion.Pais.list()}"
										optionKey="id" required="" noSelection="['':'Selecciona un Pais']" class="col-xs-4 col-sm-5-"
										onchange="${remoteFunction (
											controller: 'pais',
											action: 'getProvincias',
											params: '\'id=\' + this.value',
											update: 'provinciasDiv'
										)}"
										value="${complejo?.ubicacion?.pais?.id}" 
										class="many-to-one" />
								</div>

								<div id="provinciasDiv" class="form-group">
									<g:if test="${complejo?.ubicacion?.pais}">
										<g:include controller="pais" action="getProvincias" id="${complejo?.ubicacion?.pais?.id}" />
									</g:if>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label"
										for="direccion">Direccion</label>

									<div class="col-sm-9">
										<g:textField name="direccion" value="${complejo?.ubicacion?.direccion}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>
								
								
							<div class="page-header">
								<h1>
									<small> Servicios </small>
								</h1>
							</div>


								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.vestuario" value="${complejo?.servicios?.vestuario}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl">Vestuario</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.bebida" value="${complejo?.servicios?.bebida}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl">Bebida</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.ayudaMedica" value="${complejo?.servicios?.ayudaMedica}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl">Ayuda medica</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.wifi" value="${complejo?.servicios?.wifi}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl"> Wifi</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.television" value="${complejo?.servicios?.television}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl"> TV</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.comida" checked="${complejo?.servicios?.comida}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl">Comida</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.torneo" checked="${complejo?.servicios?.torneo}" value="${complejo?.servicios?.torneo}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl">Torneos</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.gimnasio" checked="${complejo?.servicios?.gimnasio}" value="${complejo?.servicios?.gimnasio}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl">Gimnasio</span>
									</label>
								</div>

								<div class="checkbox">
									<label> 
										<g:checkBox name="servicios.estacionamiento" checked="${complejo?.servicios?.estacionamiento}" class="col-xs-4 col-sm-5-"/>
										<span class="lbl">Estacionamiento</span>
									</label>
								</div>

								<div class="form-group">
									<label> 
										<g:textField name="servicios.precioEstacionamiento" value="${complejo?.servicios?.precioEstacionamiento}" class="col-xs-10 col-sm-5"/>
										<span class="lbl">Precio Estacionamiento</span>
									</label>
								</div>

<%--								<g:each in="${complejo?.servicios?.properties}" var="serv" status="i">--%>
<%--									<div class="checkbox">--%>
<%--										<label> --%>
<%--											<g:checkBox name="${serv.key}" value="${serv.value}" checked="${serv.value}" class="col-xs-4 col-sm-5-" />--%>
<%--		    								<span class="lbl">"${serv.key}"</span>--%>
<%--	    								</label>--%>
<%--									</div>--%>
<%--								</g:each>--%>


							<div class="page-header">
								<h1>
									<small> Configuracion de senia e items extras </small>
								</h1>
							</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="porcentajeSenia">Porcentaje de senia</label>

									<div class="col-sm-9">
										<g:textField name="porcentajeSenia" value="${complejo?.porcentajeSenia}" class="input-mini" id="spinner4" />
									</div>
								</div>


							<div class="page-header">
								<h1>
									<small> Horarios Operativos </small>
								</h1>
							</div>


								<g:each in="${[1,2,3,4,5,6,7,8]}" var="dia" status="i">
									<div class="form-group">
										<label class="col-sm-3 control-label" for="horarioApertura"> 
											<g:message
												code="horario.dia.${dia.toString()}.label"
												default="Dia ${dia.toString()}" />
										</label>
										<g:select id="horarioApertura"
											name="horarios.${dia.toString()}.apertura"
											from="${["8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"]}"
											noSelection="['':'Selecciona un Horario']"
											class="col-xs-4 col-sm-5- many-to-one"
											value="${complejo?.horarios.find{it.dia == dia}?.horarioApertura}" />
										<g:select id="horarioCierre"
											name="horarios.${dia.toString()}.cierre"
											from="${["9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"]}"
											noSelection="['':'Selecciona un Horario']"
											class="col-xs-4 col-sm-5- many-to-one"
											value="${complejo?.horarios.find{it.dia == dia}?.horarioCierre}" />
									</div>
								</g:each>


								<div class="page-header">
									<h1>
										<small> Imagenes </small>
									</h1>
								</div>
								
								<div class="row">	
									<div id="imagenesDiv">									
										<g:render template="tabla-imagenes" model="[imagenes : imagenesList]" />
									</div>
									
									    <!-- inicio selector de imagenes -->
									    <g:uploadForm controller="complejo" action="agregarImagen">
									    <div class="col-sm-4">
											<div class="widget-box">
												<div class="widget-header">
													<h4>Carga de Imagenes</h4>

													<span class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="icon-chevron-up"></i>
														</a>

														<a href="#" data-action="close">
															<i class="icon-remove"></i>
														</a>
													</span>
												</div>
												
												<g:hiddenField name="imagen.foto" id="foto2" value="" />
														
												<div class="widget-body">
													<div class="widget-main">
														<div id="input-file" >
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
														<label>
															<span class="lbl"> 
																<g:message code="comunes.nombre.label" default="Nombre" />
															</span>
															<g:textField name="imagen.nombre" id="imagen.nombre" />
														</label>
													</div>
													
													<div class="widget-main">
														<label>
															<span class="lbl"> 
																<g:message code="comunes.descripcion.label" default="Descripcion" />
															</span>
															<g:textArea name="imagen.descripcion" id="imagen.descripcion" />
														</label>
													</div>
												</div>
												
												<div class="widget-body">
													<div class="widget-main">
													<input type="submit" value="subir" />
														<g:submitToRemote class="btn btn-info" update="[success:'imagenesDiv']" after="cleanImageFields();" 
															url="[controller:'complejo', action:'agregarImagen']" value="Subir Imagen" before="setImagenToForm();" />
													</div>
												</div>
											</div>
										</div>
										</g:uploadForm>
										<!-- fin selector de imagenes -->
										
									</div>

								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button">
											<i class="icon-ok bigger-110"></i> Guardar
										</button>
										
										<g:submitButton class="btn btn-info" name="actualizarInformacionComplejo" value="Actualizar Informacion del Complejo" />
								
										&nbsp; &nbsp; &nbsp;
									</div>
								</div>
							</g:form>
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div><!-- /.main-content -->


<!-- COMIENZO DEL MODAL PARA EDITAR IMAGENES -->
<g:formRemote name="formEditImage" url="[controller:'complejo', action:'editarImagen']">
	<g:render template="edit_image_modal" model="[imagenes : imagenesList]" />
</g:formRemote>
<!-- FIN DEL MODAL PARA EDITAR IMAGENES -->

	<g:render template="/layouts/settings_box" /> 

	</div><!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="icon-double-angle-up icon-only bigger-110"></i>
	</a>

	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='../assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='../assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="../assets/js/bootstrap.min.js"></script>
	<script src="../assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="../assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="../assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="../assets/js/chosen.jquery.min.js"></script>
	<script src="../assets/js/fuelux/fuelux.spinner.min.js"></script>
	<script src="../assets/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="../assets/js/date-time/bootstrap-timepicker.min.js"></script>
	<script src="../assets/js/date-time/moment.min.js"></script>
	<script src="../assets/js/date-time/daterangepicker.min.js"></script>
	<script src="../assets/js/bootstrap-colorpicker.min.js"></script>
	<script src="../assets/js/jquery.knob.min.js"></script>
	<script src="../assets/js/jquery.autosize.min.js"></script>
	<script src="../assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
	<script src="../assets/js/jquery.maskedinput.min.js"></script>
	<script src="../assets/js/bootstrap-tag.min.js"></script>

	<!-- ace scripts -->

	<script src="../assets/js/ace-jquery-commons.js"></script>
	<script src="../assets/js/ace-elements.min.js"></script>
	<script src="../assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->

	<script type="text/javascript">

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
<%--			     document.getElementById("fotoImagenEdit").value = foto;--%>
			     document.getElementById("vista_previa").innerHTML='<img src="'+foto+'" width="100" height="75" >';
<%--			     alert("input: "+document.getElementById("fotoImagenEdit").value);--%>
			});

			function setImagenToForm() {
				var fot = document.getElementById("foto").value;
				document.getElementById("foto2").value = fot;
			}
		</script>

	</body>
</html>