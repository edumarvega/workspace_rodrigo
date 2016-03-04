<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="ingresoVario_loadNewIngresoVario" namespace="/" var="loadNewIngresoVario" />
<s:url action="ingresoVario_loadEditIngresoVario" namespace="/" var="loadEditIngresoVario" />
<s:url action="ingresoVario_loadViewIngresoVario" namespace="/" var="loadViewIngresoVario" />
<s:url action="ingresoVario_search" namespace="/" var="search" />
<s:url action="ingresoVario_delete" namespace="/" var="delete" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ingresos Varios</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){
  		
  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalNuevoIngresoVario();		  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarIngresoVario(ids[0]);
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
				showModalViewIngresoVario(ids[0]);
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

  	var divNewIngresoVario;
  	
	function showModalNuevoIngresoVario(){
		divNewIngresoVario = $('<div id="divNewIngresoVario"></div>');
		divNewIngresoVario.dialog({
			   title: 'Nuevo ingreso vario',
			   modal: true,
			   width: 600,
			   height: 480,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewIngresoVario}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	var divEditarIngresoVario;
	function showModalEditarIngresoVario(id){
		var url = '${loadEditIngresoVario}?id='+id;
		divEditarIngresoVario = $('<div id="divEditarIngresoVario"></div>');
		divEditarIngresoVario.dialog({
			   title: 'Editar ingreso vario',
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

	var divViewIngresoVario;
	function showModalViewIngresoVario(id){
		var url = '${loadViewIngresoVario}?id='+id;
		divViewIngresoVario = $('<div id="divViewIngresoVario"></div>');
		divViewIngresoVario.dialog({
			   title: 'Datos del ingreso vario',
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Ingresos Varios</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="ingresoVario_search" theme="simple"  cssClass="form-inline"  role="form">
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
					list="filterTiposIngresosVarios" 
					listKey="id"   
        			listValue="nombre"
					name="filterTipoIngresoVario" 
					value="defaultFilterTipoIngresoVario" theme="simple" cssClass="form-control input-sm"/>
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
    		<%@ include file="/pages/ingresosVarios/toolBarIngresosVarios.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/ingresosVarios/resultIngresosVarios.jsp"%>
		</div>
    </div>

</body>
</html>