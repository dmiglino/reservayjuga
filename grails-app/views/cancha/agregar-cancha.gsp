<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="layout" content="main"/>
		<title><g:message code="cancha.agregar.nueva.label" default="Agregar nueva cancha" /></title>
		<link rel="stylesheet" href="../assets/css/jquery.handsontable.full.css" />
		<script src="../assets/js/jquery.handsontable.full.js"></script>
		<link rel="stylesheet" href="../assets/css/jquery.handsontable.bootstrap.css" />
		<script src="../assets/js/jquery-ui-1.10.3.full.min.js"></script>
		<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
		<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.full.min.css" />
	</head>

	<body>

<%--		inicio main-container--%>

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
							<li>
								<a href="#"><g:message code="breadcrumbs.agregar.cancha.label" default="Agregar Cancha" /></a>
							</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                    <g:form action="crearCancha" class="form-horizontal" role="form" > 
                                    
                                          <g:render template="form_cancha" model="['cancha':cancha]" />
                                   
				                   </g:form >           
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->

<!-- 	fin main-container -->


		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		
			function updateSuperficies(items) {
			    var control = document.getElementById('selSuperficie')
			
			    // Clear all previous options
			    var i = control.length
			    while (i > 0) {
			        i--
			        control.remove(i)
			    }
			
			    // Rebuild the select
			    for (i=0; i < items.length; i++) {
			        var optItem = items[i]
			        var opt = document.createElement('option');
			        opt.text = optItem.value
			        opt.value = optItem.id
			        try {
			                control.add(opt, null) // doesn't work in IE
			        }
			        catch(ex) {
			                control.add(opt) // IE only
			        }
			    }
			}
			
			function mantenerCssDeSuperficie() {
				var label = document.getElementById("superficieLabel");
				label.setAttribute("class", "col-sm-2 control-label");
				var select = document.getElementById("cancha.superficie");
				select.setAttribute("class", "col-xs-4 col-sm-5-");
			}
			
		</script>
	</body>
</html>
