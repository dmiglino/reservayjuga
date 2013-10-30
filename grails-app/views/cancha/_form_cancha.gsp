
												<div class="form-group">
													<label class="col-sm-2 control-label" for="form-field-username">Nombre</label>

													<div>
														<g:textField name="cancha.nombre" value="${cancha?.nombre}" class="col-sm-6" id="form-field-username" />
													</div>
												</div>
												
												<div class="space-4"></div>
										
                                                <div class="form-group">
													<label class="col-sm-2 control-label" for="form-field-select-3">Techado</label>
													<div>
														<g:select id="cubierta" 
															name="cancha.cubierta"
															from="${["true","false"]}"
															noSelection="['':'']"
															class="chosen-select one-to-one"
															value="${cancha?.cubierta}"  />
													</div>
												</div>
												
												<div class="space-4"></div>
												
												<div class="form-group">
													<label class="col-sm-2 control-label" for="form-field-select-3">Deporte</label>
														<g:select id="deporte" 
															name="cancha.deporte"
															from="${deportesDisponibles}"
															noSelection="['':'']"
															class="chosen-select one-to-one"
															optionValue="${ {deporte -> g.message(code:deporte.textCode)} }"
															value="${cancha?.deporte}" 
															onchange="${remoteFunction (
																controller: 'cancha',
																action: 'getSuperficies',
																params: '\'id=\' + this.value',
																update: 'superficiesDiv'
															)}" />
													</div>
												</div>
												
												<div id="superficiesDiv" class="form-group">
													<g:if test="${cancha?.deporte}">
														<g:include controller="cancha" action="getSuperficies" id="${cancha?.deporte}" />
													</g:if>
												</div>
												
												<g:hiddenField id="superficieCancha" name="cancha.superficie" value="" />
												
												<div class="form-group">
													<label class="col-sm-2 control-label" for="form-field-select-3">Cantidad de jugadores</label>
												    <div>
												    	<g:textField name="cancha.cantidadJugadores" value="${cancha?.cantidadJugadores}" class="input-mini" />
<%--														<g:textField name="cancha.cantidadJugadores" value="" class="input-mini" id="spinner1" />--%>
												    </div>
												</div>
												
                                               <div class="page-header">
						                            <h1>
						                                <small>
								                            Precios
							                            </small>
						                            </h1>
					                           </div>      
				                 
				                				<g:if test="${!edit}">
						                           <div class="clearfix form-actions">
											           <div class="col-md-offset-3 col-md-9">
															<g:actionSubmit action="administrarCancha" class="btn btn-info" value="Volver" />
															<g:actionSubmit action="crearCancha" class="btn btn-info" value="Crear Cancha" />
												            &nbsp; &nbsp; &nbsp;
											           </div>
									   				</div>
									   			</g:if>
									   			
					                           <g:else>
							                    	<div class="modal-footer">
														<button class="btn btn-sm" data-dismiss="modal">
															<i class="icon-remove"></i>
															Cancel
														</button>
		
														<g:submitToRemote class="btn btn-info" update="[success:'canchasDiv']" after="closeModal();"
															url="[controller:'cancha', action:'editarCancha']" value="Grabar Cancha" >
															<i class="icon-ok"></i>
														</g:submitToRemote>
													</div>
					                           </g:else>