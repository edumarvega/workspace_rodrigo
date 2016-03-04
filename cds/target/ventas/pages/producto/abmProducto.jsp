<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="abmProducto_loadNewProducto" namespace="/" var="loadNewProducto" />
<s:url action="abmProducto_loadEditProducto" namespace="/" var="loadEditProducto" />
<s:url action="abmProducto_loadViewProducto" namespace="/" var="loadViewProducto" />
<s:url action="abmProducto_search" namespace="/" var="search" />
<s:url action="abmProducto_delete" namespace="/" var="delete" />
<s:url action="abmProducto_loadEditarPrecio" namespace="/" var="loadEditarPrecio" />
<s:url action="jsonProducto_getJsonProductos" namespace="/" var="getJsonProductos" />
<s:url action="getJSONResult" namespace="/" var="getJSONResult" />
<s:url action="jsonProducto_getNombreProducto" namespace="/" var="getNombreProducto" />
<s:url action="jsonProducto_getDescripcionProducto" namespace="/" var="getDescripcionProducto" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>ABM de Producto</title>
 <%@ include file="/pages/template/common-header.jsp" %>

   <script type="text/javascript">
  	$(document).ready(function(){

  		$(".crud").tooltip();

  		changeLinksPagination('resultado','filterForm');
  		
  		$("#optCreate").click(function(){
  			showModalNuevoProducto();		  			
  	  	});

  		$("#optEdit").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarProducto(ids[0]);
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
  		
  		$("#optPrice").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else{
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalEditarPrecioProducto(ids);
			}
  	  	});
  	  	

  		$("#optView").click(function(){
  			var seleccionados = $("input:checked").length;
			if(seleccionados==1){
				var ids  = new Array();
				$("input:checked").each(function(){
					ids.push($(this).val());
				});
				showModalViewProducto(ids[0]);
			}
			else if(seleccionados==0){
				showMsgWarning('Debe seleccionar un elemento');
			}
			else if(seleccionados>1){
				showMsgWarning('Selecciono mas de un elemento');
			}
  	  	});

  		// submmit del filtro de busqueda de productos
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

  		
   		$("#codigoProducto").keypress(function(){
  	  		var actual =  $(this).val().length;
  	  	  	var valorMaximo = $(this).attr('maxlength');
  		    if(actual==valorMaximo){
  	  		    doSubmitForm();
  	  		}
  		});

					
		$("#objeto").autocomplete({
			source: '${getJSONResult}',
			minLength: 3
		});

		$("#nombreProducto").autocomplete({
			dataType : 'json',
			source: '${getNombreProducto}',
			minLength: 3,
			focus: function( event, ui ) {
				$("#nombreProducto").val(ui.item.nombre);
	        	return false;
	      	},
	      	select: function( event, ui ) {
	        	$("#nombreProducto").val(ui.item.nombre);
	        	return false;
	      	} 
		}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            return $( "<li>" )
            .append( "<a>" + item.nombre + "</a>" )
            .appendTo( ul );
        };

        $("#descripcionProducto").autocomplete({
			dataType : 'json',
			source: '${getDescripcionProducto}',
			minLength: 3,
			focus: function( event, ui ) {
				$("#descripcionProducto").val(ui.item.descripcion);
	        	return false;
	      	},
	      	select: function( event, ui ) {
	        	$("#descripcionProducto").val(ui.item.descripcion);
	        	return false;
	      	} 
		}).data("ui-autocomplete")._renderItem = function( ul, item ) {
            return $( "<li>" )
            .append( "<a>" + item.nombre + "</a>" )
            .appendTo( ul );
        };
  		

  	});

  	var divNewProducto;
  	

	function showModalNuevoProducto(){
		//divNewProducto = $("#divNewProducto").dialog({
		divNewProducto = $('<div id="divNewProducto"></div>');
		divNewProducto.dialog({
			   title: 'Nuevo producto',
			   modal: true,
			   width: 550,
			   height: 480,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load('${loadNewProducto}',function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
		
	}

	var divEditarProducto;
	function showModalEditarProducto(id){
		var url = '${loadEditProducto}?id='+id;
		//divEditarProducto = $("#divEditarProducto").dialog({
		divEditarProducto = $('<div id="divEditarProducto"></div>');
		divEditarProducto.dialog({
			   title: 'Editar producto',
			   modal: true,
			   width: 550,
			   height: 450,
			   position: 'center',
			   hide: "scale",
			   close: function() {
		       		$(this).dialog('destroy').remove();
		       },
			}).load(url,function(){
					$(this).unblock();
	  			}).block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
	}
		
	var divEditarPrecio;
	function showModalEditarPrecioProducto(ids){
		var url = '${loadEditarPrecio}?ids='+ids;
		divEditarPrecio = $('<div id="divEditarPrecio"></div>');
		divEditarPrecio.dialog({
			   title: 'Editar precio de productos',
			   modal: true,
			   width: 300,
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

	var divViewProducto;	
	function showModalViewProducto(id){
		var url = '${loadViewProducto}?id='+id;
		divViewProducto = $('<div id="divViewProducto"></div>');
		divViewProducto.dialog({
			   title: 'Datos del producto',
			   modal: true,
			   width: 550,
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


	function doSubmitForm(){
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
  		
  	    $('#filterForm').ajaxSubmit(optionsFilter);
	}
  		
   </script>
</head>
<body>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">B&uacute;squeda de Productos</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="abmProducto_search" theme="simple"  cssClass="form-horizontal"  role="form">
  			<div class="form-group">
  				<div class="col-md-2 col-lg-2">
    				<input type="text" id="codigoProducto" class="form-control input-sm" name="codigo" placeholder="Código" onkeypress="validaSoloNumeros();" maxlength="13" autofocus>
    			</div>	
  			
  				<div class="col-md-3 col-lg-3">
    				<input type="text" id="nombreProducto" class="form-control input-sm" name="nombre" placeholder="Nombre">
    			</div>	
  			
  				<div class="col-md-3 col-lg-3">
    				<input type="text"  id="descripcionProducto" class="form-control input-sm" name="descripcion" placeholder="Descripción">
    			</div>	
    		</div>
    		<div class="form-group">
  				<div class="col-md-3 col-lg-3">
    				<input type="text"  id="marcaProducto" class="form-control input-sm" name="marca" placeholder="Marca">
    			</div>
  				<div class="col-md-3 col-lg-3">
    				<s:select 
						list="filterCategorias" 
						listKey="id"   
        				listValue="nombre"
						name="filterCategoria" 
						value="defaultFilterCategoria" theme="simple" cssClass="form-control input-sm"/>
				</div>		
  				<div class="col-md-2 col-lg-2">
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"></span>&nbsp;Buscar</button>
    			</div>	
  			</div>
      </s:form>
    </div>
    <div>
    	<br>
		<div id="toolBar">
    		<%@ include file="/pages/producto/toolBarProducto.jsp"%>
    	</div>
		<div id="resultado">
			<%@ include file="/pages/ajax/producto/resultProducto.jsp"%>
		</div>
    </div>
	<!--<div id="divNewProducto" style="display: none;"></div>
	<div id="divEditarProducto" style="display: none;"></div>
	<div id="divViewProducto" style="display: none;"></div> -->
</body>
</html>