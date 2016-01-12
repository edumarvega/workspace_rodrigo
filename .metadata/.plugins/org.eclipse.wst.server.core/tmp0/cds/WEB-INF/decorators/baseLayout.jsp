<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
	<title><decorator:title default="Cds (Control de Stock)"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/pages/template/common-header.jsp" %>
	<style type="text/css">
		.myHeader{
			background-color:#2aabd2;
			height:80px;
		}
		.myFooter{
			height:20px;
		}
		.myBody{
			height:550px;
		}
		.userLoger{
			color:#ffffff;
		}
	</style>
	<decorator:head></decorator:head>
</head>
<body>
    <div class="container">
	<%@ include file="/pages/header.jsp"%>
	<div class="row clearfix myBody">
		<br>
		<br>
		<%@ include file="/pages/menu.jsp"%>	
		<%@ include file="/pages/body.jsp"%>
		<%@ include file="/pages/template/dialogs.jsp"%>
		<%@ include file="/pages/template/alertas.jsp"%>
	</div>
	<%@ include file="/pages/footer.jsp"%>
</div>

    
</body>
</html>