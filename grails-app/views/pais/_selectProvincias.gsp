<%@ page import="ar.com.reservayjuga.reserva.Reserva" %>

<div class="form-group">
	<g:if test="${provinciasList}">
		<label class="col-sm-2 control-label" for="provincia">
			<g:message code="ubicacion.provincia.label" default="Provincia" />
		</label>
		<div class="col-sm-3">
			<g:select id="provincia" name="provincia.id" 
				from="${provinciasList}"
				optionKey="id" required="" 
				noSelection="['':'Selecciona una Provincia']" class="col-sm-12"
				onchange="${remoteFunction (
					controller: 'provincia',
					action: 'getLocalidades',
					params: '\'id=\' + this.value',
					update: 'localidadesDiv'
				)}"
				value="${complejo?.ubicacion?.provincia?.id}" class="many-to-one" />
		</div>
	</g:if>
	<g:else>
		No existen provincias para este país
	</g:else>
</div>

<div id="localidadesDiv" class="">
	<g:if test="${complejo?.ubicacion?.provincia}">
		<g:include controller="provincia" action="getLocalidades" id="${complejo?.ubicacion?.provincia?.id}" />
	</g:if>
</div>