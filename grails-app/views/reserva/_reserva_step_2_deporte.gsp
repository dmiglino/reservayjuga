	<%@page import="ar.com.reservayjuga.complejo.DeporteEnum"%>
<div class="row">
		<div class="col-sm-12">
			<div class="widget-box">
				<div class="widget-header">
					<center><h4><strong>Deporte </strong>(Seleccione uno o mas deportes)</h4></center>
				</div>
		
				<div class="widget-body">
					<div class="widget-main" align="center">
						<br />
						
						 <div>
						 	<g:each in="${DeporteEnum.values()}" var="deporte" status="i">
								<div style="margin-top:-5px;" class="checkbox col-sm-2">
									<label>
										<g:checkBox name="seleccionDeporte" id="seleccionDeporte" value="${deporte}" checked="false" class="ace col-sm-5-" />
										<span class="lbl"> <g:message code="${deporte.textCode}" default="${deporte.textCode}" /> </span>
									</label>
								</div>
							</g:each>			
				
							<br />
							<br />
							<br />														
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>