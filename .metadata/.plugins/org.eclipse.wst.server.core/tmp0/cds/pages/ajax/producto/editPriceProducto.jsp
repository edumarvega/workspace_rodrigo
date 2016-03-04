<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  		  	  	
  		var options = { 
  				target : '#resultado',
  		  		success: function(){ 
  		  			changeLinksPagination('resultado','filterForm');
  		  			divEditarPrecio.dialog('destroy').remove();
			    } 
		};
  		$('#formEditPriceProducto').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formEditPriceProducto"  action="abmProducto_updatePrice" theme="simple"  cssClass="form-horizontal" role="form">
			  		
  		<div class="form-group">
    		<label for="importe" class="col-md-4 col-lg-4 control-label">Precio $</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="precioProducto" name="precioProducto"  value="" placeholder="0.00" onkeypress="validaSoloNumerosConPunto();" autofocus required>
    		</div>
  		</div>
  		 		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-3 col-lg-3">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
