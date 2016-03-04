<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="ajusteProducto_loadAjusteProducto" namespace="/" var="loadAjusteProducto" />
<s:url action="ajusteProducto_search" namespace="/" var="search" />
<s:url action="ajusteProducto_loadViewAjusteProducto" namespace="/" var="loadViewAjusteProducto" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ajuste de Producto</title>
 <%@ include file="/pages/template/common-header.jsp" %>
  <style type="text/css">
  </style>
  <script type="text/javascript">
  	$(document).ready(function(){

  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

		changeLinksPagination('resultado','filterForm');

		$("#optCreate").click(function(){
			showModalAjusteProducto();		  			
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

  		$("#optView").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalViewAjusteProducto(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});
  	    	  			
  	});

  	var divAjusteProducto;
  	function showModalAjusteProducto(){
  		divAjusteProducto = $('<div id="divAjusteProducto"></div>');
  		divAjusteProducto.dialog({
			   				title: 'Ajuste de producto',
			   				modal: true,
			   				width: 580,
			   				height: 430,
			   				position: 'center',
			   				hide: "scale",
			   				resizable: 'false',
			   				close: function() {
					       		$(this).dialog('destroy').remove();
					       	},
							}).load('${loadAjusteProducto}',function(){
									$(this).unblock();
	  							}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  						}
		
	var divViewAjusteProducto;
  	function showModalViewAjusteProducto(id){
		var url = '${loadViewAjusteProducto}?id='+id;
		divViewAjusteProducto = $('<div id="divViewAjusteProducto"></div>');
		divViewAjusteProducto.dialog({
			   title: 'Detalle del ajuste',
			   modal: true,
			   width: 570,
			   height: 500,
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
<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Ajuste de productos</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="ajusteProducto_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="fechaDesde" cssClass="form-control input-sm" name="fechaDesde" placeholder="Fecha desde" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="fechaHasta" cssClass="form-control input-sm" name="fechaHasta" placeholder="Fecha hasta" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="codigoFilter" cssClass="form-control input-sm" name="codigoFilter" placeholder="Código" onkeypress="validaSoloNumeros();" maxlength="13" theme="simple" />
  			</div>
  			<div class="form-group">
    			<input type="text" id="Filter" class="form-control input-sm" name=nombreFilter placeholder="Nombre">
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
    		<%@ include file="/pages/producto/toolBarAjuste.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/producto/resultAjustes.jsp"%>
		</div>
    </div>
	<!--<div id="divAjusteProducto" style="display: none;"></div>
	<div id="divViewAjusteProducto" style="display: none;"></div> -->
</body>
</html>