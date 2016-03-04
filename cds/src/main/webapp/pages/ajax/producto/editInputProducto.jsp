<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="jsonProveedor_getNombreRazonSocialProveedor" namespace="/" var="getNombreRazonSocialProveedor" />

  <script type="text/javascript">
  	$(document).ready(function(){
		
  		$("#fechaCompra").datepicker();
  		
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
  					divEditarIngresoProducto.dialog('destroy').remove();
			    } 
		};
  		$('#formEditIngresoProducto').submit(function() {
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
	        	return false;
	      	} 
		}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            return $( "<li>" )
            .append( "<a>" + item.nombreRazonSocial + "</a>" )
            .appendTo( ul );
        };
  		
 	});


	
   </script>
	<s:form id="formEditIngresoProducto"  action="ingresoProducto_update" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idCompra" name="compra.id" value="%{compra.id}"/>
		<s:hidden id="fechaAlta" name="compra.fechaAlta" value="%{compra.fechaAlta}"/>
		<s:hidden id="usuario" name="compra.usuario" value="%{compra.usuario}"/>
		<s:hidden id="total" name="total" value="%{total}"/>
	
		<div class="form-group">
    		<label for="fechaCompra" class="col-md-3 col-lg-3 control-label">Fecha compra</label>
    		<div class="col-md-2 col-lg-2">
      			<input type="text" class="form-control input-sm" id="fechaCompra" name="fechaCompra" value="<s:property value='compra.fechaCompra'/>" required>
    		</div>
  		</div>
  			
  		<div class="form-group">
    		<label for="nroTicketFactura" class="col-md-3 col-lg-3 control-label">NºFactura-Ticket</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="nroTicketFactura"  name="nroTicketFactura" value="${compra.nroTicketFactura}" required>
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="proveedor" class="col-md-3 col-lg-3 control-label">Proveedor</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="proveedor" name="proveedor"  value="${compra.proveedor}" required>
    		</div>
  		</div>
  		  		
  		<br/>
  		
  		<div id="itemsCompra" class="form-group">
  			<div class="ingresoGrillaScroll">
				<table id="tableIngreoProductos" class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Cantidad</th>
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Descripcion</th>
							<th>Precio compra</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<s:if test="%{compra.items!=null}">
    						<s:iterator value="compra.items" status="item">
								<tr>
           							<td><s:property value="cantidad"></s:property></td>      
           							<td><s:property value="codigo"></s:property></td>
           							<td><s:property value="nombre"></s:property></td>
           							<td><s:property value="descripcion"></s:property></td>
           							<td><s:property value="precioDeCompra"></s:property></td>
       							</tr>
       						</s:iterator>
						</s:if>
					</tbody>
				</table>
			</div>
			<h3 class="text-right"><strong>Total:$<s:property value="total"/></strong></h3>
    	</div>
  		
  		<div class="form-group">
  			<label for="button" class="col-md-3 col-lg-3 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Ingresar productos</button>
    		</div>
    	</div>	
    </s:form>
