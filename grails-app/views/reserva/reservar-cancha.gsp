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
											
<%--											<form>--%>
												<div class="step-content row-fluid position-relative" id="step-container">
													<g:hiddenField name="complejoId" id="complejoId" value="${complejoId}"/>
													<g:render template="reserva_step_1" />				
													<g:render template="reserva_step_2" />				
													<g:render template="reserva_step_3" />
												</div>
	
												<hr />
												
												<div class="row-fluid wizard-actions">
													<button class="btn btn-prev">
														<i class="icon-arrow-left"></i>
														<g:message code="button.anterior.label" default="Anterior" />
													</button>
	
													<button class="btn btn-success btn-next" data-last="Finish" id="step_button" onclick="agregarDatosALaReserva();">
														<g:message code="button.siguiente.label" default="Siguiente" />
														<i class="icon-arrow-right icon-on-right"></i>
													</button>
												</div>
<%--											</form>--%>
										
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
			        // TODO call a controller
			        var JSONObject = new Object;
				    JSONObject.reservaSenia = $('#senia').val();
				    JSONstring = JSON.stringify(JSONObject);
	
				    $.ajax({
				        url:   "${createLink(controller:'reserva', action:'generarReserva')}",
				        data:  JSONObject,
				        type:  'post',
				        success: function(data) {
						   	$("#step_button").visible = false;
						},
				        error: function(request, status, error) {
				            alert(error);
				        }
				    });
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
<%--		        $("#tags").autocomplete({--%>
<%--		            source: availableTags--%>
<%--		        });--%>

		        $('#modal-wizard .modal-header').ace_wizard();
		        $('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');
		    })
		    
		    function agregarDatosALaReserva() {
				var JSONObject = new Object;
			    JSONObject.jugadorId = $('#jugadorId').val();
			    JSONObject.reservaDateText = $('#reservaDateText').val();
			    JSONObject.reservaHorario = $('#horarioReserva').val();
			    JSONObject.reservaCanchaId = $('#reservaCanchaId').val();
			    JSONObject.reservaSenia = $('#senia').val();
			    JSONstring = JSON.stringify(JSONObject);

			    $.ajax({
			        url:   "${createLink(controller:'reserva', action:'agregarDatosALaReserva')}",
			        data:  JSONObject,
			        type:  'post',
			        success:  function (data) {
		              	$("#step_3").html(data);
			        },
			        error: function(request, status, error) {
			            alert(error);
			        }
			    });
							
			}
		</script>
	</body>
</html>
