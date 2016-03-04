<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="abmCategoria_loadNewCategoria" namespace="/" var="loadNewCategoria" />
<s:url action="abmCategoria_loadEditCategoria" namespace="/" var="loadEditCategoria" />
<s:url action="abmCategoria_loadViewCategoria" namespace="/" var="loadViewCategoria" />
<s:url action="abmCategoria_search" namespace="/" var="search" />
<s:url action="abmCategoria_delete" namespace="/" var="delete" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>ABM de Categoria</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalNuevaCategoria();		  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarCategoria(ids[0]);
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
				showModalViewCategoria(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  		// submmit del filtro de busqueda de categorias
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

  	var divNewCategoria;
  	var divEditarCategoria;

	function showModalNuevaCategoria(){
		divNewCategoria = $('<div id="divNewCategoria"></div>');
		divNewCategoria.dialog({
			   title: 'Nueva categoria',
			   modal: true,
			   width: 400,
			   height: 200,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewCategoria}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	
	function showModalEditarCategoria(id){
		var url = '${loadEditCategoria}?id='+id;
		divEditarCategoria = $('<div id="divEditarCategoria"></div>');
		divEditarCategoria.dialog({
			   title: 'Editar categoria',
			   modal: true,
			   width: 400,
			   height: 200,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	}

	var divViewCategoria;
	function showModalViewCategoria(id){
		var url = '${loadViewCategoria}?id='+id;
		divViewCategoria = $('<div id="divViewCategoria"></div>');
		divViewCategoria.dialog({
			   title: 'Datos de la categoria',
			   modal: true,
			   width: 400,
			   height: 200,
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
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Categor&iacute;as</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="abmCategoria_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<input type="text" id="nombreCategoria" class="form-control input-sm" name="filterNombreCategoria" placeholder="Nombre de categoria">
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
    		<%@ include file="/pages/categoria/toolBarCategoria.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/categoria/resultCategoria.jsp"%>
		</div>
    </div>
	<!--<div id="divNewCategoria" style="display: none;"></div>
	<div id="divEditarCategoria" style="display: none;"></div>
	<div id="divViewCategoria" style="display: none;"></div> -->
</body>
</html>