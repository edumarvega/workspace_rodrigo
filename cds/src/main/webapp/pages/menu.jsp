<%@ include file="/pages/template/taglibs.jsp" %>
<div class="col-md-3 col-lg-3 column">
			<div class="panel-group" id="panel-692274">
			
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-692274" href="#panel-element-726032">Producto</a>
					</div>
			
					<div id="panel-element-726032" class="panel-collapse collapse">
						<div class="panel-body">
							<div>
								<s:url action="abmProducto_abmProducto.do" var="urlABMProducto" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/abmproducto.png"  alt="Abm producto">
    							<a href="<s:property value="urlABMProducto"/>" >ABM Producto</a>
							</div>
							
							<div>
								<s:url action="abmCategoria_abmCategoria.do" var="urlABMCategoria" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/abmcategoria.jpg"  alt="Abm categoria">
    							<a href="<s:property value="urlABMCategoria"/>" >ABM Categoria</a>
							</div>
							
    						<div>
    							<s:url action="ingresoProducto_ingresoProducto.do" var="urlIngresoProducto" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/ingresos.png"  alt="Compras">
    							<a href="<s:property value="urlIngresoProducto"/>" >Compras</a>
    						</div>
    						
							<div>
								<s:url action="egresoProducto_egresoProducto.do" var="urlEgresoProducto" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/egresos.png"  alt="Ventas">
    							<a href="<s:property value="urlEgresoProducto"/>" >Ventas</a>
							</div>
							<div>
								<s:url action="ajusteProducto_ajusteProducto.do" var="urlAjusteProducto" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/ajustes.png"  alt="Ajustes">
    							<a href="<s:property value="urlAjusteProducto"/>" >Ajustes</a>
								
							</div>
							<div>
								<s:url action="estadisticaVenta_estadisticaVenta.do" var="urlEstadisticaVenta" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/estadisticas.png"  alt="Estadisticas">
    							<a href="<s:property value="urlEstadisticaVenta"/>" >Estadísticas de ventas</a>
							</div>
							<div>
								<s:url action="alertaProducto_alertaProducto.do" var="urlAlertaProducto" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/alertas.png"  alt="Alertas">
    							<a href="<s:property value="urlAlertaProducto"/>" >Alertas de producto</a>
							</div>
						</div>
					</div>
					
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-692274" href="#panel-element-910737">Proveedor</a>
					</div>
					<div id="panel-element-910737" class="panel-collapse collapse">
						<div class="panel-body">
							<div>
								<s:url action="abmProveedor_abmProveedor.do" var="urlABMProveedor" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/abmproveedor.png"  alt="Abm proveedor">
    							<a href="<s:property value="urlABMProveedor"/>" >ABM Proveedor</a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-692274" href="#panel-element-910738">Usuario</a>
					</div>
					<div id="panel-element-910738" class="panel-collapse collapse">
						<div class="panel-body">
							<div>
								<s:url action="abmUsuario_abmUsuario.do" var="urlABMUsuario" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/abmusuario.png"  alt="Abm usuario">
    							<a href="<s:property value="urlABMUsuario"/>" >ABM Usuario</a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-692274" href="#panel-element-910739">Reportes</a>
					</div>
					<div id="panel-element-910739" class="panel-collapse collapse">
						<div class="panel-body">
							<div>
								<s:url action="reporte_reporte.do" var="urlReporteVentas" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/abmusuario.png"  alt="Reporte de ventas">
    							<a href="<s:property value="urlReporteVentas"/>" >Ventas por usuario</a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-692274" href="#panel-element-910740">Utilidades</a>
					</div>
					<div id="panel-element-910740" class="panel-collapse collapse">
						<div class="panel-body">
							<div>
								<s:url action="backUpDataBase_hacerBackUp.do" var="hacerBackUp" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/backup.jpg"  alt="Back Up">
    							<a href="<s:property value="hacerBackUp"/>" >Generar copia datos</a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-692274" href="#panel-element-910741">Caja</a>
					</div>
					<div id="panel-element-910741" class="panel-collapse collapse">
						<div class="panel-body">
							<div>
								<s:url action="caja_initCaja.do" var="initCaja" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/backup.jpg"  alt="Back Up">
    							<a href="<s:property value="initCaja"/>" >Caja del día</a>
							</div>
							<div>
								<s:url action="ingresoVario_ingresoVario.do" var="ingresoVario" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/backup.jpg"  alt="Ingresos varios">
    							<a href="<s:property value="ingresoVario"/>" >Ingresos varios</a>
							</div>
							<div>
								<s:url action="gastoVario_gastoVario.do" var="gastoVario" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/backup.jpg"  alt="Gastos varios">
    							<a href="<s:property value="gastoVario"/>" >Gastos varios</a>
							</div>
							<div>
								<s:url action="pagoProveedor_pagoProveedor.do" var="pagoProveedor" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/backup.jpg"  alt="Back Up">
    							<a href="<s:property value="pagoProveedor"/>" >Pago a proveedores</a>
							</div>
							<div>
								<s:url action="cobranzaCliente_cobranzaCliente.do" var="cobranzaCliente" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/backup.jpg"  alt="Back Up">
    							<a href="<s:property value="cobranzaCliente"/>" >Cobranza a clientes</a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-692274" href="#panel-element-910742">Cliente</a>
					</div>
					<div id="panel-element-910742" class="panel-collapse collapse">
						<div class="panel-body">
							<div>
								<s:url action="abmCliente_abmCliente.do" var="abmCliente" namespace="/">
    							</s:url>
    							<img src="${appCtx}/images/iconos/backup.jpg"  alt="ABM Cliente">
    							<a href="<s:property value="abmCliente"/>" >ABM Cliente</a>
							</div>
						</div>
					</div>
				</div>
				
				
				
			</div>
</div>