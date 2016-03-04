	<%@ include file="/pages/template/taglibs.jsp" %>
	<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<div class="displayTable">
		<display:table id="data" name="listaCuentaCorriente" requestURI="/pagoProveedor_search.do" pagesize="10" export="true" class="table table-striped table-condensed" excludedParams="*">
			<display:column  media="html">
				<input type="checkbox" name="idCtaCte" value="${data.id}"/>
			</display:column>
			<display:column property="fechaCreacion" title="Fecha de creacion" format="{0,date,dd/MM/yyyy}"/>
			<display:column property="tipoCuentaCorriente.nombre" title="Cuenta corriente"/>
			<display:column property="proveedor.nombreRazonSocial" title="Proveedor" sortable="true"/>
			<display:column title="Total compra">
				$ ${data.totalCompra}
			</display:column>
			<display:column title="Saldo">
				$ ${data.saldoDeudor}
			</display:column>
			<display:column title="Estado">
				<cw:choose>
    				<cw:when test="${data.estadoCuentaCorriente.id==1}">
    					<p style="color:#FF0000; font-weight:bold;">${data.estadoCuentaCorriente.nombre}</p>
        		    </cw:when>    
    				<cw:otherwise>
    					<p style="color:#00FF00; font-weight:bold;">${data.estadoCuentaCorriente.nombre}</p>
        			</cw:otherwise>
				</cw:choose>
           </display:column>
			<display:column property="fechaPago" title="Ultimo pago" format="{0,date,dd/MM/yyyy}"/>
										
			<display:setProperty name="export.excel.filename" value="CtaCteProveedor.xls"/>
        	<display:setProperty name="export.pdf.filename" value="CtaCteProveedor.pdf"/>
        	<display:setProperty name="export.pdf" value="true" />
        	<display:setProperty name="export.excel" value="true" />
        	<display:setProperty name="export.csv" value="false" />
        	<display:setProperty name="export.xml" value="false" />
		</display:table>
	</div>
	<s:if test="%{listaCuentaCorriente!=null}">
		<h3 class="text-right"><strong>Total Saldo a Pagar:$<s:property value="totalPagar"/></strong></h3>
	</s:if>
