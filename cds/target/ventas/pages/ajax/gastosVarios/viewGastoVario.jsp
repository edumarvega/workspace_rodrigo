<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="es">
<body>
	<div id="divPrint">
		<s:form id="formViewGastoVario"  action="gastoVario_saveOrUpdate" theme="simple"  cssClass="form-horizontal" role="form">
		
			<div class="form-group">
    			<label for="fechaCompra" class="col-md-3 col-lg-3 control-label">Fecha</label>
    			<div class="col-md-3 col-lg-3">
      				<p class="form-control-static"><s:property value="gastoVario.fecha"/></p>
    			</div>
  			</div>
  		  		
  			<div class="form-group">
    			<label for="tipoGastoVario" class="col-md-3 col-lg-3 control-label">Descripcion</label>
    			<div class="col-md-6 col-lg-6">
	    			<p class="form-control-static"><s:property value="gastoVario.tipoGastoVario.nombre"/></p>
      			</div>
  			</div>
  		
  			<div class="form-group">
    			<label for="nombre" class="col-md-3 col-lg-3 control-label">Nombre</label>
    			<div class="col-md-6 col-lg-6">
      				<p class="form-control-static"><s:property value="gastoVario.nombre"/></p>
    			</div>
  			</div>
  		
  			<div class="form-group">
    			<label for="importe" class="col-md-3 col-lg-3 control-label">Importe</label>
    			<div class="col-md-5 col-lg-5">
      				<p class="form-control-static">$<s:property value="gastoVario.importe"/></p>
    			</div>
  			</div>
  			
  		  	<div class="form-group">
    			<label for="observaciones" class="col-md-3 col-lg-3 control-label">Observaciones</label>
    			<div class="col-md-7 col-lg-7">
      				<p class="form-control-static"><s:property value="gastoVario.observaciones"/></p>
    			</div>
  			</div>	
			
    	</s:form>
	
    </div>
</body>
</html>