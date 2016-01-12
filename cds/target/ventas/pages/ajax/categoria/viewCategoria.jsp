<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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