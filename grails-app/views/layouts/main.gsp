<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<html>
	<head>
		<title><g:layoutTitle default="Reserva y Juga"/></title>
		<style>
			#header {background-color:#ffe0e0;text-align: center;}
			html, body, #main-container { height: 100%; margin: 0; padding: 0;}
			body > #main-container { height: auto; min-height: 100%; }
			#footer {background-color:#e0e0ff;
					text-align: center; 
					clear: both;
					height: 4em;
					margin-top: -0em;
					position: relative; 
					z-index: 5000; 
					width:100%;}
			#main-content { padding-bottom: 3em; }
		</style>
		
		<meta name="description" content="Common form elements and layouts" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<!-- basic styles -->
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/font-awesome.min.css" />
		
		<!--[if IE 7]>
				  <link rel="stylesheet" href="/ReservaYJuga/assets/css/font-awesome-ie7.min.css" />
				<![endif]-->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/chosen.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/datepicker.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/daterangepicker.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/colorpicker.css" />
		
		<!-- fonts -->
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/ace-fonts.css" />
		
		<!-- ace styles -->
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="/ReservaYJuga/assets/css/ace-skins.min.css" />
		
		<!--[if lte IE 8]>
				  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
				<![endif]-->
		
		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="/ReservaYJuga/assets/js/ace-extra.min.js"></script>
		
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		
		<!--[if lt IE 9]>
				<script src="/ReservaYJuga/assets/js/html5shiv.js"></script>
				<script src="/ReservaYJuga/assets/js/respond.min.js"></script>
				<![endif]-->
				
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<div id="header">
			<g:render template="/layouts/navigation_bar" model="['tituloPagina':'Reserva y Juga', 'tipoUsuario':'Encargado']" />
		</div>
		
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			<div class="main-container-inner">
				<g:render template="/layouts/sidebar_panel" />
				<div class="main-content">
					<g:layoutBody/>
					<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
						<i class="icon-double-angle-up icon-only bigger-110"></i>
					</a>
				</div>
			</div>
		</div>
		
		<g:render template="/layouts/settings_box" /> 
		
		<div id="footer">
			<g:render template="/layouts/footer" />
		</div>
		
<%--		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>--%>
		<g:javascript library="application"/>
		<r:layoutResources />

		<!-- BASIC SCRIPTS -->

		<!--[if !IE]> -->
	
		<script type="text/javascript">
			window.jQuery || document.write("<script src='/ReservaYJuga/assets/js/jquery-2.0.3.min.js'>" + "<"+"/script>");
		</script>
	
		<!-- <![endif]-->
	
		<!--[if IE]>
			<script type="text/javascript">
			 window.jQuery || document.write("<script src='/ReservaYJuga/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
			</script>
		<![endif]-->
	
		<script type="text/javascript">
			if ("ontouchend" in document)
				document.write("<script src='/ReservaYJuga/assets/js/jquery.mobile.custom.min.js'>" + "<"+"/script>");
		</script>
		
		<script src="/ReservaYJuga/assets/js/bootstrap.min.js"></script>
		<script src="/ReservaYJuga/assets/js/typeahead-bs2.min.js"></script>
	
		<!-- page specific plugin scripts -->
	
		<!--[if lte IE 8]>
			  <script src="/ReservaYJuga/assets/js/excanvas.min.js"></script>
			<![endif]-->
	
		<script src="/ReservaYJuga/assets/js/fuelux/fuelux.spinner.min.js"></script>
		<script src="/ReservaYJuga/assets/js/bootstrap-colorpicker.min.js"></script>
		<script src="/ReservaYJuga/assets/js/bootstrap-tag.min.js"></script>
		<script src="/ReservaYJuga/assets/js/chosen.jquery.min.js"></script>
		<script src="/ReservaYJuga/assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="/ReservaYJuga/assets/js/date-time/bootstrap-timepicker.min.js"></script>
		<script src="/ReservaYJuga/assets/js/date-time/moment.min.js"></script>
		<script src="/ReservaYJuga/assets/js/date-time/daterangepicker.min.js"></script>
		<script src="/ReservaYJuga/assets/js/jquery.knob.min.js"></script>
		<script src="/ReservaYJuga/assets/js/jquery.autosize.min.js"></script>
		<script src="/ReservaYJuga/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
		<script src="/ReservaYJuga/assets/js/jquery.maskedinput.min.js"></script>
		<script src="/ReservaYJuga/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="/ReservaYJuga/assets/js/jquery.ui.touch-punch.min.js"></script>
	
		<!-- ace scripts -->
	
		<script src="/ReservaYJuga/assets/js/ace-jquery-commons.js"></script>
		<script src="/ReservaYJuga/assets/js/ace-elements.min.js"></script>
		<script src="/ReservaYJuga/assets/js/ace.min.js"></script>
			
	</body>
</html>