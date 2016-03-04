<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Login a cds</title>
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
  		background-image: url("/ventas/images/panales_opt.jpg");
  		background-repeat: no-repeat;
    	background-attachment: fixed;
    	background-position: center; 
	}
</style>
</head>
<body>
		<div class="container">
			<s:form action="login_validateUser" theme="simple" cssClass="form-signin" role="form">
       	 		<h2 class="form-signin-heading">Ingreso a cds</h2>
        		<s:if test="hasActionErrors()">
   					<p class="text-danger"><strong>Error:&nbsp;</strong><s:property value="error"/></p>
				</s:if>
        		<input type="text" name="username"  class="form-control input-sm" placeholder="Usuario" required autofocus>
        		<input type="password"  name="password" class="form-control input-sm" placeholder="Password" required>
        		<button class="btn btn-lg btn-info btn-block" type="submit">Login</button>
      		</s:form>
	    </div>

</body>
</html>