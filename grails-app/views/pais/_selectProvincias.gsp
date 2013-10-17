<%@ page import="ar.com.reservayjuga.reserva.Reserva" %>

<div class="form-group">
	<label class="col-sm-3 control-label no-padding-right" for="pais">
		<g:message code="ubicacion.provincia.label" default="Provincia" />
	</label>
	<g:if test="${provinciasList}">
		<g:select id="provincia" name="provincia.id" from="${provinciasList}"
			optionKey="id" required="" noSelection="['':'Selecciona una Provincia']" class="col-xs-4 col-sm-5-"
			onchange="${remoteFunction (
				controller: 'provincia',
				action: 'getLocalidades',
				params: '\'id=\' + this.value',
				update: 'localidadesDiv'
			)}"
			value="${complejo?.ubicacion?.pais?.provincias?.id}" class="many-to-one" />
	</g:if>
	<g:else>
		No existen provincias para este país
	</g:else>
</div>
