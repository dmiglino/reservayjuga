<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="layout" content="main"/>
		<title><g:message code="reserva.titulo.label" default="Reservar Cancha" /></title>

		<link rel="stylesheet" href="../assets/css/select2.css" />
    	<link rel="stylesheet" href="../assets/css/reservar-cancha.css" />
	</head>

	<body>
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="/ReservaYJuga/panelControl"><g:message code="sidebar.panel.label" default="Panel de control" /></a>
							</li>

							<li>
								<a href="/ReservaYJuga/reserva"><g:message code="reserva.titulo.label" default="Reservar Cancha" /></a>
							</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
							    <small>
								    <g:message code="reserva.titulo.label" default="Reservar Cancha" />
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
												<h4 class="lighter"><g:message code="reserva.proceso.titulo.label" default="Proceso de reserva" /></h4>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
														<ul class="wizard-steps">
															<li data-target="#step1" class="active">
																<span class="step">1</span>
																<span class="title"><g:message code="reserva.proceso.datosjugador.label" default="Datos del jugador" /></span>
															</li>

															<li data-target="#step2">
																<span class="step">2</span>
																<span class="title"><g:message code="reserva.proceso.datosreserva.label" default="Datos de la reserva" /></span>
															</li>

															<li data-target="#step3">
																<span class="step">3</span>
																<span class="title"><g:message code="reserva.proceso.resumen.label" default="Resumen" /></span>
															</li>
														</ul>
													</div>

													<hr />
													<div class="step-content row-fluid position-relative" id="step-container">
														<div class="step-pane active" id="step1">
															<h3 class="lighter block green"><g:message code="reserva.jugador.busqueda.label" default="Busqueda del jugador" /></h3>

															<form class="form-horizontal" id="sample-form">
															    
															    <div class="form-group">
															        <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email"><g:message code="reserva.jugador.nombreomail.label" default="Nombre o email" />:</label>
											                        <div class="col-xs-12 col-sm-4">
												                        <input id="tags" type="text" class="form-control" />
												                        <div class="space-4"></div>
											                        </div>
										                        </div>
															    
																<div class="space-2"></div>
                                                                
                                                               	<h3 class="lighter block green"><g:message code="reserva.jugador.datos.label" default="Datos del jugador" /></h3>
                                                                
																<div class="form-group">
																	<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name"><g:message code="common.nombre.label" default="Nombre" />:</label>

																	<div class="col-xs-12 col-sm-3">
																		<div class="clearfix">
																			<input type="text" id="Text1" name="name" class="col-xs-12 col-sm-12" />
																		</div>
																	</div>
																	
																	<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name"><g:message code="common.apellido.label" default="Apellido" />:</label>

																	<div class="col-xs-12 col-sm-3">
																		<div class="clearfix">
																			<input type="text" id="Text2" name="name" class="col-xs-12 col-sm-12" />
																		</div>
																	</div>
																</div>
																
																<div class="space-2"></div>

																<div class="form-group">
																	<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name"><g:message code="common.email.label" default="E-Mail" />:</label>

																	<div class="col-xs-12 col-sm-3">
																		<div class="clearfix">
																			<input type="text" id="name" name="name" class="col-xs-12 col-sm-12" />
																		</div>
																	</div>
																	
																	<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name"><g:message code="common.telefono.label" default="Telefono" />:</label>

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
                                                                <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="id-date-picker-1"><g:message code="common.fecha.nacimiento.label" default="Telefono" /></label>
														        
															        <div class="col-xs-12 col-sm-3">
																        <div class="input-group">
																	        <input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="dd-mm-yyyy" />
																	        <span class="input-group-addon">
																		        <i class="icon-calendar bigger-110"></i>
																	        </span>
																        </div>
															        </div>
															        
															        <label class="control-label col-xs-12 col-sm-1 no-padding-right"><g:message code="common.sexo.label" default="Sexo" /></label>

																	<div class="col-xs-12 col-sm-3">
																		<div>
																			<label class="blue">
																				<input name="gender" value="1" type="radio" class="ace" />
																				<span class="lbl"> <g:message code="common.hombre.label" default="Hombre" /></span>
																			</label>
																		</div>

																		<div>
																			<label class="blue">
																				<input name="gender" value="2" type="radio" class="ace" />
																				<span class="lbl"> <g:message code="common.mujer.label" default="Mujer" /></span>
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
												                        <g:message code="button.actualizar.label" default="Actualizar" />
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
													                    <h4><strong><g:message code="reserva.dia.label" default="DIA" /></strong> (<g:message code="reserva.dia.seleccionar.label" default="Selecciona el dia del partido" />)</h4>
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
													                    <h4><strong><g:message code="reserva.hora.label" default="HORA" /></strong> (<g:message code="reserva.hora.seleccionar.label" default="Selecciona la hora del partido" />)</h4>
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
													                    <h4><strong><g:message code="reserva.cancha.label" default="CANCHA" /></strong> (<g:message code="reserva.dia.seleccionar.label" default="Selecciona la cancha" />)</h4>
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
													                <div class="profile-info-name"> <g:message code="complejo.entity.label" default="Complejo" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="username">El Polideportivo</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="reserva.dia.label" default="Dia" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="country">30-10-2013</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="reserva.hora.label" default="Hora" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="age">18:00-19:00</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="reserva.cancha.label" default="Cancha" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="signup">Cancha 5 - Camp Nou</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="jugador.entity.label" default="Jugador" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="login">Tomas Escamez</span>
													                </div>
												                </div>

												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="common.email.label" default="E-Mail" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="about">tomas@gmail.com</span>
													                </div>
												                </div>
											            </div>
											            
											            
											            <div class="profile-user-info profile-user-info-striped" style="width: 502px;float: left;">
												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="reserva.alquiler.label" default="Precio Alquiler" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="Span1">$540</span>
													                </div>
												                </div>
												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="reserva.porcentaje.label" default="Porcentaje" /> </div>
                                                                     
													                <div class="profile-info-value">
														                <span class="editable" id="Span2">40%</span>
													                </div>
												                </div>
												                <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="reserva.senia.label" default="Seña" /> </div>

													                <div class="profile-info-value">
														                <span class="editable" id="Span4">$216</span>
													                </div>
												                </div>
												                
												               <div class="profile-info-row">
													                <div class="profile-info-name"> <g:message code="reserva.senia.pagada.label" default="Seña Pagada" /> </div>

													                <div class="profile-info-value">
														                <!--<span class="editable" id="Span3">$200</span>-->
														                <input type="text" id="Text3" name="name" placeholder="$216" />
													                </div>
												                </div>

											            </div>
											            
											           <button class="btn btn-warning" style="float:left;margin-left: 11px;padding-right: 8px;margin-top: 8px;">
															<i class="icon-print"></i>
															<g:message code="button.imprimir.label" default="Imprimir" />
														</button>
											            														
														</div>
													</div>

													<hr />
													<div class="row-fluid wizard-actions">
														<button class="btn btn-prev">
															<i class="icon-arrow-left"></i>
															<g:message code="button.anterior.label" default="Anterior" />
														</button>

														<button class="btn btn-success btn-next" data-last="Finish ">
															<g:message code="button.siguiente.label" default="Siguiente" />
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

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='../assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!-- page specific plugin scripts -->

		<script src="../assets/js/fuelux/fuelux.wizard.min.js"></script>
		<script src="../assets/js/jquery.validate.min.js"></script>
		<script src="../assets/js/additional-methods.min.js"></script>
		<script src="../assets/js/bootbox.min.js"></script>
		<script src="../assets/js/select2.min.js"></script>
		
		<!-- ace scripts -->

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
