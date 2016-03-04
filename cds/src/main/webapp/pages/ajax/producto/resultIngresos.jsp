	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaCompra" requestURI="/ingresoProducto_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column  media="html">
				<input type="checkbox" name="idCompra" value="${data.id}"/>
			</display:column>
			<display:column property="fechaCompra" title="Fecha de compra" format="{0,date,dd/MM/yyyy}" sortable="true"/>
			<display:column property="nroTicketFactura" title="Nº Ticket Factura" sortable="true" />
			<display:column property="proveedor" title="Proveedor" sortable="true" />
			<display:column property="formaDePago.nombre" title="Forma de pago" sortable="true" />
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
	<s:if test="%{listaCompra!=null}">
		<h3 class="text-right"><strong>Total Compras:$<s:property value="totalCompraDiaria"/></strong></h3>
	</s:if>
