<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="producto_searchProducto" namespace="/" var="searchProducto" />
  <script type="text/javascript">
  	$(document).ready(function(){

  		changeLinksPagination('resultadoProductoSearch','searchProductoForm');

  	  	var optionsProducto = { 
  		  		target : '#resultadoProductoSearch',
  		  		url: '${searchProducto}', 
  		  		beforeSubmit:  function(){
	    			$('#resultadoProductoSearch >.displayTable').block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	    		},
			    success:    function(){ 
  					changeLinksPagination('resultadoProductoSearch','searchProductoForm');
			    } 
		};
  	  	
  		$('#searchProductoForm').submit(function() {
  	        $(this).ajaxSubmit(optionsProducto);
  	        return false;
  	    });
	    
  		  		

  		$("#codigo").keypress(function(){
  	  		var actual =  $(this).val().length;
  	  	  	var valorMaximo = $(this).attr('maxlength');
  		    if(actual==valorMaximo){
  		    	var codigo = $('#codigo').val();
  	  		    var nombre = $('#nombre').val();
  	  			var marca  = $('#marca').val();
  		    	$.ajax({
  		  			url:   '${searchProducto}',
  		  			data: {'codigo': codigo, 'nombre': nombre,'marca': marca}, 
  		  			cache: false,
  		  			type:  'get',
  		  			beforeSend: function () {
  		  				$('#nombre').val('');
  		  				$('#marca').val('');
  		  				$("#resultadoProductoSearch").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  		  			},
  		  			success:  function (response) {
  		  				$('#resultadoProductoSearch').html(response);
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
	<s:form id="searchProductoForm"  action="producto_searchProducto" theme="simple"  cssClass="form-horizontal" role="form">
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
    </s:form>
    <div id="resultadoProductoSearch">
    	<%@ include file="/pages/ajax/producto/resultSearchProducto.jsp"%>
    </div>
