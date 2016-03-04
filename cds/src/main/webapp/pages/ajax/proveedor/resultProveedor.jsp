	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaProveedores" requestURI="/abmProveedor_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column  media="html">
				<input type="checkbox" name="idProveedor" value="${data.id}"/>
			</display:column>
			<display:column property="cuit" title="Cuit" sortable="true"/>
			<display:column property="nombreRazonSocial" title="Nombre o Raz&oacute;n social" sortable="true" />
			<display:column property="telefono" title="Telefono"/>
			<display:column property="celular" title="Celular"/>
			<display:column property="email" title="Email"/>
			<display:setProperty name="export.excel.filename" value="Productos.xls"/>
        	<display:setProperty name="export.pdf.filename" value="Productos.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
