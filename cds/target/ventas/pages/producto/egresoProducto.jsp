<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="egresoProducto_loadEgresoProducto" namespace="/" var="loadEgresoProducto" />
<s:url action="egresoProducto_search" namespace="/" var="search" />
<s:url action="egresoProducto_imprimirVenta" namespace="/" var="imprimirVenta" />
<s:url action="egresoProducto_imprimirTicketNoFiscal" namespace="/" var="imprimirTicketNoFiscal" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Ventas</title>
 <%@ include file="/pages/template/common-header.jsp" %>
  <style type="text/css">
  </style>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$(".crud").tooltip();
  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalEgresoProducto();	  			
  	  	});

  		var optionsFilter = { 
			    target:     '#resultado', 
			    url:        '${search}', 
			    beforeSubmit:  function(){
			    	$(".displayTable").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
				},
			    success:    function(){ 
					changeLinksPagination('resultado','filterForm');
			    } 
		};
  		$('#filterForm').submit(function() {
  	        $(this).ajaxSubmit(optionsFilter);
  	        return false;
  	    });


  		$("#optPrint").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showDialogPrintVenta(ids[0]);
				$("input:checked").each(function(){
					$(this).removeAttr('checked');
				});
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  		$("#optView").click(function(){
  			var seleccionados = $("input:checked").length;
  			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showDialogPrintTicketNoFiscal(ids[0]);
				$("input:checked").each(function(){
					$(this).removeAttr('checked');
				});
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  	});

  	var divEgresoProducto;
  	function showModalEgresoProducto(){
  		divEgresoProducto = $('<div id="divEgresoProducto"></div>');
  		divEgresoProducto.dialog({
			   title: 'Ventas',
			   modal: true,
			   width: 750,
			   height: 700,
			   position: 'center',
			   hide: "scale",
			   resizable: 'false',
			   beforeClose: function(event, ui) { 
  			   		$("input:checked").each(function(){
						$(this).removeAttr('checked');
					});
  			   		$(this).dialog('destroy').remove();
         	   }
			}).load('${loadEgresoProducto}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  	}

  	var divImprimirVenta;
  	function showDialogPrintVenta(id){
  		var url = '${imprimirVenta}?id='+id;
  		divImprimirVenta = $('<div id="divImprimirVenta"></div>');
  		divImprimirVenta.dialog({
			   title: 'Detalle de venta',
			   modal: true,
			   width: 750,
			   height: 600,
			   position: 'center',
			   hide: "scale",
			   resizable: 'false',
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			   buttons: {
			   		"Imprimir": function () {
						$("#divPrint").printArea();
				 	}
			   }
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  	}

  	var divTicketNoFiscal;
  	function showDialogPrintTicketNoFiscal(id){
  		var url = '${imprimirTicketNoFiscal}?id='+id;
  		divTicketNoFiscal = $('<div id="divTicketNoFiscal"></div>');
  		divTicketNoFiscal.dialog({
			   title: 'Ticket no fiscal',
			   modal: true,
			   width: 350,
			   height: 450,
			   position: 'center',
			   hide: "scale",
			   resizable: 'false',
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			   buttons: {
			   		"Imprimir": function () {
						$("#divPrint").printArea();
				 	}
			   }
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  	}
 	
   </script>
</head>
<body>
<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Búsqueda de Ventas</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="egresoProducto_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="fechaDesde" cssClass="form-control input-sm" name="fechaDesde" placeholder="Fecha desde" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="fechaHasta" cssClass="form-control input-sm" name="fechaHasta" placeholder="Fecha hasta" theme="simple" />
  			</div>
  			<div class="form-group">
    			<input type="text" id="observacionesFilter" class="form-control input-sm" name="observaciones" placeholder="Observaciones">
  			</div>
  			<div class="form-group">
    			<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"></span>&nbsp;Buscar</button>
  			</div>
		</div>
      </s:form>
    </div>
    <div>
    	<br>
		<div id="toolBar">
    		<%@ include file="/pages/producto/toolBarEgresoProducto.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/producto/resultEgresos.jsp"%>
		</div>
    </div>
	<!--<div id="divEgresoProducto" style="display: none;"></div>
	<div id="divTicketNoFiscal" style="display: none;"></div>
	<div id="divImprimirVenta" style="display: none;"></div> -->
</body>
</html>