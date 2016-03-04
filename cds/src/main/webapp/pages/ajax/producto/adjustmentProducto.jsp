<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="producto_loadFilterProducto" namespace="/" var="loadFilterProducto" />
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
					divAjusteProducto.dialog('destroy').remove();
  					
			    } 
		};
  		$('#formAjusteProducto').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });

  		$("#buscarProducto").click(function(){
  			showModalFilterProducto();		  			
  	  	});
  		
 	});


  	var divBusquedaProducto;
  	function showModalFilterProducto(){
  		divBusquedaProducto = $('<div id="divBusquedaProducto"></div>');
  		divBusquedaProducto.dialog({
			   title: 'Busqueda de producto',
			   modal: true,
			   width: 1024,
			   height: 560,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadFilterProducto}',function(){
					$(this).unblock();
					$("#codigo").focus();
					
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}
	
   </script>
	<s:form id="formAjusteProducto"  action="ajusteProducto_save" theme="simple"  cssClass="form-horizontal" role="form">
	<s:hidden id="idProducto" name="idProducto" value=""/>
	
		<div class="form-group">
    		<label for="cantidad" class="col-md-3 col-lg-3 control-label">Nombre</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="nombreProducto"  name="" value="" disabled="disabled">
    		</div>
    		<div class="col-md-0 col-lg-0">
      			<img id="buscarProducto" src="${appCtx}/images/iconos/lupaOver.gif"  alt="Buscar producto">
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="codigo" class="col-md-3 col-lg-3 control-label">Código</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="codigoProducto" name=""  value="" maxlength="13" disabled="disabled">
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-3 col-lg-3 control-label">Descripcion</label>
    		<div class="col-md-9 col-lg-9">
      			<input type="text" class="form-control input-sm" id="descripcionProducto"  name="" value="" disabled="disabled">
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-3 col-lg-3 control-label">Cantidad actual</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="cantidadActualProducto"  name="" value="" disabled="disabled">
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="cantidad" class="col-md-3 col-lg-3 control-label">Cantidad nueva</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="cantidadNuevaProducto"  name="ajuste.cantidadConAjuste" value="" onkeypress="validaSoloNumeros();" placeholder="0" autofocus required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="motivo" class="col-md-3 col-lg-3 control-label">Motivo ajuste</label>
    		<div class="col-md-4 col-lg-4">
      			<select name="motivo" class="form-control" required>
  					<option value="">Selecione</option>
  					<s:iterator value="motivos">
  					<option value='<s:property value="id"/>'><s:property value="nombre"/></option><br/>
					</s:iterator>
				</select>	
      		</div>
  		</div>
		

  		
  		<div class="form-group">
  			<label for="button" class="col-md-3 col-lg-3 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    
    <!--<div id="divBusquedaProducto" style="display:none;"></div> -->
  			
    
    	
