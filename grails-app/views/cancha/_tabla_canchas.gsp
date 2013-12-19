<!-- inicio tabla -->		
	<div class="col-xs-12">
	<div class="table-responsive">
		<table id="sample-table-1" class="ajax table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<g:sortableColumn property="nombre" title="${message(code: 'common.nombre.label', default: 'Nombre')}" />
					<g:sortableColumn property="deporte" title="${message(code: 'common.deporte.label', default: 'Deporte')}" />
					<g:sortableColumn property="cantidadJugadores" title="${message(code: 'common.cantidad.jugadores.label', default: 'Cantidad de jugadores')}" />
					<g:sortableColumn property="cubierta" title="${message(code: 'common.techado.label', default: 'Techado')}" />
					<g:sortableColumn property="superficie" title="${message(code: 'common.superficie.label', default: 'Superficie')}" />
					<th><g:message code="common.tabla.acciones.label" default="Acciones" /></th>
				</tr>
			</thead>

			<tbody>
				<g:each in="${canchas}" var="cancha" status="i">
					<tr>
						<td>${cancha?.nombre}</td>
						<td>${cancha?.deporte}</td>
						<td>${cancha?.cantidadJugadores}</td>
						<td class="hidden-480"><g:formatBoolean boolean="${cancha?.cubierta}" true="SI" false="NO" /></td>
						<td>${cancha?.superficie}</td>
						
						<td>
							<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
								<g:remoteLink controller="cancha" action="selectToEdit" id="${cancha?.id}" update="[success:'modal-box-form',failure:'error']" class="btn btn-xs btn-info" onSuccess="setCanchaToEdit();"><i class="icon-edit bigger-120"></i></g:remoteLink>
								<g:remoteLink controller="cancha" action="deleteCancha" id="${cancha?.id}" update="[success:'tabla_canchas',failure:'error']" class="btn btn-xs btn-danger"><i class="icon-trash bigger-120"></i></g:remoteLink>
							</div>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div><!-- /.table-responsive -->
    </div>

    <div class="pagination">
	    <g:paginate controller="cancha" action="administrarCancha" total="${canchasTotal}" />
	</div>
	
	<script>
		function setCanchaToEdit() {
			$('#modal-form').modal('show');
			var label = document.getElementById("superficieLabel");
			label.setAttribute("class", "col-sm-3 control-label");
			var select = document.getElementById("cancha.superficie");
			select.setAttribute("class", "width-50");
		}
	</script>