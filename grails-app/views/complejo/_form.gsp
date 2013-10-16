<%@ page import="ar.com.reservayjuga.complejo.Complejo" %>



<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="complejo.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${complejoInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'webSite', 'error')} ">
	<label for="webSite">
		<g:message code="complejo.webSite.label" default="Web Site" />
		
	</label>
	<g:textField name="webSite" value="${complejoInstance?.webSite}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'telefono1', 'error')} required">
	<label for="telefono1">
		<g:message code="complejo.telefono1.label" default="Telefono1" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono1" required="" value="${complejoInstance?.telefono1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'telefono2', 'error')} ">
	<label for="telefono2">
		<g:message code="complejo.telefono2.label" default="Telefono2" />
		
	</label>
	<g:textField name="telefono2" value="${complejoInstance?.telefono2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'telefono3', 'error')} ">
	<label for="telefono3">
		<g:message code="complejo.telefono3.label" default="Telefono3" />
		
	</label>
	<g:textField name="telefono3" value="${complejoInstance?.telefono3}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'telefono4', 'error')} ">
	<label for="telefono4">
		<g:message code="complejo.telefono4.label" default="Telefono4" />
		
	</label>
	<g:textField name="telefono4" value="${complejoInstance?.telefono4}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'mail', 'error')} ">
	<label for="mail">
		<g:message code="complejo.mail.label" default="Mail" />
		
	</label>
	<g:field type="email" name="mail" value="${complejoInstance?.mail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'informacionExtra', 'error')} ">
	<label for="informacionExtra">
		<g:message code="complejo.informacionExtra.label" default="Informacion Extra" />
		
	</label>
	<g:textArea name="informacionExtra" cols="40" rows="5" maxlength="1000" value="${complejoInstance?.informacionExtra}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'horarios', 'error')} ">
	<label for="horarios">
		<g:message code="complejo.horarios.label" default="Horarios" />
		
	</label>
	<g:select name="horarios" from="${ar.com.reservayjuga.complejo.Horario.list()}" multiple="multiple" optionKey="id" size="5" value="${complejoInstance?.horarios*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'imagenes', 'error')} ">
	<label for="imagenes">
		<g:message code="complejo.imagenes.label" default="Imagenes" />
		
	</label>
	<g:select name="imagenes" from="${ar.com.reservayjuga.complejo.Imagen.list()}" multiple="multiple" optionKey="id" size="5" value="${complejoInstance?.imagenes*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'canchas', 'error')} ">
	<label for="canchas">
		<g:message code="complejo.canchas.label" default="Canchas" />
		
	</label>
	<g:select name="canchas" from="${ar.com.reservayjuga.complejo.Cancha.list()}" multiple="multiple" optionKey="id" size="5" value="${complejoInstance?.canchas*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'reservas', 'error')} ">
	<label for="reservas">
		<g:message code="complejo.reservas.label" default="Reservas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${complejoInstance?.reservas?}" var="r">
    <li><g:link controller="reserva" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reserva" action="create" params="['complejo.id': complejoInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reserva.label', default: 'Reserva')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'servicios', 'error')} required">
	<label for="servicios">
		<g:message code="complejo.servicios.label" default="Servicios" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="servicios" name="servicios.id" from="${ar.com.reservayjuga.complejo.Servicios.list()}" optionKey="id" required="" value="${complejoInstance?.servicios?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: complejoInstance, field: 'ubicacion', 'error')} required">
	<label for="ubicacion">
		<g:message code="complejo.ubicacion.label" default="Ubicacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ubicacion" name="ubicacion.id" from="${ar.com.reservayjuga.complejo.Ubicacion.list()}" optionKey="id" required="" value="${complejoInstance?.ubicacion?.id}" class="many-to-one"/>
</div>

