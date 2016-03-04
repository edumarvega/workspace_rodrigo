<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="cobranzaCliente_save" namespace="/" var="save" />

  <script type="text/javascript">
  	$(document).ready(function(){

  		$("#cobro").focus();
  		  		
  		$("#cobro").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var cobranza =  parseFloat($(this).val());
  	  	  	var saldoAnterior = parseFloat($("#saldoAnterior").val());
  	  	  	if(valorActual>0){
  	  	  		var saldoActual =(saldoAnterior-cobranza).toFixed(2);
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
			    	$("#divNewCobranzaCliente").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
				},
			    success: function(){ 
					changeLinksPagination('resultado','filterForm');
					divNewCobranzaCliente.dialog('destroy').remove();
			    } 
		};
  	
  		$('#formCobranzaCliente').submit(function() {
  	        $(this).ajaxSubmit(optionsFilter);
  	        return false;
  	    });

  	     		
  		
 	});
  	
   </script>
	<s:form id="formCobranzaCliente" theme="simple"  cssClass="form-horizontal" role="form">
		
		<s:hidden id="idCuentaCorriente" name="idCuentaCorriente" value="%{idCuentaCorriente}"/>
		<s:hidden id="totalVenta" name="totalVenta" value="%{totalVenta}"/>
		<s:hidden id="saldoAnterior" name="saldoAnterior" value="%{saldoAnterior}"/>
		<s:hidden id="saldoActual" name="saldoActual" value="%{saldoActual}"/>
		
				 			
  		<div class="form-group">
    		<label for="total" class="col-md-4 col-lg-4 control-label">Total venta $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="totalVentaDisabled"  name="totalVentaDisabled" value="${totalVenta}" disabled="disabled">
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
    		<label for="cobro" class="col-md-4 col-lg-4 control-label">Pago $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="cobro"  name="cobro" value="" onkeypress="validaSoloNumerosConPunto();" required>
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
