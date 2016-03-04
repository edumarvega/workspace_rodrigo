<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="alertaProducto_loadAlertaProducto" namespace="/" var="loadAlertaProducto" />
<script type="text/javascript">
	$(document).ready(function () {
		$("#verAlerta").click(function (){
			dialogAlerta = $('<div id="dialogAlerta"></div>');
			dialogAlerta.dialog({
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
		});

	});	
</script>

<div id="alerta" class="alerta" style="display: none;">
	<p id="verAlerta" class="text-center">Stock crítico!!</p>
</div>

<!--<div id="dialogAlerta" style="display: none;"></div> -->

