<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){

  	  	$("#usuario").val('');
  		$("#password").val('');
		$("#usuario").focus();
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
	  				changeLinksPagination('resultado','filterForm');
			    	divNewUsuario.dialog('destroy').remove();
			    } 
		};
  		$('#formAltaUsuario').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formAltaUsuario"  action="abmUsuario_save" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idUsuario" name="usuario.id" value=""/>
  		<div class="form-group">
    		<label for="usuario" class="col-sm-4 control-label">Usuario</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="usuario" name="usuario.usuario" value="" autofocus required>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="password" class="col-sm-4 control-label">Contraseña</label>
    		<div class="col-sm-5">
      			<input type="password" class="form-control input-sm" id="password" name="usuario.password" value="" required>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="permiso" class="col-sm-4 control-label">Permisos</label>
    		<div class="col-sm-5">
      			<!--<s:select headerKey="-1" headerValue="Selecione"
					list="permisos" 
					listKey="id"   
        			listValue="nombre"
					name="permiso" 
					value="defaultPermiso" theme="simple" cssClass="form-control"/>-->
				<select name="permiso" class="form-control" required>
  					<option value="">Selecione...</option>
  					<s:iterator value="permisos">
  					<option value='<s:property value="id"/>'><s:property value="nombre"/></option><br/>
					</s:iterator>
				</select>
      		</div>
  		</div>
  		<div class="form-group">
    		<label for="apellido" class="col-sm-4 control-label">Apellido</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="apellido" name="usuario.apellido" value="" required>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="nombre" class="col-sm-4 control-label">Nombres</label>
    		<div class="col-sm-5">
      			<input type="text" class="form-control input-sm" id="nombre" name="usuario.nombre" value="" required>
    		</div>
  		</div>
  		  		 		
  		<div class="form-group">
  			<label for="button" class="col-sm-4 control-label"></label>
    		<div class="col-sm-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
