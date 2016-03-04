	<%@ include file="/pages/template/taglibs.jsp" %>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaProductos" requestURI="/producto_searchProducto.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column property="codigo" title="C&oacute;digo" sortable="true"/>
			<display:column property="nombre" title="Nombre" sortable="true" />
			<display:column property="descripcion" title="Descripci&oacute;n"/>
			<display:column property="marca" title="Marca"/>
			<display:column property="categoria.nombre" title="Categoria" sortable="true"/>
			<display:column title="Precio">
				$ ${data.precio}
			</display:column>
			<display:column property="cantidad" title="Stock"/>
			<display:setProperty name="export.excel.filename" value="Productos.xls"/>
        	<display:setProperty name="export.pdf.filename" value="Productos.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
