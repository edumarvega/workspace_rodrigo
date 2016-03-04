<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="alertaProducto_loadAlertaProducto" namespace="/" var="loadAlertaProducto" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Alertas de producto en stock critico</title>
 <%@ include file="/pages/template/common-header.jsp" %>
  <style type="text/css">
  </style>
  <script type="text/javascript">
  	$(document).ready(function(){
  		showModalAlertaProducto();		  			
  	});

	var divAlertaProducto;  	
  	function showModalAlertaProducto(){
  		divAlertaProducto = $('<div id="divAlertaProducto"></div>');
  		divAlertaProducto.dialog({
			   title: 'Alertas de producto en stock cr&iacute;tico',
			   modal: true,
			   width: 700,
			   height: 450,
			   position: 'center',
			   hide: "scale",
			   resizable: 'false',
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadAlertaProducto}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  	}
 	
   </script>
</head>
<body>
	<!--<div id="divAlertaProducto" style="display: none;"></div> -->
</body>
</html>