<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
			    	divEditarCliente.dialog('destroy').remove();
			    } 
		};
  		$('#formEdicionCliente').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formEdicionCliente"  action="abmCliente_update" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idUsuario" name="cliente.id" value="%{cliente.id}"/>
						
		
  		<div class="form-group">
    		<label for="apellido" class="col-sm-4 control-label">Apellido</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="apellido" name="cliente.apellido" value="${cliente.apellido}" required autofocus>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="nombres" class="col-sm-4 control-label">Nombres</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="nombres" name="cliente.nombres" value="${cliente.nombres}" required>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="direccion" class="col-sm-4 control-label">Direccion</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="direccion" name="cliente.direccion" value="${cliente.direccion}" >
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="telefono" class="col-sm-4 control-label">Telefono</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="telefono" name="cliente.telefono" value="${cliente.telefono}" >
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="celular" class="col-sm-4 control-label">Celular</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="celular" name="cliente.celular" value="${cliente.celular}" >
    		</div>
  		</div>
 		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
