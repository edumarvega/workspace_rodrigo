<%@ include file="/pages/template/taglibs.jsp" %>
<br>
<div id="divPrint">
	<div class="displayTable">
		<display:table id="data" name="listaMovimientoCuentaCorriente" requestURI="/cobranzaCliente_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column property="fechaCobro" title="Fecha de pago" format="{0,date,dd/MM/yyyy}"/>
			<display:column property="movimiento" title="Movimiento" />
			<display:column title="Total venta">
				$ ${data.totalVenta}
			</display:column>
			<display:column title="Pago">
				$ ${data.cobro}
			</display:column>
			<display:column title="Saldo">
				$ ${data.saldoAcreedor}
			</display:column>
													
			<display:setProperty name="export.excel.filename" value="MovimientoCtaCteCliente.xls"/>
        	<display:setProperty name="export.pdf.filename" value="MovimientoCtaCteCliente.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
</div>	
