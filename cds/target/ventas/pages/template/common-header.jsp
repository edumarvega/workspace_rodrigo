<%@ include file="/pages/template/taglibs.jsp" %>
<cw:set var="appCtx" value="${pageContext.request.contextPath}" scope="application" /><%-- Application Context --%>

<!--<script src="js/jquery-1.11.js"></script>-->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<!--<script src="js/jquery-ui-1.10.0.custom.min.js"></script>-->
<script src="js/jquery.form.js"></script>
<script src="js/jquery.blockUI.js"></script>
<script src="js/displayTagAjax.js"></script>
<script src="js/template.js"></script>
<script src="js/jquery.plugin.js"></script>
<script src="js/jquery.timeentry.js"></script>
<script src="js/jquery.PrintArea.js"></script>
<script src="js/jquery.jqplot.js"></script>
<script src="js/jqplot.pieRenderer.min.js"></script>
<script src="js/jqplot.donutRenderer.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--<link rel="stylesheet" type="text/css" href="css/custom-theme/jquery-ui-1.10.3.custom.css">-->
<link rel="stylesheet" type="text/css" href="css/custom-theme/jquery-ui-1.10.4.custom.css">
<link rel="stylesheet" type="text/css" href="css/jquery.timeentry.css">
<link rel="stylesheet" type="text/css" href="css/jquery.jqplot.css">

<script type="text/javascript">
$(document).ready(function () {
	datepickerDefaults = {
			showOtherMonths: true,
		    selectOtherMonths: true,
			dateFormat: 'dd/mm/yy',
			firstDay: 1,
			dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
			dayNames: ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'],
			duration: 0,
			monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
			monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
			nextText: 'Siguiente',
			prevText: 'Anterior'
	};
	$.datepicker.setDefaults(datepickerDefaults);
});	
</script>