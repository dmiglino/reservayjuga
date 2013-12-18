<div class="step-pane active" id="step1">
	<g:form class="form-horizontal" id="step1-form">

		<h3 class="lighter block green">
			<g:message code="reserva.jugador.busqueda.label"
				default="Busqueda del jugador" />
		</h3>
	
		<div class="form-group">
			<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email">
				<g:message code="reserva.jugador.emailodni.label" default="E-mail o DNI" />:
			</label>
			<div class="col-xs-12 col-sm-4">
				<g:textField name="emaildni" value="${reserva?.jugador}" class="col-sm-6" id="emaildni" />
				<div class="space-4"></div>
			</div>
			
	    	<button onclick="buscarJugador();return false;"><i class="icon-zoom-in bigger-120"><g:message code="button.buscar.jugador.label" default="Buscar Jugador" /></i></button>
	    	
		</div>
	
		<div class="space-2"></div>
		<g:render template="reserva_step_1_datos_jugador" />	
		<div class="space-2"></div>
	
		<div class="form-group"></div>
	
		<div class="col-md-offset-3 col-md-9">
			<g:submitToRemote controller="reserva" action="actualizarDatosDelJugador" value="${message(code: 'button.actualizar.jugador.label',default: 'Actualizar')}" update="[success:'datosJugadorDiv',failure:'error']" class="btn btn-xs btn-danger"></g:submitToRemote>
			&nbsp; &nbsp; &nbsp;
		</div>
	</g:form>
</div>

<script>
function buscarJugador() {

	var JSONObject = new Object;
    JSONObject.emaildni = $('#emaildni').val();
    JSONstring = JSON.stringify(JSONObject);
    
    $.ajax({
        url:   "${createLink(controller:'reserva', action:'buscarJugador')}",
        data:  JSONObject,
        type:  'post',
		success: function(data) {
		   	$("#step_1_datos_jugador").html(data);
		},
        error: function(request, status, error) {
            alert("Ha ocurrido un error: "+error);
        }
    });

};
</script>