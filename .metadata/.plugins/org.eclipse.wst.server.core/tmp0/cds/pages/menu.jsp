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
			</div>
</div>