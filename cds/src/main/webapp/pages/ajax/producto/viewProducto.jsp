<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<body>
	<div id="divPrint">
	<s:form id="formViewProducto" action="abmProducto_saveOrUpdate" theme="simple"  cssClass="form-horizontal" role="form">
		<div class="form-group">
    		<label for="codigo" class="col-md-3 col-lg-3 control-label">C�digo</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="producto.codigo"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="nombre" class="col-md-3 col-lg-3 control-label">Nombre</label>
    		<div class="col-md-7 col-lg-7">
      			<p class="form-control-static"><s:property value="producto.nombre"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="descripcion" class="col-md-3 col-lg-3 control-label">Descripci�n</label>
    		<div class="col-md-9 col-lg-9">
      			<p class="form-control-static"><s:property value="producto.descripcion"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="marca" class="col-md-3 col-lg-3 control-label">Marca</label>
    		<div class="col-md-7 col-lg-7">
      			<p class="form-control-static"><s:property value="producto.marca"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="categoria" class="col-md-3 col-lg-3 control-label">Categoria</label>
    		<div class="col-md-4 col-lg-4">
    			<p class="form-control-static"><s:property value="producto.categoria.nombre"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="precio" class="col-md-3 col-lg-3 control-label">Precio</label>
    		<div class="col-md-4 col-lg-4">
    			<p class="form-control-static"><s:property value="producto.precio"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-3 col-lg-3 control-label">Stock actual</label>
    		<div class="col-md-4 col-lg-4">
    			<p class="form-control-static"><s:property value="producto.cantidad"/></p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-3 col-lg-3 control-label">Stock critico</label>
    		<div class="col-md-4 col-lg-4">
    			<p class="form-control-static"><s:property value="producto.stockCritico"/></p>
    		</div>
  		</div>
    </s:form>
    </div>
</body>
</html>