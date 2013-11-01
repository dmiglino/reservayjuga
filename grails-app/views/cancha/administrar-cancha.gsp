<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="layout" content="main"/>
		<title><g:message code="cancha.titulo.label" default="Administracion de Canchas" /></title>
	</head>

	<body>

<%--		inicio main-container--%>

					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#"><g:message code="sidebar.panel.label" default="Panel de Control" /></a>
							</li>

							<li>
								<a href="#"><g:message code="sidebar.administrar.cancha.label" default="Administrar Canchas" /></a>
							</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
							    <small>
									Listado de canchas
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<g:form action="agregarCancha" class="form-horizontal" role="form" >
							
						            <div class="row" id="tabla_canchas" >

						            	<g:render template="tabla_canchas" model="['cancha':cancha]" />
						            									
									</div>
                                    
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<g:actionSubmit action="agregarCancha" class="btn btn-info" value="Agregar Cancha" />
											&nbsp; &nbsp; &nbsp;
										</div>
									</div>
								</g:form>
								</div>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
                
                           <!-- comienzo DEL MODAL BOX PARA EDITAR -->
                           <g:formRemote name="formEditCancha" url="[controller:'cancha', action:'editarCancha']">
                				<div id="modal-form" class="modal" tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="blue bigger"><g:message code="cancha.edicion.label" default="Edicion de Cancha" /></h4>
											</div>

											<div class="modal-body overflow-visible">
												<div class="row">
												    <div class="col-xs-8 col-sm-8">
														<div class="space-4"></div>

														<g:hiddenField name="idCanchaEdit" value="" />
														
<%--                                            			<g:render template="form_cancha" model="['cancha':['nombre':'asd','deporte':'FUTBOL','cubierta':true], 'edit':true]" />--%>
                                            	
														<div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-username"><g:message code="common.nombre.label" default="Nombre" /></label>

															<div>
																<g:textField name="nombreCanchaEdit" value="${cancha?.nombre}" class="col-sm-6" id="nombreCanchaEdit" />
															</div>
														</div>

														<div class="space-4"></div>
                                                        
                                                        <div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-select-3"><g:message code="common.techado.label" default="Techado" /></label>
															<div>
																<g:select id="cubiertaCanchaEdit" 
																	name="cubiertaCanchaEdit"
																	from="${["true","false"]}"
																	noSelection="['':'']"
																	class="chosen-select one-to-one"
																	value=""  />
															</div>
														</div>
														
														<div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-select-3"><g:message code="common.deporte.label" default="Deporte" /></label>
															<div>
																<g:select id="deporteCanchaEdit" 
																	name="deporteCanchaEdit"
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
														
														<g:hiddenField id="superficieCancha" name="superficieCanchaEdit" value="" />
												
														<div id="superficiesDiv" class="form-group">
															<g:if test="${cancha?.deporte}">
																<g:include controller="cancha" action="getSuperficies" id="${cancha?.deporte}" />
															</g:if>
														</div>
														
<%--														<g:hiddenField id="superficieCancha" name="cancha.superficie" value="" />--%>
														
														<div class="space-4"></div>
														
														<div class="form-group">
															<label class="col-sm-6 control-label" for="form-field-select-3"><g:message code="common.cantidad.jugadores.label" default="Cantidad de Jugadores" /></label>
														    <div>
																<g:textField name="cantidadJugadoresCanchaEdit" value="" class="input-mini" id="cantidadJugadoresCanchaEdit" />
														    </div>
														</div>
														
													</div>
												</div>
											</div>

											<div class="modal-footer">
												<button class="btn btn-sm" data-dismiss="modal">
													<i class="icon-remove"></i>
													<g:message code="common.cancelar.label" default="Cancelar" />
												</button>

												<g:submitToRemote class="btn btn-info" update="[success:'canchasDiv']" after="closeModal();"
													url="[controller:'cancha', action:'editarCancha']" value="Grabar Cancha" >
													<i class="icon-ok"></i>
												</g:submitToRemote>
											</div>
										</div>
									</div>
								</div>
							</g:formRemote>
                <!-- FIN DEL MODAL BOX PARA EDITAR -->
                

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		
			function closeModal() {
				$('#modal-form').modal('hide');
			}
	
			$(document).on("click", ".open-EditCanchaModal", function () {
			     var canchaId = $(this).data('id');
<%--			     var nombre = document.getElementById("nombreCancha").value; --%>
<%--			     var deporte = document.getElementById("deporteCancha").value; --%>
<%--			     var cantidadJugadores = document.getElementById("cantidadJugadoresCancha").value; --%>
<%--			     var cubierta = document.getElementById("cubiertaCancha").value; --%>
<%--			     var superficie = document.getElementById("superficieCancha").value; --%>
			     $(".modal-body #idCanchaEdit").val(canchaId);
<%--			     $(".modal-body #nombreCanchaEdit").val(nombre); --%>
<%--			     $(".modal-body #deporteCanchaEdit").val(deporte); --%>
<%--			     $(".modal-body #cantidadJugadoresCanchaEdit").val(cantidadJugadores); --%>
<%--			     $(".modal-body #cubiertaCanchaEdit").value(cubierta); --%>
<%--			     $(".modal-body #superficieCanchaEdit").val(superficie); --%>
					var newData = $.post("${createLink(controller: 'cancha', action: 'selectToEdit')}/"+canchaId);
					alert("dat: "+newData);
					alert("can: "+newData.cancha);
				$.ajax({ 
			        context: $(this),
			        url:"selectToEdit/"+canchaId,
			        type:"POST",
			        data:{"id":canchaId},
			        success:function(data){
			        	alert(data);
			        }
				});
			});
		</script>

	</body>
</html>