<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="abmUsuario_loadNewUsuario" namespace="/" var="loadNewUsuario" />
<s:url action="abmUsuario_loadEditUsuario" namespace="/" var="loadEditUsuario" />
<s:url action="abmUsuario_loadViewUsuario" namespace="/" var="loadViewUsuario" />
<s:url action="abmUsuario_search" namespace="/" var="search" />
<s:url action="abmUsuario_delete" namespace="/" var="delete" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>ABM de Usuario</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalNuevoUsuario();		  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarUsuario(ids[0]);
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
				showModalViewUsuario(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  		// submmit del filtro de busqueda de usuarios
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

  	var divNewUsuario;
  	var divEditarUsuario;

	function showModalNuevoUsuario(){
		divNewUsuario = $('<div id="divNewUsuario"></div>');
		divNewUsuario.dialog({
			   title: 'Nuevo usuario',
			   modal: true,
			   width: 500,
			   height: 350,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewUsuario}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	
	function showModalEditarUsuario(id){
		var url = '${loadEditUsuario}?id='+id;
		divEditarUsuario = $('<div id="divEditarUsuario"></div>');
		divEditarUsuario.dialog({
			   title: 'Editar usuario',
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

	var divViewUsuario;
	function showModalViewUsuario(id){
		var url = '${loadViewUsuario}?id='+id;
		divViewUsuario = $('<div id="divViewUsuario"></div>');
		divViewUsuario.dialog({
			   title: 'Datos del usuario',
			   modal: true,
			   width: 500,
			   height: 320,
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Usuarios</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="abmUsuario_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<input type="text" id="filterUsuario" class="form-control input-sm" name="filterUsuario" placeholder="Usuario" maxlength="15" autofocus>
  			</div>
  			<div class="form-group">
    			<s:textfield id="filterApellido" cssClass="form-control input-sm" name="filterApellido" placeholder="Apellido"  maxlength="15" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="filterNombre" cssClass="form-control input-sm" name="filterNombre" placeholder="Nombres"  maxlength="40" theme="simple" />
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
    		<%@ include file="/pages/usuario/toolBarUsuario.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/usuario/resultUsuario.jsp"%>
		</div>
    </div>
	<!--<div id="divNewUsuario" style="display: none;"></div>
	<div id="divEditarUsuario" style="display: none;"></div>
	<div id="divViewUsuario" style="display: none;"></div> -->
</body>
</html>