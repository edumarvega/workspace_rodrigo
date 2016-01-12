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
  	  		var valores = $("input[name='productoselect']:checked").val().split("-");

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
  			
  			if($('#precioProducto').length>0){
  				$('#precioProducto').val(valores[4]);
  	  	  	}

  			if($('#cantidadActualProducto').length>0){
  				$('#cantidadActualProducto').val(valores[5]);
  	  	  	}
  			divBusquedaProducto.dialog('destroy').remove();
        });

  		$("#codigo").keypress(function(){
  	  		var actual =  $(this).val().length;
  	  	  	var valorMaximo = $(this).attr('maxlength');
  		    if(actual==valorMaximo){
  		    	var codigo = $('#codigo').val();
  	  		    var nombre = $('#nombre').val();
  		    	$.ajax({
  		  			url:   '${search}',
  		  			data: {'codigo': codigo, 'nombre': nombre}, 
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
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="codigo"  name="codigo" value="" onkeypress="validaSoloNumeros();" maxlength="13">
    		</div>
    		<label for="nombre" class="col-md-1 col-lg-1 control-label">Nombre</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="nombre"  name="nombre" value="">
    		</div>
    		<label for="boton" class="col-md-0 col-lg-0 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"></span>&nbsp;Buscar</button>
    		</div>
  		</div>
  		<br/>
    </s:form>
    <div id="resultadoProductoFilter">
    	<%@ include file="/pages/ajax/producto/resultFilterProducto.jsp"%>
    </div>
