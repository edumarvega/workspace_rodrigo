<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="reporte_search" namespace="/" var="search" />
<s:url action="reporte_imprimirVenta" namespace="/" var="imprimirVenta" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Reporte de Ventas</title>
 <%@ include file="/pages/template/common-header.jsp" %>
  <style type="text/css">
  </style>
  <script type="text/javascript">
  	$(document).ready(function(){
  		
  		$(".crud").tooltip();
  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

		changeLinksPagination('resultado','filterForm');
  		
  		
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

  		
  	});

  	
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

  	 	
   </script>
</head>
<body>
<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Reporte de Ventas por usuario</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="reporte_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="fechaDesde" cssClass="form-control input-sm" name="fechaDesde" placeholder="Fecha desde" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="fechaHasta" cssClass="form-control input-sm" name="fechaHasta" placeholder="Fecha hasta" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:select 
					list="listaUsuarios" 
					listKey="id"   
        			listValue="usuario"
					name="usuario" 
					value="defaultUsuario" theme="simple" cssClass="form-control input-sm"/>
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
    		<%@ include file="/pages/reporte/toolBarReporteVenta.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/reporte/reporteVentaByUsuario.jsp"%>
		</div>
    </div>
	<!--<div id="divImprimirVenta" style="display: none;"></div> -->
</body>
</html>