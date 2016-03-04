<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="producto_search" namespace="/" var="search" />
  <script type="text/javascript">
  	$(document).ready(function(){

  		changeLinksPagination('resultadoProductoFilter','filterProductoForm');

  	  	var optionsProducto = { 
  		  		target : '#resultadoProductoFilter',
  		  		url: '${search}', 
  		  		beforeSubmit:  function(){
	    			$('#resultadoProductoFilter >.displayTable').block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	    		},
			    success:    function(){ 
  					changeLinksPagination('resultadoProductoFilter','filterProductoForm');
			    } 
		};
  	  	
  		$('#filterProductoForm').submit(function() {
  	        $(this).ajaxSubmit(optionsProducto);
  	        return false;
  	    });
	    
  		
  		$('body').on('click','input:radio[name=productoselect]' ,function() {
  	  		//var tmp = $("input[name='productoselect']:checked").val();
  	  		var tmp = $(this).val();
  	  		var valores = tmp.split('-');
  	  	
  	  		if($('#idProducto').length>0){
				$('#idProducto').val(valores[0]);
		  	}  

	    		if($('#codigoProducto').length>0){
  				$('#codigoProducto').val(valores[1]);
  	 		}
  	  		
  	  		if($('#nombreProducto').length>0){
  	  			$('#nombreProducto').val(valores[2]);
  	  	  	}
  			  			
  			if($('#descripcionProducto').length>0){
  				$('#descripcionProducto').val(valores[3]);
  	  	  	}
  			
  			if($('#precioDeCompra').length>0){
  				$('#precioDeCompra').focus();
  	  	  	}

  			if($('#cantidadActualProducto').length>0){
  				$('#cantidadActualProducto').val(valores[5]);
  	  	  	}
  			$('#divBusquedaProducto').dialog('destroy').remove();
  			
        });
  		
  		

  		$("#codigo").keypress(function(){
  	  		var actual =  $(this).val().length;
  	  	  	var valorMaximo = $(this).attr('maxlength');
  		    if(actual==valorMaximo){
  		    	var codigo = $('#codigo').val();
  	  		    var nombre = $('#nombre').val();
  	  			var marca  = $('#marca').val();
  		    	$.ajax({
  		  			url:   '${search}',
  		  			data: {'codigo': codigo, 'nombre': nombre,'marca': marca}, 
  		  			cache: false,
  		  			type:  'get',
  		  			beforeSend: function () {
  		  				$('#nombre').val('');
  		  				$("#resultadoProductoFilter").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  		  			},
  		  			success:  function (response) {
  		  				$('#resultadoProductoFilter').html(response);
  	  		    		$("#codigo").val('');
  	  		    		$('#nombre').val('');  
  	  		    		$('#marca').val('');
  	  		    		$("#codigo").focus();
  		  			}
  		      	});
  	  		}
  		});
  		
 	});
 
	
   </script>
	<s:form id="filterProductoForm"  action="producto_search" theme="simple"  cssClass="form-horizontal" role="form">
 		<div class="form-group">
    		<label for="codigo" class="col-md-1 col-lg-1 control-label">Codigo</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="codigo"  name="codigo" value="" onkeypress="validaSoloNumeros();" maxlength="13" autofocus>
    		</div>
    		<label for="nombre" class="col-md-1 col-lg-1 control-label">Nombre</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="nombre"  name="nombre" value="">
    		</div>
    		<label for="marca" class="col-md-1 col-lg-1 control-label">Marca</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="marca"  name="marca" value="">
    		</div>
    		<label for="boton" class="col-md-0 col-lg-0 control-label"></label>
    		<div class="col-md-2 col-lg-2">
      			<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"></span>&nbsp;Buscar</button>
    		</div>
  		</div>
  		<br/>
    </s:form>
    <div id="resultadoProductoFilter">
    	<%@ include file="/pages/ajax/producto/resultFilterProducto.jsp"%>
    </div>
