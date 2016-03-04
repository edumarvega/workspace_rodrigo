<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
			    	divEditarUsuario.dialog('destroy').remove();
			    } 
		};
  		$('#formEdicionUsuario').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formEdicionUsuario"  action="abmUsuario_update" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idUsuario" name="id" value="%{id}"/>
						
		<div class="form-group">
    		<label for="usuario" class="col-md-4 col-lg-4 control-label">Usuario</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="usuario" name="username" value="${username}" autofocus required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="password" class="col-md-4 col-lg-4 control-label">Contraseña</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="password" class="form-control input-sm" id="password" name="password" value="" required>
    		</div>
  		</div>
  		   		
  		<div class="form-group">
    		<label for="permiso" class="col-md-4 col-lg-4 control-label">Permisos</label>
    		<div class="col-md-5 col-lg-5">
      			<s:select
					list="permisos" 
					listKey="id"   
        			listValue="nombre"
					name="permiso" 
					value="defaultPermiso" theme="simple" cssClass="form-control"/>
      		</div>
  		</div>
  		<div class="form-group">
    		<label for="apellido" class="col-md-4 col-lg-4 control-label">Apellido</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="apellido" name="apellido" value="${apellido}" required>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="nombre" class="col-md-4 col-lg-4 control-label">Nombres</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="nombre" name="nombres" value="${nombres}" required>
    		</div>
  		</div>
 		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
