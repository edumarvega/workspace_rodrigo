<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
  					divEditarIngresoVario.dialog('destroy').remove();
			    } 
		};
  		$('#formEdicionIngresoVario').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formEdicionIngresoVario"  action="ingresoVario_update" theme="simple"  cssClass="form-horizontal" role="form">
		
		<s:hidden id="idIngresoVario" name="ingresoVario.id" value="%{ingresoVario.id}"/>
		<s:hidden id="idIngresoVario" name="fecha" value="%{fecha}"/>
				
		<div class="form-group">
    		<label for="fechaCompra" class="col-md-3 col-lg-3 control-label">Fecha</label>
    		<div class="col-md-3 col-lg-3">
      			<s:date name="fecha" var="fecha" format="dd/MM/yyyy"/>
      			<s:textfield id="fecha" value="%{#fecha}" cssClass="form-control input-sm" disabled="true"/>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="tipoGastoVario" class="col-md-3 col-lg-3 control-label">Descripcion</label>
    		<div class="col-md-4 col-lg-4">
 				<s:select 
					list="tiposIngresosVarios" 
					listKey="id"   
        			listValue="nombre"
        			id="tipoIngresoVario"
					name="tipoIngresoVario" 
					value="defaultTipoIngresoVario" theme="simple" cssClass="form-control"/>	
      		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="nombre" class="col-md-3 col-lg-3 control-label">Nombre</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="nombre" name="ingresoVario.nombre"  value="${ingresoVario.nombre}" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="importe" class="col-md-3 col-lg-3 control-label">Importe</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="importe" name="ingresoVario.importe"  value="${ingresoVario.importe}" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
  		</div>
  			
  		  		
  		<div class="form-group">
    		<label for="observaciones" class="col-md-3 col-lg-3 control-label">Observaciones</label>
    		<div class="col-md-7 col-lg-7">
      			<textarea class="form-control input-sm" rows="3" name="ingresoVario.observaciones">${ingresoVario.observaciones}</textarea>
    		</div>
  		</div>
 		
  		<div class="form-group">
  			<label for="button" class="col-md-3 col-lg-3 control-label"></label>
    		<div class="col-md-3 col-lg-3">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>		
		
		
    </s:form>
    	
