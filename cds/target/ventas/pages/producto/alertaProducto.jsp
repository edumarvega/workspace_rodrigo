<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="alertaProducto_loadAlertaProducto" namespace="/" var="loadAlertaProducto" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
			   title: 'Alertas de producto en stock crítico',
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