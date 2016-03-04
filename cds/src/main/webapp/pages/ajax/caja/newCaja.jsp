<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  		  	  	
  		var options = { 
  		  		success: function(){ 
  					divNewCaja.dialog('destroy').remove();
			    } 
		};
  		$('#formAltaCaja').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formAltaCaja"  action="caja_save" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idCaja" name="caja.id" value=""/>
				
	  		
  		<div class="form-group">
    		<label for="importe" class="col-md-4 col-lg-4 control-label">Importe $</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="importe" name="caja.cajaInicial"  value="" placeholder="0.00" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="cambio" class="col-md-4 col-lg-4 control-label">Cambio $</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="cambio" name="caja.cambio"  value="" placeholder="0.00" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
  		</div>
  		 		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-3 col-lg-3">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
