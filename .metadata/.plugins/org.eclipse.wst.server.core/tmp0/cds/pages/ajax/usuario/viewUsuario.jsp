<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="es">
<body>
	<div id="divPrint">
		<s:form id="formViewUsuario"  action="abmUsuario_saveOrUpdate" theme="simple"  cssClass="form-horizontal" role="form">
		  			
  		<div class="form-group">
    		<label for="usuario" class="col-sm-4 control-label">Usuario</label>
    		<div class="col-sm-5">
      			<p class="form-control-static"><s:property value="usuario.usuario"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="usuario" class="col-sm-4 control-label">Permiso</label>
    		<div class="col-sm-5">
      			<p class="form-control-static"><s:property value="permiso"/></p>
    		</div>
  		</div>
  		  		
  		<div class="form-group">
    		<label for="apellido" class="col-sm-4 control-label">Apellido</label>
    		<div class="col-sm-5">
      			<p class="form-control-static"><s:property value="usuario.apellido"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="nombre" class="col-sm-4 control-label">Nombres</label>
    		<div class="col-sm-5">
      			<p class="form-control-static"><s:property value="usuario.nombre"/></p>
    		</div>
  		</div>
  		
  		
    </s:form>
	
    </div>
</body>
</html>