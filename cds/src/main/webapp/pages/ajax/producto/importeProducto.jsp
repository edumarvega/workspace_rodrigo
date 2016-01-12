<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="producto_loadFilterProducto" namespace="/" var="loadFilterProducto" />
<s:url action="egresoProducto_save" namespace="/" var="save" />
<s:url action="getJSONAlertas_verificarAlertas" namespace="/" var="verificarAlertas" />
<script type="text/javascript">

  $(document).ready(function(){

  		$("#importe").focus();
		$("#ventaTotal").val($("#total").val());
		
		var totalGlobal = $("#total").val();
		

  		$("#importe").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var importe =  parseFloat($(this).val());
  	  	  	var total = parseFloat($("#total").val());
  	  	  	if(valorActual>0){
  	  	  		var vuelto =(importe-total).toFixed(2);
  		  		$("#vuelto").val(vuelto);
  		  		$("#cambio").val(vuelto);
  	  	  	}
  	  	  	else{
  	  	  		$("#vuelto").val('0.00');
  	  	  		$("#cambio").val('0.00');	
  	  	  	}
  		});

  		$("#porcentajeDescuento").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var porcentajeDescuento = $(this).val();
  	  		var importe =  parseFloat($("#importe").val());
  	  		var total = parseFloat(totalGlobal);
  	  		var cambio = $("#cambio").val();
  	  	  	
  	  	  	if(valorActual>0){
  	  	  		var importeADescontar = (total*porcentajeDescuento)/100;
  	  	  	  	var totalConDescuento = (total-importeADescontar).toFixed(2); 
  	  	  		var vuelto =(importe-totalConDescuento).toFixed(2);
  	  	  		$("#total").val(totalConDescuento);
  	  	  		$("#ventaTotal").val(totalConDescuento);
  		  		$("#vuelto").val(vuelto);
  		  		$("#cambio").val(vuelto);
  		  		$("#descuento").val(importeADescontar);
  	  	  	}
  	  	  	else{
  	  	  		var totalSinDescuento = parseFloat(totalGlobal);
  	  	  		var cambio = (importe-totalSinDescuento).toFixed(2);
  	  			$("#total").val(totalSinDescuento);
  	  			$("#ventaTotal").val(totalSinDescuento);
  	  			$("#vuelto").val(cambio);
  	  	  		$("#cambio").val(cambio);
  	  	  		$("#descuento").val('');
  	  	  	}
  		});

  		$("#interesDebito").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var interes = parseFloat($(this).val());
  	  		var total = parseFloat($("#ventaTotal").val());
  	  	  	
  	  	  	if(valorActual>0){
  	  	  	  	var importeConInteres = (total*interes)/100;
  	  	  	  	var totalConInteres = (total+importeConInteres).toFixed(2); 
  	  	  		$("#total").val(totalConInteres);
  	  	  		$("#ventaTotal").val(totalConInteres);
  	  	  	}
  	  	  	else{
  	  	  		$("#total").val(totalGlobal);
  	  	  		$("#ventaTotal").val(totalGlobal);
  	  	  		
  	  	  	
  	  	  	}
  		});

  		$("#interesTarjetaCredito").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var interes = parseFloat($(this).val());
  	  		var total = parseFloat($("#ventaTotal").val());
  	  	  	
  	  	  	if(valorActual>0){
  	  	  	  	var importeConInteres = (total*interes)/100;
  	  	  	  	var totalConInteres = (total+importeConInteres).toFixed(2); 
  	  	  		$("#total").val(totalConInteres);
  	  	  		$("#ventaTotal").val(totalConInteres);
  	  	  	}
  	  	  	else{
  	  	  		$("#total").val(totalGlobal);
	  	  		$("#ventaTotal").val(totalGlobal);
  	  	  	}
  		});



  		// submmit del filtro de busqueda de productos
  		var optionsFilter = { 
			    target:     '#resultado', 
			    url:        '${save}', 
			    beforeSerialize: function($form, options) { 
				 			  					
	  					if($("#formImporteProducto_selectedMedioDePagoEfectivo").is(":checked")){
	  						$("#importe").prop('required',true);
		  					$("#interesDebito").removeAttr("required");
		  					$("#interesTarjetaCredito").removeAttr("required");
	  					}
						
	  					if($("#formImporteProducto_selectedMedioDePagoDébito").is(":checked")){
	  						$("#importe").removeAttr("required");
							$("#interesDebito").prop('required',true);
		  					$("#interesTarjetaCredito").removeAttr("required");
	  					}
						
	  					if($("#formImporteProducto_selectedMedioDePagoTarjetaCrédito").is(":checked")){
	  						$("#importe").removeAttr("required");
		  					$("#interesDebito").removeAttr("required");
		  					$("#interesTarjetaCredito").prop('required',true);
	  					}
	  					
					return true;                  
				},
			    beforeSubmit:  function(){
  	  				$("#divImporteProducto").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  	  	  	  		
				},
			    success: function(){ 
					
  					changeLinksPagination('resultado','filterForm');
  					$("a:contains('Ultima')").click();

  					//esto quita el checked del radio button de la pantalla egresos
  					$("input:checked").each(function(){
  						$(this).removeAttr('checked');
  					});
  								
  					$.ajax({
  						url: '${verificarAlertas}',
  						cache: false,
  						type:  'GET',
  						dataType: 'json',
  						success:  function(data){
  							if(data==="si") {
  								$("#alerta").show(2000);
  							}
  							divImporteProducto.dialog('destroy').remove();
  		  		  			divEgresoProducto.dialog('destroy').remove();	
  						}
  				    });
			    } 
		};
  		$('#formImporteProducto').submit(function() {
  	        $(this).ajaxSubmit(optionsFilter);
  	        return false;
  	    });

  		$("#formImporteProducto_selectedMedioDePagoEfectivo").click(function(){
  			$("#total").val(totalGlobal);
  	  		$("#ventaTotal").val(totalGlobal);
  	  		
  			$("#addDescuento").removeAttr('checked');
  	  		$("#divDescuento").hide();
  	  		$("#divTarjetaDebito").hide();
  	  		$("#divTarjetaCredito").hide();
  	  		$("#divImporte").show();
  	  		$("#divCambio").show();
  	  		$("#importe").val('');
  	  		$("#vuelto").val('');
  	  		$("#importe").focus();
  	  		$("#importe").prop('required',true);
  	  		$("#descuento").val('');
  	  		$("#porcentajeDescuento").removeAttr("required");
  	  		$("#interesDebito").removeAttr("required");
			$("#interesTarjetaCredito").removeAttr("required");  			
	  	});

  	  	$("#formImporteProducto_selectedMedioDePagoDébito").click(function(){
  	  		$("#total").val(totalGlobal);
	  		$("#ventaTotal").val(totalGlobal);
	  		
  	  	  	var total = parseFloat($("#ventaTotal").val());
  	  	  	var descuento = parseFloat($("#descuento").val());
  	  		if(!isNaN(descuento) ) {
  	  			var totalSinDescuento = (total+descuento).toFixed(2);
  	  			$("#total").val(totalSinDescuento);
  	  			$("#ventaTotal").val(totalSinDescuento);
  	  			$("#descuento").val('');
  	  		}
  	  	  	  	  		
  	  		$("#vuelto").val('');
  	  		$("#cambio").val('');
  	  		$("#divImporte").hide();
  	  		$("#divDescuento").hide();
  	  		$("#divCambio").hide();
	  		$("#divTarjetaCredito").hide();
	  		$("#divTarjetaDebito").show();
	  		$("#interesDebito").val('');
	  		$("#interesDebito").focus();
	  		$("#interesDebito").prop('required',true);
	  		$("#porcentajeDescuento").removeAttr("required");
	  		$("#interesTarjetaCredito").removeAttr("required");	
	  		$("#importe").removeAttr("required");	
	  	});

  	  	$("#formImporteProducto_selectedMedioDePagoTarjetaCrédito").click(function(){
  	  		$("#total").val(totalGlobal);
  			$("#ventaTotal").val(totalGlobal);
  		
  	  		var total = parseFloat($("#ventaTotal").val());
	  	  	var descuento = parseFloat($("#descuento").val());
	  		if(!isNaN(descuento) ) {
	  			var totalSinDescuento = (total+descuento).toFixed(2);
	  			$("#total").val(totalSinDescuento);
	  			$("#ventaTotal").val(totalSinDescuento);
	  			$("#descuento").val('');
	  		}
	  		
	  		$("#vuelto").val('');
  	  		$("#cambio").val('');
  	  		$("#divImporte").hide();
  	  		$("#divDescuento").hide();
  	  		$("#divCambio").hide();
  			$("#divTarjetaDebito").hide();
  			$("#divTarjetaCredito").show();
	  		$("#interesTarjetaCredito").val('');
	  		$("#interesTarjetaCredito").focus();
	  		$("#interesTarjetaCredito").prop('required',true);
	  		$("#porcentajeDescuento").removeAttr("required");
	  		$("#interesDebito").removeAttr("required");
	  		$("#importe").removeAttr("required");
	  	});

  	  $('#addDescuento').click(function() {
    		if($(this).is(':checked')) {
    			$("#divDescuento").show();
    			$("#porcentajeDescuento").val('');
    	  		$("#porcentajeDescuento").focus();
    	  		$("#porcentajeDescuento").attr("required");
    		}
    		else{
    			$("#total").val(parseFloat($("#ventaTotal").val()));
    			$("#divDescuento").hide();
    			$("#porcentajeDescuento").removeAttr("required");	
    			var total = $("#total").val();
    			var efectivo = parseFloat($("#importe").val());
    			var cambio = (efectivo-total).toFixed(2);
    			$("#cambio").val(cambio); 
    			$("#vuelto").val(cambio);
        	}
		});

  	    

  		/*$("#aceptar").click(function(){
  			$.ajax({
  				url: '${save}',
  				cache: false,
  				type:  'get',
  				beforeSend: function () {
  					$("#divImporteProducto").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Actualizando stock...</h5>' });
  				},
  				success:  function (response) {

  					$("#resultado").html(response);
  					changeLinksPagination('resultado','filterForm');
  					$("a:contains('Ultima')").click();

  					//esto quita el checked del radio button de la pantalla egresos
  					$("input:checked").each(function(){
  						$(this).removeAttr('checked');
  					});
  								
  					$.ajax({
  						url: '${verificarAlertas}',
  						cache: false,
  						type:  'GET',
  						dataType: 'json',
  						success:  function(data){
  							if(data==="si") {
  								$("#alerta").show(2000);
  							}
  							divImporteProducto.dialog('destroy').remove();
  		  		  			divEgresoProducto.dialog('destroy').remove();	
  						}
  				    });
  				}
  		    });
  		});*/
  		
 	});

 	
   </script>
	<s:form id="formImporteProducto" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="ventaTotal" name="ventaTotal" value=""/>
		<s:hidden id="cambio" name="cambio" value=""/>
		<s:hidden id="descuento" name="descuento" value=""/>
				 			
  		<div class="form-group">
    		<label for="total" class="col-md-3 col-lg-3 control-label">TOTAL $</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="total"  name="totalVenta" value="${totalVenta}" disabled="disabled">
    		</div>
  		</div>
  		<br>
  		<div class="form-group">
    		<label for="mediosDePago" class="col-md-3 col-lg-3 control-label">Venta en</label>
    		<div class="col-md-0 col-lg-0">
    			<s:radio name="selectedMedioDePago" list="mediosDePago" value="defaultMediDePago" cssClass="control-label"/>
    		</div>
  		</div>
  		
  		<div id="divImporte" class="form-group">
    		<label for="importe" class="col-md-3 col-lg-3 control-label">Pago con $</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="importe"  name="importe" value="" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
    		<div class="col-md-0 col-lg-0">
    			<input id="addDescuento"  type="checkbox"/>&nbsp;Descuento
    		</div>
  		</div>
  		<div id="divDescuento" class="form-group" style="display:none">
    		<label for="porcentajeDescuento" class="col-md-3 col-lg-3 control-label">Descuento %</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="porcentajeDescuento"  name="porcentajeDescuento" value="" onkeypress="validaSoloNumerosConPunto();" >
    		</div>
  		</div>
  		<div id="divTarjetaDebito" class="form-group" style="display:none">
    		<label for="interesDebito" class="col-md-3 col-lg-3 control-label">Interes %</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="interesDebito"  name="interesDebito" value="" onkeypress="validaSoloNumerosConPunto();" >
    		</div>
  		</div>
  		<div id="divTarjetaCredito" class="form-group" style="display:none">
    		<label for="interesTarjetaCredito" class="col-md-3 col-lg-3 control-label">Interes %</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="interesTarjetaCredito"  name="interesTarjetaCredito" value="" onkeypress="validaSoloNumerosConPunto();" >
    		</div>
  		</div>
  		<br>
  		<div id="divCambio" class="form-group">
    		<label for="vuelto" class="col-md-3 col-lg-3 control-label">Cambio $</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="vuelto"  name="vuelto" value="" disabled="disabled">
    		</div>
  		</div>
  		<div class="form-group">
  			<label for="button" class="col-md-3 col-lg-3 control-label"></label>
    		<div class="col-md-3 col-lg-3">
      			<button id="aceptar" type="submit" class="btn btn-info">Aceptar</button>
    		</div>
   		</div>	
 		
    </s:form>
   
    	
