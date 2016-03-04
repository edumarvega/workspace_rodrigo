<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="gastoVario_loadNewGastoVario" namespace="/" var="loadNewGastoVario" />
<s:url action="gastoVario_loadEditGastoVario" namespace="/" var="loadEditGastoVario" />
<s:url action="gastoVario_loadViewGastoVario" namespace="/" var="loadViewGastoVario" />
<s:url action="gastoVario_search" namespace="/" var="search" />
<s:url action="gastoVario_delete" namespace="/" var="delete" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Gastos Varios</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){
  		
  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalNuevoGastoVario();		  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarGastoVario(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
 			
  	  	});

  		$("#optDelete").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else{
				var url = '${delete}';
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				var params = 'ids='+ids;
	
				showMsgInfo('Desea eliminar el o los elementos?',url,params,'resultado');
			}
  	  	});
  	  	

  		$("#optView").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalViewGastoVario(ids[0]);
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


  		/*$("#nombreRazonSocial").autocomplete({
			dataType : 'json',
			source: '${getNombreRazonSocialProveedor}',
			minLength: 3,
			focus: function( event, ui ) {
				$("#nombreRazonSocial").val(ui.item.nombreRazonSocial);
	        	return false;
	      	},
	      	select: function( event, ui ) {
	        	$("#nombreRazonSocial").val(ui.item.nombreRazonSocial);
	        	return false;
	      	} 
		}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            return $( "<li>" )
            .append( "<a>" + item.nombreRazonSocial + "</a>" )
            .appendTo( ul );
        };*/

  	});

  	var divNewGastoVario;
  	
	function showModalNuevoGastoVario(){
		divNewGastoVario = $('<div id="divNewGastoVario"></div>');
		divNewGastoVario.dialog({
			   title: 'Nuevo gasto vario',
			   modal: true,
			   width: 600,
			   height: 480,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewGastoVario}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	var divEditarGastoVario;
	function showModalEditarGastoVario(id){
		var url = '${loadEditGastoVario}?id='+id;
		divEditarGastoVario = $('<div id="divEditarGastoVario"></div>');
		divEditarGastoVario.dialog({
			   title: 'Editar gasto vario',
			   modal: true,
			   width: 600,
			   height: 480,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	}

	var divViewGastoVario;
	function showModalViewGastoVario(id){
		var url = '${loadViewGastoVario}?id='+id;
		divViewGastoVario = $('<div id="divViewGastoVario"></div>');
		divViewGastoVario.dialog({
			   title: 'Datos del gasto vario',
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Gastos Varios</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="gastoVario_search" theme="simple"  cssClass="form-inline"  role="form">
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
					list="filterTiposGastoVario" 
					listKey="id"   
        			listValue="nombre"
					name="filterTipoGastoVario" 
					value="defaultFilterTipoGastoVario" theme="simple" cssClass="form-control input-sm"/>
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
    		<%@ include file="/pages/gastosVarios/toolBarGastosVarios.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/gastosVarios/resultGastosVarios.jsp"%>
		</div>
    </div>

</body>
</html>