
<%@ page import="ar.com.reservayjuga.complejo.Complejo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'complejo.label', default: 'Complejo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-complejo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-complejo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'complejo.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="webSite" title="${message(code: 'complejo.webSite.label', default: 'Web Site')}" />
					
						<g:sortableColumn property="telefono1" title="${message(code: 'complejo.telefono1.label', default: 'Telefono1')}" />
					
						<g:sortableColumn property="telefono2" title="${message(code: 'complejo.telefono2.label', default: 'Telefono2')}" />
					
						<g:sortableColumn property="telefono3" title="${message(code: 'complejo.telefono3.label', default: 'Telefono3')}" />
					
						<g:sortableColumn property="telefono4" title="${message(code: 'complejo.telefono4.label', default: 'Telefono4')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${complejoInstanceList}" status="i" var="complejoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${complejoInstance.id}">${fieldValue(bean: complejoInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: complejoInstance, field: "webSite")}</td>
					
						<td>${fieldValue(bean: complejoInstance, field: "telefono1")}</td>
					
						<td>${fieldValue(bean: complejoInstance, field: "telefono2")}</td>
					
						<td>${fieldValue(bean: complejoInstance, field: "telefono3")}</td>
					
						<td>${fieldValue(bean: complejoInstance, field: "telefono4")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${complejoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
