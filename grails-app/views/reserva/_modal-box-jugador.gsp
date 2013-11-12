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
	</g:formRemote>