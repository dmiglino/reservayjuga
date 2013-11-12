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
	
					<form class="form-horizontal" role="form">
	
						<div class="row">
							<!-- inicio tabla -->
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="sample-table-1" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<g:sortableColumn property="cancha" title="${message(code: 'reserva.field.cancha.label', default: 'Cancha')}" />
												<g:sortableColumn property="dia" title="${message(code: 'reserva.field.dia.label', default: 'Dia')}" />
												<g:sortableColumn property="horario" title="${message(code: 'reserva.field.horario.label', default: 'Horario')}" />
												<g:sortableColumn property="jugador" title="${message(code: 'reserva.field.jugador.label', default: 'Jugador')}" />
												<g:sortableColumn property="tipoReserva" title="${message(code: 'reserva.field.tipoReserva.label', default: 'Tipo de Reserva')}" />
												<g:sortableColumn property="precioTotal" title="${message(code: 'reserva.field.precioTotal.label', default: 'Precio total')}" />
												<g:sortableColumn property="seniaPagada" title="${message(code: 'reserva.field.seniaPagada.label', default: 'Seña pagada')}" />
												<g:sortableColumn property="faltante" title="${message(code: 'reserva.field.faltante.label', default: 'Faltante')}" />
												<g:sortableColumn property="estado" title="${message(code: 'reserva.field.estado.label', default: 'Estado')}" />
												<th><g:message code="common.tabla.acciones.label" default="Acciones" /></th>
											</tr>
										</thead>
	
										<tbody>
											<tr>
												<td>Cancha 1 - Camp Nou</td>
												<td class="hidden-480">25-08-2013</td>
												<td>15:00-16:00</td>
												<td>Tomas Escamez <a href="#modal-form" role="button"
													class="tooltip-info" title="Ver detalles"
													data-toggle="modal"> <span class="blue"> <i
															class="icon-zoom-in bigger-120"></i>
													</span>
												</a>
												</td>
												<td>Online</td>
												<td>$500</td>
												<td>$150</td>
												<td>$0</td>
												<td>Concretada</td>
												<td>
													<div
														class="visible-md visible-lg hidden-sm hidden-xs btn-group">
														<button class="btn btn-xs btn-info" title="Editar">
															<i class="icon-edit bigger-120"></i>
														</button>
														<button class="btn btn-xs btn-danger" title="Eliminar">
															<i class="icon-trash bigger-120"></i>
														</button>
													</div>
												</td>
											</tr>
	
											<tr>
												<td>Cancha 2 - San Siro</td>
												<td class="hidden-480">26-08-2013</td>
												<td>17:00-18:00</td>
												<td>Diego Miglino <a href="#modal-form" role="button"
													class="tooltip-info" title="Ver detalles"
													data-toggle="modal"> <span class="blue"> <i
															class="icon-zoom-in bigger-120"></i>
													</span>
												</a>
												</td>
												<td>Presencial</td>
												<td>$500</td>
												<td>$130</td>
												<td style="color: Red;">$370</td>
												<td>Pendiente</td>
												<td>
													<div
														class="visible-md visible-lg hidden-sm hidden-xs btn-group">
														<button class="btn btn-xs btn-success"
															title="Marcar como pagada">
															<i class="icon-ok bigger-120"></i>
														</button>
														<button class="btn btn-xs btn-info" title="Editar">
															<i class="icon-edit bigger-120"></i>
														</button>
														<button class="btn btn-xs btn-danger" title="Eliminar">
															<i class="icon-trash bigger-120"></i>
														</button>
													</div>
												</td>
											</tr>
	
											<tr>
												<td>Cancha 3 - San Genaro</td>
												<td class="hidden-480">26-08-2013</td>
												<td>21:00-22:00</td>
												<td>Matias Perez <a href="#modal-form" role="button"
													class="tooltip-info" title="Ver detalles"
													data-toggle="modal"> <span class="blue"> <i
															class="icon-zoom-in bigger-120"></i>
													</span>
												</a>
												</td>
												<td>Presencial</td>
												<td>$520</td>
												<td>$140</td>
												<td style="color: Red;">$380</td>
												<td>Pendiente</td>
												<td>
													<div
														class="visible-md visible-lg hidden-sm hidden-xs btn-group">
														<button class="btn btn-xs btn-success"
															title="Marcar como pagada">
															<i class="icon-ok bigger-120"></i>
														</button>
														<button class="btn btn-xs btn-info" title="Editar">
															<i class="icon-edit bigger-120"></i>
														</button>
														<button class="btn btn-xs btn-danger" title="Eliminar">
															<i class="icon-trash bigger-120"></i>
														</button>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- /.table-responsive -->
							</div>
						</div>
					</form>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	
		<!-- comienzo DEL MODAL BOX PARA EDITAR -->
		<div id="modal-form" class="modal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="blue bigger"><g:message code="reserva.jugador.informacion.label" default="Informacion del jugador" /></h4>
					</div>
	
					<div class="modal-body overflow-visible">
						<div class="row">
							<div class="col-xs-8 col-sm-8">
								<div class="space-4"></div>
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-username">Nombre
											y Apellido:</label> <label class="col-sm-6 control-label"
											for="form-field-username"><strong>Tomas
												Escamez</strong></label>
									</div>
	
									<div class="space-4"></div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">E-mail</label>
										<label class="col-sm-6 control-label" for="form-field-username"><strong>tomase@gmail.com</strong></label>
									</div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">Telefono</label>
										<label class="col-sm-6 control-label" for="form-field-username"><strong>156-448-7449</strong></label>
									</div>
	
									<div class="space-4"></div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">Fecha
											de Nacimiento</label> <label class="col-sm-6 control-label"
											for="form-field-username"><strong>10/08/1987</strong></label>
									</div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">Sexo</label>
										<label class="col-sm-6 control-label" for="form-field-username"><strong>Masculino</strong></label>
									</div>
								</form>
							</div>
						</div>
					</div>
	
					<div class="modal-footer">
						<button class="btn btn-sm" data-dismiss="modal">
							<i class="icon-remove"></i> <g:message code="common.cancelar.label" default="Cancelar" />
						</button>
	
						<button class="btn btn-sm btn-primary">
							<i class="icon-ok"></i> <g:message code="common.grabar.label" default="Grabar" />
						</button>
					</div>
				</div>
			</div>
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
	
		</script>
	
	</body>
</html>