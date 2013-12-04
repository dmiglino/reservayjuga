<div class="step-pane" id="step3">

	<div class="profile-user-info profile-user-info-striped" style="width: 802px; margin-right: 1px; float: left;">
	
		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="complejo.entity.label" default="Complejo" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="nombre">
					<g:field name="complejoNombre" value="${reserva?.complejo?.nombre}" id="form-field-nombre" type="text" readonly="readonly" />
				</span>
			</div>
		</div>

		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="reserva.dia.label" default="Dia" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="dia">
					<g:field name="reservaDia" value="${reserva?.dia}" id="form-field-dia" type="text" readonly="readonly" />
				</span>
			</div>
		</div>

		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="reserva.hora.label" default="Hora" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="hora">
					<g:field name="reservaHora" value="${reserva?.horaInicio}" id="form-field-hora" type="text" readonly="readonly" />
				</span>
			</div>
		</div>

		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="reserva.cancha.label" default="Cancha" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="cancha">
					<g:field name="reservaCancha" value="${reserva?.cancha?.nombre}" id="form-field-cancha" type="text" readonly="readonly" />
				</span>
			</div>
		</div>

		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="jugador.entity.label" default="Jugador" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="jugador">
					<g:field name="reservaJugador" value="${reserva?.jugador}" id="form-field-jugador" type="text" readonly="readonly" />
				</span>
			</div>
		</div>

		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="common.email.label" default="E-Mail" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="mail">
					<g:field name="reservaJugadorMail" value="${reserva?.jugador?.mail}" id="form-field-mail" type="text" readonly="readonly" />
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
					<g:field name="reservaPrecio" value="${reserva?.precioTotal}" id="form-field-precio" type="text" readonly="readonly" />
				</span>
			</div>
		</div>

		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="reserva.senia.pagada.label" default="Seña Pagada" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="Span3">
					<g:field name="reservaSenia" value="${reserva?.senia}" id="form-field-senia" type="text" readonly="readonly" />
				</span>
			</div>
		</div>

		<div class="profile-info-row">
			<div class="profile-info-name">
				<g:message code="reserva.faltapagar.label" default="Falta Pagar" />
			</div>

			<div class="profile-info-value">
				<span class="editable" id="faltante">
					<g:field name="faltante" value="${reserva?.faltaPagar()}" id="form-field-faltante" type="text" readonly="readonly"/>
				</span>
			</div>
		</div>
	</div>

	<button class="btn btn-warning"
		style="float: left; margin-left: 11px; padding-right: 8px; margin-top: 8px;">
		<i class="icon-print"></i>
		<g:message code="button.imprimir.label" default="Imprimir" />
	</button>

</div>