<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
	  				changeLinksPagination('resultado','filterForm');
			    	divNewCliente.dialog('destroy').remove();
			    } 
		};
  		$('#formAltaCliente').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formAltaCliente"  action="abmCliente_save" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idCliente" name="cliente.id" value=""/>
		
  		<div class="form-group">
    		<label for="apellido" class="col-sm-4 control-label">Apellido</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="apellido" name="cliente.apellido" value="" required autofocus>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="nombres" class="col-sm-4 control-label">Nombres</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="nombres" name="cliente.nombres" value="" required>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="direccion" class="col-sm-4 control-label">Direccion</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="direccion" name="cliente.direccion" value="" >
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="telefono" class="col-sm-4 control-label">Telefono</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="telefono" name="cliente.telefono" value="" >
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="celular" class="col-sm-4 control-label">Celular</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="celular" name="cliente.celular" value="" >
    		</div>
  		</div>
  		  		 		
  		<div class="form-group">
  			<label for="button" class="col-sm-4 control-label"></label>
    		<div class="col-sm-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
