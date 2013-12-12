	
<div id="step_2_horarios">
	<div class="col-sm-4">
		<div class="widget-box">
			<div class="widget-header">
				<h4>
					<strong><g:message code="reserva.hora.label" default="HORA" /></strong>
					(
					<g:message code="reserva.hora.seleccionar.label"
						default="Selecciona la hora del partido" />
					)
				</h4>
			</div>

			<div class="widget-body" id="step_2_horarios_body">
				<div class="widget-main">
					<center>
						<g:each in="${horariosConfigurados}" var="horario" status="i">
							<button class="btn btn-primary">${horario}</button>
<%--							<button class="btn disabled btn-primary">18:00 - 19:00</button>--%>
						</g:each>
					</center>
				</div>
			</div>
		</div>
	</div>
</div>
	

<script type="text/javascript">

	function searchCanchasParaHorarios(fecha, horario) {
		var JSONObject = new Object;
	    JSONObject.fecha = fecha;
	    JSONObject.horario = horario;
	    JSONObject.canchaId = "1";
	    JSONstring = JSON.stringify(JSONObject);
	    
	    $.ajax({
	        data:  JSONObject,
	        url:   "${createLink(controller:'reserva', action:'searchCanchasParaHorarios')}",
	        type:  'post',
	        dataType: 'json',
<%--	        beforeSend: function () { NO LA USAMOS PORQUE ES RAPIDO Y GENERA UN PARPADEO MOLESTO, SI TENEMOS ALGO QUE TARDA MAS, USAR ESTO.--%>
<%--              	$("#step_2_canchas_body").html("Procesando, espere por favor...");--%>
<%--	        },--%>
	        successa<:  function (data) {
              	$("#step_2_canchas").html(data);
	        },
	        error: function(request, status, error) {
	            alert(error)
	        }
	    });
	};

</script>
