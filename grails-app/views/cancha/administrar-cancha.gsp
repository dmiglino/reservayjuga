<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="layout" content="main"/>
		<title><g:message code="cancha.titulo.label" default="Administracion de Canchas" /></title>
		<script src="../assets/js/jquery-ui-1.10.3.full.min.js"></script>
		<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
		<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.full.min.css" />
	</head>

	<body>

<%--	inicio main-container--%>

		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>

			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#"><g:message code="sidebar.panel.label" default="Panel de Control" /></a>
				</li>
				<li>
					<a href="#"><g:message code="sidebar.administrar.cancha.label" default="Administrar Canchas" /></a>
				</li>
			</ul><!-- .breadcrumb -->
		</div>

		<div class="page-content">
		
			<div id="accordion" class="accordion-style2">
				<div class="group">
					<h3 class="accordion-header">Filtros</h3>
					<div>
						<div class="row" id="filtro_canchas">
							<g:render template="filtros-canchas" />
						</div>
					</div>
				</div>
			</div>
			
			<div class="page-header">
				<h1>
				    <small>
						<g:message code="cancha.listado.label" default="Listado de canchas" />
					</small>
				</h1>
			</div><!-- /.page-header -->

			<div class="row">
				<div class="col-xs-12">

					<!-- PAGE CONTENT BEGINS -->
					<g:form action="agregarCancha" class="form-horizontal" role="form" >
				
			            <div class="row" id="tabla_canchas" >
			            	<g:render template="tabla_canchas" />
						</div>
                                 
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<g:actionSubmit action="agregarCancha" class="btn btn-info" value="Agregar Cancha" />
								&nbsp; &nbsp; &nbsp;
							</div>
						</div>
						
					</g:form>
					
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
             
		<!-- comienzo DEL MODAL BOX PARA EDITAR -->
		<div id="modal-box-form" >
			<g:render template="modal-box" model="['cancha':cancha]" />
		</div>
		<!-- FIN DEL MODAL BOX PARA EDITAR -->
                

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		
			function closeModal() {
				$('#modal-form').modal('hide');
			}

			//jquery accordion
	  		$( "#accordion" ).accordion({
	  			collapsible: true ,
	  			heightStyle: "content",
	  			animate: 250,
	  			header: ".accordion-header"
	  		}).sortable({
	  			axis: "y",
	  			handle: ".accordion-header",
	  			stop: function( event, ui ) {
	  				// IE doesn't register the blur when sorting
	  				// so trigger focusout handlers to remove .ui-state-focus
	  				ui.item.children( ".accordion-header" ).triggerHandler( "focusout" );
	  			}
	  		});
	  		
		</script>

	</body>
</html>