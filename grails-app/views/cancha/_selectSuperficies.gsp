<div class="form-group">
	<g:if test="${superficiesDisponibles}">
		<label class="col-sm-2 control-label" for="superficie">
			<g:message code="enum.superficie.label" default="Superficie" />
		</label>
		<g:select id="cancha.superficie" 
			name="superficie" 
			from="${superficiesDisponibles}"
			required="" 
			noSelection="['':'Selecciona una Superficie']" 
			class="col-xs-4 col-sm-5-"
			optionValue="${ {superficie -> g.message(code:superficie.textCode)} }"
			value="${cancha?.superficie}" 
			class="many-to-one"
			onchange="setSuperficieCanchaValue(this.value);" />
	</g:if>
	<g:else>
		No existen barrios para esta localidad
	</g:else>
</div>

<script type="text/javascript">
		function setSuperficieCanchaValue(value) {
			document.getElementById("superficieCancha").value = value;
		}
</script>