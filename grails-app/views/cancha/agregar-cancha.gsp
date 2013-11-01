<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="layout" content="main"/>
		<title>Agregar nueva cancha</title>
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
								<a href="#">Panel de control</a>
							</li>

							<li>
								<a href="#">Administrar Canchas</a>
							</li>
							<li>
								<a href="#">Agregar Cancha</a>
							</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
							    <small>
								    Datos de la cancha
								</small>
							</h1>
						</div><!-- /.page-header -->

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
			
		</script>
	</body>
</html>
