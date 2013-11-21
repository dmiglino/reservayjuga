
<div class="step-pane" id="step2">

	<div class="row">

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
					<div class="widget-main">
						<div class="date-picker" align="center" data-date-format="dd-mm-yyyy"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-4">
			<div class="widget-box">
				<div class="widget-header">
					<h4>
						<strong><g:message code="reserva.hora.label"
								default="HORA" /></strong> (
						<g:message code="reserva.hora.seleccionar.label"
							default="Selecciona la hora del partido" />
						)
					</h4>
				</div>

				<div class="widget-body">
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

		<div class="col-sm-4">
			<div class="widget-box">
				<div class="widget-header">
					<h4>
						<strong><g:message code="reserva.cancha.label"
								default="CANCHA" /></strong> (
						<g:message code="reserva.dia.seleccionar.label"
							default="Selecciona la cancha" />
						)
					</h4>
				</div>

				<div class="widget-body">
					<div class="widget-main overflow-auto">
						<ul class="ul-canchas">
							<li id="1" class="cancha-futbol"><span>01</span></li>
							<li id="2" class="cancha-futbol"><span>02</span></li>
							<li id="3" class="cancha-futbol active"><span>03</span></li>
							<li id="4" class="cancha-futbol"><span>04</span></li>
							<li id="5" class="cancha-futbol"><span>05</span></li>
							<li id="6" class="cancha-futbol"><span>06</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
