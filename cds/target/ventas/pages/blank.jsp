<%@ include file="/pages/template/taglibs.jsp" %>
<br><br><br><br><br>
<div class="row">
	<div class="col-md-2 col-lg-2">
        <s:url action="ingresoProducto_ingresoProducto.do" var="urlIngresoProducto" namespace="/">
    	</s:url>
    	<a href="<s:property value="urlIngresoProducto"/>"><img src="${appCtx}/images/regalo.png" alt="Compras" height="130" width="130" class="center-block"></a>
        <h4 class="text-center">COMPRAS</h4> 
     </div>
     <div class="col-md-2 col-lg-2">
        <s:url action="egresoProducto_egresoProducto.do" var="urlEgresoProducto" namespace="/">
    	</s:url>
        <a href="<s:property value="urlEgresoProducto"/>"><img src="${appCtx}/images/calculadora.png" alt="Ventas" height="130" width="130" class="center-block"></a>
     	<h4 class="text-center">VENTAS</h4>
     	
     </div>
     <div class="col-md-2 col-lg-2">
        <s:url action="abmProducto_abmProducto.do" var="urlABMProducto" namespace="/">
    	</s:url>
        <a href="<s:property value="urlABMProducto"/>"><img src="${appCtx}/images/etiqueta.png" alt="Abm Productos" height="130" width="130" class="center-block"></a>
     	<h4 class="text-center">ABM PRODUCTOS</h4>
     </div>
     <div class="col-md-2 col-lg-2">
     	<s:url action="caja_initCaja.do" var="initCaja" namespace="/">
    	</s:url>
    	<a href="<s:property value="initCaja"/>"><img src="${appCtx}/images/caja.png" alt="Caja" height="130" width="130" class="center-block"></a>
        <h4 class="text-center">CAJA</h4>
     </div>
     <div class="col-md-2 col-lg-2">
     	<img id="consultarProducto" src="${appCtx}/images/busqueda.png" alt="Consulta" height="130" width="130" class="center-block">
        <h4 class="text-center">CONSULTA</h4>
     </div>
     <div class="col-md-2 col-lg-2">
        
     </div>
</div>