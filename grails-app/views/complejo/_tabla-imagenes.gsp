	<!-- inicio tabla -->		
	<div class="col-sm-8">
		<div class="table-responsive">
		
			<table id="imagenesTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
<%--						<g:sortableColumn params="[controller:'complejo', action:'ordenarImagenes']" property="nombre" title="${message(code: 'common.nombre.label', default: 'Nombre')}" />--%>
<%--						<g:sortableColumn params="[controller:'complejo', action:'ordenarImagenes']" property="descripcion" title="${message(code: 'common.descripcion.label', default: 'Descripcion')}" />--%>
						<th class="hidden-480"><g:message code="common.nombre.label" default="Nombre" /></th>
						<th class="hidden-480"><g:message code="common.descripcion.label" default="Descripcion" /></th>
						<th>
							<i class="icon-time bigger-110 hidden-480"></i>
							<g:message code="common.fecha.label" default="Fecha" />
						</th>
<%--						<g:sortableColumn params="[controller:'complejo', action:'ordenarImagenes']" property="portada" title="${message(code: 'common.portada.label', default: 'Portada')}" />--%>
						<th class="hidden-480"><g:message code="common.portada.label" default="Portada" /></th>
						<th>
							<g:message code="common.tabla.acciones.label" default="Acciones" />
							<g:if test="${imagenes}">
								&nbsp;&nbsp;
								<g:remoteLink controller="complejo" action="deleteAllImagenes" id="${imagen?.id}" update="[success:'imagenesDiv',failure:'error']" class="btn btn-xs btn-danger"><i class="icon-trash bigger-120"></i></g:remoteLink>
							</g:if>
						</th>
					</tr>
				</thead>
				
				<tbody>
					<g:each in="${imagenes}" var="imagen" status="i">
						<tr>
							<td>${imagen?.nombre}</td>
							<td>${imagen?.descripcion}</td>
							<td><g:formatDate date="${imagen?.fecha}" format="dd-MM-yyyy" /></td>
							<td class="hidden-480"><g:formatBoolean boolean="${imagen?.portada}" true="SI" false="NO" /></td>
		
							<td>
								<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
		<%--						<g:hiddenField name="idImagen" value="${imagen?.id}" />--%>
									<g:hiddenField name="nombreImagen" value="${imagen?.nombre}" />
									<g:hiddenField name="descripcionImagen" value="${imagen?.descripcion}" />
									<g:hiddenField name="portadaImagen" value="${imagen?.portada}" />
<%--									<g:hiddenField name="fotoImagen" value="${imagen?.foto}" />--%>
										
									<a href="#modal-form" data-id="${imagen?.id}" role="button" class="open-EditImageModal btn btn-xs btn-info" data-toggle="modal"> <i class="icon-edit bigger-120"></i> </a>
									<g:remoteLink controller="complejo" action="deleteImagen" id="${imagen?.id}" update="[success:'imagenesDiv',failure:'error']" class="btn btn-xs btn-danger"><i class="icon-trash bigger-120"></i></g:remoteLink>
								</div>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div><!-- /.table-responsive -->
		    
	    <div class="pagination">
		    <util:remotePaginate total="${imagenesTotal}" update="imagenesDiv" controller="complejo" action="ordenarImagenes" pageSizes="[5: '5 on Page',10:'10 on Page',15:'15 on Page']" max="5" />
		</div>
	
	</div><!-- fin tabla -->
