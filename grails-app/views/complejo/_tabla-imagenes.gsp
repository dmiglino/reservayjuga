<!-- inicio tabla -->		
										<div class="col-sm-8">
										<div class="table-responsive">
										
											<table id="imagenesTable" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<g:sortableColumn property="imagenes.nombre" title="${message(code: 'comun.nombre.label', default: 'Nombre')}" />
														<g:sortableColumn property="imagenes.descripcion" title="${message(code: 'comun.descripcion.label', default: 'Descripcion')}" />

														<th>
															<i class="icon-time bigger-110 hidden-480"></i>
															Fecha
														</th>
														<th class="hidden-480">Portada</th>

														<th>Acciones</th>
													</tr>
												</thead>
												
												<tbody>
													<g:each in="${imagenes}" var="imagen" status="i">
														<tr>
															<td>${imagen?.nombre}</td>
															<td>${imagen?.descripcion}</td>
															<td><g:formatDate date="${imagen?.fecha}" format="yyyy-MM-dd" /></td>
															<td class="hidden-480"><g:formatBoolean boolean="${imagen?.portada}" true="SI" false="NO" /></td>
	
															<td>
																<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
																	<button class="btn btn-xs btn-info">
																		<i class="icon-edit bigger-120"></i>
																	</button>
	
																	<g:hiddenField name="idImagen" value="${imagen?.id}" />
																	<g:remoteLink controller="complejo" action="deleteImagen" id="${imagen?.id}" update="[success:'imagenesDiv',failure:'error']" class="btn btn-xs btn-danger"><i class="icon-trash bigger-120"></i></g:remoteLink>
				
																</div>
	
															</td>
														</tr>
													</g:each>
												</tbody>
											</table>
										</div><!-- /.table-responsive -->
									    </div><!-- fin tabla -->