<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="jsonProductoExistente_verificarExisteProducto" namespace="/" var="verificarExisteProducto" />


<script type="text/javascript">

	$(document).ready(function(){
  		  	  	
  	  	$("#codigo").focus();
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
			    	divNewProducto.dialog('destroy').remove();
			    	
			    } 
		};
  		
  		$('#formAltaProducto').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });

  		$('#codigo').focusout(function() {
  			var codigo = $(this).val();
  			var valorActual =  $(this).val().length;
  	  	  	if(valorActual>0){
  	  	  		$.ajax({
					url: '${verificarExisteProducto}',
					data: {'codigo': codigo}, 
					cache: false,
					type:  'GET',
					dataType: 'json',
					success:  function(data){
						if(data==="si") {
							showMsgError('El producto ya existe.');
						}
					}
				});
  	  		}
  	    });
  		
 	});
</script>
  
	<s:form id="formAltaProducto"  action="abmProducto_save" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idProducto" name="producto.id" value=""/>
  		<div class="form-group">
    		<label for="codigo" class="col-md-3 col-lg-3 control-label">Código</label>
    		<div id="divCodigo" class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="codigo" name="producto.codigo"  value="" maxlength="13" onkeypress="validaSoloNumeros();" required>
    		</div>
  		</div>
  			
  		<div class="form-group">
    		<label for="nombre" class="col-md-3 col-lg-3 control-label">Nombre</label>
    		<div class="col-md-7 col-lg-7">
      			<input type="text" class="form-control input-sm" id="nombre" name="producto.nombre" value="" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="descripcion" class="col-md-3 col-lg-3 control-label">Descripción</label>
    		<div class="col-md-9 col-lg-9">
      			<input type="text" class="form-control input-sm" id="descripcion"  name="producto.descripcion" value="" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="marca" class="col-md-3 col-lg-3 control-label">Marca</label>
    		<div class="col-md-7 col-lg-7">
      			<input type="text" class="form-control input-sm" id="marca"  name="producto.marca" value="" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="categoria" class="col-md-3 col-lg-3 control-label">Categoria</label>
    		<div class="col-md-4 col-lg-4">
      			<!--<input type="text" class="form-control input-sm" id="categoria" name="categoria" required>-->
      			<!--<s:select headerKey="-1" headerValue="Selecione"
					list="categorias" 
					listKey="id"   
        			listValue="nombre"
					name="categoria" 
					value="defaultCategoria" theme="simple" cssClass="form-control"/>-->
				<select name="categoria" class="form-control" required>
  					<option value="">Selecione...</option>
  					<s:iterator value="categorias">
  					<option value='<s:property value="id"/>'><s:property value="nombre"/></option><br/>
					</s:iterator>
				</select>	
      		</div>
  		</div>
  		<div class="form-group">
    		    <label for="cantidad" class="col-md-3 col-lg-3 control-label">Cantidad</label>
    		    <div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="cantidad"  name="producto.cantidad" value="" onkeypress="validaSoloNumeros();" placeholder="0" required>
    		   </div>
  		</div>
  		<div class="form-group">
    		<label for="precio" class="col-md-3 col-lg-3 control-label">Precio</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="precio" name="precio"  value="" placeholder="0.00" onkeypress="validaSoloNumerosConPunto();">
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="stockCritico" class="col-md-3 col-lg-3 control-label">Stock critico</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="stockCritico"  name="producto.stockCritico" value="" onkeypress="validaSoloNumeros();" placeholder="0">
    		</div>
  		</div>
  		<div class="form-group">
  			<label for="button" class="col-md-3 col-lg-3 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    
   	
