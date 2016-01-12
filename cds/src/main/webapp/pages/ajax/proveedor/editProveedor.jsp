<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
			    	divEditarProveedor.dialog('destroy').remove();
			    } 
		};
  		$('#formEdicionProveedor').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formEdicionProveedor"  action="abmProveedor_update" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idProveedor" name="proveedor.id" value="%{proveedor.id}"/>
		<div class="form-group">
    		<label for="cuit" class="col-md-4 col-lg-4 control-label">Cuit</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="cuit" name="cuit"  value="${cuit}" maxlength="11" onkeypress="validaSoloNumeros();" autofocus required>
    		</div>
  		</div>
  			
  		<div class="form-group">
    		<label for="nombreRazonSocial" class="col-md-4 col-lg-4 control-label">Nombre o Razon social</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="nombreRazonSocial" name="proveedor.nombreRazonSocial" value="${proveedor.nombreRazonSocial}" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="telefono" class="col-md-4 col-lg-4 control-label">Telefono</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="telefono"  name="proveedor.telefono" value="${proveedor.telefono}" >
    		</div>
    		<label for="fax" class="col-md-1 col-lg-1 control-label">Fax</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="fax"  name="proveedor.fax" value="${proveedor.fax}" >
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="celular" class="col-md-4 col-lg-4 control-label">Celular</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="celular"  name="proveedor.celular" value="${proveedor.celular}" >
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="direccion" class="col-md-4 col-lg-4 control-label">Direccion</label>
    		<div class="col-md-7 col-lg-7">
      			<input type="text" class="form-control input-sm" id="direccion"  name="proveedor.domicilio" value="${proveedor.domicilio}" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="numero" class="col-md-4 col-lg-4 control-label">Numero</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="numero"  name="proveedor.numero" value="${proveedor.numero}" onkeypress="validaSoloNumeros();" maxlength="6" required>
    		</div>
    		<label for="piso" class="col-md-1 col-lg-1 control-label">Piso</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="piso"  name="proveedor.piso" value="${proveedor.piso}" onkeypress="validaSoloNumeros();" maxlength="2">
    		</div>
    		<label for="depto" class="col-md-1 col-lg-1 control-label">Dpto.</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="depto"  name="proveedor.dpto" value="${proveedor.dpto}" maxlength="2">
    		</div>
    		
  		</div>
  		
  		<div class="form-group">
    		<label for="localidadPartido" class="col-md-4 col-lg-4 control-label">Localidad/Partido</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="localidadPartido"  name="proveedor.localidadPartido" value="${proveedor.localidadPartido}">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="provincia" class="col-md-4 col-lg-4 control-label">Provincia</label>
    		<div class="col-md-3 col-lg-3">
      			<s:select
					list="provincias" 
					listKey="id"   
        			listValue="nombre"
					name="provincia" 
					value="defaultProvincia" theme="simple" cssClass="form-control"/>
      		</div>
      		<label for="codigoPostal" class="col-md-3 col-lg-3 control-label">Codigo Postal</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="codigoPostal"  name="proveedor.codigoPostal" value="${proveedor.codigoPostal}">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="email" class="col-md-4 col-lg-4 control-label">Email</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="email"  name="proveedor.email" value="${proveedor.email}">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="paginaWeb" class="col-md-4 col-lg-4 control-label">Pagina Web</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="paginaWeb"  name="proveedor.paginaWeb" value="${proveedor.paginaWeb}">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="facebook" class="col-md-4 col-lg-4 control-label">Facebook</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="facebook"  name="proveedor.direccionFacebook" value="${proveedor.direccionFacebook}">
    		</div>
  		</div>
  		<div class="form-group">
  			<label for="twitter" class="col-md-4 col-lg-4 control-label">Twitter</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="twitter"  name="proveedor.direccionTwitter" value="${proveedor.direccionTwitter}">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="observaciones" class="col-md-4 col-lg-4 control-label">Observaciones</label>
    		<div class="col-md-7 col-lg-7">
      			<textarea class="form-control input-sm" rows="3" name="proveedor.observaciones">${proveedor.observaciones}</textarea>
    		</div>
  		</div>
 		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
