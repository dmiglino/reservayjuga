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
							<small><g:message code="header.bienvenido.label" default="Bienvenido," /></small>
								<sec:username/>
						</span> <i class="icon-caret-down"></i>
					</a>
	
					<ul
						class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
						<li><a href="#"> <i class="icon-cog"></i> <g:message code="header.settings.label" default="Settings" />
						</a></li>
	
						<li class="divider"></li>
						<sec:ifLoggedIn>
						<li><g:link controller="logout" actions="index"> <i class="icon-off"></i> <g:message code="header.logout.label" default="Logout" /></g:link>
						</li>
						</sec:ifLoggedIn>
					</ul>
				</li>
				
			</ul><!-- /.ace-nav -->
			
		</div><!-- /.navbar-header -->
		
	</div><!-- /.navbar-container -->

</div><!-- /.navbar navbar-default -->