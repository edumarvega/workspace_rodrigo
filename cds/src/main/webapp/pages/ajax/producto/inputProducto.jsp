<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="ingresoProducto_loadAddProducto" namespace="/" var="loadAddProducto" />
<s:url action="ingresoProducto_deleteProducto" namespace="/" var="deleteProducto" />
<s:url action="jsonProveedor_getNombreRazonSocialProveedor" namespace="/" var="getNombreRazonSocialProveedor" />
<s:url action="ingresoProducto_loadFormaDePagoProducto" namespace="/" var="loadFormaDePagoProducto" />

  <script type="text/javascript">
  	$(document).ready(function(){
		
  		$("#fechaCompra").datepicker();
  		
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
  					divIngresoProducto.dialog('destroy').remove();
			    } 
		};
  		$('#formIngresoProducto').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });

  		//$('#precio').mask("#.##0,00", {reverse: true, maxlength: false});

  		$("#codigo").keyup(function(){
  	  		var actual =  $(this).val().length;
  	  	  	var valorMaximo = $(this).attr('maxlength');
  		    if(actual==valorMaximo){
  	  		    alert('ajax... buscar de la session la lista de productos');
  	  		}
  		});

  		$("#proveedor").autocomplete({
			dataType : 'json',
			source: '${getNombreRazonSocialProveedor}',
			minLength: 3,
			focus: function( event, ui ) {
				$("#proveedor").val(ui.item.nombreRazonSocial);
	        	return false;
	      	},
	      	select: function( event, ui ) {
	        	$("#proveedor").val(ui.item.nombreRazonSocial);
	        	$("#idProveedor").val(ui.item.id);
	        	return false;
	      	} 
		}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            return $( "<li>" )
            .append( "<a>" + item.nombreRazonSocial + "</a>" )
            .appendTo( ul );
        };

        
  		$("#addProducto").click(function(){
  			showModalAddProducto();		  			
  	  	});
  		
  		$("#ingresarProducto").click(function(){
  			showModalFormaPagoProducto();	  			
  	  	});
  	  	
  		
 	});

  	var divAddProducto
  	function showModalAddProducto(){
  		divAddProducto = $('<div id="divAddProducto"></div>');
  		divAddProducto.dialog({
			   title: 'Agregar producto',
			   modal: true,
			   width: 630,
			   height: 440,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadAddProducto}',function(){
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
				$("#itemsCompra").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
			},
			success:  function (response) {
				$("#itemsCompra").html(response);
				$("#itemsCompra").unblock();
			}
	    });
	}
	
	var divFormaDePagoProducto;
   	function showModalFormaPagoProducto(){
   		
   		var fechaCompra = $('#fechaCompra').val();
   		var nroTicketFactura = $('#nroTicketFactura').val();
   		var idProveedor = $('#idProveedor').val();
   		var total = $('#totalCompraTmp').val();
   		  		
   		var url = '${loadFormaDePagoProducto}?fechaCompra='+fechaCompra+'&nroTicketFactura='+nroTicketFactura+'&idProveedor='+idProveedor+'&total='+total;
   		divFormaDePagoProducto = $('<div id="divFormaDePagoProducto"></div>');
   		divFormaDePagoProducto.dialog({
			   title: 'Forma de pago compra',
			   modal: true,
			   width: 600,
			   height: 380,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}
	
   </script>
	<s:form id="formIngresoProducto"  action="ingresoProducto_save" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idProveedor" name="idProveedor" value=""/>
				
		<div class="form-group">
    		<label for="fechaCompra" class="col-md-3 col-lg-3 control-label">Fecha compra</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="fechaCompra" name="compra.fechaCompra" placeholder="  /  /  " required>
    		</div>
  		</div>
  			
  		<div class="form-group">
    		<label for="nroTicketFactura" class="col-md-3 col-lg-3 control-label">NºFactura-Ticket</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="nroTicketFactura"  name="compra.nroTicketFactura" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="proveedor" class="col-md-3 col-lg-3 control-label">Proveedor</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="proveedor" name="compra.proveedor" value="" required>
    		</div>
  		</div>
 		
  		<span id="addProducto" class="label label-success">Agregar producto</span>
  		<div id="itemsCompra" class="form-group">
  			<%@ include file="/pages/ajax/producto/grillaIngresoProducto.jsp"%>
    	</div>
 		
    </s:form>
    <div class="form-group">
  		<label for="button" class="col-md-3 col-lg-3 control-label"></label>
    	<div class="col-md-4 col-lg-4">
      		<button id="ingresarProducto" type="button" class="btn btn-info">Ingresar productos</button>
    	</div>
    </div>	
    
    <!--<div id="divAddProducto" style="display:none"></div> -->
    
    	
