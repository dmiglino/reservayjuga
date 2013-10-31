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
		  <link rel="stylesheet" href="../assets/css/ace-ie.min.css" />
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
		<g:render template="/layouts/navigation_bar" model="['tituloPagina':'Encargado de las canchas', 'tipoUsuario':'Encargado']" />

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<g:render template="/layouts/sidebar_panel" /> 

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Panel de control</a>
							</li>

							<li>
								<a href="#">Administrar Canchas</a>
							</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
							    <small>
									Listado de canchas
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<g:form action="agregarCancha" class="form-horizontal" role="form" >
							
						            <div class="row" id="tabla_canchas" >

						            	<g:render template="tabla_canchas" model="['cancha':cancha]" />
						            									
									</div>
                                    
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<g:actionSubmit action="agregarCancha" class="btn btn-info" value="Agregar Cancha" />
											&nbsp; &nbsp; &nbsp;
										</div>
									</div>
								</g:form>
								</div>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
                
                           <!-- comienzo DEL MODAL BOX PARA EDITAR -->
                           <g:formRemote name="formEditCancha" url="[controller:'cancha', action:'editarCancha']">
                				<div id="modal-form" class="modal" tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="blue bigger">Edicion de canchas</h4>
											</div>

											<div class="modal-body overflow-visible">
												<div class="row">
												    <div class="col-xs-8 col-sm-8">
														<div class="space-4"></div>

														<g:hiddenField name="idCanchaEdit" value="" />
														
<%--                                            			<g:render template="form_cancha" model="['cancha':['nombre':'asd','deporte':'FUTBOL','cubierta':true], 'edit':true]" />--%>
                                            	
														<div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-username">Nombre</label>

															<div>
																<g:textField name="nombreCanchaEdit" value="${cancha?.nombre}" class="col-sm-6" id="nombreCanchaEdit" />
															</div>
														</div>

														<div class="space-4"></div>
                                                        
                                                        <div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-select-3">Techado</label>
															<div>
																<g:select id="cubiertaCanchaEdit" 
																	name="cubiertaCanchaEdit"
																	from="${["true","false"]}"
																	noSelection="['':'']"
																	class="chosen-select one-to-one"
																	value=""  />
															</div>
														</div>
														
														<div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-select-3">Deporte</label>
<%--															${deportesDisponibles}--%>
															<div>
																<g:select id="deporteCanchaEdit" 
																	name="deporteCanchaEdit"
																	from="${deportesDisponibles}"
																	noSelection="['':'']"
																	class="chosen-select one-to-one"
																	optionValue="${ {deporte -> g.message(code:deporte.textCode)} }"
																	value="${cancha?.deporte}" 
																	onchange="${remoteFunction (
																		controller: 'cancha',
																		action: 'getSuperficies',
																		params: '\'id=\' + this.value',
																		update: 'superficiesDiv'
																	)}" />
															</div>
														</div>
														
														<g:hiddenField id="superficieCancha" name="superficieCanchaEdit" value="" />
												
														<div id="superficiesDiv" class="form-group">
															<g:if test="${cancha?.deporte}">
																<g:include controller="cancha" action="getSuperficies" id="${cancha?.deporte}" />
															</g:if>
														</div>
														
<%--														<g:hiddenField id="superficieCancha" name="cancha.superficie" value="" />--%>
														
														<div class="space-4"></div>
														
														<div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-select-3">Cantidad de jugadores</label>
														    <div>
																<g:textField name="cantidadJugadoresCanchaEdit" value="" class="input-mini" id="cantidadJugadoresCanchaEdit" />
														    </div>
														</div>
														
													</div>
												</div>
											</div>

											<div class="modal-footer">
												<button class="btn btn-sm" data-dismiss="modal">
													<i class="icon-remove"></i>
													Cancel
												</button>

												<g:submitToRemote class="btn btn-info" update="[success:'canchasDiv']" after="closeModal();"
													url="[controller:'cancha', action:'editarCancha']" value="Grabar Cancha" >
													<i class="icon-ok"></i>
												</g:submitToRemote>
											</div>
										</div>
									</div>
								</div>
							</g:formRemote>
                <!-- FIN DEL MODAL BOX PARA EDITAR -->
                
                <g:render template="/layouts/settings_box" /> 
                
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='../assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='../assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
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
		
			function closeModal() {
				$('#modal-form').modal('hide');
			}
	
			$(document).on("click", ".open-EditCanchaModal", function () {
			     var canchaId = $(this).data('id');
<%--			     var nombre = document.getElementById("nombreCancha").value; --%>
<%--			     var deporte = document.getElementById("deporteCancha").value; --%>
<%--			     var cantidadJugadores = document.getElementById("cantidadJugadoresCancha").value; --%>
<%--			     var cubierta = document.getElementById("cubiertaCancha").value; --%>
<%--			     var superficie = document.getElementById("superficieCancha").value; --%>
			     $(".modal-body #idCanchaEdit").val(canchaId);
<%--			     $(".modal-body #nombreCanchaEdit").val(nombre); --%>
<%--			     $(".modal-body #deporteCanchaEdit").val(deporte); --%>
<%--			     $(".modal-body #cantidadJugadoresCanchaEdit").val(cantidadJugadores); --%>
<%--			     $(".modal-body #cubiertaCanchaEdit").value(cubierta); --%>
<%--			     $(".modal-body #superficieCanchaEdit").val(superficie); --%>
					var newData = $.get("${createLink(controller: 'cancha', action: 'selectToEdit')}/"+canchaId);
					alert("dat: "+newData);
					alert("can: "+newData.cancha);
			});
			
		</script>

	</body>
</html>