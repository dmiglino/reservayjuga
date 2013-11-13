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
<div>
<div id="example1" class="handsontable"></div>
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

var data = [
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8],
            [1, 2, 3, 4, 5, 6, 7, 8]
          ];

          $('#example1').handsontable({
            data: data,
            colHeaders: ["LUN", "MAR", "MIE","MIE","JUE","SAB","DOM","FER"],
            rowHeaders: ["01:00", "02:00", "03:00","04:00","05:00","06:00","07:00","08:00",
                         "09:00", "10:00", "11:00","12:00","13:00","14:00","15:00","16:00",
                         "17:00", "18:00", "19:00","20:00","21:00","22:00","23:00","24:00"],
            minSpareRows: 0
          });

          $('#example1 table').addClass('table');
          	
                     
	function setCantJugValue() {
		var spinnerValue = document.getElementById('spinner1').value;
		document.getElementById('cantJugValue').value = spinnerValue;
	}
                      
</script>