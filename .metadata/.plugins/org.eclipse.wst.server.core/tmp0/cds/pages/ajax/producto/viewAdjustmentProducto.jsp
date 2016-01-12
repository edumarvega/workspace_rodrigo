<%@ include file="/pages/template/taglibs.jsp" %>
	<div id="divPrint">
	<s:form id="formAjusteProducto"  action="ajusteProducto_save" theme="simple"  cssClass="form-horizontal" role="form">
	
		<div class="form-group">
    		<label for="cantidad" class="col-md-4 col-lg-4 control-label">Fecha de ajuste</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:date name="ajuste.fechaAjuste" format="dd/MM/yyyy" /></p>
    		</div>
    		
  		</div>
		<div class="form-group">
    		<label for="cantidad" class="col-md-4 col-lg-4 control-label">Nombre</label>
    		<div class="col-md-8 col-lg-8">
      			<p class="form-control-static"><s:property value="ajuste.nombre"/></p>
    		</div>
    		
  		</div>
  		<div class="form-group">
    		<label for="codigo" class="col-md-4 col-lg-4 control-label">Código</label>
    		<div class="col-md-8 col-lg-8">
      			<p class="form-control-static"><s:property value="ajuste.codigo"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-4 col-lg-4 control-label">Descripcion</label>
    		<div class="col-md-8 col-lg-8">
      			<p class="form-control-static"><s:property value="ajuste.descripcion"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-4 col-lg-4 control-label">Cantidad sin ajuste</label>
    		<div class="col-md-8 col-lg-8">
      			<p class="form-control-static"><s:property value="ajuste.cantidadSinAjuste"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-4 col-lg-4 control-label">Cantidad con ajuste</label>
    		<div class="col-md-8 col-lg-8">
      			<p class="form-control-static"><s:property value="ajuste.cantidadConAjuste"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="motivo" class="col-md-4 col-lg-4 control-label">Motivo ajuste</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="ajuste.motivoAjuste.nombre"/></p>
      		</div>
  		</div>
    </s:form>
    </div>
    
  			
    
    	
