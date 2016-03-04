	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaClientes" requestURI="/abmCliente_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*" decorator="ar.com.templateit.cds.web.decorator.RoleDecorator">
			<display:column  media="html">
				<input type="checkbox" name="idCliente" value="${data.id}"/>
			</display:column>
			<display:column property="apellido" title="Apellido" sortable="true" />
			<display:column property="nombres" title="Nombres" sortable="true" />
			<display:column property="direccion" title="Direccion" />
			<display:column property="telefono" title="Telefono" />
			<display:column property="celular" title="Celular" />
			<display:setProperty name="export.excel.filename" value="Clientes.xls"/>
        	<display:setProperty name="export.pdf.filename" value="Clientes.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
