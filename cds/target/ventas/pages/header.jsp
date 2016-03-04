<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="login_loadLogout.do" var="urlLoginLogout" namespace="/"></s:url>
<s:url action="home.do" var="urlHome" namespace="/"></s:url>
<div class="row clearfix myHeader">
		<div class="col-md-9 col-lg-9 column">
			<a href="<s:property value="urlHome"/>"><img src="${appCtx}/images/codigobarra.jpg" class="img-circle" alt="Circular Image"></a>
		</div>
		<div class="col-md-3 col-lg-3 column">
			<br><br>	
			<span class="userLoger">Usuario:&nbsp;<%= request.getUserPrincipal().getName() %>&nbsp;&nbsp;</span><span class="label label-danger"><a href="<s:property value="urlLoginLogout"/>" >Cerrar sesion</a></span>   
		</div>
</div>