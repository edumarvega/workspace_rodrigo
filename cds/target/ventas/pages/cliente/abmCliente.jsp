<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="abmCliente_loadNewCliente" namespace="/" var="loadNewCliente" />
<s:url action="abmCliente_loadEditCliente" namespace="/" var="loadEditCliente" />
<s:url action="abmCliente_loadViewCliente" namespace="/" var="loadViewCliente" />
<s:url action="abmCliente_search" namespace="/" var="search" />
<s:url action="abmCliente_delete" namespace="/" var="delete" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>ABM de Cliente</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalNuevoCliente();		  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarCliente(ids[0]);
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
				showModalViewCliente(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  		// submmit del filtro de busqueda de Clientes
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

  	var divNewCliente;
  	var divEditarCliente;

	function showModalNuevoCliente(){
		divNewCliente = $('<div id="divNewCliente"></div>');
		divNewCliente.dialog({
			   title: 'Nuevo Cliente',
			   modal: true,
			   width: 500,
			   height: 350,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewCliente}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	
	function showModalEditarCliente(id){
		var url = '${loadEditCliente}?id='+id;
		divEditarCliente = $('<div id="divEditarCliente"></div>');
		divEditarCliente.dialog({
			   title: 'Editar Cliente',
			   modal: true,
			   width: 500,
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

	var divViewCliente;
	function showModalViewCliente(id){
		var url = '${loadViewCliente}?id='+id;
		divViewCliente = $('<div id="divViewCliente"></div>');
		divViewCliente.dialog({
			   title: 'Datos del Cliente',
			   modal: true,
			   width: 500,
			   height: 350,
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Clientes</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="abmCliente_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="filterApellido" cssClass="form-control input-sm" name="filterApellido" placeholder="Apellido"  maxlength="15" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="filterNombre" cssClass="form-control input-sm" name="filterNombres" placeholder="Nombres"  maxlength="40" theme="simple" />
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
    		<%@ include file="/pages/cliente/toolBarCliente.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/cliente/resultCliente.jsp"%>
		</div>
    </div>
	<!--<div id="divNewUsuario" style="display: none;"></div>
	<div id="divEditarUsuario" style="display: none;"></div>
	<div id="divViewUsuario" style="display: none;"></div> -->
</body>
</html>