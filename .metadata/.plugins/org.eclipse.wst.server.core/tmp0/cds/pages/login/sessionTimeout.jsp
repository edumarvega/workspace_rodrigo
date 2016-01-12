<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Session timeout</title>
 <!--<link rel="stylesheet" type="text/css" href="css/main.css">
 <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
 <script src="js/jquery-1.11.js"></script>
 <script src="js/bootstrap.min.js"></script>-->
 <%@ include file="/pages/template/common-header.jsp" %>
 <style type="text/css">
	body {
  		padding-top: 40px;
  		padding-bottom: 40px;
  		background-color: #eee;
	}
</style>
</head>
<body>
	<div class="container">
	 <p class="text-right"><s:property value="fechaHora" /></p>
      <s:form action="login_load" theme="simple" cssClass="form-logout" role="form">
        <h4 class="text-center">Finalizaci&oacute;n de sesi&oacute;n de usuario&nbsp;</h4>
        <p class="text-center text-danger">Tu sesi&oacute;n a finalizado por inactividad.</p>
        <p class="text-center">Si queres volver a ingresar a cds ingresa<button class="btn btn-link" type="submit">hace click aqui</button></p>
      </s:form>
   </div>
</body>
</html>