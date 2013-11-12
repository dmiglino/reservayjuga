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
			<h4 class="green smaller lighter"><g:message code="reserva.filtros.estado.label" default="Estado" /></h4>	
			<div>
				<select multiple="" class="width-80 chosen-select"
					id="form-field-select-4" data-placeholder="Seleccione un estado..">
					<option value="">&nbsp;</option>
					<option value="C1">Pendiente</option>
					<option value="C4">Señado</option>
					<option value="C2">Concretado</option>
					<option value="C3">Cancelado</option>
				</select>
			</div>
		</div>
			
		<div class="col-xs-4">
			<h4 class="green smaller lighter"><g:message code="reserva.filtros.tiporeserva.label" default="Tipo de Reserva" /></h4>	
			<div>
				<select multiple="" class="width-80 chosen-select"
					id="form-field-select-4" data-placeholder="Seleccione un tipo de reserva">
					<option value="">&nbsp;</option>
					<option value="C1">Online</option>
					<option value="C4">Presencial</option>
				</select>
			</div>
		</div>
			
		<br /> <br /> <br /> <br />
		
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
		
		<br /> <br /> <br />
		<br /> <br /> <br />
	</div>
</div>