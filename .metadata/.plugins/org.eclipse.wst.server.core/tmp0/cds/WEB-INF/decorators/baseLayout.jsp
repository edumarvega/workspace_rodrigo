<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="jsonCaja_verificarCaja" namespace="/" var="verificarCaja" />
<s:url action="caja_loadNewCaja" namespace="/" var="loadNewCaja" />
<s:url action="producto_loadSearchProducto" namespace="/" var="loadSearchProducto" />
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
	<title><decorator:title default="Terminal punto de venta - www.templateit.com.ar - 011 1564768633"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/pages/template/common-header.jsp" %>
	<style type="text/css">
		.myHeader{
			background-color:#2aabd2;
			height:80px;
		}
		.myFooter{
			height:20px;
		}
		.myBody{
			height:550px;
		}
		.userLoger{
			color:#ffffff;
		}
	</style>
	<decorator:head></decorator:head>
	<script type="text/javascript">
  		$(document).ready(function(){
  			
  			verificarCaja();
  			
  			$("#consultarProducto").click(function(){
  	  			showModalConsultarProducto();		  			
  	  	  	});
  			
  			$("#consultarProducto").mouseover(function() {
  			  $(this).css('cursor','pointer');
  			});
  			
  			$("#consultarProducto").mouseout(function() {
  			  $(this).css('cursor','default');
  			});
  		});
  		
  		function verificarCaja(){
  			$.ajax({
				url: '${verificarCaja}',
				cache: false,
				type:  'GET',
				dataType: 'json',
				success:  function(data){
					if(data==="si") {
						showModalNuevCaja();
					}
				}
			});
  		}

  		var divNewCaja;
  		function showModalNuevCaja(){
  			divNewCaja = $('<div id="divNewCaja"></div>');
			divNewCaja.dialog({
			   title: 'Caja del dia',
			   modal: true,
			   width: 350,
			   height: 240,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewCaja}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
		}
  		
  		var divConsultarProducto;
  		function showModalConsultarProducto(){
  			divConsultarProducto = $('<div id="divConsultarProducto"></div>');
  			divConsultarProducto.dialog({
			   title: 'Consulta de producto',
			   modal: true,
			   width: 1024,
			   height: 560,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadSearchProducto}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
		}

  		
   </script>
</head>
<body>
    <div class="container">
	<%@ include file="/pages/header.jsp"%>
	<div class="row clearfix myBody">
		<br>
		<br>
		<%@ include file="/pages/menu.jsp"%>	
		<%@ include file="/pages/body.jsp"%>
		<%@ include file="/pages/template/dialogs.jsp"%>
		<%@ include file="/pages/template/alertas.jsp"%>
	</div>
	<%@ include file="/pages/footer.jsp"%>
</div>

    
</body>
</html>