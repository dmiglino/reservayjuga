<div class="navbar navbar-default" id="navbar">

	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>
	
	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand"> 
				<small> 
					<i class="icon-leaf"></i> ${tituloPagina} 
				</small>
			</a><!-- /.brand -->
			
		</div><!-- /.navbar-header -->
		
	
		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
	
				<li class="light-blue">
					<a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> 
						<span class="user-info"> 
							<small>Bienvenido,</small>
								${tipoUsuario}
						</span> <i class="icon-caret-down"></i>
					</a>
	
					<ul
						class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
						<li><a href="#"> <i class="icon-cog"></i> Settings
						</a></li>
	
						<li class="divider"></li>
	
						<li><a href="#"> <i class="icon-off"></i> Logout
						</a></li>
					</ul>
				</li>
				
			</ul><!-- /.ace-nav -->
			
		</div><!-- /.navbar-header -->
		
	</div><!-- /.navbar-container -->

</div><!-- /.navbar navbar-default -->