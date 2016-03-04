<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
			    	divNewProveedor.dialog('destroy').remove();
			    } 
		};
  		$('#formAltaProveedor').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formAltaProveedor"  action="abmProveedor_save" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idProveedor" name="proveedor.id" value=""/>
  		<div class="form-group">
    		<label for="cuit" class="col-md-4 col-lg-4 control-label">Cuit</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="cuit" name="cuit"  value="" maxlength="11" onkeypress="validaSoloNumeros();" autofocus required>
    		</div>
  		</div>
  			
  		<div class="form-group">
    		<label for="nombreRazonSocial" class="col-md-4 col-lg-4 control-label">Nombre o Razon social</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="nombreRazonSocial" name="proveedor.nombreRazonSocial" value="" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="telefono" class="col-md-4 col-lg-4 control-label">Telefono</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="telefono"  name="proveedor.telefono" value="" >
    		</div>
    		<label for="fax" class="col-md-1 col-lg-1 control-label">Fax</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="fax"  name="proveedor.fax" value="" >
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="celular" class="col-md-4 col-lg-4 control-label">Celular</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="celular"  name="proveedor.celular" value="" >
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="direccion" class="col-md-4 col-lg-4 control-label">Direccion</label>
    		<div class="col-md-7 col-lg-7">
      			<input type="text" class="form-control input-sm" id="direccion"  name="proveedor.domicilio" value="" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="numero" class="col-md-4 col-lg-4 control-label">Numero</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="numero"  name="proveedor.numero" value="" onkeypress="validaSoloNumeros();" maxlength="6" required>
    		</div>
    		<label for="piso" class="col-md-1 col-lg-1 control-label">Piso</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="piso"  name="proveedor.piso" value="" onkeypress="validaSoloNumeros();" maxlength="2">
    		</div>
    		<label for="depto" class="col-md-1 col-lg-1 control-label">Dpto.</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="depto"  name="proveedor.dpto" value="" maxlength="2">
    		</div>
    		
  		</div>
  		
  		<div class="form-group">
    		<label for="localidadPartido" class="col-md-4 col-lg-4 control-label">Localidad/Partido</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="localidadPartido"  name="proveedor.localidadPartido" value="">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="provincia" class="col-md-4 col-lg-4 control-label">Provincia</label>
    		<div class="col-md-3 col-lg-3">
      			<!--<s:select headerKey="-1" headerValue="Selecione"
					list="provincias" 
					listKey="id"   
        			listValue="nombre"
					name="provincia" 
					value="defaultProvincia" theme="simple" cssClass="form-control"/>-->
				<select name="provincia" class="form-control" required>
  					<option value="">Selecione...</option>
  					<s:iterator value="provincias">
  					<option value='<s:property value="id"/>'><s:property value="nombre"/></option><br/>
					</s:iterator>
				</select>	
      		</div>
      		<label for="codigoPostal" class="col-md-3 col-lg-3 control-label">Codigo Postal</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="codigoPostal"  name="proveedor.codigoPostal" value="">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="email" class="col-md-4 col-lg-4 control-label">Email</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="email"  name="proveedor.email" value="">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="paginaWeb" class="col-md-4 col-lg-4 control-label">Pagina Web</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="paginaWeb"  name="proveedor.paginaWeb" value="">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="facebook" class="col-md-4 col-lg-4 control-label">Facebook</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="facebook"  name="proveedor.direccionFacebook" value="">
    		</div>
  		</div>
  		<div class="form-group">
  			<label for="twitter" class="col-md-4 col-lg-4 control-label">Twitter</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="twitter"  name="proveedor.direccionTwitter" value="">
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="observaciones" class="col-md-4 col-lg-4 control-label">Observaciones</label>
    		<div class="col-md-7 col-lg-7">
      			<textarea class="form-control input-sm" rows="3" name="proveedor.observaciones"></textarea>
    		</div>
  		</div>
 		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
