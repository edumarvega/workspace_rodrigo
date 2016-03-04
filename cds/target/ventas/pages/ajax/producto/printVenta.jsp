<%@ include file="/pages/template/taglibs.jsp" %>
<div id="divPrint">
		<div class="row">
  			<div class="col-md-12 col-lg-12">
  				<p class="text-center"><strong>X</strong></p>
  			</div>
  		</div>  
		<div class="row">
  			<div class="col-md-12 col-lg-12">
  				<p class="text-center">Documento no valido como factura</p>
  			</div>
  		</div>
		<div class="row">
  			<div class="col-md-6 col-lg-6">
  				<p class="text-left"><strong>Empresa:&nbsp;</strong><s:property value="nombreEmpresa"/></p>
  				<p class="text-left"><strong>Teléfono:&nbsp;</strong><s:property value="telefono"/></p>
  				<p class="text-left"><strong>E-mail:&nbsp;</strong><s:property value="email"/></p>
  			</div>
  			<div class="col-md-6 col-lg-6">
  				<p class="text-right"><strong>Fecha:&nbsp;</strong><s:date name="venta.fechaVenta" format="dd/MM/yyyy" /></p>
  			</div>
  		</div>
  		<div class="row">
  			<hr>
			<div class="printVentaGrillaScroll">
				<table id="tableProductos" class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Cantidad</th>
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Descripcion</th>
							<th>Precio</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<s:if test="%{venta.items!=null}">
    						<s:iterator value="venta.items" status="item">
								<tr>
									<td><s:property value="cantidad"></s:property></td>      
           							<td><s:property value="codigo"></s:property></td>
           							<td><s:property value="nombre"></s:property></td>
           							<td><s:property value="descripcion"></s:property></td>
           							<td><s:property value="precio"></s:property></td>
		       					</tr>
    		   				</s:iterator>
						</s:if>
					</tbody>
				</table>
			</div>
  		</div>
  		<div class="row">
  			<hr>
  			<div class="col-md-3 col-lg-3">
  			</div>
  			<div class="col-md-3 col-lg-3">
  			</div>
  			<div class="col-md-3 col-lg-3">
  				<p class="text-right"><strong>TOTAL $</strong></p>
  			</div>
  			<div class="col-md-3 col-lg-3">
  				<p class="text-right"><strong>${venta.total}</strong></p>
  			</div>
  		</div>
  	
</div>  	
  	
