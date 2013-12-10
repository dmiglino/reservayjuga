	
<div id="step_2_horarios">
	<div class="col-sm-4">
		<div class="widget-box">
			<div class="widget-header">
				<h4>
					<strong><g:message code="reserva.hora.label" default="HORA" /></strong> ${params}
					(
					<g:message code="reserva.hora.seleccionar.label"
						default="Selecciona la hora del partido" />
					)
				</h4>
			</div>

			<div class="widget-body" id="step_2_horarios_body">
				<div class="widget-main">
					<center>
						<button class="btn btn-primary">10:00 - 11:00</button>
						<button class="btn btn-primary">11:00 - 12:00</button>
						<button class="btn btn-primary">12:00 - 13:00</button>
						<button class="btn btn-primary">13:00 - 14:00</button>
						<button class="btn btn-primary">14:00 - 15:00</button>
						<button class="btn btn-primary">15:00 - 16:00</button>
						<button class="btn btn-primary">16:00 - 17:00</button>
						<button class="btn btn-primary">17:00 - 18:00</button>
						<button class="btn disabled btn-primary">18:00 - 19:00</button>
						<button class="btn btn-primary">19:00 - 20:00</button>
						<button class="btn btn-primary">20:00 - 21:00</button>
						<button class="btn disabled btn-primary">21:00 - 22:00</button>
						<button class="btn disabled btn-primary">22:00 - 23:00</button>
						<button class="btn btn-primary">23:00 - 24:00</button>
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
	        complete:  function (response) {
	              	$("#step_2_canchas").html(response.responseText);
	        },
	        error: function(request, status, error) {
	            alert(error)
	        }
	    });
	};

</script>
