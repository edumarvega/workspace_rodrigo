	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaIngresosVarios" requestURI="/ingresoVario_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column  media="html">
				<input type="checkbox" name="idIngresoVario" value="${data.id}"/>
			</display:column>
			<display:column property="fecha" title="Fecha" format="{0,date,dd/MM/yyyy}"/>
			<display:column property="tipoIngresoVario.nombre" title="Tipo ingreso" sortable="true"/>
			<display:column property="nombre" title="Nombre"/>
			<display:column property="observaciones" title="Observaciones"/>
			<display:column title="Importe">
				$ ${data.importe}
			</display:column>
			<display:setProperty name="export.excel.filename" value="IngresosVarios.xls"/>
        	<display:setProperty name="export.pdf.filename" value="IngresosVarios.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
	<s:if test="%{listaIngresosVarios!=null}">
		<h3 class="text-right"><strong>Total Ingresos:$<s:property value="totalIngresosVarios"/></strong></h3>
	</s:if>
