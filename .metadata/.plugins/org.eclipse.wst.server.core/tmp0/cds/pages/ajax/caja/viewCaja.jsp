<%@ include file="/pages/template/taglibs.jsp" %>
     
<div id="divPrint">     
	<s:form id="formViewCaja"  action="caja_saveOrUpdate" theme="simple"  cssClass="form-horizontal" role="form">
  		  		
  		<div class="form-group">
    		<label for="sinLabel1" class="col-md-2 col-lg-2 control-label"></label>
    		<div class="col-md-1 col-lg-1">
      		</div>
    		<label for="fecha" class="col-md-1 col-lg-1 control-label">Fecha</label>
    		<div class="col-md-3 col-lg-3">
      			<s:date name="fechaActual" var="fechaActual" format="dd/MM/yyyy"/>
      			<s:textfield name="fechaActual" value="%{#fechaActual}" cssClass="form-control input-sm" disabled="true"/>
    		</div>
    		<label for="sinLabel2" class="col-md-2 col-lg-2 control-label"></label>
    		<div class="col-md-2 col-lg-2">
    		</div>
  		</div>
  		  		
  		<div class="form-group">
    		<label for="cajaInicial" class="col-md-3 col-lg-3 control-label">Caja inicial $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="cajaInicial"  name="cajaDiaria" value="${cajaDiaria}" disabled="disabled">
    		</div>
    		<label for="cambio" class="col-md-3 col-lg-3 control-label">Cambio $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="cambio"  name="cambio" value="${cambio}" disabled="disabled">
    		</div>
  		</div>
  		
  		<hr>
  		
  		<div class="form-group">
    		<label for="ventasEfectivo" class="col-md-3 col-lg-3 control-label">Total Ventas Efectivo $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="ventasEfectivo"  name="totalVentasEfectivo" value="${totalVentasEfectivo}" disabled="disabled">
    		</div>
    		<label for="comprasEfectivo" class="col-md-4 col-lg-4 control-label">Total Compras Efectivo $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="comprasEfectivo"  name="totalIngresosVarios" value="${totalCompraEfectivo}" disabled="disabled">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="ingresosVarios" class="col-md-3 col-lg-3 control-label">Total Ingresos Varios $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="ingresosVarios"  name="totalIngresosVarios" value="${totalIngresosVarios}" disabled="disabled">
    		</div>
    		<label for="gastosVarios" class="col-md-4 col-lg-4 control-label">Total Gastos Varios $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="gastosVarios"  name="totalGastosVarios" value="${totalGastosVarios}" disabled="disabled">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="ctaCteCliente" class="col-md-3 col-lg-3 control-label">Total Cta.Cte.Cliente $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="ctaCteCliente"  name="totalCtaCteCliente" value="${totalCtaCteCliente}" disabled="disabled">
    		</div>
    		<label for="ctaCteProveedor" class="col-md-4 col-lg-4 control-label">Total Cta.Cte.Proveedor $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="ctaCteProveedor"  name="totalCtaCteProveedor" value="${totalCtaCteProveedor}" disabled="disabled">
    		</div>
  		</div>
  		
  		<hr>
  		
  		<div class="form-group">
    		<label for="sinLabel1" class="col-md-2 col-lg-2 control-label"></label>
    		<div class="col-md-1 col-lg-1">
      		</div>
    		<label for="totalEfectivo" class="col-md-3 col-lg-3 control-label">Total Efectivo $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="totalEfectivo"  name="totalEfectivo" value="${totalEfectivo}" disabled="disabled">
    		</div>
    		<label for="sinLabel2" class="col-md-2 col-lg-2 control-label"></label>
    		<div class="col-md-2 col-lg-2">
    		</div>
  		</div>
  		
    </s:form>
</div>    	
