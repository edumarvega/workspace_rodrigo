<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="es">
<body>
	<div id="divPrint">
		<s:form id="formViewCategoria"  action="abmCategoria_saveOrUpdate" theme="simple"  cssClass="form-horizontal" role="form">
  			<div class="form-group">
    			<label for="nombre" class="col-md-4 col-lg-4 control-label">Nombre</label>
    			<div class="col-md-5 col-lg-5">
      				<p class="form-control-static"><s:property value="categoria.nombre"/></p>
    			</div>
  			</div>
    	</s:form>
    </div>
</body>
</html>