<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  		  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
  					divNewIngresoVario.dialog('destroy').remove();
			    } 
		};
  		$('#formAltaIngresoVario').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formAltaIngresoVario"  action="ingresoVario_save" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idIngresoVario" name="ingresoVario.id" value=""/>
				
		<div class="form-group">
    		<label for="fechaCompra" class="col-md-3 col-lg-3 control-label">Fecha</label>
    		<div class="col-md-3 col-lg-3">
    			<s:date name="fecha" var="fecha" format="dd/MM/yyyy"/>
      			<s:textfield name="fecha" value="%{#fecha}" cssClass="form-control input-sm" disabled="true"/>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="tipoGastoVario" class="col-md-3 col-lg-3 control-label">Descripcion</label>
    		<div class="col-md-3 col-lg-3">
 				<select name=tipoIngresoVario class="form-control" required>
  					<option value="">Selecione...</option>
  					<s:iterator value="tiposIngresosVarios">
  					<option value='<s:property value="id"/>'><s:property value="nombre"/></option><br/>
					</s:iterator>
				</select>	
      		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="nombre" class="col-md-3 col-lg-3 control-label">Nombre</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="nombre" name="ingresoVario.nombre"  value="" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="importe" class="col-md-3 col-lg-3 control-label">Importe</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="importe" name="ingresoVario.importe"  value="" placeholder="0.00" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
  		</div>
  			
  		  		
  		<div class="form-group">
    		<label for="observaciones" class="col-md-3 col-lg-3 control-label">Observaciones</label>
    		<div class="col-md-7 col-lg-7">
      			<textarea class="form-control input-sm" rows="3" name="ingresoVario.observaciones"></textarea>
    		</div>
  		</div>
 		
  		<div class="form-group">
  			<label for="button" class="col-md-3 col-lg-3 control-label"></label>
    		<div class="col-md-3 col-lg-3">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
