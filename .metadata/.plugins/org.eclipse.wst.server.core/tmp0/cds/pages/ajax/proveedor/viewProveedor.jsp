<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="es">
<body>
	<div id="divPrint">
		<s:form id="formViewProveedor"  action="abmProveedor_saveOrUpdate" theme="simple"  cssClass="form-horizontal" role="form">
		<div class="form-group">
    		<label for="cuit" class="col-md-4 col-lg-4 control-label">Cuit</label>
    		<div class="col-md-3 col-lg-4">
      			<p class="form-control-static"><s:property value="cuit"/></p>
    		</div>
  		</div>
  			
  		<div class="form-group">
    		<label for="nombreRazonSocial" class="col-md-4 col-lg-4 control-label">Nombre o Razon social</label>
    		<div class="col-md-5 col-lg-5">
      			<p class="form-control-static"><s:property value="proveedor.nombreRazonSocial"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="telefono" class="col-md-4 col-lg-4 control-label">Telefono</label>
    		<div class="col-md-3 col-lg-3">
      			<p class="form-control-static"><s:property value="proveedor.telefono"/></p>
    		</div>
    		<label for="fax" class="col-md-1 col-lg-1 control-label">Fax</label>
    		<div class="col-md-3 col-lg-3">
      			<p class="form-control-static"><s:property value="proveedor.fax"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="celular" class="col-md-4 col-lg-4 control-label">Celular</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="proveedor.celular"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="direccion" class="col-md-4 col-lg-4 control-label">Direccion</label>
    		<div class="col-md-7 col-lg-7">
      			<p class="form-control-static"><s:property value="proveedor.domicilio"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="numero" class="col-md-4 col-lg-4 control-label">Numero</label>
    		<div class="col-md-2 col-lg-2">
      			<p class="form-control-static"><s:property value="proveedor.numero"/></p>
    		</div>
    		<label for="piso" class="col-md-1 col-lg-1 control-label">Piso</label>
    		<div class="col-md-2 col-lg-2">
      			<p class="form-control-static"><s:property value="proveedor.piso"/></p>
    		</div>
    		<label for="depto" class="col-md-1 col-lg-1 control-label">Dpto.</label>
    		<div class="col-md-2 col-lg-2">
      			<p class="form-control-static"><s:property value="proveedor.dpto"/></p>
    		</div>
    		
  		</div>
  		
  		<div class="form-group">
    		<label for="localidadPartido" class="col-md-4 col-lg-4 control-label">Localidad/Partido</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="proveedor.localidadPartido"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="provincia" class="col-md-4 col-lg-4 control-label">Provincia</label>
    		<div class="col-md-3 col-lg-3">
      			<p class="form-control-static"><s:property value="proveedor.provincia.nombre"/></p>
      		</div>
      		<label for="codigoPostal" class="col-md-3 col-lg-3 control-label">Codigo Postal</label>
    		<div class="col-md-2 col-lg-2">
      			<p class="form-control-static"><s:property value="proveedor.codigoPostal"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="email" class="col-md-4 col-lg-4 control-label">Email</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="proveedor.email"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="paginaWeb" class="col-md-4 col-lg-4 control-label">Pagina Web</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="proveedor.paginaWeb"/></p>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="facebook" class="col-md-4 col-lg-4 control-label">Facebook</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="proveedor.direccionFacebook"/></p>
    		</div>
  		</div>
  		<div class="form-group">
  			<label for="twitter" class="col-md-4 col-lg-4 control-label">Twitter</label>
    		<div class="col-md-4 col-lg-4">
      			<p class="form-control-static"><s:property value="proveedor.direccionTwitter"/></p>
    		</div>
  		</div>
    </s:form>
	
    </div>
</body>
</html>