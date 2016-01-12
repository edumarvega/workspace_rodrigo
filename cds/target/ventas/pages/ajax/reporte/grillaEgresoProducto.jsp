<%@ include file="/pages/template/taglibs.jsp" %>
<s:if test="%{mensajeError!=null}">
	<div class="alert alert-danger fade in">
		<p class="text-center"><b>Error!</b>&nbsp;<s:property value="mensajeError"/></p>
	</div>
</s:if>
<span style="color: #2aabd2; font-size: 14px; font-weight: bold;">&nbsp;&nbsp;Productos</span>
<br>
<div class="egresoGrillaScroll">
	<table id="tableProductos" class="table table-striped table-condensed">
		<thead>
			<tr>
				<th>Cantidad</th>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Precio</th>
				<th>Subtotal</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<s:if test="%{items!=null}">
    			<s:iterator value="items" status="item">
					<tr>      
						<td><s:property value="cantidad"></s:property></td>
           				<td><s:property value="codigo"></s:property></td>
           				<td><s:property value="nombre"></s:property></td>
           				<td><s:property value="descripcion"></s:property></td>
           				<td>$<s:property value="precio"></s:property></td>
           				<td>$<s:property value="subTotal"></s:property></td>
           				<td><a onclick="eliminar(<s:property value="%{#item.index}" />);return false;">[Quitar]</a></td>                 
       				</tr>
       			</s:iterator>
			</s:if>
		</tbody>
	</table>
</div>
<h3 class="text-right"><strong>Total:$<s:property value="totalVenta"/></strong></h3>
