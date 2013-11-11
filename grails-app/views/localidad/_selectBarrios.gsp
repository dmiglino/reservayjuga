<div class="form-group">
	<g:if test="${barriosList}">
		<label class="col-sm-2 control-label" for="barrio">
			<g:message code="ubicacion.barrio.label" default="Barrio" />
		</label>
		<div class="col-sm-3">
			<g:select id="barrio" name="barrio.id" from="${barriosList}"
				optionKey="id" required="" noSelection="['':'Selecciona un Barrio']" class="col-sm-12"
				value="${complejo?.ubicacion?.barrio?.id}" class="many-to-one" />
		</div>
	</g:if>
	<g:else>
		No existen barrios para esta localidad
	</g:else>
</div>
