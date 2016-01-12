<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login a cds</title>
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
	
	.thumbnail {
 		 background-color: #ffffff;
  		 box-shadow: 0% 0% 15px #ffffff; 
  		 opacity: 0.8; 
  		 filter: alpha(opacity=80); /* For IE8 and earlier */
	}
	.texto-venta{
		 color: white;
		 font-weight:bold;
	}
	.fondo-venta{
		background-color: #2AABD2;
	}
</style>
</head>
<body>	
		<div class="container"><br><br>
			<div class="row">
				<div class="col-md-5 col-lg-5 thumbnail">
					<form action="<s:url value='j_spring_security_check'/>" class="form-signin" role="form" method="POST">
		       	 		<h2 class="form-signin-heading">Ingreso a cds</h2>
		        		<s:if test="hasActionErrors()">
		   					<p class="text-danger"><strong>Error:&nbsp;</strong><s:property value="error"/></p>
						</s:if>
		        		<input type="text" name="j_username"  class="form-control input-sm" placeholder="usuario" required autofocus>
		        		<input type="password"  name="j_password" class="form-control input-sm" placeholder="password" required>
		        		<button class="btn btn-lg btn-info btn-block" type="submit">Login</button>
		      		<form>
                </div>
                <div class="col-md-7 col-lg-7">
                </div>			
			</div>
			<div class="row">
				<div class="col-md-3 col-lg-3">
                </div>
                <div class="col-md-3 col-lg-3">
                </div>
                <div class="col-md-3 col-lg-3">
                </div>
                <div class="col-md-3 col-lg-3 fondo-venta">
                	<p class="text-right texto-venta">www.templateit.com.ar</p>
					<p class="text-right texto-venta">Ventas 011 15 64768633</p>
                </div>
				
			</div>
	    </div>

</body>
</html>