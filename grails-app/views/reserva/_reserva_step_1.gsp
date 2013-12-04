<div class="step-pane active" id="step1">
	<g:form class="form-horizontal" id="sample-form">

	<h3 class="lighter block green">
		<g:message code="reserva.jugador.busqueda.label"
			default="Busqueda del jugador" />
	</h3>

	<div class="form-group">
		<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email">
			<g:message code="reserva.jugador.nombreomail.label" default="Nombre o email" />:
		</label>
		<div class="col-xs-12 col-sm-4">
			<g:textField name="nombremail" value="${reserva?.jugador}" class="col-sm-6" id="form-field-user" />
			<div class="space-4"></div>
		</div>
		
		<g:remoteLink controller="reserva" action="agregarJugadorQueReserva" update="[success:'datosJugadorDiv',failure:'error']" class="btn btn-xs btn-danger"><i class="icon-ok bigger-120"></i></g:remoteLink>
		
	</div>

	<div class="space-2"></div>

	<h3 class="lighter block green">
		<g:message code="reserva.jugador.datos.label" default="Datos del jugador" />
	</h3>

	<div class="form-group">
		<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">
			<g:message code="common.nombre.label" default="Nombre" />:
		</label>

		<div class="col-xs-12 col-sm-3">
			<div class="clearfix">
				<g:textField name="nombre" value="${reserva?.jugador?.nombre}"
					class="col-xs-12 col-sm-12" id="form-field-username" />
			</div>
		</div>

		<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name">
			<g:message code="common.apellido.label" default="Apellido" />:
		</label>

		<div class="col-xs-12 col-sm-3">
			<div class="clearfix">
				<g:textField name="apellido" value="${reserva?.jugador?.apellido}"
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
				<g:textField name="mail" value="${reserva?.jugador?.mail}"
					class="col-xs-12 col-sm-12" id="form-field-mail" />
			</div>
		</div>

		<label class="control-label col-xs-12 col-sm-1 no-padding-right" for="name">
			<g:message code="common.telefono.label" default="Telefono" />:
		</label>

		<div class="col-xs-12 col-sm-3">
			<div class="input-group">
				<span class="input-group-addon"> <i class="icon-phone"></i> </span> 
				<g:textField name="telefono" value="${reserva?.jugador?.telefono}"
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
				<g:field class="form-control date-picker" id="id-date-picker-1" name="date-picker" type="text" data-date-format="dd-mm-yyyy" value="${reserva?.jugador?.getFechaNacimientoString()}" /> 
<%--				<g:datePicker id="id-date-picker-1" name="resJugFechaNac" value="${reserva?.jugador?.fechaNacimiento}" precision="day"></g:datePicker >--%>
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
					<g:radio name="sexo" value="${reserva?.jugador?.sexo}" class="ace" checked="${reserva?.jugador?.isHombre()}" />
					<span class="lbl"> <g:message code="common.hombre.label" default="Hombre" /></span>
				</label>
			</div>

			<div>
				<label class="blue"> 
<%--					<input name="gender" value="2" type="radio" class="ace" />--%>
					<g:radio name="sexo" value="${reserva?.jugador?.sexo}" class="ace"  checked="${reserva?.jugador?.isMujer()}" />
					<span class="lbl"> <g:message code="common.mujer.label" default="Mujer" /></span>
				</label>
			</div>
		</div>

	</div>

	<div class="space-2"></div>

	<div class="form-group"></div>

	<div class="col-md-offset-3 col-md-9">
		<button class="btn btn-info" type="button">
			<i class="icon-ok bigger-110"></i>
			<g:message code="button.actualizar.label" default="Actualizar" />
		</button>
		&nbsp; &nbsp; &nbsp;
	</div>

	</g:form>
</div>