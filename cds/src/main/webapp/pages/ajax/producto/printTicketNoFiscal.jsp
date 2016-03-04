<%@ include file="/pages/template/taglibs.jsp" %>
<div id="divPrint">
	<table>
		<tr>
			<td align="center">
				<p style="font-size: 11px;">
					<s:property value="nombreEmpresa"/><br>
					<s:property value="direccion"/><br>
					<s:property value="telefono"/><br>
					<s:property value="email"/><br>
					<b>NO FISCAL</b>
				</p>
			</td>
		</tr>
		<tr>
			<td align="left">
				<p style="font-size: 11px;">Fecha:<s:date name="venta.fechaVenta" format="dd/MM/yyyy"/><br>
					Hora:<s:date name="venta.fechaAlta" format="HH:mm:ss"/>
				</p>
			</td>
		</tr>
	</table>
	<table>
		<thead>
			<tr>
				<td style="font-size: 11px;"><b>Cant.</b></td>
				<td style="font-size: 11px;"><b>Desc.&nbsp;&nbsp;</b></td>
				<td style="font-size: 11px;"><b>Precio</b></td>
			</tr>
		</thead>
		<tbody>
			<s:if test="%{venta.items!=null}">
    			<s:iterator value="venta.items" status="item">
					<tr>
						<td>
							<p style="font-size: 11px;"><s:property value="cantidad"/></p>
						</td> 
						<s:if test="%{descripcion.length()>11}">
							<td><p style="font-size: 11px;"><s:property value="descripcion.substring(0,13)"/>...</p></td>
						</s:if>
						<s:else>
							<td><p style="font-size: 11px;"><s:property value="nombre"/></p></td>
						</s:else>     
           				<td>
           					<p style="font-size: 11px;">$<s:property value="precio"/></p>
           				</td>
		       		</tr>
    		   	</s:iterator>
			</s:if>
			<tr>
				<td>
					<p style="font-size: 11px;"><b>TOTAL:</b></p>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					<p style="font-size: 11px;"><b>$<s:property value="venta.total"/></b></p>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<s:if test="%{venta.formaDePago.intValue()==1}">
						<p style="font-size: 11px;font-style: italic;">Efectivo:$<s:property value="venta.efectivo"/><br>
						Cambio:$<s:property value="venta.cambio"/>
						</p>
					</s:if>
					<s:elseif test="%{venta.formaDePago.intValue()==2}">
   						<p style="font-size: 11px;font-style: italic;">DEBITO</p>
					</s:elseif>
					<s:else>
    					<p style="font-size: 11px;font-style: italic;">TARJ.CREDITO</p>
					</s:else>
				</td>
			</tr>
		</tbody>
	</table>
</div>  	
  	
