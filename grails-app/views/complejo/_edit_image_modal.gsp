	<div id="modal-form" class="modal" tabindex="-1">
		<div class="modal-dialog" >
			<div class="modal-content" >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="blue bigger"><g:message code="modal.imagen.titulo.label" default="Edicion de imagenes" /></h4>
				</div>
	
				<div class="modal-body overflow-visible">
					<div class="row">
						<div class="col-xs-12 col-sm-5">
							<div class="space"></div>
							<div id="input-file" >
								<input type="file" name="fotoImagenEdit" value="" />
							</div>
							<div id="vista_previa"><!-- miniatura --><g:message code="modal.imagen.vistaprevia.label" default="Vista previa" /></div>
						</div>
	
						<div class="col-xs-12 col-sm-7">
							
							<g:hiddenField name="idImagenEdit" value="" />
								
							<div class="form-group">
								<label for="form-field-first"><g:message code="common.nombre.label" default="Nombre" /></label>
								<div>
									<g:textField name="nombreImagenEdit" value="" class="input-medium" id="nombreImagenEdit" />
								</div>
							</div>
							
							<div class="space-4"></div>
	
							<div class="form-group">
								<label for="form-field-username"><g:message code="common.descripcion.label" default="Descripcion" /></label>
	
								<div>
									<g:textField name="descripcionImagenEdit" value="" class="input-large" id="descripcionImagenEdit" />
								</div>
							</div>
	
							<div class="space-4"></div>
							
							<div class="form-group">
								<label for="form-field-select-3"><g:message code="common.portada.label" default="Portada" /></label>
	
								<div>
									<g:select id="portadaImagenEdit" 
										name="portadaImagenEdit"
										from="${["true","false"]}"
										noSelection="['':'']"
										class="chosen-select one-to-one"
										value=""  />
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
	
					<g:submitToRemote class="btn btn-info" update="[success:'imagenesDiv']" after="closeModal();"
						url="[controller:'imagen', action:'editarImagen']" value="${message(code: 'button.grabar.imagen.label',default: 'Grabar Imagen')}" >
						<i class="icon-ok"></i>
					</g:submitToRemote>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function closeModal() {
			$('#modal-form').modal('hide');
		}
	</script>
		