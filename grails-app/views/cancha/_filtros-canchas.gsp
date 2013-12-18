<%@page import="ar.com.reservayjuga.complejo.DeporteEnum"%>
<%@page import="ar.com.reservayjuga.complejo.SuperficieEnum"%>
<g:formRemote name="filter_form" url="[ controller: 'cancha', action:'filtrarCanchas' ]" update="tabla_canchas" >
	<div class="col-xs-12">
		<div class="well">
			
			<div class="col-xs-4">
				<h4 class="green smaller lighter"><g:message code="cancha.filtros.deporte.label" default="Deporte" /></h4>	
				<div>
					<g:select id="deporteCanchaFilter" 
						name="deporteCanchaFilter"
						from="${DeporteEnum.values()}"
						noSelection="['':'Seleccione un deporte..']"
						class="width-80"
						value=""  />
				</div>
			</div>
				
			<div class="col-xs-4">
				<h4 class="green smaller lighter"><g:message code="cancha.filtros.superficie.label" default="Superficie" /></h4>	
				<div>
					<g:select id="superficieCanchaFilter" 
						name="superficieCanchaFilter"
						from="${SuperficieEnum.values()}"
						noSelection="['':'Seleccione una superficie..']"
						class="width-80 "
						value=""  />
				</div>
			</div>
				
			<div class="col-xs-4">
				<br />
				<g:submitButton class="btn" name="submit" value="Filtrar" />
			</div>
			
			<br /> <br /> <br /> <br />
		</div>
	</div>
</g:formRemote>