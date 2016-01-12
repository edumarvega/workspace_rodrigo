<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="producto_loadFilterProducto" namespace="/" var="loadFilterProducto" />
<s:url action="egresoProducto_loadImporteProducto" namespace="/" var="loadImporteProducto" />
<s:url action="egresoProducto_addProducto" namespace="/" var="addProducto" />
<s:url action="egresoProducto_addProductoPorPrecio" namespace="/" var="addProductoPorPrecio" />
<s:url action="egresoProducto_deleteProducto" namespace="/" var="deleteProducto" />
<s:url action="jsonProducto_getNombreProducto" namespace="/" var="getNombreProducto" />
  <script type="text/javascript">
  	$(document).ready(function(){
  	  	
  		$("#codigo").keypress(function(){
  	  		var actual =  $(this).val().length;
  	  	  	var valorMaximo = $(this).attr('maxlength');
  		    if(actual==valorMaximo){
  	  		    var cantidad = $('#cantidad').val();
  	  			var codigo = $('#codigo').val();
  		    	$.ajax({
  		  			url:   '${addProducto}',
  		  			data: {'cantidad': cantidad, 'codigo': codigo}, 
  		  			cache: false,
  		  			type:  'get',
  		  			beforeSend: function () {
  		  				$("#itemsVenta").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  		  			},
  		  			success:  function (response) {
  		  				$('#itemsVenta').html(response);
  		  				/*$("#cantidad").val(''); 
  	  		    		$("#codigo").val('');  
  	  		    		$("#nombre").val('');
  	  		    		$("#codigo").attr("disabled", "disabled");
	  			        $("#nombre").attr("disabled", "disabled");
  	  		    		$("#cantidad").focus();*/	
  	  		    		$("#cantidad").val('1'); 
  	  		    		$("#codigo").val('');  
  	  		    		//$("#nombre").attr("disabled", "disabled");
  	  		    		$("#codigo").focus();
  		  			}
  		      	});
  	  		}
  		});


  		$("#nombre").autocomplete({
			dataType : 'json',
			source: '${getNombreProducto}',
			minLength: 3,
			focus: function( event, ui ) {
				$("#nombre").val(ui.item.nombre);
	        	return false;
	      	},
	      	select: function( event, ui ) {
	        	$("#nombre").val(ui.item.nombre);
	        	$("#codigo").val(ui.item.codigo);
	        	$("#codigo").keypress();
	        	return false;
	      	} 
		}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            return $( "<li>" )
            .append( "<a>"+ item.nombre + "-" + item.descripcion + "-" + item.marca + "</a>" )
            .appendTo( ul );
        };

  		
  		$("#egresar").click(function(){
  			showModalImporteProducto();	  			
  	  	});

  		/*$('#addNombre').click(function() {
	    	if($(this).is(':checked')) {
	    		$( "#nombreProducto" ).show();
	  			var actual =  $("#cantidad").val().length;
	  			if(actual>0){
  					$("#nombre").removeAttr("disabled");
  	  			}
  	  		}
  	  		else{
  				$("#nombreProducto").hide();
  				$("#nombre").val('');
		    	$("#nombre").attr("disabled", "disabled");
  		  	}
  		});*/

  		/*$("#cantidad").blur(function(){
  			var actual =  $(this).val().length;
  			if(actual>0){
  				$("#codigo").removeAttr("disabled");
  				if($('#addNombre').is(':checked')) {
  					$("#nombre").removeAttr("disabled");
  	  			}
  	  		}
  			else{
  				$("#codigo").attr("disabled", "disabled");
  	  		}
  				
  	  	});*/

  	  	$("#formEgresoProducto_selectedVentaPorcódigo").click(function(){
  	  		$("#divCodigo").show();
  	  		$("#divNombreProducto").hide();
  	  		$("#divPrecio").hide();
  	  		$("#codigo").val('');
  	  		$("#codigo").focus();  			
	  	});

  	  	$("#formEgresoProducto_selectedVentaPornombre").click(function(){
  	  		$("#divCodigo").hide();
	  		$("#divNombreProducto").show();
	  		$("#divPrecio").hide();
	  		$("#nombre").val('');
	  		$("#nombre").focus();				  			
	  	});

  	  	$("#formEgresoProducto_selectedVentaPorprecio").click(function(){
  	  		$("#divCodigo").hide();
	  		$("#divNombreProducto").hide();
	  		$("#divPrecio").show();
	  		$("#precio").val('');
	  		$("#precio").focus();		  			
	  	});

  	  	$("#addProducto").click(function(){
  	  			  	  	
		    if($("#precio").val().length>0){
		    	var cantidad = $("#cantidad").val();
	  		    var precio = $("#precio").val();
	  			var categoria = $('#formEgresoProducto_categoria option:selected').val();
		    	$.ajax({
		  			url:   '${addProductoPorPrecio}',
		  			data: {'cantidad':cantidad ,'precio': precio, 'categoria': categoria}, 
		  			cache: false,
		  			type:  'get',
		  			beforeSend: function () {
		  				$("#itemsVenta").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		  			},
		  			success:  function (response) {
		  				$('#itemsVenta').html(response);
	  		    		$("#cantidad").val('1'); 
	  		    		$("#precio").val('');  
	  		    		$("#precio").focus('');
		  			}
		      	});
	  		}			  			
	  	});
	  	
  	  
  		
  		
  		
 	});

  	var divImporteProducto;
   	function showModalImporteProducto(){
   	   	var observaciones = escape($("#observaciones").val());
   		var url = '${loadImporteProducto}?observaciones='+observaciones;
   		divImporteProducto = $('<div id="divImporteProducto"></div>');
  		divImporteProducto.dialog({
			   title: 'Cálculo de importe',
			   modal: true,
			   width: 650,
			   height: 370,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}


  	function eliminar(index){
		var url = '${deleteProducto}?index='+index;
		$.ajax({
			url:  url,
			cache: false,
			type:  'get',
			beforeSend: function () {
				$("#itemsVenta").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
			},
			success:  function (response) {
				$("#itemsVenta").html(response);
				$("#itemsVenta").unblock();
				$("#cantidad").val('1');

				if ($('#divCodigo').is(":visible")){
					$("#codigo").focus();
				}
				else if($('#divNombreProducto').is(":visible")){
					$("#nombre").val('');
					$("#nombre").focus();
				}
				else if($('#divPrecio').is(":visible")){
					$("#precio").val('');
					$("#precio").focus();
				}
			}
	    });
	}
	
   </script>
	<s:form id="formEgresoProducto"  action="egresoProducto_save" theme="simple"  cssClass="form-horizontal" role="form">
		<div class="form-group">
    		<label for="cantidad" class="col-md-2 col-lg-2 control-label">Cantidad</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="cantidad"  name="cantidad" value="1" onkeypress="validaSoloNumeros();">
    		</div>
    		<label for="categoria" class="col-md-2 col-lg-2 control-label">Venta por</label>
    		<div class="col-md-0 col-lg-0">
    			<s:radio name="selectedVentaPor" list="ventasPor" value="defaultVentaPor" cssClass="control-label"/>
    		</div>
  		</div>

  		<div id="divCodigo" class="form-group">
    		<label for="codigo" class="col-md-2 col-lg-2 control-label">Codigo</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="codigo"  name="codigo" value="" onkeypress="validaSoloNumeros();" maxlength="13" autofocus>
    		</div>
  		</div>
  		
  		<div  id="divNombreProducto" class="form-group" style="display:none">
    		<label for="nombre" class="col-md-2 col-lg-2 control-label">Nombre</label>
    		<div class="col-md-6 col-lg-6">
      			<input type="text" class="form-control input-sm" id="nombre"  name="nombre" value="">
    		</div>
  		</div>
  		
  		<div id="divPrecio"  class="form-group" style="display:none">
    		<label for="precio" class="col-md-2 col-lg-2 control-label">Precio $</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="precio"  name="precio" value="" onkeypress="validaSoloNumerosConPunto();">
    		</div>
    		<label for="categoria" class="col-md-2 col-lg-2 control-label">Categoria</label>
    		<div class="col-md-3 col-lg-3">
				<s:select 
					list="categorias" 
					listKey="id"   
        			listValue="nombre"
					name="categoria" 
					value="defaultCategoria" theme="simple" cssClass="form-control"/>	
      		</div>
      		<span id="addProducto" class="label label-success">Agregar producto</span>
  		</div>
  		
  		<div id="itemsVenta" class="form-group">
  			<%@ include file="/pages/ajax/producto/grillaEgresoProducto.jsp"%>
    	</div>
    	<div class="form-group">
    		<label for="observaciones" class="col-md-2 col-lg-2 control-label">Observaciones</label>
    		<div class="col-md-7 col-lg-7">
      			<textarea id="observaciones" class="form-control input-sm" rows="5" name="observaciones"></textarea>
    		</div>
  		</div>
    </s:form>
    <div class="form-group">
  		<label for="button" class="col-md-2 col-lg-2 control-label"></label>
    	<div class="col-md-4 col-lg-4">
      		<button id="egresar" type="button" class="btn btn-info">Confirmar venta</button>
    	</div>
   </div>
   <!--<div id="divImporteProducto" style="display:none;"></div> -->
    	
