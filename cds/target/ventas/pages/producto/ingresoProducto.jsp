<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="ingresoProducto_loadIngresoProducto" namespace="/" var="loadIngresoProducto" />
<s:url action="ingresoProducto_loadEditIngresoProducto" namespace="/" var="loadEditIngresoProducto" />
<s:url action="ingresoProducto_loadViewIngresoProducto" namespace="/" var="loadViewIngresoProducto" />

<s:url action="ingresoProducto_search" namespace="/" var="search" />
<s:url action="jsonProveedor_getNombreRazonSocialProveedor" namespace="/" var="getNombreRazonSocialProveedor" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Compras</title>
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
  			showModalIngresoProducto();	  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarIngresoProducto(ids[0]);
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
				showModalViewIngresoProducto(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});
  	  	

  		$("#proveedorFilter").autocomplete({
			dataType : 'json',
			source: '${getNombreRazonSocialProveedor}',
			minLength: 3,
			focus: function( event, ui ) {
				$("#proveedorFilter").val(ui.item.nombreRazonSocial);
	        	return false;
	      	},
	      	select: function( event, ui ) {
	        	$("#proveedorFilter").val(ui.item.nombreRazonSocial);
	        	return false;
	      	} 
		}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            return $( "<li>" )
            .append( "<a>" + item.nombreRazonSocial + "</a>" )
            .appendTo( ul );
        };

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
  				  			
  	});

  	var divIngresoProducto;
  	function showModalIngresoProducto(){
  		divIngresoProducto = $('<div id="divIngresoProducto"></div>');
  		divIngresoProducto.dialog({
			   title: 'Compras',
			   modal: true,
			   width: 750,
			   height: 580,
			   position: 'center',
			   hide: "scale",
			   resizable: 'false',
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadIngresoProducto}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  	}

  	var divEditarIngresoProducto;
  	function showModalEditarIngresoProducto(id){
		var url = '${loadEditIngresoProducto}?id='+id;
		divEditarIngresoProducto = $('<div id="divEditarIngresoProducto"></div>');
		divEditarIngresoProducto.dialog({
			   title: 'Editar compra',
			   modal: true,
			   width: 750,
			   height: 580,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	}

  	var divViewIngresoProducto;
  	function showModalViewIngresoProducto(id){
		var url = '${loadViewIngresoProducto}?id='+id;
		divViewIngresoProducto = $('<div id="divViewIngresoProducto"></div>');
		divViewIngresoProducto.dialog({
			   title: 'Ver detalle de la compra',
			   modal: true,
			   width: 750,
			   height: 580,
			   position: 'center',
			   hide: "scale",
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Búsqueda de Compras</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="ingresoProducto_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="fechaDesde" cssClass="form-control input-sm" name="fechaDesde" placeholder="Fecha desde" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="fechaHasta" cssClass="form-control input-sm" name="fechaHasta" placeholder="Fecha hasta" theme="simple" />
  			</div>
  			<div class="form-group">
    			<input type="text" id="nroTicketFacturaFilter" class="form-control input-sm" name="nroTicketFactura" placeholder="NºTicket-Factura">
  			</div>
  			<div class="form-group">
    			<input type="text"  id="proveedorFilter" class="form-control input-sm" name="proveedor" placeholder="Proveedor">
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
    		<%@ include file="/pages/producto/toolBarIngresoProducto.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/producto/resultIngresos.jsp"%>
		</div>
    </div>
	<!--<div id="divIngresoProducto" style="display: none;"></div>
	<div id="divEditarIngresoProducto" style="display: none;"></div>
	<div id="divViewIngresoProducto" style="display: none;"></div> -->
</body>
</html>