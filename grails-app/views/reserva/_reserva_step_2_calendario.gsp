
<div class="col-sm-4">
	<div class="widget-box">
		<div class="widget-header">
			<h4>
				<strong><g:message code="reserva.dia.label" default="DIA" /></strong>
				(
					<g:message code="reserva.dia.seleccionar.label"
					default="Selecciona el dia del partido" />
				)
			</h4>
		</div>

		<div class="widget-body">
			<div class="widget-main" align="center">
				<input type="text" id="reservaDateText" name="something" value="${reserva?.getDiaString()}"/>
				<div id="reservaDateDiv"></div> 
<%--						<g:field class="date-picker" id="id-date-picker-2" name="date-picker" type="text" data-date-format="dd-mm-yyyy" value="${reserva?.getDiaString()}" /> --%>
<%--						<div class="date-picker" align="center" data-date-format="dd-mm-yyyy" value="${reserva?.getDiaString()}"></div>--%>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	
	$('.date-picker').datepicker({ dateFormat: 'dd-mm-yy', autoclose: false }).next().on(ace.click_event, function() {
	    $(this).prev().focus();
	});
	
	$('#reservaDateDiv').datepicker({
		onSelect: function ()
	    {
	        this.focus();
	    }
	});
	
	$('#reservaDateText').change(function(){
		var queryDate = $('#reservaDateText').val();
		var dateParts = queryDate.match(/(\d+)/g)
		realDate = new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
	
		$('#reservaDateDiv').datepicker({ dateFormat: 'dd-mm-yy' }); // format to show
		$('#reservaDateDiv').datepicker("update", realDate);
	
		searchHorariosParaFecha(queryDate);
	});
	
	$('#reservaDateDiv').on('changeDate', function(ev) {
		var d = new Date(Date.parse(ev.date));
		var dateString =(d.getDate()+1)+"-"+(d.getMonth()+1)+"-"+ d.getFullYear();	
		$('#reservaDateText').attr('value', dateString);
		
		searchHorariosParaFecha(dateString);
	});
	
	function searchHorariosParaFecha(fecha) {
		var JSONObject = new Object;
	    JSONObject.fecha = fecha;
	    JSONObject.canchaId = "1"; //TODO recuperar valor posta
	    JSONstring = JSON.stringify(JSONObject);
	    
	    $.ajax({
	        url:   "${createLink(controller:'reserva', action:'searchHorariosParaFecha')}",
	        data:  JSONObject,
	        type:  'get',
	        dataType: 'json',
<%--	        beforeSend: function () { NO LA USAMOS PORQUE ES RAPIDO Y GENERA UN PARPADEO MOLESTO, SI TENEMOS ALGO QUE TARDA MAS, USAR ESTO.--%>
<%--              	$("#step_2_horarios_body").html("Procesando, espere por favor...");--%>
<%--	        },--%>
	        complete:  function (response) {
               	$("#step_2_horarios").html(response.responseText);
	        },
	        error: function(request, status, error) {
	            alert(error)
	        }
	    });
	};

</script>