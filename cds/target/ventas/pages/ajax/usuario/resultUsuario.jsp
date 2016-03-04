	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaUsuarios" requestURI="/abmUsuario_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*" decorator="ar.com.templateit.cds.web.decorator.RoleDecorator">
			<display:column  media="html">
				<input type="checkbox" name="idUsuario" value="${data.id}"/>
			</display:column>
			<display:column property="usuario" title="Usuario" sortable="true"/>
			<display:column property="apellido" title="Apellido" sortable="true" />
			<display:column property="nombre" title="Nombres" sortable="true" />
			<display:column property="role" title="Permiso" />
			<display:setProperty name="export.excel.filename" value="Productos.xls"/>
        	<display:setProperty name="export.pdf.filename" value="Productos.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
