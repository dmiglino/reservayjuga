<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Form Wizard - Ace Admin</title>

		<meta name="description" content="and Validation" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="../assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
        
		<link rel="stylesheet" href="../assets/css/select2.css" />
    	<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.full.min.css" />
    	<link rel="stylesheet" href="../assets/css/datepicker.css" />
    	<link rel="stylesheet" href="../assets/css/reservar-cancha.css" />

        
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
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
    				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							Encargado del complejo
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

	    <div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						
						
						
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									<small>Bienvenido,</small>
									Encargado
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										Settings
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="icon-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

				
                    <ul class="nav nav-list">
						<li>
							<a href="index.html">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Panel de control </span>
							</a>
						</li>
						
						<li>
							<a href="administrar-complejo.html">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Administrar Complejo </span>
							</a>
						</li>
						
						<li>
							<a href="index.html">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Administrar Canchas </span>
							</a>
						</li>
						
						<li>
							<a href="index.html">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Administrar Reservas </span>
							</a>
						</li>
						
						<li>
							<a href="index.html">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Reservar Cancha </span>
							</a>
						</li>
						
						<li>
							<a href="index.html">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Estadisticas </span>
							</a>
						</li>

						
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

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
								<a href="#">Reservar Cancha</a>
							</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
							    <small>
								    Reservar cancha
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                     
                                    <div class="row-fluid">
									<div class="span12">
										<div class="widget-box">
											<div class="widget-header widget-header-blue widget-header-flat">
												<h4 class="lighter">Proceso de reserva</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
														<ul class="wizard-steps">
															<li data-target="#step1" class="active">
																<span class="step">1</span>
																<span class="title">Datos del jugador</span>
															</li>

															<li data-target="#step2">
																<span class="step">2</span>
																<span class="title">Datos de la reserva</span>
															</li>

															<li data-target="#step3">
																<span class="step">3</span>
																<span class="title">Resumen</span>
															</li>
														</ul>
													</div>

													<hr />
													<div class="step-content row-fluid position-relative" id="step-container">
														<div class="step-pane active" id="step1">
															<h3 class="lighter block green">Busqueda del jugador</h3>

															<form class="form-horizontal" id="sample-form">
															    
															    <div class="form-group">
															        <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email">Nombre o email:</label>
											                        <div class="col-xs-12 col-sm-4">
												                        <input id="tags" type="text" class="form-control" />
												                        <div class="space-4"></div>
											                        </div>
										                        </div>
															    
																<div class="space-2"></div>
                                                                
                                                               	<h3 class="lighter block green">Datos del jugador</h3>
                                                                
																<div class="form-group">
																	<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">Nombre:</label>

																	<div class="col-xs-12 col-sm-3">
																		<div class="clearfix">
																			<input type="text" id="Text1" name="name" class="col-xs-12 col-sm-12" />
																		</div>
																	</div>
																	
																	<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name">Apellido:</label>

																	<div class="col-xs-12 col-sm-3">
																		<div class="clearfix">
																			<input type="text" id="Text2" name="name" class="col-xs-12 col-sm-12" />
																		</div>
																	</div>
																</div>
																
																<div class="space-2"></div>

																<div class="form-group">
																	<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">E-mail:</label>

																	<div class="col-xs-12 col-sm-3">
																		<div class="clearfix">
																			<input type="text" id="name" name="name" class="col-xs-12 col-sm-12" />
																		</div>
																	</div>
																	
																	<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name">Telefono:</label>

																	<div class="col-xs-12 col-sm-3">
																		<div class="input-group">
																			<span class="input-group-addon">
																				<i class="icon-phone"></i>
																			</span>

																			<input type="text" id="Text4" name="name" class="col-xs-12 col-sm-12" />
																		</div>
																	</div>

																</div>

																<div class="space-2"></div>

                                                                                                                     
                                                               <div class="form-group">
                                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="id-date-picker-1">Fecha de nacimiento</label>
														        
															        <div class="col-xs-12 col-sm-3">
																        <div class="input-group">
																	        <input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="dd-mm-yyyy" />
																	        <span class="input-group-addon">
																		        <i class="icon-calendar bigger-110"></i>
																	        </span>
																        </div>
															        </div>
															        
															        <label class="control-label col-xs-12 col-sm-1 no-padding-right">Sexo</label>

																	<div class="col-xs-12 col-sm-3">
																		<div>
																			<label class="blue">
																				<input name="gender" value="1" type="radio" class="ace" />
																				<span class="lbl"> Hombre</span>
																			</label>
																		</div>

																		<div>
																			<label class="blue">
																				<input name="gender" value="2" type="radio" class="ace" />
																				<span class="lbl"> Mujer</span>
																			</label>
																		</div>
																	</div>
															        
															        
															    </div>
															
                                                                <div class="space-2"></div>
                                                                
                                                                <div class="form-group">
																	
																</div>
                                                                
                                                                <div class="col-md-offset-3 col-md-9">
											                        <button class="btn btn-info" type="button">
												                        <i class="icon-ok bigger-110"></i>
												                        Actualizar
											                        </button>

											                        &nbsp; &nbsp; &nbsp;
										                        </div>
                                                                
                                                                
															</form>
														</div>

														<div class="step-pane" id="step2">
															
															<div class="row">
																
															  <div class="col-sm-4">
											                    <div class="widget-box">
												                    <div class="widget-header">
													                    <h4><strong>DIA</strong> (Selecciona el dia del partido)</h4>
												                    </div>

												                    <div class="widget-body">
													                    <div class="widget-main">
														                    <center><div class="date-picker" data-date-format="dd-mm-yyyy"></div></center>
													                    </div>
												                    </div>
											                    </div>
										                      </div>
										                      
										                      <div class="col-sm-4">
											                    <div class="widget-box">
												                    <div class="widget-header">
													                    <h4><strong>HORA</strong> (Selecciona la hora del partido)</h4>
												                    </div>

												                    <div class="widget-body">
													                    <div class="widget-main">
													                        <center>
														                        <button class="btn btn-primary">10:00 - 11:00</button>
														                        <button class="btn btn-primary">11:00 - 12:00</button>
														                        <button class="btn btn-primary">12:00 - 13:00</button>
														                        <button class="btn btn-primary">13:00 - 14:00</button>
														                        <button class="btn btn-primary">14:00 - 15:00</button>
														                        <button class="btn btn-primary">15:00 - 16:00</button>
														                        <button class="btn btn-primary">16:00 - 17:00</button>
														                        <button class="btn btn-primary">17:00 - 18:00</button>
														                        <button class="btn disabled btn-primary">18:00 - 19:00</button>
														                        <button class="btn btn-primary">19:00 - 20:00</button>
														                        <button class="btn btn-primary">20:00 - 21:00</button>
														                        <button class="btn disabled btn-primary">21:00 - 22:00</button>
														                        <button class="btn disabled btn-primary">22:00 - 23:00</button>
														                        <button class="btn btn-primary">23:00 - 24:00</button>
														                    </center>
													                    </div>
												                    </div>
											                    </div>
										                      </div>
										                      
										                      <div class="col-sm-4">
											                    <div class="widget-box">
												                    <div class="widget-header">
													                    <h4><strong>CANCHA</strong> (Selecciona la cancha)</h4>
												                    </div>

												                    <div class="widget-body">
													                    <div class="widget-main overflow-auto">
													                    <ul class="ul-canchas">
														                    <li id="1" class="cancha-futbol">
														                        <span>01</span>
														                    </li>
														                    <li id="2" class="cancha-futbol">
														                        <span>02</span>
														                    </li>
														                    <li id="3" class="cancha-futbol active">
														                        <span>03</span>
														                    </li>
														                    <li id="4" class="cancha-futbol">
														                        <span>04</span>
														                    </li>
														                    <li id="5" class="cancha-futbol">
														                        <span>05</span>
														                    </li>
														                    <li id="6" class="cancha-futbol">
														                        <span>06</span>
														                    </li>
													                    </ul>
													                    </div>
												                    </div>
											                    </div>
										                      </div>
																
															</div>	
														</div>
														
														<div class="step-pane" id="step3">
															<div class="profile-user-info profile-user-info-striped" style="width: 502px;margin-right: 1px;float: left;">
												                <div class="profile-info-row">
													                <div class="profile-info-name"> Complejo </div>

													                <div class="profile-info-value">
														                <span class="editable" id="username">El Polideportivo</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> Día </div>

													                <div class="profile-info-value">
														                <span class="editable" id="country">30-10-2013</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> Hora </div>

													                <div class="profile-info-value">
														                <span class="editable" id="age">18:00-19:00</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> Cancha </div>

													                <div class="profile-info-value">
														                <span class="editable" id="signup">Cancha 5 - Camp Nou</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> Jugador </div>

													                <div class="profile-info-value">
														                <span class="editable" id="login">Tomas Escamez</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> Email </div>

													                <div class="profile-info-value">
														                <span class="editable" id="about">tomas@gmail.com</span>
													                </div>
												                </div>
											            </div>
											            
											            
											            <div class="profile-user-info profile-user-info-striped" style="width: 502px;float: left;">
												                <div class="profile-info-row">
													                <div class="profile-info-name"> Precio Alquiler </div>

													                <div class="profile-info-value">
														                <span class="editable" id="Span1">$540</span>
													                </div>
												                </div>
												                <div class="profile-info-row">
													                <div class="profile-info-name">Porcentaje</div>
                                                                     
													                <div class="profile-info-value">
														                <span class="editable" id="Span2">40%</span>
													                </div>
												                </div>
												                <div class="profile-info-row">
													                <div class="profile-info-name"> Senia </div>

													                <div class="profile-info-value">
														                <span class="editable" id="Span4">$216</span>
													                </div>
												                </div>
												                
												               <div class="profile-info-row">
													                <div class="profile-info-name"> Senia pagada </div>

													                <div class="profile-info-value">
														                <!--<span class="editable" id="Span3">$200</span>-->
														                <input type="text" id="Text3" name="name" placeholder="$216" />
													                </div>
												                </div>

											            </div>
											            
											           <button class="btn btn-warning" style="float:left;margin-left: 11px;padding-right: 8px;margin-top: 8px;">
															<i class="icon-print"></i>
															Imprimir
														</button>
											            														
														</div>
													</div>

													<hr />
													<div class="row-fluid wizard-actions">
														<button class="btn btn-prev">
															<i class="icon-arrow-left"></i>
															Prev
														</button>

														<button class="btn btn-success btn-next" data-last="Finish ">
															Next
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</div><!-- /widget-main -->
											</div><!-- /widget-body -->
										</div>
									</div>
								</div>
      
                                          
                                          
                                          
                                          
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
                
				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
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
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
							<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
							<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
							<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
							<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
							<label class="lbl" for="ace-settings-add-container">
								Inside
								<b>.container</b>
							</label>
						</div>
					</div>
				</div><!-- /#ace-settings-container -->
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
    if ("ontouchend" in document) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
		</script>
		<script src="../assets/js/bootstrap.min.js"></script>
		<script src="../assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="../assets/js/fuelux/fuelux.wizard.min.js"></script>
		<script src="../assets/js/jquery.validate.min.js"></script>
		<script src="../assets/js/additional-methods.min.js"></script>
		<script src="../assets/js/bootbox.min.js"></script>
		<script src="../assets/js/jquery.maskedinput.min.js"></script>
		<script src="../assets/js/select2.min.js"></script>
		
    	<script src="../assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="../assets/js/date-time/bootstrap-timepicker.min.js"></script>
		<script src="../assets/js/date-time/moment.min.js"></script>
		
        <script src="../assets/js/jquery-ui-1.10.3.full.min.js"></script>
		<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>


		<!-- ace scripts -->

		<script src="../assets/js/ace-elements.min.js"></script>
		<script src="../assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		    jQuery(function($) {

		        $('[data-rel=tooltip]').tooltip();

		        $(".select2").css('width', '200px').select2({ allowClear: true })
				.on('change', function() {
				    $(this).closest('form').validate().element($(this));
				});


		        var $validation = false;
		        $('#fuelux-wizard').ace_wizard().on('change', function(e, info) {
		            if (info.step == 1 && $validation) {
		                if (!$('#validation-form').valid()) return false;
		            }
		        }).on('finished', function(e) {
		            bootbox.dialog({
		                message: "Felicitaciones! Su reserva ha sido realizada.",
		                buttons: {
		                    "success": {
		                        "label": "OK",
		                        "className": "btn-sm btn-primary"
		                    }
		                }
		            });
		        }).on('stepclick', function(e) {
		            //return false;//prevent clicking on steps
		        });


		        $('#skip-validation').removeAttr('checked').on('click', function() {
		            $validation = this.checked;
		            if (this.checked) {
		                $('#sample-form').hide();
		                $('#validation-form').removeClass('hide');
		            }
		            else {
		                $('#validation-form').addClass('hide');
		                $('#sample-form').show();
		            }
		        });



		        //documentation : http://docs.jquery.com/Plugins/Validation/validate


		        $.mask.definitions['~'] = '[+-]';
		        $('#phone').mask('(999) 999-9999');

		        jQuery.validator.addMethod("phone", function(value, element) {
		            return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
		        }, "Enter a valid phone number.");

		        $('#validation-form').validate({
		            errorElement: 'div',
		            errorClass: 'help-block',
		            focusInvalid: false,
		            rules: {
		                email: {
		                    required: true,
		                    email: true
		                },
		                password: {
		                    required: true,
		                    minlength: 5
		                },
		                password2: {
		                    required: true,
		                    minlength: 5,
		                    equalTo: "#password"
		                },
		                name: {
		                    required: true
		                },
		                phone: {
		                    required: true,
		                    phone: 'required'
		                },
		                url: {
		                    required: true,
		                    url: true
		                },
		                comment: {
		                    required: true
		                },
		                state: {
		                    required: true
		                },
		                platform: {
		                    required: true
		                },
		                subscription: {
		                    required: true
		                },
		                gender: 'required',
		                agree: 'required'
		            },

		            messages: {
		                email: {
		                    required: "Please provide a valid email.",
		                    email: "Please provide a valid email."
		                },
		                password: {
		                    required: "Please specify a password.",
		                    minlength: "Please specify a secure password."
		                },
		                subscription: "Please choose at least one option",
		                gender: "Please choose gender",
		                agree: "Please accept our policy"
		            },

		            invalidHandler: function(event, validator) { //display error alert on form submit   
		                $('.alert-danger', $('.login-form')).show();
		            },

		            highlight: function(e) {
		                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
		            },

		            success: function(e) {
		                $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
		                $(e).remove();
		            },

		            errorPlacement: function(error, element) {
		                if (element.is(':checkbox') || element.is(':radio')) {
		                    var controls = element.closest('div[class*="col-"]');
		                    if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
		                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
		                }
		                else if (element.is('.select2')) {
		                    error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
		                }
		                else if (element.is('.chosen-select')) {
		                    error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
		                }
		                else error.insertAfter(element.parent());
		            },

		            submitHandler: function(form) {
		            },
		            invalidHandler: function(form) {
		            }
		        });

		        $('.date-picker').datepicker({ autoclose: true }).next().on(ace.click_event, function() {
		            $(this).prev().focus();
		        });
                
                
		        //autocomplete
		        var availableTags = [
					"ActionScript",
					"AppleScript",
					"Asp",
					"BASIC",
					"C",
					"C++",
					"Clojure",
					"COBOL",
					"ColdFusion",
					"Erlang",
					"Fortran",
					"Groovy",
					"Haskell",
					"Java",
					"JavaScript",
					"Lisp",
					"Perl",
					"PHP",
					"Python",
					"Ruby",
					"Scala",
					"Scheme"
				];
		        $("#tags").autocomplete({
		            source: availableTags
		        });
		        $('#modal-wizard .modal-header').ace_wizard();
		        $('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');
		    })
		</script>
	</body>
</html>
