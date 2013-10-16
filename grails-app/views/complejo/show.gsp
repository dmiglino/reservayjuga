
<%@ page import="ar.com.reservayjuga.complejo.Complejo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'complejo.label', default: 'Complejo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-complejo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-complejo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list complejo">
			
				<g:if test="${complejoInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="complejo.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${complejoInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.webSite}">
				<li class="fieldcontain">
					<span id="webSite-label" class="property-label"><g:message code="complejo.webSite.label" default="Web Site" /></span>
					
						<span class="property-value" aria-labelledby="webSite-label"><g:fieldValue bean="${complejoInstance}" field="webSite"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.telefono1}">
				<li class="fieldcontain">
					<span id="telefono1-label" class="property-label"><g:message code="complejo.telefono1.label" default="Telefono1" /></span>
					
						<span class="property-value" aria-labelledby="telefono1-label"><g:fieldValue bean="${complejoInstance}" field="telefono1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.telefono2}">
				<li class="fieldcontain">
					<span id="telefono2-label" class="property-label"><g:message code="complejo.telefono2.label" default="Telefono2" /></span>
					
						<span class="property-value" aria-labelledby="telefono2-label"><g:fieldValue bean="${complejoInstance}" field="telefono2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.telefono3}">
				<li class="fieldcontain">
					<span id="telefono3-label" class="property-label"><g:message code="complejo.telefono3.label" default="Telefono3" /></span>
					
						<span class="property-value" aria-labelledby="telefono3-label"><g:fieldValue bean="${complejoInstance}" field="telefono3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.telefono4}">
				<li class="fieldcontain">
					<span id="telefono4-label" class="property-label"><g:message code="complejo.telefono4.label" default="Telefono4" /></span>
					
						<span class="property-value" aria-labelledby="telefono4-label"><g:fieldValue bean="${complejoInstance}" field="telefono4"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.mail}">
				<li class="fieldcontain">
					<span id="mail-label" class="property-label"><g:message code="complejo.mail.label" default="Mail" /></span>
					
						<span class="property-value" aria-labelledby="mail-label"><g:fieldValue bean="${complejoInstance}" field="mail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.informacionExtra}">
				<li class="fieldcontain">
					<span id="informacionExtra-label" class="property-label"><g:message code="complejo.informacionExtra.label" default="Informacion Extra" /></span>
					
						<span class="property-value" aria-labelledby="informacionExtra-label"><g:fieldValue bean="${complejoInstance}" field="informacionExtra"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.horarios}">
				<li class="fieldcontain">
					<span id="horarios-label" class="property-label"><g:message code="complejo.horarios.label" default="Horarios" /></span>
					
						<g:each in="${complejoInstance.horarios}" var="h">
						<span class="property-value" aria-labelledby="horarios-label"><g:link controller="horario" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.imagenes}">
				<li class="fieldcontain">
					<span id="imagenes-label" class="property-label"><g:message code="complejo.imagenes.label" default="Imagenes" /></span>
					
						<g:each in="${complejoInstance.imagenes}" var="i">
						<span class="property-value" aria-labelledby="imagenes-label"><g:link controller="imagen" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.canchas}">
				<li class="fieldcontain">
					<span id="canchas-label" class="property-label"><g:message code="complejo.canchas.label" default="Canchas" /></span>
					
						<g:each in="${complejoInstance.canchas}" var="c">
						<span class="property-value" aria-labelledby="canchas-label"><g:link controller="cancha" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.reservas}">
				<li class="fieldcontain">
					<span id="reservas-label" class="property-label"><g:message code="complejo.reservas.label" default="Reservas" /></span>
					
						<g:each in="${complejoInstance.reservas}" var="r">
						<span class="property-value" aria-labelledby="reservas-label"><g:link controller="reserva" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.servicios}">
				<li class="fieldcontain">
					<span id="servicios-label" class="property-label"><g:message code="complejo.servicios.label" default="Servicios" /></span>
					
						<span class="property-value" aria-labelledby="servicios-label"><g:link controller="servicios" action="show" id="${complejoInstance?.servicios?.id}">${complejoInstance?.servicios?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${complejoInstance?.ubicacion}">
				<li class="fieldcontain">
					<span id="ubicacion-label" class="property-label"><g:message code="complejo.ubicacion.label" default="Ubicacion" /></span>
					
						<span class="property-value" aria-labelledby="ubicacion-label"><g:link controller="ubicacion" action="show" id="${complejoInstance?.ubicacion?.id}">${complejoInstance?.ubicacion?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${complejoInstance?.id}" />
					<g:link class="edit" action="edit" id="${complejoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
