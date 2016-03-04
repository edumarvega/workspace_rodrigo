<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>ABM de Producto</title>
 
  <style type="text/css">
  </style>
  <script type="text/javascript">
  	
   </script>
</head>
<body>
	
    <div>
    	<div id="resultadoProductos">
			<br>
	<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Resultado</span>
	<br>
	<display:table id="data" name="listaProductos" requestURI="/abmProducto_abmProducto.do" pagesize="10" export="true">
		<display:column media="html">
			<input type="checkbox" id="seleccion" name="seleccion" value="${data.id}">
		</display:column>
		<display:column property="codigo" title="C&oacute;digo" sortable="true"/>
		<display:column property="nombre" title="Nombre" sortable="true"/>
		<display:column property="descripcion" title="Descripci&oacute;n"/>
		<display:setProperty name="export.excel.filename" value="Productos.xls"/>
        <display:setProperty name="export.pdf.filename" value="Productos.pdf"/>
        <display:setProperty name="export.pdf" value="true" />
        <display:setProperty name="export.excel" value="true" />
        <display:setProperty name="export.csv" value="false" />
        <display:setProperty name="export.xml" value="false" />
	</display:table>
	
		</div>
    </div>
	
</body>
</html>