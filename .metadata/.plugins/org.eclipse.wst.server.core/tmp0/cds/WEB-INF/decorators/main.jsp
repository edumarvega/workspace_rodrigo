<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="Sitemesh"/></title>
</head>

<body>
	<table border="1" cellpadding="2" cellspacing="2" align="center">
    	<tr>
        	<td height="30" colspan="2"><%@ include file="/pages/header.jsp"%></td>
    	</tr>
    	<tr>
        	<td height="250"><%@ include file="/pages/menu.jsp"%></td>
        	<td width="350"><decorator:body /></td>
    	</tr>
    	<tr>
        	<td height="30" colspan="2"><%@ include file="/pages/footer.jsp"%></td>
    	</tr>
	</table>
</body>
</html>