<!-- inicio tabla -->
<div class="col-xs-12">
	<div class="table-responsive">
		<table id="sample-table-1" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<g:sortableColumn property="cancha" title="${message(code: 'reserva.field.cancha.label', default: 'Cancha')}" />
					<g:sortableColumn property="dia" title="${message(code: 'reserva.field.dia.label', default: 'Dia')}" />
					<g:sortableColumn property="horaInicio" title="${message(code: 'reserva.field.horario.label', default: 'Horario')}" />
					<g:sortableColumn property="jugador" title="${message(code: 'reserva.field.jugador.label', default: 'Jugador')}" />
					<g:sortableColumn property="tipoReserva" title="${message(code: 'reserva.field.tipoReserva.label', default: 'Tipo de Reserva')}" />
					<g:sortableColumn property="precioTotal" title="${message(code: 'reserva.field.precioTotal.label', default: 'Precio total')}" />
					<g:sortableColumn property="senia" title="${message(code: 'reserva.field.seniaPagada.label', default: 'Seña pagada')}" />
					<th><g:message code="reserva.field.faltante.label" default="Faltante" /></th>
					<g:sortableColumn property="estado" title="${message(code: 'reserva.field.estado.label', default: 'Estado')}" />
					<th><g:message code="common.tabla.acciones.label" default="Acciones" /></th>
				</tr>
			</thead>

			<tbody>
				<g:each in="${reservas}" var="reserva" status="i">
					<tr>
						<td>${reserva?.cancha}</td>
						<td class="hidden-480"><g:formatDate date="${reserva?.dia}" format="dd-MM-yyyy" /></td>
						<td>${reserva?.horaInicio} - ${reserva?.horaFin}</td>
						<td>${reserva?.jugador}
							<g:remoteLink controller="reserva" action="selectJugadorToShow" id="${reserva?.id}" update="[success:'modal-box-form',failure:'error']" class="blue" onSuccess="setJugadorToShow();">
								<i class="icon-zoom-in bigger-120"></i>
							</g:remoteLink>
						</td>
						<td>${reserva?.tipoReserva}</td>
						<td>$ ${reserva?.precioTotal}</td>
						<td>$ ${reserva?.senia}</td>
						<td>$ ${reserva?.precioTotal - reserva?.senia}</td>
						<td>${reserva?.estado}</td>
						<td>
							<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
								
								<g:remoteLink controller="reserva" title="Marcar como pagada" action="concretarReserva" id="${reserva?.id}" update="[success:'tabla_reservas',failure:'error']" class="btn btn-xs btn-success" >
									<i class="icon-ok bigger-120"></i>
								</g:remoteLink>
						
								<!-- <g:remoteLink controller="reserva" action="seniarReserva" id="${reserva?.id}" update="[success:'tabla_reservas',failure:'error']" class="btn btn-xs btn-info" >
									<i class="icon-ok bigger-120"></i>
								</g:remoteLink> -->
						
								<g:remoteLink controller="reserva"  title="Marcar como cancelada" action="cancelarReserva" id="${reserva?.id}" update="[success:'tabla_reservas',failure:'error']" class="btn btn-xs btn-danger">
									<i class="icon-ban-circle bigger-120"></i>
								</g:remoteLink>
								
								<button class="btn btn-xs btn-info" onclick="selectToEdit('${reserva?.id}');">
									<i class="icon-edit bigger-120"></i>
								</button>
								
								<g:remoteLink controller="reserva" title="Eliminar reserva" action="deleteReserva" id="${reserva?.id}" update="[success:'tabla_reservas',failure:'error']" class="btn btn-xs btn-danger">
									<i class="icon-trash bigger-120"></i>
								</g:remoteLink>
							</div>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
	<!-- /.table-responsive -->
</div>

    <div class="pagination">
	    <g:paginate controller="reserva" action="administrarReservas" total="${reservasTotal}" />
	</div>
	
	<script type="text/javascript">

			function selectToEdit(reservaId) {
				alert(reservaId);
				var JSONObject = new Object;
			    JSONObject.reservaId = reservaId;
			    JSONObject.testes = "tests";
			    JSONstring = JSON.stringify(JSONObject);
			    
			    $.ajax({
			        url:   "${createLink(controller:'reserva', action:'selectToEdit')}",
			        data:  JSONObject,
			        type:  'post',
			        error: function(request, status, error) {
			            alert("Ha ocurrido un error: "+error);
			        }
			    });
			}
	
			function setJugadorToShow() {
				$('#modal-form').modal('show');
			}
	</script>
