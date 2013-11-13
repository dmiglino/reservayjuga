<%@page import="ar.com.reservayjuga.complejo.DeporteEnum"%>

<div class="form-group">
	<label class="col-sm-2 control-label" for="form-field-username"><g:message code="common.nombre.label" default="Nombre" /></label>

	<div>
		<g:textField name="cancha.nombre" value="${cancha?.nombre}"
			class="col-sm-6" id="form-field-username" />
	</div>
</div>

<div class="space-4"></div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="form-field-select-3"><g:message code="common.techado.label" default="Techado" /></label>
	<div>
		<g:select id="cubierta" name="cancha.cubierta"
			from="${["true","false"]}" noSelection="['':'']"
			class="chosen-select one-to-one" value="${cancha?.cubierta}" />
	</div>
</div>

<div class="space-4"></div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="form-field-select-3"><g:message code="common.deporte.label" default="Deporte" /></label>
	<g:select id="deporte" name="cancha.deporte"
		from="${DeporteEnum.values()}" noSelection="['':'']"
		class="chosen-select one-to-one"
		optionValue="${ {deporte -> g.message(code:deporte.textCode)} }"
		value="${cancha?.deporte}"
		onchange="${remoteFunction (
					controller: 'cancha',
					action: 'getSuperficies',
					params: '\'id=\' + this.value',
					update: 'superficiesDiv'
				)}" />
</div>

<div class="space-4"></div>

<div id="superficiesDiv" class="form-group">
	<g:if test="${cancha?.deporte}">
		<g:include controller="cancha" action="getSuperficies" id="${cancha?.deporte}" />
	</g:if>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="form-field-select-3"><g:message code="common.cantidad.jugadores.label" default="Cantidad de Jugadores" /></label>
	<div>
		<g:textField name="cancha.cantidad" value="" class="input-mini" id="spinner1" />
		<g:hiddenField name="cancha.cantidadJugadores" id="cantJugValue" value="" />
	</div>
</div>

<div class="page-header">
	<h1>
		<small> <g:message code="common.precios.label" default="Precios" /> </small>
	</h1>
</div>

<g:if test="${!edit}">
	<div class="clearfix form-actions">
		<div class="col-md-offset-3 col-md-9">
			<g:actionSubmit action="administrarCancha" class="btn btn-info"
				value="Volver" />
			<g:actionSubmit action="crearCancha" class="btn btn-info"
				value="Crear Cancha" onclick="setCantJugValue();" />
			&nbsp; &nbsp; &nbsp;
		</div>
	</div>
</g:if>

<g:else>
	<div class="modal-footer">
		<button class="btn btn-sm" data-dismiss="modal">
			<i class="icon-remove"></i> <g:message code="common.cancelar.label" default="Cancelar" />
		</button>

		<g:submitToRemote class="btn btn-info" update="[success:'canchasDiv']"
			after="closeModal();"
			url="[controller:'cancha', action:'editarCancha']"
			value="Grabar Cancha" onclick="setCantJugValue();">
			<i class="icon-ok"></i>
		</g:submitToRemote>
	</div>
</g:else>

<script type="text/javascript">
                     
	function setCantJugValue() {
		var spinnerValue = document.getElementById('spinner1').value;
		document.getElementById('cantJugValue').value = spinnerValue;
	}
                      
</script>