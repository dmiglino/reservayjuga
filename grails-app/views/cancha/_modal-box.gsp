<%@page import="ar.com.reservayjuga.complejo.DeporteEnum"%>
<g:formRemote name="formEditCancha" url="[controller:'cancha', action:'editarCancha']" >
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

							<g:hiddenField name="idCanchaEdit" value="${cancha?.id}" />
<%--                        <g:render template="form_cancha" model="['edit':true]" />--%>
                                     	
							<div class="form-group">
								<label class="col-sm-6 control-label" for="form-field-username"><g:message code="common.nombre.label" default="Nombre" /></label>
								<div>
									<g:textField name="cancha.nombre" value="${cancha?.nombre}" class="col-sm-6" id="nombreCanchaEdit" />
								</div>
							</div>

							<div class="space-4"></div>
                                                 
                            <div class="form-group">
								<label class="col-sm-6 control-label" for="form-field-select-3"><g:message code="common.techado.label" default="Techado" /></label>
								<div>
									<g:select id="cubiertaCanchaEdit" 
										name="cancha.cubierta"
										from="${["true","false"]}"
										noSelection="['':'']"
										class="col-xs-4 col-sm-6-"
										value="${cancha?.cubierta}"  />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-6 control-label" for="form-field-select-3"><g:message code="common.deporte.label" default="Deporte" /></label>
								<div>
									<g:select id="deporteCanchaEdit" 
										name="cancha.deporte"
										from="${DeporteEnum.values()}"
										noSelection="['':'']"
										class="col-xs-4 col-sm-6-"
										optionValue="${ {deporte -> g.message(code:deporte.textCode)} }"
										value="${cancha?.deporte}" 
										onchange="${remoteFunction (
											controller: 'cancha',
											action: 'getSuperficies',
											params: '\'id=\' + this.value',
											update: 'superficiesDiv'
										)}"
										/>
								</div>
							</div>
							
							<div class="space-4"></div>
					
							<div id="superficiesDiv" class="form-group">
								<g:if test="${cancha?.deporte}">
									<g:include controller="cancha" action="getSuperficies" params="[id:cancha?.deporte, cancha:cancha]" />
								</g:if>
							</div>
							
							<div class="space-4"></div>
							
							<div class="form-group">
								<label class="col-sm-6 control-label" for="form-field-select-3"><g:message code="common.cantidad.jugadores.label" default="Cantidad de Jugadores" /></label>
							    <div>
									<g:textField name="cancha.cantidad" value="${cancha?.cantidadJugadores}" class="input-mini" id="spinner1" onchange="setCantJugValue();"/>
									<g:hiddenField name="cancha.cantidadJugadores" id="cantJugValue" value="${cancha?.cantidadJugadores}" />
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

					<g:submitToRemote class="btn btn-info" update="[success:'tabla_canchas',failure:'error']" after="closeModal();"
						url="[controller:'cancha', action:'editarCancha']" value="${message(code: 'button.grabar.cancha.label',default: 'Grabar Cancha')}" >
						<i class="icon-ok"></i>
					</g:submitToRemote>
				</div>
			</div>
		</div>
	</div>
</g:formRemote>

<script type="text/javascript">
	function setCantJugValue() {
		var spinnerValue = document.getElementById('spinner1').value;
		document.getElementById('cantJugValue').value = spinnerValue;
	}
	
	function mantenerCssDeSuperficie() {
		var label = document.getElementById("superficieLabel");
		label.setAttribute("class", "col-sm-6 control-label");
		var select = document.getElementById("cancha.superficie");
		select.setAttribute("class", "col-xs-4 col-sm-6-");
	}
</script>