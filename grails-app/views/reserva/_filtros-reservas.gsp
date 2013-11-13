<%@page import="ar.com.reservayjuga.reserva.TipoReservaEnum"%>
<%@page import="ar.com.reservayjuga.reserva.ReservaEnum"%>
<g:formRemote name="filter_form" url="[ controller: 'reserva', action:'filtrarReservas' ]" update="tabla_reservas" >
	<div class="col-xs-12">
		<div class="well">
			<div class="col-xs-4">
				<h4 class="green smaller lighter"><g:message code="reserva.filtros.cancha.label" default="Canchas" /></h4>
				<div>
					<g:select id="canchaReservaFilter" 
						name="canchaReservaFilter"
						from="${canchas}"
						optionKey="id"
						noSelection="['':'Seleccione una cancha..']"
						class="width-80 chosen-select"
						value=""  />
				</div>
			</div>
			
			<div class="col-xs-4">
				<h4 class="green smaller lighter"><g:message code="reserva.filtros.estado.label" default="Estado" /></h4>	
				<div>
					<g:select id="estadoReservaFilter" 
						name="estadoReservaFilter"
						from="${ReservaEnum.values()}"
						noSelection="['':'Seleccione un estado..']"
						class="width-80 chosen-select"
						value=""  />
				</div>
			</div>
				
			<div class="col-xs-4">
				<h4 class="green smaller lighter"><g:message code="reserva.filtros.tiporeserva.label" default="Tipo de Reserva" /></h4>	
				<div>
					<g:select id="tipoReservaFilter" 
						name="tipoReservaFilter"
						from="${TipoReservaEnum.values()}"
						noSelection="['':'Seleccione un tipo..']"
						class="width-80 chosen-select"
						value=""  />
				</div>
			</div>
				
			<br /> <br /> <br /> <br />
			
			<div class="col-xs-4">
				<h4 class="green smaller lighter"><g:message code="reserva.filtros.dia.label" default="Dia" /></h4>	
				<div class="input-group">
					<span class="input-group-addon">
						<i class="icon-calendar bigger-110"></i>
					</span>
					<input class="form-control" type="text" name="dateRangePicker" id="id-date-range-picker-1" />
				</div>
			</div>
			
			<div class="col-xs-4">
				<h4 class="green smaller lighter"><g:message code="reserva.filtros.horario.label" default="Horario" /></h4>
				<div class="input-group bootstrap-timepicker">
					<input id="timepicker1" type="text" class="form-control" /> 
					<span class="input-group-addon"> 
						<i class="icon-time bigger-110"></i>
					</span>
				</div>
			</div>
			
			<div class="col-xs-4">
				<i class="icon-zoom-in bigger-200"></i>
				<g:submitButton name="submit" value="Filtrar" />
			</div>
			
			<br /> <br /> <br />
			<br /> <br /> <br />
		</div>
	</div>
</g:formRemote>