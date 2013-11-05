<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="layout" content="main"/>
		<title><g:message code="sistema.principal.titulo.label" default="Pagina Principal del Sistema" /></title>
	</head>

	<body>
		<div class="page-content">
			<div class="page-header">
				<h1>
					<small> <g:message code="panelcontrol.titulo.label" default="Panel de Control" /> </small>
				</h1>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
						
						<ul class="nav nav-list">
							<li>
								<a href="/ReservaYJuga/pais">
									<i class="icon-dashboard"></i>
									<span class="menu-text"> <g:message code="panelcontrol.administrar.paises.label" default="Administrar Paises" /> </span>
								</a>
							</li>
							
							<li>
								<a href="/ReservaYJuga/provincia">
									<i class="icon-dashboard"></i>
									<span class="menu-text"> <g:message code="panelcontrol.administrar.provincias.label" default="Administrar Provincias" /> </span>
								</a>
							</li>
							
							<li>
								<a href="/ReservaYJuga/localidad">
									<i class="icon-dashboard"></i>
									<span class="menu-text"> <g:message code="panelcontrol.administrar.localidades.label" default="Administrar Localidades" /> </span>
								</a>
							</li>
							
							<li>
								<a href="/ReservaYJuga/barrio">
									<i class="icon-dashboard"></i>
									<span class="menu-text"> <g:message code="panelcontrol.administrar.barrios.label" default="Administrar Barrios" /> </span>
								</a>
							</li>
							
						</ul>
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
	</body>
</html>