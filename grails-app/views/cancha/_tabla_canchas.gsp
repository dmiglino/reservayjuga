<!-- inicio tabla -->		
	<div class="col-xs-12">
	<div class="table-responsive">
		<table id="sample-table-1" class="ajax table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<g:sortableColumn property="nombre" title="${message(code: 'comun.nombre.label', default: 'Nombre')}" />
					<g:sortableColumn property="deporte" title="${message(code: 'comun.deporte.label', default: 'Deporte')}" />
					<g:sortableColumn property="cantidadJugadores" title="${message(code: 'comun.cantidadJugadores.label', default: 'Cantidad de jugadores')}" />
					<g:sortableColumn property="cubierta" title="${message(code: 'comun.techado.label', default: 'Techado')}" />
					<g:sortableColumn property="superficie" title="${message(code: 'comun.superficie.label', default: 'Superficie')}" />
					<th>Acciones</th>
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
	<%--							<g:hiddenField name="idCancha" value="${cancha?.id}" />--%>
								<g:hiddenField name="nombreCancha" value="${cancha?.nombre}" />
								<g:hiddenField name="deporteCancha" value="${cancha?.deporte}" />
								<g:hiddenField name="cantidadJugadoresCancha" value="${cancha?.cantidadJugadores}" />
								<g:hiddenField name="cubiertaCancha" value="${cancha?.cubierta}" />
								<g:hiddenField name="superficieCancha" value="${cancha?.superficie}" />
									
								<a href="#modal-form" data-id="${cancha?.id}" role="button" class="open-EditCanchaModal btn btn-xs btn-info" data-toggle="modal"> <i class="icon-edit bigger-120"></i> </a>
								<g:remoteLink controller="cancha" action="deleteCancha" id="${cancha?.id}" update="[success:'canchasDiv',failure:'error']" class="btn btn-xs btn-danger"><i class="icon-trash bigger-120"></i></g:remoteLink>
							</div>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div><!-- /.table-responsive -->
    </div>

<%--    <div class="pagination">--%>
<%--	    <g:paginate total="${canchasTotal}" />--%>
<%--	</div>--%>