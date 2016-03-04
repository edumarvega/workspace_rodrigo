<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/template/taglibs.jsp" %>
<s:url action="estadisticaVenta_loadEstadisticaVenta" namespace="/" var="loadEstadisticaVenta" />
<s:url action="getJSONVentas_search" namespace="/" var="search" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Estad&iacute;sticas de ventas</title>
 <%@ include file="/pages/template/common-header.jsp" %>
  <style type="text/css">
  </style>
  <script type="text/javascript">
  	$(document).ready(function(){

  		$("#fechaDesde").datepicker();
  		$("#fechaHasta").datepicker();

  		$("#verVentas").click(function(){
  			$("#divChart").text('');
  			var titulo;
  			var valorOption = $("#filterForm input[type='radio']:checked").val();
  			if(valorOption==1){
  	  			titulo = 'Ventas por producto';
  	  		}
  			else{
  				titulo = 'Ventas por categor&iacute;a de producto';
  	  		}
  			
  			var formData = $('filterForm').serialize();
  			$.ajax({
  				url: '${search}',
  				data: $('#filterForm').serialize(),
  				cache: false,
  				type:  'GET',
  				dataType: 'json',
  				beforeSend: function () {
  					$("#filter").block({ message: '<h5><img src="${appCtx}/images/loading.gif"/> Procesando...</h5>' });
  				},
  				success:  function (response) {
  					var array = $.map(response, function (item, index) {
  		                return [[item.etiqueta, item.valor]];
  		            });
  		           
  		            if(array.length>0){
  		            	var dataChart = array;
  	  			   	  	var plot1 = jQuery.jqplot ('divChart', [dataChart],{ 
  	  			   	  		         	seriesDefaults: {
  	  			   	  		         		// Make this a pie chart.
  	  			   	  		            	renderer: jQuery.jqplot.PieRenderer, 
  	  			   	  		            	rendererOptions: {
  	  			   	  		             		// Put data labels on the pie slices.
  	  			   	  		             		// By default, labels show the percentage of the slice.
  	  			   	  		             		showDataLabels: true,
  	  			   	  		           			dataLabels: 'value',       
  	  			   	  	        				dataLabelFormatString: '$%.2f',
  	  			   	  	        				dataLabelPositionFactor: 1.2,
  	  			   	  	        				shadow: false,
  	  			   	  	        				sliceMargin: 3
  	  			   	            				
  	  			   	  		             	}
  	  			   	  		          	}, 
  	  			   	  		   			title: {
  	  			   	  		        		text: titulo,   
  	  			   	  		        		show: true,
  	  			   	  		    		},
  	  			   	  		            legend: { show:true, location: 'e' }
  	  			   	  		          	}
  	  			   	  	);
  	  		        }
  		            else{
  		            	$("#divChart").text('No se encontraron datos para el criterio de b&uacute;squeda.');
  	  		        }
  		              			   	  	
  					$("#filter").unblock();
  				}
  		    });

  			
  				  			
  	  	});
 				  			
  	});

 	
   </script>
</head>
<body>
<span style="color:#2aabd2; font-size: 14px; font-weight:bold;">Estadísticas de ventas</span>
	<br>
	<br>
	<div id="filter">
      <s:form id="filterForm" action="estadisticaVenta_search" theme="simple"  cssClass="form-inline"  role="form">
  		<div class="row">
  			<div class="form-group">
    			<s:textfield id="fechaDesde" cssClass="form-control input-sm" name="fechaDesde" placeholder="Fecha desde" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:textfield id="fechaHasta" cssClass="form-control input-sm" name="fechaHasta" placeholder="Fecha hasta" theme="simple" />
  			</div>
  			<div class="form-group">
    			<s:radio label="Filtrar" name="selectOption" list="#{'1':'Por producto','2':'Por categoría'}" value="1" theme="simple"/>
  			</div>
  			<div class="form-group">
				<button id="verVentas" type="button" class="btn btn-info">Ver ventas</button>
  	  		</div>
		</div>
      </s:form>
      
    </div>
    <br/>
	<div id="divChart" style="height:400px;width:400px;"></div>
</body>
</html>