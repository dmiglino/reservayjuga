<!-- inicio tabla -->
<div class="col-xs-12">
	<div class="table-responsive">
		<table id="sample-table-1" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<g:sortableColumn property="cancha" title="${message(code: 'reserva.field.cancha.label', default: 'Cancha')}" />
					<g:sortableColumn property="dia" title="${message(code: 'reserva.field.dia.label', default: 'Dia')}" />
					<g:sortableColumn property="horario" title="${message(code: 'reserva.field.horario.label', default: 'Horario')}" />
					<g:sortableColumn property="jugador" title="${message(code: 'reserva.field.jugador.label', default: 'Jugador')}" />
					<g:sortableColumn property="tipoReserva" title="${message(code: 'reserva.field.tipoReserva.label', default: 'Tipo de Reserva')}" />
					<g:sortableColumn property="precioTotal" title="${message(code: 'reserva.field.precioTotal.label', default: 'Precio total')}" />
					<g:sortableColumn property="seniaPagada" title="${message(code: 'reserva.field.seniaPagada.label', default: 'Seña pagada')}" />
					<g:sortableColumn property="faltante" title="${message(code: 'reserva.field.faltante.label', default: 'Faltante')}" />
					<g:sortableColumn property="estado" title="${message(code: 'reserva.field.estado.label', default: 'Estado')}" />
					<th><g:message code="common.tabla.acciones.label" default="Acciones" /></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>Cancha 1 - Camp Nou</td>
					<td class="hidden-480">25-08-2013</td>
					<td>15:00-16:00</td>
					<td>Tomas Escamez 
						<a href="#modal-form" role="button" class="tooltip-info" title="Ver detalles" data-toggle="modal"> 
							<span class="blue"> 
								<i class="icon-zoom-in bigger-120"></i>
							</span>
						</a>
					</td>
					<td>Online</td>
					<td>$500</td>
					<td>$150</td>
					<td>$0</td>
					<td>Concretada</td>
					<td>
						<div
							class="visible-md visible-lg hidden-sm hidden-xs btn-group">
							<button class="btn btn-xs btn-info" title="Editar">
								<i class="icon-edit bigger-120"></i>
							</button>
							<button class="btn btn-xs btn-danger" title="Eliminar">
								<i class="icon-trash bigger-120"></i>
							</button>
						</div>
					</td>
				</tr>

				<tr>
					<td>Cancha 2 - San Siro</td>
					<td class="hidden-480">26-08-2013</td>
					<td>17:00-18:00</td>
					<td>Diego Miglino <a href="#modal-form" role="button"
						class="tooltip-info" title="Ver detalles"
						data-toggle="modal"> <span class="blue"> <i
								class="icon-zoom-in bigger-120"></i>
						</span>
					</a>
					</td>
					<td>Presencial</td>
					<td>$500</td>
					<td>$130</td>
					<td style="color: Red;">$370</td>
					<td>Pendiente</td>
					<td>
						<div
							class="visible-md visible-lg hidden-sm hidden-xs btn-group">
							<button class="btn btn-xs btn-success"
								title="Marcar como pagada">
								<i class="icon-ok bigger-120"></i>
							</button>
							<button class="btn btn-xs btn-info" title="Editar">
								<i class="icon-edit bigger-120"></i>
							</button>
							<button class="btn btn-xs btn-danger" title="Eliminar">
								<i class="icon-trash bigger-120"></i>
							</button>
						</div>
					</td>
				</tr>

				<tr>
					<td>Cancha 3 - San Genaro</td>
					<td class="hidden-480">26-08-2013</td>
					<td>21:00-22:00</td>
					<td>Matias Perez <a href="#modal-form" role="button"
						class="tooltip-info" title="Ver detalles"
						data-toggle="modal"> <span class="blue"> <i
								class="icon-zoom-in bigger-120"></i>
						</span>
					</a>
					</td>
					<td>Presencial</td>
					<td>$520</td>
					<td>$140</td>
					<td style="color: Red;">$380</td>
					<td>Pendiente</td>
					<td>
						<div
							class="visible-md visible-lg hidden-sm hidden-xs btn-group">
							<button class="btn btn-xs btn-success"
								title="Marcar como pagada">
								<i class="icon-ok bigger-120"></i>
							</button>
							<g:remoteLink controller="reserva" action="selectToEdit" id="${reserva?.id}" update="[success:'modal-box-form',failure:'error']" class="btn btn-xs btn-info" onSuccess="setReservaToEdit();"><i class="icon-edit bigger-120"></i></g:remoteLink>
							<button class="btn btn-xs btn-info" title="Editar">
								<i class="icon-edit bigger-120"></i>
							</button>
							<button class="btn btn-xs btn-danger" title="Eliminar">
								<i class="icon-trash bigger-120"></i>
							</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- /.table-responsive -->
</div>