<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="abmProveedor_loadNewProveedor" namespace="/" var="loadNewProveedor" />
<s:url action="abmProveedor_loadEditProveedor" namespace="/" var="loadEditProveedor" />
<s:url action="abmProveedor_loadViewProveedor" namespace="/" var="loadViewProveedor" />
<s:url action="abmProveedor_search" namespace="/" var="search" />
<s:url action="abmProveedor_delete" namespace="/" var="delete" />
<s:url action="jsonProveedor_getNombreRazonSocialProveedor" namespace="/" var="getNombreRazonSocialProveedor" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>ABM de Proveedor</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalNuevoProveedor();		  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarProveedor(ids[0]);
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
				showModalViewProveedor(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  		// submmit del filtro de busqueda de proveedores
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


  		$("#nombreRazonSocial").autocomplete({
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
        };

  	});

  	var divNewProveedor;
  	var divEditarProveedor;

	function showModalNuevoProveedor(){
		divNewProveedor = $('<div id="divNewProveedor"></div>');
		divNewProveedor.dialog({
			   title: 'Nuevo proveedor',
			   modal: true,
			   width: 700,
			   height: 750,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewProveedor}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	
	function showModalEditarProveedor(id){
		var url = '${loadEditProveedor}?id='+id;
		divEditarProveedor = $('<div id="divEditarProveedor"></div>');
		divEditarProveedor.dialog({
			   title: 'Editar proveedor',
			   modal: true,
			   width: 700,
			   height: 750,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	}

	var divViewProveedor;
	function showModalViewProveedor(id){
		var url = '${loadViewProveedor}?id='+id;
		divViewProveedor = $('<div id="divViewProveedor"></div>');
		divViewProveedor.dialog({
			   title: 'Datos del proveedor',
			   modal: true,
			   width: 700,
			   height: 750,
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Proveedores</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="abmProveedor_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<input type="text" id="cuit" class="form-control input-sm" name="filterCuit" placeholder="Cuit" onkeypress="validaSoloNumeros();" maxlength="11" autofocus>
  			</div>
  			<div class="form-group">
    			<input type="text" id="nombreRazonSocial" class="form-control input-sm" name="filterNombreRazonSocial" placeholder="Nombre o razon social">
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
    		<%@ include file="/pages/proveedor/toolBarProveedor.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/proveedor/resultProveedor.jsp"%>
		</div>
    </div>
	<!--<div id="divNewProveedor" style="display: none;"></div>
	<div id="divEditarProveedor" style="display: none;"></div>
	<div id="divViewProveedor" style="display: none;"></div> -->
</body>
</html>