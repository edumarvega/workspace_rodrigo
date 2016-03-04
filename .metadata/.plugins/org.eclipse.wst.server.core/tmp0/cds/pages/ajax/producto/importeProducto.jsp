<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="producto_loadFilterProducto" namespace="/" var="loadFilterProducto" />
<s:url action="egresoProducto_save" namespace="/" var="save" />
<s:url action="getJSONAlertas_verificarAlertas" namespace="/" var="verificarAlertas" />
<s:url action="jsonCliente_getNombreCliente" namespace="/" var="getNombreCliente" />

  <script type="text/javascript">
  	$(document).ready(function(){

  		$("#importe").focus();
		$("#ventaTotal").val($("#totalVenta").val());
		
		var totalGlobal = $("#totalVenta").val();
		

  		$("#importe").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var importe =  parseFloat($(this).val());
  	  	  	var total = parseFloat($("#totalVenta").val());
  	  	  	if(valorActual>0){
  	  	  		var vuelto =(importe-total).toFixed(2);
  		  		$("#vueltoDisabled").val(vuelto);
  		  		$("#cambio").val(vuelto);
  	  	  	}
  	  	  	else{
  	  	  		$("#vueltoDisabled").val('0.00');
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
  	  	  		$("#totalVenta").val(totalConDescuento);
  	  	  		$("#ventaTotal").val(totalConDescuento);
  		  		$("#vuelto").val(vuelto);
  		  		$("#cambio").val(vuelto);
  		  		$("#descuento").val(importeADescontar);
  		  		$("#vueltoDisabled").val(vuelto);
  	  	  	}
  	  	  	else{
  	  	  		var totalSinDescuento = parseFloat(totalGlobal);
  	  	  		var cambio = (importe-totalSinDescuento).toFixed(2);
  	  			$("#totalVenta").val(totalSinDescuento);
  	  			$("#ventaTotal").val(totalSinDescuento);
  	  			$("#vuelto").val(cambio);
  	  	  		$("#cambio").val(cambio);
  	  	  		$("#descuento").val('');
  	  	  		$("#vueltoDisabled").val(cambio);
  	  	  	}
  		});

  		
  		$("#interesDebito").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var interes = parseFloat($(this).val());
  	  		var total = parseFloat($("#ventaTotal").val());
  	  	  	
  	  	  	if(valorActual>0){
  	  	  	  	var importeConInteres = (total*interes)/100;
  	  	  	  	var totalConInteres = (total+importeConInteres).toFixed(2); 
  	  	  		$("#totalVenta").val(totalConInteres);
  	  	  		$("#ventaTotal").val(totalConInteres);
  	  	  	}
  	  	  	else{
  	  	  		$("#totalVenta").val(totalGlobal);
  	  	  		$("#ventaTotal").val(totalGlobal);
   	  	  	}
  		});

  
  		
  		$("#interesTarjeta").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var interes = parseFloat($(this).val());
  	  		var total = parseFloat(totalGlobal);
  	  	  	
  	  	  	if(valorActual>0){
  	  	  	  	var importeConInteres = (total*interes)/100;
  	  	  	  	var totalConInteres = (total+importeConInteres).toFixed(2); 
  	  	  		$("#totalVenta").val(totalConInteres);
  	  	  		$("#ventaTotal").val(totalConInteres);
  	  	  	}
  	  	  	else{
  	  	  		$("#totalVenta").val(totalGlobal);
	  	  		$("#ventaTotal").val(totalGlobal);
  	  	  	}
  		});

		
  		
  		$("#importeCtaCte").keyup(function(){
  	  		var valorActual = $(this).val().length;
  	  		var importeCtaCte =  parseFloat($(this).val());
  	  	  	var total = parseFloat($("#totalVenta").val());
  	  	  	if(valorActual>0){
  	  	  		var saldo =(total-importeCtaCte).toFixed(2);
  		  		$("#saldoCtaCteDisabled").val(saldo);
  		  		$("#saldoCtaCte").val(vuelto);
  	  	  	}
  	  	  	else{
  	  	  		$("#saldoCtaCteDisabled").val('0.00');
  	  	  		$("#saldoCtaCte").val('0.00');	
  	  	  	}
  		});
  		  		
  		
  	
  		
  		$('select').on('change', function() {
  		  
  			if(this.value==1){
  				 				
  				$('#divContadoImporte').show();
  				$('#divContadoCambio').show();
  				 				
  				
  				$('#divNumeroTarjetaCredito').hide(); 
  				  				
  				$('#divNombreCliente').hide(); 
  				$('#divCtaCteImporte').hide(); 
  				$('#divCtaCteSaldo').hide();
  				
  				$("#importe").focus();
  				$("#importe").val('');
  				$("#cambio").val('');
  				
  				$("#importe").prop('required',true);
  				$("#numeroTarjetaCredito").prop('required',false);
	    		$("#nombreClienteValue").prop('required',false);
	    		$("#importeCtaCte").prop('required',false);
	    		
	    		
	    		//Traido del radiobutton
	    		$("#totalVenta").val(totalGlobal);
	  	  		$("#ventaTotal").val(totalGlobal);
	  	  		
	  			$("#addDescuento").removeAttr('checked');
	  	  		$("#divDescuento").hide();
	  	  		$("#divTarjetaDebito").hide();
	  	  		$("#divInteresTarjeta").hide();
	  	  		$("#divImporte").show();
	  	  		$("#divCambio").show();
	  	  		$("#importe").val('');
	  	  		$("#vuelto").val('');
	  	  		$("#importe").focus();
	  	  		$("#importe").prop('required',true);
	  	  		$("#descuento").val('');
	  	  		$("#porcentajeDescuento").removeAttr("required");
	  	  		$("#interesDebito").removeAttr("required");
				$("#interesTarjeta").removeAttr("required");  
  				
  			  
  		  	}
  		  	else if(this.value==2){
  		  		
  		  		$('#divContadoImporte').hide();
				$('#divContadoCambio').hide();
								
				
				$('#divNumeroTarjetaCredito').hide(); 
								
				$('#divNombreCliente').hide(); 
				$('#divCtaCteImporte').hide(); 
				$('#divCtaCteSaldo').hide();
								
				
				$("#importe").prop('required',false);
				$("#numeroTarjetaCredito").prop('required',false);
	    		$("#nombreClienteValue").prop('required',false);
	    		$("#importeCtaCte").prop('required',false);
	    		
	    		//Traido del radio button
	    		
	    		$("#totalVenta").val(totalGlobal);
		  		$("#ventaTotal").val(totalGlobal);
		  		
	  	  	  	var total = parseFloat($("#ventaTotal").val());
	  	  	  	var descuento = parseFloat($("#descuento").val());
	  	  		if(!isNaN(descuento) ) {
	  	  			var totalSinDescuento = (total+descuento).toFixed(2);
	  	  			$("#totalVenta").val(totalSinDescuento);
	  	  			$("#ventaTotal").val(totalSinDescuento);
	  	  			$("#descuento").val('');
	  	  		}
	  	  	  	  	  		
	  	  		$("#vuelto").val('');
	  	  		$("#cambio").val('');
	  	  		$("#divImporte").hide();
	  	  		$("#divDescuento").hide();
	  	  		$("#divCambio").hide();
		  		$("#divInteresTarjeta").show();
		  		$("#divTarjetaDebito").show();
		  		$("#interesDebito").val('');
		  		$("#interesDebito").focus();
		  		$("#interesDebito").prop('required',true);
		  		$("#porcentajeDescuento").removeAttr("required");
		  		$("#interesTarjeta").val('');
		  		$("#interesTarjeta").prop('required',true);
		  		$("#interesTarjeta").focus();	
		  		$("#importe").removeAttr("required");
				  			  
  		  	}
  		  	else if(this.value==3){
  		  		
  		  		$('#divContadoImporte').hide();
				$('#divContadoCambio').hide();
				
								
				$('#divNumeroTarjetaCredito').show(); 
								
				$('#divNombreCliente').hide(); 
				$('#divCtaCteImporte').hide(); 
				$('#divCtaCteSaldo').hide();
				
				$('#numeroTarjetaCredito').focus();
								
				$("#importe").prop('required',false);
	    		$("#numeroTarjetaCredito").prop('required',true);
	    		$("#nombreClienteValue").prop('required',false);
	    		$("#importeCtaCte").prop('required',false);
	    		
	    		//Traido del radio button
	    		
	    		$("#totalVenta").val(totalGlobal);
	  			$("#ventaTotal").val(totalGlobal);
	  		
	  	  		var total = parseFloat($("#ventaTotal").val());
		  	  	var descuento = parseFloat($("#descuento").val());
		  		if(!isNaN(descuento) ) {
		  			var totalSinDescuento = (total+descuento).toFixed(2);
		  			$("#totalVenta").val(totalSinDescuento);
		  			$("#ventaTotal").val(totalSinDescuento);
		  			$("#descuento").val('');
		  		}
		  		
		  		$("#vuelto").val('');
	  	  		$("#cambio").val('');
	  	  		$("#divImporte").hide();
	  	  		$("#divDescuento").hide();
	  	  		$("#divCambio").hide();
	  			$("#divTarjetaDebito").hide();
	  			$("#divInteresTarjeta").show();
		  		$("#interesTarjeta").val('');
		  		$("#interesTarjeta").prop('required',true);
		  		$("#interesTarjeta").focus();
		  		$("#porcentajeDescuento").removeAttr("required");
		  		$("#interesDebito").removeAttr("required");
		  		$("#importe").removeAttr("required");
		  
		  	}
  		  	else{
  		  		$('#divContadoImporte').hide();
				$('#divContadoCambio').hide();
				
								
				$('#divNumeroTarjetaCredito').hide(); 
				$('#divInteresTarjeta').hide();
				
				
				$('#divNombreCliente').show(); 
				$('#divCtaCteImporte').show(); 
				$('#divCtaCteSaldo').show();
				
				$('#nombreClienteValue').focus();
				$("#importeCtaCte").val('');
				$("#saldoCtaCteDisabled").val($("#totalVenta").val());
  	  	  		$("#saldoCtaCte").val($("#totalVenta").val());
  	  	  		
  	  	  		$("#importe").prop('required',false);
    			$("#numeroTarjetaCredito").prop('required',false);
    			$("#nombreClienteValue").prop('required',true);
	    		$("#importeCtaCte").prop('required',true);
	    		$("#interesTarjeta").prop('required',false);
  		  	}	
  			
  		});
  		
  		
  		$('#addDescuento').click(function() {
    		if($(this).is(':checked')) {
    			$("#divDescuento").show();
    			$("#porcentajeDescuento").val('');
    	  		$("#porcentajeDescuento").focus();
    	  		$("#porcentajeDescuento").attr("required");
    		}
    		else{
    			$("#totalVenta").val(parseFloat(totalGlobal));
    			$("#ventaTotal").val($("#totalVenta").val());
    			$("#divDescuento").hide();
    			$("#porcentajeDescuento").removeAttr("required");	
    			var total = $("#totalVenta").val();
    			var efectivo = parseFloat($("#importe").val());
    			var cambio = (efectivo-total).toFixed(2);
    			$("#cambio").val(cambio); 
    			$("#vuelto").val(cambio);
    			$("#vueltoDisabled").val(cambio);
        	}
		});
  		
  		$("#nombreClienteValue").autocomplete({
			dataType : 'json',
			source: '${getNombreCliente}',
			minLength: 3,
			focus: function( event, ui ) {
				$("#nombreClienteValue").val(ui.item.apellido);
	        	return false;
	      	},
	      	select: function( event, ui ) {
	        	$("#nombreClienteValue").val(ui.item.apellido);
	        	$("#idCliente").val(ui.item.id);
	        	$("#importeCtaCte").focus();
	        		        	
	        	return false;
	      	} 
			}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            	return $( "<li>" )
            		.append( "<a>"+ item.apellido + "-" + item.nombres + "</a>" )
            		.appendTo( ul );
        };


  		// submmit del filtro de busqueda de productos
  		var optionsFilter = { 
			    target:     '#resultado', 
			    url:        '${save}', 
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

  			    
 		
  		
 	});
  	
   </script>
	<s:form id="formImporteProducto" theme="simple"  cssClass="form-horizontal" role="form">
		
		<s:hidden id="ventaTotal" name="ventaTotal" value=""/>
		<s:hidden id="cambio" name="cambio" value=""/>
		<s:hidden id="descuento" name="descuento" value=""/>
		<s:hidden id="saldoCtaCte" name="saldoCtaCte" value=""/>
		<s:hidden id="idCliente" name="idCliente" value=""/>	
			 			
  		<div class="form-group">
    		<label for="totalVenta" class="col-md-4 col-lg-4 control-label">Total a cobrar $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="totalVenta"  name="totalVenta" value="${totalVenta}" disabled="disabled">
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
  		
  		<div id="divContadoImporte" class="form-group">
    		<label for="importe" class="col-md-4 col-lg-4 control-label">Pago con $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="importe"  name="importe" value="" onkeypress="validaSoloNumerosConPunto();" required>
    		</div>
    		<div class="col-md-0 col-lg-0">
    			<input id="addDescuento"  type="checkbox"/>&nbsp;Descuento
    		</div>
  		</div>
  		<div id="divDescuento" class="form-group" style="display:none">
    		<label for="porcentajeDescuento" class="col-md-4 col-lg-4 control-label">Descuento %</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="porcentajeDescuento"  name="porcentajeDescuento" value="" onkeypress="validaSoloNumerosConPunto();" >
    		</div>
  		</div>
  		
  		<div id="divContadoCambio" class="form-group">
    		<label for="vueltoDisabled" class="col-md-4 col-lg-4 control-label">Cambio $</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="vueltoDisabled"  name="vueltoDisabled" value="" disabled="disabled">
    		</div>
  		</div>
  		<br>
  		
  		  		
  		
  		<div id="divNumeroTarjetaCredito" class="form-group" style="display:none">
    		<label for="numeroTarjetaCredito" class="col-md-4 col-lg-4 control-label">Num de Tarjeta</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="numeroTarjetaCredito"  name="numeroTarjetaCredito" value="" onkeypress="validaSoloNumeros();" maxlength="16">
    		</div>
  		</div>
  		
  		<div id="divInteresTarjeta" class="form-group" style="display:none">
    		<label for="interesTarjeta" class="col-md-4 col-lg-4 control-label">Interes %</label>
    		<div class="col-md-3 col-lg-3">
      			<input type="text" class="form-control input-sm" id="interesTarjeta"  name="interesTarjeta" value="" onkeypress="validaSoloNumerosConPunto();" >
    		</div>
  		</div>
		
  		
  		
  		<div id="divNombreCliente" class="form-group" style="display:none">
    		<label for="nombreClienteValue" class="col-md-4 col-lg-4 control-label">Cliente</label>
    		<div class="col-md-4 col-lg-4">
      			<input type="text" class="form-control input-sm" id="nombreClienteValue"  name="nombreClienteValue" value="">
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
   
    	
