	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaVenta" requestURI="/reporte_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column  media="html">
				<input type="checkbox" name="idVenta" value="${data.id}"/>
			</display:column>
			<display:column property="fechaVenta" title="Fecha de venta" format="{0,date,dd/MM/yyyy}" sortable="true"/>
			<display:column property="usuario.usuario" title="Usuario" sortable="true"/>
			<display:column property="observaciones" title="Observaciones" maxLength="45"/>
			<display:column title="Efectivo">
				$ ${data.efectivo}
			</display:column>
			<display:column title="Cambio">
				$ ${data.cambio}
			</display:column>
			<display:column title="Total">
				$ ${data.total}
			</display:column>
			<display:setProperty name="export.excel.filename" value="Ingresos.xls"/>
        	<display:setProperty name="export.pdf.filename" value="Ingresos.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
	<s:if test="%{listaVenta!=null}">
		<h3 class="text-right"><strong>Total:$<s:property value="totalVentaDiaria"/></strong></h3>
	</s:if>
