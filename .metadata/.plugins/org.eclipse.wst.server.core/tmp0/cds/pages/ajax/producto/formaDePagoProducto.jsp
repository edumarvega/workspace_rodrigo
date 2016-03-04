<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="producto_loadFilterProducto" namespace="/" var="loadFilterProducto" />
<s:url action="ingresoProducto_save" namespace="/" var="save" />
<s:url action="getJSONAlertas_verificarAlertas" namespace="/" var="verificarAlertas" />
<s:url action="jsonCliente_getNombreCliente" namespace="/" var="getNombreCliente" />

  <script type="text/javascript">
  	$(document).ready(function(){

  		$("#importeContado").focus();

  		  		
  		  		
  		$("#importeCtaCte").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var importeCtaCte =  parseFloat($(this).val());
  	  	  	var total = parseFloat($("#total").val());
  	  	  	if(valorActual>0){
  	  	  		var saldo =(total-importeCtaCte).toFixed(2);
  		  		$("#saldoCtaCteDisabled").val(saldo);
  		  		$("#saldoCtaCte").val(saldo);
  	  	  	}
  	  	  	else{
  	  	  		$("#saldoCtaCteDisabled").val('0.00');
  	  	  		$("#saldoCtaCte").val('0.00');	
  	  	  	}
  		});
  		  		
  		
  		$('select').on('change', function() {
  		  
  			if(this.value==1){
  				 				
  				$('#divImporteContado').show();
  				$('#divCtaCteImporte').hide(); 
  				$('#divCtaCteSaldo').hide();
  				
  				$("#importeContado").focus();
  				$("#importeContado").val($("#total").val());
  				$("#saldoCtaCte").val('');
  				  				
  				$("#importeContado").prop('required',true);
  				$("#importeCtaCte").prop('required',false);
  			 			  
  		  	}
  		  	else{
  		  		$('#divImporteContado').hide();
				$('#divCtaCteImporte').show(); 
				$('#divCtaCteSaldo').show();
												
				$('#importeCtaCte').focus();
				$("#importeCtaCte").val('');
				$("#saldoCtaCteDisabled").val($("#total").val());
  	  	  		$("#saldoCtaCte").val($("#total").val());
  	  	  		
  	  	  		$("#importeContado").prop('required',false);
    			$("#importeCtaCte").prop('required',true);
  		  	}	
  			
  		});
  		
  		  		

  		// submmit del filtro de busqueda de productos
  		var optionsFilter = { 
			    target:     '#resultado', 
			    url:        '${save}',
			    beforeSubmit:  function(){
			    	$("#divFormaDePagoProducto").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
				},
			    success: function(){ 
					
  					changeLinksPagination('resultado','filterForm');
  					$("a:contains('Ultima')").click();

  					//esto quita el checked del radio button de la pantalla egresos
  					$("input:checked").each(function(){
  						$(this).removeAttr('checked');
  					});
  					
  					divFormaDePagoProducto.dialog('destroy').remove();
  					divIngresoProducto.dialog('destroy').remove();
  					
			    } 
		};
  	
  		$('#formFormaDePagoProducto').submit(function() {
  	        $(this).ajaxSubmit(optionsFilter);
  	        return false;
  	    });

  	     		
  		
 	});
  	
   </script>
	<s:form id="formFormaDePagoProducto" theme="simple"  cssClass="form-horizontal" role="form">
		
		<s:hidden id="fechaCompra" name="fechaCompra" value="%{fechaCompra}"/>
   		<s:hidden id="nroTicketFactura" name="nroTicketFactura" value="%{nroTicketFactura}"/>
   		<s:hidden id="idProveedor" name="idProveedor" value="%{idProveedor}"/>
   		<s:hidden id="total" name="total" value="%{total}"/>
		<s:hidden id="saldoCtaCte" name="saldoCtaCte" value=""/>
		
				 			
  		<div class="form-group">
    		<label for="total" class="col-md-4 col-lg-4 control-label">Total a pagar $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="totalCompra"  name="totalCompra" value="${total}" disabled="disabled">
    		</div>
  		</div>
  		<br><br>
  		<div class="form-group">
    		<label for="formaDePago" class="col-md-4 col-lg-4 control-label">Forma de pago</label>
    		<div class="col-md-5 col-lg-5">
 				<s:select 
					list="listaFormaDePago" 
					listKey="id"   
        			listValue="nombre"
        			id="formaDePago"
					name="formaDePago" 
					value="defaultFormaDePago" theme="simple" cssClass="form-control"/>	
      		</div>
  		</div>
  		
  		<div id="divImporteContado" class="form-group">
    		<label for="importeContado" class="col-md-4 col-lg-4 control-label">Importe $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="importeContado"  name="importeContado" value="${total}" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
  		</div>
  		  		
  		  		  		
  		<div id="divCtaCteImporte" class="form-group" style="display:none">
    		<label for="importeCtaCte" class="col-md-4 col-lg-4 control-label">Pago con $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="importeCtaCte"  name="importeCtaCte" value="" onkeypress="validaSoloNumerosConPunto();">
    		</div>
  		</div>
  		<div id="divCtaCteSaldo" class="form-group" style="display:none">
    		<label for="saldoCtaCteDisabled" class="col-md-4 col-lg-4 control-label">Saldo $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="saldoCtaCteDisabled"  name="saldoCtaCteDisabled" value="" disabled="disabled">
    		</div>
  		</div>
  		
  		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button id="aceptar" type="submit" class="btn btn-info">Aceptar</button>
    		</div>
   		</div>	
 		
    </s:form>
   
    	
