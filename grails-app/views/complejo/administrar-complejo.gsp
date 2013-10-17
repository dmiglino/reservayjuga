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

<link rel="stylesheet"
	href="../assets/css/jquery-ui-1.10.3.custom.min.css" />
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
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> Encargado del complejo
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">



					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <span class="user-info"> <small>Bienvenido,</small>
								Encargado
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
							<li><a href="#"> <i class="icon-cog"></i> Settings
							</a></li>

							<li class="divider"></li>

							<li><a href="#"> <i class="icon-off"></i> Logout
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>


				<ul class="nav nav-list">
					<li><a href="index.html"> <i class="icon-dashboard"></i> <span
							class="menu-text"> Panel de control </span>
					</a></li>

					<li><a href="administrar-complejo.html"> <i
							class="icon-dashboard"></i> <span class="menu-text">
								Administrar Complejo </span>
					</a></li>

					<li><a href="index.html"> <i class="icon-dashboard"></i> <span
							class="menu-text"> Administrar Canchas </span>
					</a></li>

					<li><a href="index.html"> <i class="icon-dashboard"></i> <span
							class="menu-text"> Administrar Reservas </span>
					</a></li>

					<li><a href="index.html"> <i class="icon-dashboard"></i> <span
							class="menu-text"> Reservar Cancha </span>
					</a></li>

					<li><a href="index.html"> <i class="icon-dashboard"></i> <span
							class="menu-text"> Estadisticas </span>
					</a></li>


				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

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

							<g:form action="actualizarInformacionComplejo" class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="nombre"> Nombre </label>

									<div class="col-sm-9">
										<g:textField name="nombre" value="${complejo?.nombre}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="webSite">Sitio Web </label>

									<div class="col-sm-9">
										<g:textField name="webSite" value="${complejo?.webSite}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="mail">Mail </label>

									<div class="col-sm-9">
										<g:textField name="mail" value="${complejo?.mail}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="telefono1">Telefono 1 </label>

									<div class="col-sm-9">
										<g:textField name="telefono1" value="${complejo?.telefono1}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="telefono2">Telefono 2 </label>

									<div class="col-sm-9">
										<g:textField name="telefono2" value="${complejo?.telefono2}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="telefono3">Telefono 3 </label>

									<div class="col-sm-9">
										<g:textField name="telefono3" value="${complejo?.telefono3}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="telefono4">Telefono 4 </label>

									<div class="col-sm-9">
										<g:textField name="telefono4" value="${complejo?.telefono4}" class="col-xs-10 col-sm-5"/>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for=informacionExtra> Informacion Extra </label>
									<g:textArea name="informacionExtra" value="${complejo?.informacionExtra}"" class="col-xs-4 col-sm-5-"/>
								</div>

								<div class="space-4"></div>

							<g:submitButton name="actualizarInformacionComplejo" value="Actualizar Informacion Complejo"/>
								
								<div class="page-header">
									<h1>
										<small> Ubicacion </small>
									</h1>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-1">Pais</label> <select
										class="col-xs-4 col-sm-5-" id="form-field-select-1">
										<option value="">&nbsp;</option>
										<option value="AL">Argentina</option>
										<option value="AK">Brasil</option>
										<option value="AZ">Paraguay</option>
										<option value="AR">Uruguay</option>
										<option value="CA">Venezuela</option>
									</select>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Provincia</label> <select
										class="col-xs-4 col-sm-5-" id="form-field-select-2">
										<option value="">&nbsp;</option>
										<option value="AL">Buenos Aires</option>
										<option value="AK">Corrientes</option>
										<option value="AZ">Formosa</option>
										<option value="AR">Salta</option>
										<option value="CA">Tucuman</option>
									</select>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-3">Localidad</label> <select
										class="col-xs-4 col-sm-5-" id="form-field-select-3">
										<option value="">&nbsp;</option>
										<option value="AL">Capital Federal</option>
										<option value="AK">GBA Norte</option>
										<option value="AZ">GBA Sur</option>
										<option value="AR">GBA Oeste</option>
									</select>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-4">Barrio</label> <select
										class="col-xs-4 col-sm-5-" id="form-field-select-4">
										<option value="">&nbsp;</option>
										<option value="AL">Belgrano</option>
										<option value="AK">Saavedra</option>
										<option value="AZ">Caballito</option>
										<option value="AR">Monserrat</option>
										<option value="CA">Retiro</option>
									</select>
								</div>


								<div class="page-header">
									<h1>
										<small> Servicios </small>
									</h1>
								</div>


								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl">
											Vestuario</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl">
											Bebida</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl">
											Ayuda medica</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl"> Wifi</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl"> TV</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl">
											Comida</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl">
											Torneos</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl">
											Gimnasio</span>
									</label>
								</div>

								<div class="checkbox">
									<label> <input name="form-field-checkbox"
										type="checkbox" class="ace" /> <span class="lbl">
											Estacionamiento</span>
									</label>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-7">Precio estacionamiento </label>

									<div class="col-sm-9">
										<input type="text" id="Text1" class="col-xs-3 col-sm-2" />
									</div>
								</div>

								<div class="page-header">
									<h1>
										<small> Configuracion de senia e items extras </small>
									</h1>
								</div>
								<span class="lbl"> Porcentaje de senia</span> <br /> <br /> <input
									type="text" class="input-mini" id="spinner3" />

								<div class="page-header">
									<h1>
										<small> Horarios Operativos </small>
									</h1>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Lunes </label> <select
										class="col-xs-2 col-sm-4-" id="Select1">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select2">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Martes </label> <select
										class="col-xs-2 col-sm-4-" id="Select3">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select4">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Miercoles </label> <select
										class="col-xs-2 col-sm-4-" id="Select5">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select6">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Jueves </label> <select
										class="col-xs-2 col-sm-4-" id="Select7">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select8">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Viernes </label> <select
										class="col-xs-2 col-sm-4-" id="Select9">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select10">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Sabado </label> <select
										class="col-xs-2 col-sm-4-" id="Select11">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select12">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Domingo </label> <select
										class="col-xs-2 col-sm-4-" id="Select13">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select14">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-select-2">Feriado </label> <select
										class="col-xs-2 col-sm-4-" id="Select15">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select> <select class="col-xs-2 col-sm-4-" id="Select16">
										<option value="">&nbsp;</option>
										<option value="1">9:00</option>
										<option value="2">10:00</option>
										<option value="3">11:00</option>
										<option value="4">12:00</option>
										<option value="5">13:00</option>
									</select>
								</div>


								<div class="page-header">
									<h1>
										<small> Imagenes </small>
									</h1>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<div class="widget-box">
											<div class="widget-header">
												<h4>Custom File Input</h4>

												<span class="widget-toolbar"> <a href="#"
													data-action="collapse"> <i class="icon-chevron-up"></i>
												</a> <a href="#" data-action="close"> <i class="icon-remove"></i>
												</a>
												</span>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<input type="file" id="id-input-file-2" /> <input
														multiple="" type="file" id="id-input-file-3" /> <label>
														<input type="checkbox" name="file-format"
														id="id-file-format" class="ace" /> <span class="lbl">
															Allow only images</span>
													</label>
												</div>
											</div>
										</div>
									</div>
								</div>



								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button">
											<i class="icon-ok bigger-110"></i> Guardar
										</button>

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

		<div class="ace-settings-container" id="ace-settings-container">
			<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
				id="ace-settings-btn">
				<i class="icon-cog bigger-150"></i>
			</div>

			<div class="ace-settings-box" id="ace-settings-box">
				<div>
					<div class="pull-left">
						<select id="skin-colorpicker" class="hide">
							<option data-skin="default" value="#438EB9">#438EB9</option>
							<option data-skin="skin-1" value="#222A2D">#222A2D</option>
							<option data-skin="skin-2" value="#C6487E">#C6487E</option>
							<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
						</select>
					</div>
					<span>&nbsp; Choose Skin</span>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-navbar" /> <label class="lbl"
						for="ace-settings-navbar"> Fixed Navbar</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-sidebar" /> <label class="lbl"
						for="ace-settings-sidebar"> Fixed Sidebar</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-breadcrumbs" /> <label class="lbl"
						for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-rtl" /> <label class="lbl"
						for="ace-settings-rtl"> Right To Left (rtl)</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-add-container" /> <label class="lbl"
						for="ace-settings-add-container"> Inside <b>.container</b>
					</label>
				</div>
			</div>
		</div>
		<!-- /#ace-settings-container -->
	</div>
	<!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
	</div>
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

	<script src="../assets/js/ace-elements.min.js"></script>
	<script src="../assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->

	<script type="text/javascript">
			jQuery(function($) {
				$('#id-disable-check').on('click', function() {
					var inp = $('#form-input-readonly').get(0);
					if(inp.hasAttribute('disabled')) {
						inp.setAttribute('readonly' , 'true');
						inp.removeAttribute('disabled');
						inp.value="This text field is readonly!";
					}
					else {
						inp.setAttribute('disabled' , 'disabled');
						inp.removeAttribute('readonly');
						inp.value="This text field is disabled!";
					}
				});
			
			
				$(".chosen-select").chosen(); 
				$('#chosen-multiple-style').on('click', function(e){
					var target = $(e.target).find('input[type=radio]');
					var which = parseInt(target.val());
					if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
					 else $('#form-field-select-4').removeClass('tag-input-style');
				});
			
			
				$('[data-rel=tooltip]').tooltip({container:'body'});
				$('[data-rel=popover]').popover({container:'body'});
				
				$('textarea[class*=autosize]').autosize({append: "\n"});
				$('textarea.limited').inputlimiter({
					remText: '%n character%s remaining...',
					limitText: 'max allowed : %n.'
				});
			
				$.mask.definitions['~']='[+-]';
				$('.input-mask-date').mask('99/99/9999');
				$('.input-mask-phone').mask('(999) 999-9999');
				$('.input-mask-eyescript').mask('~9.99 ~9.99 999');
				$(".input-mask-product").mask("a*-999-a999",{placeholder:" ",completed:function(){alert("You typed the following: "+this.val());}});
			
			
			
		
				
					
				$('#id-input-file-1 , #id-input-file-2').ace_file_input({
					no_file:'No File ...',
					btn_choose:'Choose',
					btn_change:'Change',
					droppable:false,
					onchange:null,
					thumbnail:false //| true | large
					//whitelist:'gif|png|jpg|jpeg'
					//blacklist:'exe|php'
					//onchange:''
					//
				});
				
				$('#id-input-file-3').ace_file_input({
					style:'well',
					btn_choose:'Drop files here or click to choose',
					btn_change:null,
					no_icon:'icon-cloud-upload',
					droppable:true,
					thumbnail:'small'//large | fit
					//,icon_remove:null//set null, to hide remove/reset button
					/**,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					}*/
					/**,before_remove : function() {
						return true;
					}*/
					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}
			
				}).on('change', function(){
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});
				
			
				//dynamically change allowed formats by changing before_change callback function
				$('#id-file-format').removeAttr('checked').on('change', function() {
					var before_change
					var btn_choose
					var no_icon
					if(this.checked) {
						btn_choose = "Drop images here or click to choose";
						no_icon = "icon-picture";
						before_change = function(files, dropped) {
							var allowed_files = [];
							for(var i = 0 ; i < files.length; i++) {
								var file = files[i];
								if(typeof file === "string") {
									//IE8 and browsers that don't support File Object
									if(! (/\.(jpe?g|png|gif|bmp)$/i).test(file) ) return false;
								}
								else {
									var type = $.trim(file.type);
									if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif|bmp)$/i).test(type) )
											|| ( type.length == 0 && ! (/\.(jpe?g|png|gif|bmp)$/i).test(file.name) )//for android's default browser which gives an empty string for file.type
										) continue;//not an image so don't keep this file
								}
								
								allowed_files.push(file);
							}
							if(allowed_files.length == 0) return false;
			
							return allowed_files;
						}
					}
					else {
						btn_choose = "Drop files here or click to choose";
						no_icon = "icon-cloud-upload";
						before_change = function(files, dropped) {
							return files;
						}
					}
					var file_input = $('#id-input-file-3');
					file_input.ace_file_input('update_settings', {'before_change':before_change, 'btn_choose': btn_choose, 'no_icon':no_icon})
					file_input.ace_file_input('reset_input');
				});
			
			
			
			
				$('#spinner1').ace_spinner({value:0,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
				.on('change', function(){
					//alert(this.value)
				});
				$('#spinner2').ace_spinner({value:0,min:0,max:10000,step:100, touch_spinner: true, icon_up:'icon-caret-up', icon_down:'icon-caret-down'});
				$('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'icon-plus smaller-75', icon_down:'icon-minus smaller-75', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
			
			
				
				
				
				//we could just set the data-provide="tag" of the element inside HTML, but IE8 fails!
				var tag_input = $('#form-field-tags');
				if(! ( /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase())) ) 
				{
					tag_input.tag(
					  {
						placeholder:tag_input.attr('placeholder'),
						//enable typeahead by specifying the source array
						source: ace.variable_US_STATES,//defined in ace.js >> ace.enable_search_ahead
					  }
					);
				}
				else {
					//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
					tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
					//$('#form-field-tags').autosize({append: "\n"});
				}
				
				
				
			
						
			});
		</script>
	</body>
</html>
