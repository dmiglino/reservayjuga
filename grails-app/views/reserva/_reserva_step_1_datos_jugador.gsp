
	<div id="step_1_datos_jugador">
		<h3 class="lighter block green">
			<g:message code="reserva.jugador.datos.label" default="Datos del jugador" />
		</h3>
	
		<div class="form-group">
			<div id="jugadorIdDiv" >
				<g:hiddenField name="jugadorId" value="${jugador?.id}" />
			</div>
			
			<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">
				<g:message code="common.nombre.label" default="Nombre" />:
			</label>
	
			<div class="col-xs-12 col-sm-3">
				<div class="clearfix">
					<g:textField name="nombre" value="${jugador?.nombre}"
						class="col-xs-12 col-sm-12" id="form-field-username" />
				</div>
			</div>
	
			<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name">
				<g:message code="common.apellido.label" default="Apellido" />:
			</label>
	
			<div class="col-xs-12 col-sm-3">
				<div class="clearfix">
					<g:textField name="apellido" value="${jugador?.apellido}"
						class="col-xs-12 col-sm-12" id="form-field-apellido" />
				</div>
			</div>
			
		</div>
	
		<div class="space-2"></div>
	
		<div class="form-group">
			<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">
				<g:message code="common.email.label" default="E-Mail" />:
			</label>
	
			<div class="col-xs-12 col-sm-3">
				<div class="clearfix">
					<g:textField name="mail" value="${jugador?.mail}"
						class="col-xs-12 col-sm-12" id="form-field-mail" />
				</div>
			</div>
	
			<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name">
				<g:message code="common.telefono.label" default="Telefono" />:
			</label>
	
			<div class="col-xs-12 col-sm-3">
				<div class="input-group">
					<span class="input-group-addon"> <i class="icon-phone"></i> </span> 
					<g:textField name="telefono" value="${jugador?.telefono}"
						class="col-xs-12 col-sm-12" id="form-field-telefono" />
				</div>
			</div>
	
		</div>
	
		<div class="space-2"></div>
	
		<div class="form-group">
	
			<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="id-date-picker-1">
				<g:message code="common.fecha.nacimiento.label" default="Fecha de Nacimiento" />
			</label>
	
			<div class="col-xs-12 col-sm-3">
				<div class="input-group">
					<g:field class="form-control date-picker" id="id-date-picker-1" name="datePicker" type="text" data-date-format="dd-mm-yyyy" value="${jugador?.getFechaNacimientoString()}" /> 
	<%--				<g:datePicker id="id-date-picker-1" name="resJugFechaNac" value="${jugador?.fechaNacimiento}" precision="day"></g:datePicker >--%>
					<span class="input-group-addon"> 
						<i class="icon-calendar bigger-110"></i>
					</span>
				</div>
			</div>
	
			<label class="control-label col-xs-12 col-sm-1 no-padding-right">
				<g:message code="common.sexo.label" default="Sexo" />
			</label>
	
			<div class="col-xs-12 col-sm-3">
				<div>
					<label class="blue"> 
	<%--					<input name="gender" value="1" type="radio" class="ace" /> --%>
						<g:radio name="sexo" value="${jugador?.sexo}" class="ace" checked="${jugador?.isHombre()}" />
						<span class="lbl"> <g:message code="common.hombre.label" default="Hombre" /></span>
					</label>
				</div>
	
				<div>
					<label class="blue"> 
	<%--					<input name="gender" value="2" type="radio" class="ace" />--%>
						<g:radio name="sexo" value="${jugador?.sexo}" class="ace"  checked="${jugador?.isMujer()}" />
						<span class="lbl"> <g:message code="common.mujer.label" default="Mujer" /></span>
					</label>
				</div>
			</div>
	
		</div>
	
	</div>
