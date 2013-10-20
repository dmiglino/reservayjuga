<%@ page import="ar.com.reservayjuga.reserva.Reserva" %>

<div class="form-group">
	<g:if test="${localidadesList}">
		<label class="col-sm-3 control-label" for="localidad">
			<g:message code="ubicacion.localidad.label" default="Localidad" />
		</label>
		<g:select id="localidad" name="localidad.id" from="${localidadesList}"
			optionKey="id" required="" noSelection="['':'Selecciona una Localidad']" class="col-xs-4 col-sm-5-"
			onchange="${remoteFunction (
				controller: 'localidad',
				action: 'getBarrios',
				params: '\'id=\' + this.value',
				update: 'barriosDiv'
			)}"
			value="${complejo?.ubicacion?.localidad?.id}" class="many-to-one" />
	</g:if>
	<g:else>
		No existen localidades para esta provincia
	</g:else>
</div>

<div id="barriosDiv" class="form-group">
	<g:if test="${complejo?.ubicacion?.localidad}">
		<g:include controller="localidad" action="getBarrios" id="${complejo?.ubicacion?.localidad?.id}" />
	</g:if>
</div>