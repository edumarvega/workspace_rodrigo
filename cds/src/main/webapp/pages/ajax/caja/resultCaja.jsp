	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaCaja" requestURI="/caja_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column  media="html">
				<input type="checkbox" name="idGastoVario" value="${data.id}"/>
			</display:column>
			<display:column property="fecha" title="Fecha" format="{0,date,dd/MM/yyyy}"/>
			<display:column title="Caja inicial">
				$ ${data.cajaInicial}
			</display:column>
			<display:column property="estadoCaja.nombre" title="Estado" sortable="true"/>
			<display:setProperty name="export.excel.filename" value="Caja.xls"/>
        	<display:setProperty name="export.pdf.filename" value="Caja.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
