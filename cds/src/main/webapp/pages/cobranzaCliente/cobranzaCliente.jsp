<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="cobranzaCliente_loadNewCobranzaCliente" namespace="/" var="loadNewCobranzaCliente" />
<s:url action="cobranzaCliente_loadViewCobranzaCliente" namespace="/" var="loadViewCobranzaCliente" />
<s:url action="cobranzaCliente_search" namespace="/" var="search" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Cuenta Corriente Cliente</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){
  		
  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalNuevoCobranzaCliente(ids[0]);
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
				showModalViewCobranzaCliente(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  		// submmit del filtro de busqueda de ingresos varios
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

  	var divNewCobranzaCliente;
  	function showModalNuevoCobranzaCliente(id){
  		var url = '${loadNewCobranzaCliente}?id='+id;
  		divNewCobranzaCliente = $('<div id="divNewCobranzaCliente"></div>');
  		divNewCobranzaCliente.dialog({
			   title: 'Nueva cobranza cuenta corriente cliente',
			   modal: true,
			   width: 580,
			   height: 350,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	
	var divViewCobranzaCliente;
	function showModalViewCobranzaCliente(id){
		var url = '${loadViewCobranzaCliente}?id='+id;
		divViewCobranzaCliente = $('<div id="divViewCobranzaCliente"></div>');
		divViewCobranzaCliente.dialog({
			   title: 'Movimientos cuenta corriente cliente',
			   modal: true,
			   width: 600,
			   height: 480,
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Cuenta corriente cliente</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="cobranzaCliente_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="fechaDesde" cssClass="form-control input-sm" name="fechaDesde" placeholder="Fecha desde" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="fechaHasta" cssClass="form-control input-sm" name="fechaHasta" placeholder="Fecha hasta" theme="simple" />
  			</div>
  			<div class="form-group">
    			<input type="text" id="nombre" class="form-control input-sm" name="filterNombre" placeholder="Nombre">
  			</div>
  			<div class="form-group">
    			<s:select 
					list="filterEstadosCuentaCorriente" 
					listKey="id"   
        			listValue="nombre"
					name="filterEstadoCuentaCorriente" 
					value="defaultFilterEstadoCuentaCorriente" theme="simple" cssClass="form-control input-sm"/>
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
    		<%@ include file="/pages/cobranzaCliente/toolBarCobranzaCliente.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/cobranzaCliente/resultCobranzaCliente.jsp"%>
		</div>
    </div>

</body>
</html>