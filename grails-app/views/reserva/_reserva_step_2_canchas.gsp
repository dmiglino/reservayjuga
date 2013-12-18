	
<div id="step_2_canchas">
	<div class="col-sm-4">
		<div class="widget-box">
			<div class="widget-header">
				<h4>
					<strong><g:message code="reserva.cancha.label" default="CANCHA" /></strong> 
					(
						<g:message code="reserva.dia.seleccionar.label" default="Selecciona la cancha" />
					)
				</h4>
			</div>

			<div class="widget-body" id="step_2_canchas_body">
				<div class="widget-main overflow-auto">
					<ul class="ul-canchas">
						<g:each in="${canchas}" var="cancha" status="i">
							<li id="cancha_${cancha.id}" class="cancha-futbol" onclick="seleccionarCanchaAReservar('${cancha.id}');"><span>${i}</span></li>
							<g:hiddenField name="reservaCanchaId" id="reservaCanchaId" value="" />
						</g:each>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">

	function seleccionarCanchaAReservar(canchaId) {
		//borra la cancha seleccionada anteriormente
		var canchaAnterior = document.getElementById('reservaCanchaId').value;
		if(canchaAnterior != null && canchaAnterior != "") {
			var buttonId = "cancha_"+document.getElementById('reservaCanchaId').value;
			var li = document.getElementById(buttonId);
			var previousStyleClass = li.getAttribute("class");
			var previousStyleClassWithoutActive = previousStyleClass.replace(" active", "");
			li.setAttribute("class", previousStyleClassWithoutActive);
		}
		
		//setea el id de la cancha seleccionada
		document.getElementById('reservaCanchaId').value = canchaId;
		
		//marca como seleccionada la nueva cancha
		if(canchaId != null) {
			var buttonId = "cancha_"+canchaId;
			var li = document.getElementById(buttonId);
			var previousStyleClass = li.getAttribute("class");
			li.setAttribute("class", previousStyleClass+" active");
		}
	};

</script>