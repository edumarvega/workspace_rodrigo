	<%@ include file="/pages/template/taglibs.jsp" %>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaProductos" requestURI="/producto_search.do" pagesize="10" class="table table-striped table-condensed" excludedParams="*">
			<display:column  media="html">
				<input type="radio" name="productoselect" class="radioSelect" value="${data.id}-${data.codigo}-${data.nombre}-${data.descripcion}-${data.precio}-${data.cantidad}"/>
			</display:column>
			<display:column property="codigo" title="C&oacute;digo" sortable="true"/>
			<display:column property="nombre" title="Nombre" sortable="true" />
			<display:column property="descripcion" title="Descripci&oacute;n"/>
			<display:column property="marca" title="Marca"/>
		</display:table>
	</div>
