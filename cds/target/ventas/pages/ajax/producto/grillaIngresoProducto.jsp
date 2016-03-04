<%@ include file="/pages/template/taglibs.jsp" %>
<br>
<div class="ingresoGrillaScroll">
	<table id="tableProductos" class="table table-striped table-condensed">
		<thead>
			<tr>
				<th>Cantidad</th>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Precio Compra</th>
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
           				<td>$<s:property value="precioDeCompra"></s:property></td>
           				<td>$<s:property value="subTotal"></s:property></td>
           				<td><a onclick="eliminar(<s:property value="%{#item.index}" />);return false;">[Quitar]</a></td>                 
       				</tr>
       			</s:iterator>
			</s:if>
		</tbody>
	</table>
</div>
<s:hidden id="totalCompraTmp" name="totalCompraTmp" value="%{totalCompraTmp}"/>
<h3 class="text-right"><strong>Total:$<s:property value="totalCompraTmp"/></strong></h3>
