	 <g:formRemote name="formEditReserva" url="[controller:'reserva', action:'editarReserva']" >
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
										<label class="col-sm-6 control-label" for="form-field-username">
											<g:message code="common.nombre.apellido.label" default="Nombre y Apellido" />:
										</label> 
										<label class="col-sm-6 control-label"
											for="form-field-username">
											<strong>${jugador}</strong>
										</label>
									</div>
	
									<div class="space-4"></div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">
											<g:message code="common.email.label" default="E-Mail" />:
										</label>
										<label class="col-sm-6 control-label" for="form-field-username"><strong>${jugador?.mail}</strong></label>
									</div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">
											<g:message code="common.telefono.label" default="Telefono" />:
										</label>
										<label class="col-sm-6 control-label" for="form-field-username"><strong>${jugador?.telefono}</strong></label>
									</div>
	
									<div class="space-4"></div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">
											<g:message code="common.fecha.nacimiento.label" default="Fecha de Nacimiento" />:
										</label> 
										<label class="col-sm-6 control-label" for="form-field-username">
											<strong>
												<g:formatDate date="${jugador?.fechaNacimiento}" format="dd-MM-yyyy" />
											</strong>
										</label>
									</div>
	
									<div class="form-group">
										<label class="col-sm-6 control-label" for="form-field-select-3">
											<g:message code="common.sexo.label" default="Sexo" />:
										</label>
										<label class="col-sm-6 control-label" for="form-field-username"><strong>${jugador?.sexo}</strong></label>
									</div>
								</form>
							</div>
						</div>
					</div>
	
					<div class="modal-footer">
						<button class="btn btn-sm" data-dismiss="modal">
							<i class="icon-ok"></i> <g:message code="common.volver.label" default="Volver" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</g:formRemote>