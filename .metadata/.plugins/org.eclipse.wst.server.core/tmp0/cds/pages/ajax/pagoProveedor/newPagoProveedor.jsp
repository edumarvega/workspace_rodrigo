<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="pagoProveedor_save" namespace="/" var="save" />

  <script type="text/javascript">
  	$(document).ready(function(){

  		$("#pago").focus();
  		  		
  		$("#pago").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var pago =  parseFloat($(this).val());
  	  	  	var saldoAnterior = parseFloat($("#saldoAnterior").val());
  	  	  	if(valorActual>0){
  	  	  		var saldoActual =(saldoAnterior-pago).toFixed(2);
  		  		$("#saldoActual").val(saldoActual);
  		  		$("#saldoActualDisabled").val(saldoActual);
  	  	  	}
  	  	  	else{
  	  	  		$("#saldoActual").val('0.00');
  	  	  		$("#saldoActualDisabled").val('0.00');	
  	  	  	}
  		});
  		  		

  		// submmit del filtro de busqueda de productos
  		var optionsFilter = { 
			    target:     '#resultado', 
			    url:        '${save}',
			    beforeSubmit:  function(){
			    	$("#divNewPagoProveedor").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
				},
			    success: function(){ 
					changeLinksPagination('resultado','filterForm');
  					divNewPagoProveedor.dialog('destroy').remove();
			    } 
		};
  	
  		$('#formPagoProveedor').submit(function() {
  	        $(this).ajaxSubmit(optionsFilter);
  	        return false;
  	    });

  	     		
  		
 	});
  	
   </script>
	<s:form id="formPagoProveedor" theme="simple"  cssClass="form-horizontal" role="form">
		
		<s:hidden id="idCuentaCorriente" name="idCuentaCorriente" value="%{idCuentaCorriente}"/>
		<s:hidden id="totalCompra" name="totalCompra" value="%{totalCompra}"/>
		<s:hidden id="saldoAnterior" name="saldoAnterior" value="%{saldoAnterior}"/>
		<s:hidden id="saldoActual" name="saldoActual" value="%{saldoActual}"/>
		
				 			
  		<div class="form-group">
    		<label for="total" class="col-md-4 col-lg-4 control-label">Total compra $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="totalCompraDisabled"  name="totalCompraDisabled" value="${totalCompra}" disabled="disabled">
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="total" class="col-md-4 col-lg-4 control-label">Saldo anterior $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="saldoAnteriorDisabled"  name="saldoAnteriorDisabled" value="${saldoAnterior}" disabled="disabled">
    		</div>
  		</div>
  		<br><br> 		  		
  		<div class="form-group">
    		<label for="pago" class="col-md-4 col-lg-4 control-label">Pago $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="pago"  name="pago" value="" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="saldoActualDisabled" class="col-md-4 col-lg-4 control-label">Saldo actual $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="saldoActualDisabled"  name="saldoActualDisabled" value="${saldoActual}" disabled="disabled">
    		</div>
  		</div>
  		
  		
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button id="aceptar" type="submit" class="btn btn-info">Aceptar</button>
    		</div>
   		</div>	
 		
    </s:form>
