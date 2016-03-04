<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="caja_loadEditCaja" namespace="/" var="loadEditCaja" />
<s:url action="caja_loadViewCaja" namespace="/" var="loadViewCaja" />
<s:url action="caja_search" namespace="/" var="search" />
<s:url action="caja_delete" namespace="/" var="delete" />
<s:url action="caja_cerrarCaja" namespace="/" var="cerrarCaja" />
<s:url action="jsonCajaCerrada_verificarEsadoCaja" namespace="/" var="verificarEsadoCaja" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Caja</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){
  		
  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			
  			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				
				var url1 = '${verificarEsadoCaja}?id='+ids[0];
				
				$.ajax({
					url: url1,
					cache: false,
					type:  'GET',
					dataType: 'json',
					success:  function(data){
						if(data==="no") {
							showModalEditarCaja(ids[0]);
						}
						else{
							showMsgWarning('No puede modificar, la caja esta cerrada.');
						}
					}
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
				showModalViewCaja(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});
  		
  		$("#optCloseCaja").click(function(){
  			var ids  = new Array();
  			var seleccionados = $("input:checked").length;
  			
			if(seleccionados==1){
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				
				var url1 = '${verificarEsadoCaja}?id='+ids[0];
				
				$.ajax({
					url: url1,
					cache: false,
					type:  'GET',
					dataType: 'json',
					success:  function(data){
						if(data==="no") {
							var url2 = '${cerrarCaja}';
							var params = 'id='+ids[0];
							showMsgInfo('Desea Cerrar la Caja?',url2,params,'resultado');
						}
						else{
							showMsgWarning('La caja ya se encuentra cerrada.');
						}
					}
				});
				
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

  	
	var divEditarCaja;
	function showModalEditarCaja(id){
		var url = '${loadEditCaja}?id='+id;
		divEditarCaja = $('<div id="divEditarCaja"></div>');
		divEditarCaja.dialog({
			   title: 'Editar Caja del dia',
			   modal: true,
			   width: 350,
			   height: 240,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	}

	var divViewCaja;
	function showModalViewCaja(id){
		var url = '${loadViewCaja}?id='+id;
		divViewCaja = $('<div id="divViewCaja"></div>');
		divViewCaja.dialog({
			   title: 'Caja del dia',
			   modal: true,
			   width: 820,
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Caja</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="caja_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="fechaDesde" cssClass="form-control input-sm" name="fechaDesde" placeholder="Fecha desde" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="fechaHasta" cssClass="form-control input-sm" name="fechaHasta" placeholder="Fecha hasta" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:select 
					list="estadosCaja" 
					listKey="id"   
        			listValue="nombre"
					name="estadoCaja" 
					value="defaultEstadoCaja" theme="simple" cssClass="form-control input-sm"/>
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
    		<%@ include file="/pages/caja/toolBarCaja.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/caja/resultCaja.jsp"%>
		</div>
    </div>

</body>
</html>