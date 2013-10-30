<div class="form-group">
	<g:if test="${barriosList}">
		<label class="col-sm-3 control-label" for="barrio">
			<g:message code="ubicacion.barrio.label" default="Barrio" />
		</label>
		<g:select id="barrio" name="barrio.id" from="${barriosList}"
			optionKey="id" required="" noSelection="['':'Selecciona un Barrio']" class="col-xs-4 col-sm-5-"
			value="${complejo?.ubicacion?.barrio?.id}" class="many-to-one" />
	</g:if>
	<g:else>
		No existen barrios para esta localidad
	</g:else>
</div>
