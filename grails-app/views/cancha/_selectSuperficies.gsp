<%--<div class="form-group">--%>
	<g:if test="${superficiesDisponibles}">
<%--		<script>--%>
<%--			mantenerCssDeSuperficie();--%>
<%--		</script>--%>
		<label class="col-sm-2 control-label" for="superficie" id="superficieLabel">
			<g:message code="enum.superficie.label" default="Superficie" />
		</label>
		<g:select id="cancha.superficie" 
			name="cancha.superficie" 
			from="${superficiesDisponibles}"
			required="" 
			noSelection="['':'Selecciona una Superficie']" 
			class="col-xs-4 col-sm-5-"
			optionValue="${ {superficie -> g.message(code:superficie.textCode)} }"
			value="${cancha?.superficie}" 
			class="many-to-one" />
	</g:if>
	<g:else>
		No existen barrios para esta localidad
	</g:else>
<%--</div>--%>

