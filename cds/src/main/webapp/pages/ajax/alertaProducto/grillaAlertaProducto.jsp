<%@ include file="/pages/template/taglibs.jsp" %>
<br>
<div class="egresoGrillaScroll">
<table id="tableAlertas" class="table table-striped table-condensed">
	<thead>
		<tr>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Categoria</th>
			<th>Stock actual</th>
		</tr>
	</thead>
	<tbody>
		<s:if test="%{alertas!=null}">
    		<s:iterator value="alertas" status="alerta">
				<tr>      
           			<td><s:property value="codigo"></s:property></td>
           			<td><s:property value="nombre"></s:property></td>
           			<td><s:property value="descripcion"></s:property></td>
           			<td><s:property value="categoria"></s:property></td>
           			<td><s:property value="cantidadActual"></s:property></td>
     			</tr>
       		</s:iterator>
		</s:if>
	</tbody>

</table>
</div>
