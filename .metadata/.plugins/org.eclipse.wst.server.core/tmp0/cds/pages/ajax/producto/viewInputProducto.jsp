<%@ include file="/pages/template/taglibs.jsp" %>
<div id="divPrint">
	<s:form id="formVewIngresoProducto"  action="ingresoProducto_update" theme="simple"  cssClass="form-horizontal" role="form">
		<div class="form-group">
    		<label for="fechaCompra" class="col-md-3 col-lg-3 control-label">Fecha compra</label>
    		<div class="col-md-2 col-lg-2">
      			<p class="form-control-static"><s:property value="compra.fechaCompra"/></p>
    		</div>
  		</div>
  			
  		<div class="form-group">
    		<label for="nroTicketFactura" class="col-md-3 col-lg-3 control-label">NºFactura-Ticket</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="compra.nroTicketFactura"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="proveedor" class="col-md-3 col-lg-3 control-label">Proveedor</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="compra.proveedor"/></p>
    		</div>
  		</div>
  		  		
  		<br/>
  		
  		<div id="itemsCompra" class="form-group">
  			<div class="ingresoGrillaScroll">
				<table id="tableIngreoProductos" class="table table-striped table-condensed">
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
						<s:if test="%{compra.items!=null}">
    						<s:iterator value="compra.items" status="item">
								<tr>
           							<td><s:property value="cantidad"></s:property></td>      
           							<td><s:property value="codigo"></s:property></td>
           							<td><s:property value="nombre"></s:property></td>
           							<td><s:property value="descripcion"></s:property></td>
           							<td><s:property value="precioDeCompra"></s:property></td>
       							</tr>
       						</s:iterator>
						</s:if>
					</tbody>
				</table>
			</div>
    	</div>
  		<div class="form-group">
    		<label for="total" class="col-md-3 col-lg-3 control-label">Total $</label>
    		<div class="col-md-2 col-lg-2">
      			<p class="form-control-static"><s:property value="total"/></p>
    		</div>
  		</div>
    </s:form>
</div>