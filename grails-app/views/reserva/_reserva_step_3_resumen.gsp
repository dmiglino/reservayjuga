
	<div id="step_3">
		<div class="profile-user-info profile-user-info-striped" style="width: 330px; margin-right: 1px; float: left;">
		
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="complejo.entity.label" default="Complejo" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="nombre">
						<g:field name="complejoNombre" value="${reserva?.complejo?.nombre}" id="nombre" type="text" readonly="readonly" />
					</span>
				</div>
			</div>
	
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="reserva.dia.label" default="Dia" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="dia">
						<g:field name="reservaDia" value="${reserva?.getDiaString()}" id="dia" type="text" readonly="readonly" />
					</span>
				</div>
			</div>
	
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="reserva.hora.label" default="Hora" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="hora">
						<g:field name="reservaHora" value="${reserva?.horaInicio}" id="hora" type="text" readonly="readonly" />
					</span>
				</div>
			</div>
	
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="reserva.cancha.label" default="Cancha" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="cancha">
						<g:field name="reservaCancha" value="${reserva?.cancha?.nombre}" id="cancha" type="text" readonly="readonly" />
					</span>
				</div>
			</div>
	
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="jugador.entity.label" default="Jugador" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="jugador">
						<g:field name="reservaJugador" value="${reserva?.jugador}" id="jugador" type="text" readonly="readonly" />
					</span>
				</div>
			</div>
	
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="common.email.label" default="E-Mail" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="mail">
						<g:field name="reservaJugadorMail" value="${reserva?.jugador?.mail}" id="mail" type="text" readonly="readonly" />
					</span>
				</div>
			</div>
		</div>
	
	
		<div class="profile-user-info profile-user-info-striped" style="width: 502px; float: left;">
		
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="reserva.alquiler.label" default="Precio Alquiler" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="Span1">
						<g:field name="reservaPrecio" value="${reserva?.precioTotal}" id="precio" type="text" readonly="readonly" />
					</span>
				</div>
			</div>
	
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="reserva.senia.pagada.label" default="Seña Pagada" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable" id="Span3">
						<g:field name="reservaSenia" value="${reserva?.senia}" id="senia" type="text" onchange="setearSenia();" />
					</span>
				</div>
			</div>
	
			<div class="profile-info-row">
				<div class="profile-info-name">
					<g:message code="reserva.faltapagar.label" default="Falta Pagar" />
				</div>
	
				<div class="profile-info-value">
					<span class="editable">
						<g:field name="faltante" value="${reserva?.faltaPagar()}" id="faltante" type="text" readonly="readonly"/>
					</span>
				</div>
			</div>
		</div>
		<button class="btn btn-warning"
		style="float: left; margin-left: 11px; padding-right: 8px;">
		<i class="icon-print"></i>
		<g:message code="button.imprimir.label" default="Imprimir" />
		</button>
	</div>
	
<script>
	function setearSenia() {
		var senia = document.getElementById('senia').value;
		var total = document.getElementById('precio').value;
		if(senia != null && senia != "" && total != null && total != "") {
			if(senia > total) {
				alert("${message(code:'validacion.senia.superior.monto')}");
				document.getElementById('senia').value = 0;
			} else {
				document.getElementById('faltante').value = total - senia;
			}
		}
	}
</script>