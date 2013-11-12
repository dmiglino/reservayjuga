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
	
			<div class="col-xs-12">
				<div class="well">
					<div class="col-xs-4">
						<h4 class="green smaller lighter"><g:message code="reserva.filtros.cancha.label" default="Canchas" /></h4>
						<div>
							<select multiple="" class="width-80 chosen-select"
								id="form-field-select-4" data-placeholder="Seleccione una cancha...">
								<option value="">&nbsp;</option>
								<option value="C1">Cancha 1</option>
								<option value="C2">Cancha 2</option>
								<option value="C3">Cancha 3</option>
								<option value="C4">Cancha 4</option>
								<option value="C5">Cancha 5</option>
							</select>
						</div>
					</div>
					<div class="col-xs-4">
						<h4 class="green smaller lighter"><g:message code="reserva.filtros.dia.label" default="Dia" /></h4>	
								<div class="input-group">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
									<input class="form-control" type="text" name="date-range-picker" id="id-date-range-picker-1" />
								</div>
					</div>
					<div class="col-xs-4">
						<h4 class="green smaller lighter"><g:message code="reserva.filtros.horario.label" default="Horario" /></h4>
							<div class="input-group bootstrap-timepicker">
								<input id="timepicker1" type="text" class="form-control" /> 
								<span class="input-group-addon"> 
									<i class="icon-time bigger-110"></i>
								</span>
							</div>
					</div>
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
				</div>
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
						<div class="row">
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