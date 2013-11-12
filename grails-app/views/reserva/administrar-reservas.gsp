<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title><g:message code="reservas.administracion.titulo.label" default="Administracion de Reservas" /></title>
		<meta name="layout" content="main" />
	</head>

	<body>
	
	<%-- inicio main-container--%>
	
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i> 
					<a href="#"><g:message code="sidebar.panel.label" default="Panel de control" /></a>
				</li>
				<li>
					<a href="#"><g:message code="sidebar.administrar.reserva.label" default="Administrar Reservas" /></a>
				</li>
			</ul>
			<!-- .breadcrumb -->
		</div>
	
		<div class="page-content">
			<div class="page-header">
				<h1>
					<small> <g:message code="reserva.filtros.titulo.label" default="Filtros" /> </small>
				</h1>
			</div><!-- /.page-header -->
	
			<div class="row" id="tabla_reservas">
				<g:render template="filtros-reservas" />
			</div>
	
			<div class="page-header">
				<h1>
					<small> <g:message code="reservas.listado.titulo.label" default="Listado de Reservas" /> </small>
				</h1>
			</div>
			<!-- /.page-header -->
	
			<div class="row">
				<div class="col-xs-12">
	
					<!-- PAGE CONTENT BEGINS -->
					<g:form action="reservarCancha" class="form-horizontal" role="form" >
						<div class="row" id="tabla_reservas">
							<g:render template="tabla-reservas" />
						</div>
						         
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<g:actionSubmit action="reservarCancha" class="btn btn-info" value="Nueva Reserva" />
								&nbsp; &nbsp; &nbsp;
							</div>
						</div>
					</g:form>
					
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	
		<!-- comienzo DEL MODAL BOX PARA EDITAR -->		
		<div id="modal-box-form" >
			<g:render template="modal-box-jugador" model="['cancha':cancha]" />
		</div>
		<!-- FIN DEL MODAL BOX PARA EDITAR -->
	
	
		<script type="text/javascript">
			
				$('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){
					$(this).next().focus();
				});
				
				$('#timepicker1').timepicker({
					minuteStep: 15,
					showSeconds: false,
					showMeridian: false
				}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
				
				function setJugadorToShow() {
					$('#modal-form').modal('show');
				}
		</script>
	
	</body>
</html>