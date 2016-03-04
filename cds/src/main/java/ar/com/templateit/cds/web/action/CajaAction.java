package ar.com.templateit.cds.web.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.CajaBO;
import ar.com.templateit.cds.web.bo.CompraBO;
import ar.com.templateit.cds.web.bo.CuentaCorrienteBO;
import ar.com.templateit.cds.web.bo.EstadoCajaBO;
import ar.com.templateit.cds.web.bo.FormaDePagoBO;
import ar.com.templateit.cds.web.bo.GastoVarioBO;
import ar.com.templateit.cds.web.bo.IngresoVarioBO;
import ar.com.templateit.cds.web.bo.MovimientoCuentaCorrienteBO;
import ar.com.templateit.cds.web.bo.VentaBO;
import ar.com.templateit.cds.web.entity.Caja;
import ar.com.templateit.cds.web.entity.Compra;
import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.EstadoCaja;
import ar.com.templateit.cds.web.entity.FormaDePago;
import ar.com.templateit.cds.web.entity.GastoVario;
import ar.com.templateit.cds.web.entity.IngresoVario;
import ar.com.templateit.cds.web.entity.MovimientoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;
import ar.com.templateit.cds.web.util.TemplateUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CajaAction extends ActionSupport{

	private static final long serialVersionUID = 962225211169076559L;
	
	private Date fechaDesde;
	private Date fechaHasta;
	private Caja caja;
	private List<Caja> listaCaja;
	private List<EstadoCaja> estadosCaja;
	private String mostrar;
	private Date fecha;
	private Date fechaHora;
	private String idEstadoCaja;
	private String cajaCerrada;
	private String estadoCaja;
	private String defaultEstadoCaja;
	private BigDecimal cajaDiaria;
	private Date fechaActual;
	private BigDecimal totalVentasEfectivo;
	private BigDecimal totalIngresosVarios;
	private BigDecimal totalCtaCteCliente;
	private BigDecimal totalCompraEfectivo;
	private BigDecimal totalGastosVarios;
	private BigDecimal totalCtaCteProveedor;
	private BigDecimal totalEfectivo;
	private BigDecimal cambio;
	private String mySqldumPath;
	private String comando;
	private String pathBackup;
	
	private CajaBO cajaBO;
	private EstadoCajaBO estadoCajaBO;
	private VentaBO ventaBO;
	private IngresoVarioBO ingresoVarioBO;
	private CuentaCorrienteBO cuentaCorrienteBO;
	private CompraBO compraBO;
	private GastoVarioBO gastoVarioBO;
	private FormaDePagoBO formaDePagoBO;
	private MovimientoCuentaCorrienteBO movimientoCuentaCorrienteBO;
	
	
	public String initCaja() {
		this.estadosCaja = new ArrayList<EstadoCaja>();
		
		this.setFechaDesde(new Date());
		this.setFechaHasta(new Date());
				
		EstadoCaja estadoCaja = new EstadoCaja();
		estadoCaja.setId(new Long(0));
		estadoCaja.setNombre("Todos");
		this.estadosCaja.add(estadoCaja);
		
		List<EstadoCaja> tmp = this.estadoCajaBO.loadAllEstadoCaja();
		this.estadosCaja.addAll(tmp);
		this.setDefaultEstadoCaja(this.estadosCaja.get(0).toString());
		
		this.listaCaja = this.cajaBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta(), null);
		
		return "initCaja";
	}
	
	public String verificarCaja(){
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		this.mostrar = "si";
		
		boolean existeCaja = this.cajaBO.verificarCaja(new Date(), usuario);
		
		if(existeCaja){
			this.mostrar = "no";
		}
		
		return SUCCESS;
	}
	
	public String verificarEsadoCaja(){
		this.cajaCerrada = "si";
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.caja = this.cajaBO.getCaja(Long.valueOf(id));
		
		if(this.caja.getEstadoCaja().getId().intValue()==1){
			this.cajaCerrada = "no";
		}
		
		return SUCCESS;
	}
	
	public String loadNewCaja() {
		
		List<EstadoCaja> estadosCaja = this.estadoCajaBO.loadAllEstadoCaja();
				
		this.caja = new Caja();
		this.caja.setEstadoCaja(estadosCaja.get(0));
		
		return "loadNewCaja";
	}
	
	public String loadEditCaja() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.caja = this.cajaBO.getCaja(Long.valueOf(id));
		this.setFecha(this.caja.getFecha());
		this.setFechaHora(this.caja.getFechaHora());
		this.setIdEstadoCaja(this.caja.getEstadoCaja().getId().toString());
					
		return "loadEditCaja";
	}
	
	public String loadViewCaja() {
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		BigDecimal totalIngresos = new BigDecimal("0.00");
		BigDecimal totalSalidas = new BigDecimal("0.00");
				
		Date fechaDesde = new Date();
		Date fechaHasta = new Date();
		
		FormaDePago formaDePago = this.formaDePagoBO.loadAllFormaDePago().get(0);
		
		String id = ServletActionContext.getRequest().getParameter("id");
		
		Caja  caja = this.cajaBO.getCaja(Long.valueOf(id));
		
		CuentaCorriente cuentaCorriente = this.cuentaCorrienteBO.getCuentaCorrienteById(Long.valueOf(id));
		
		this.setFechaActual(new Date());
		this.setCajaDiaria(caja.getCajaInicial());
		
		this.setTotalVentasEfectivo(new BigDecimal("0.00"));
		this.setTotalIngresosVarios(new BigDecimal("0.00"));
		this.setTotalCtaCteCliente(new BigDecimal("0.00"));
		this.setTotalCompraEfectivo(new BigDecimal("0.00"));
		this.setTotalGastosVarios(new BigDecimal("0.00"));
		this.setTotalCtaCteProveedor(new BigDecimal("0.00"));
		this.setTotalEfectivo(caja.getCajaInicial());
		this.setCambio(caja.getCambio());
		
		if(caja.getEstadoCaja().getId().intValue()==1){
			
			List<Venta> ventas= this.ventaBO.findVentaEfectivoByUsuario(fechaDesde, fechaHasta, formaDePago, usuario);
			List<IngresoVario> ingresosVarios = this.ingresoVarioBO.findByCriteria(fechaDesde, fechaHasta, null, null, usuario,null);
			List<MovimientoCuentaCorriente> ctaCteCliente = this.movimientoCuentaCorrienteBO.findMovimientoCtaCteByCriteria(cuentaCorriente, new Date(), null, usuario);
			List<Compra> compras = this.compraBO.findCompraEfectivoByUsuario(fechaDesde, fechaHasta, formaDePago, usuario);
			List<GastoVario> gastosVarios = this.gastoVarioBO.findByCriteria(fechaDesde, fechaHasta, null, null, usuario,null);
			List<MovimientoCuentaCorriente> ctaCorrienteProveedor = this.movimientoCuentaCorrienteBO.findMovimientoCtaCteByCriteria(cuentaCorriente, null, new Date(), usuario);
			
			//Ingresos
			for(Venta venta:ventas){
				this.totalVentasEfectivo = this.totalVentasEfectivo.add(venta.getTotal());
			}
						
			for(IngresoVario ingresoVario :ingresosVarios){
				this.totalIngresosVarios  = this.totalIngresosVarios.add(ingresoVario.getImporte());
			}
						
			for(MovimientoCuentaCorriente movCtaCteCliente :ctaCteCliente){
				this.totalCtaCteCliente = this.totalCtaCteCliente.add(movCtaCteCliente.getCobro());
			}
					
			//Salidas
			for(Compra compra : compras){
				this.totalCompraEfectivo = this.totalCompraEfectivo.add(compra.getTotal());
			}
						
			for(GastoVario gastoVario : gastosVarios){
				this.totalGastosVarios = this.totalGastosVarios.add(gastoVario.getImporte());
			}
					
			for(MovimientoCuentaCorriente movCtaCteCliente :ctaCorrienteProveedor){
				this.totalCtaCteProveedor = this.totalCtaCteProveedor.add(movCtaCteCliente.getPago());
			}
		}
		else{
			
			this.setTotalVentasEfectivo(caja.getVentaEfectivo());
			this.setTotalIngresosVarios(caja.getIngresosVariosEfectivo());
			this.setTotalCtaCteCliente(caja.getCuentaCorrienteCliente());
			this.setTotalCompraEfectivo(caja.getCompras());
			this.setTotalGastosVarios(caja.getGastosVariosEfectivo());
			this.setTotalCtaCteProveedor(caja.getCuentaCorrienteProveedor());
		}
		
		totalIngresos = caja.getCajaInicial().add(this.totalVentasEfectivo).add(this.totalIngresosVarios).add(this.totalCtaCteCliente).add(this.cambio);
		totalSalidas = this.totalCompraEfectivo.add(this.totalGastosVarios).add(this.totalCtaCteProveedor);
					
		this.totalEfectivo = totalIngresos.subtract(totalSalidas);
	
							
		return "loadViewCaja";
	}
	
	public String search() {
		EstadoCaja estadoCaja = null;
		
		if(this.getEstadoCaja()!=null){
			if(Integer.valueOf(this.getEstadoCaja()).intValue()!=0){
				estadoCaja = this.estadoCajaBO.getEstadoCaja(Long.valueOf(this.getEstadoCaja()));
			}
		}
				
		this.listaCaja = this.cajaBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta(), estadoCaja);
		
		return "searchCaja";
	}
	
	public String save() {
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		List<EstadoCaja> estadosCaja = this.estadoCajaBO.loadAllEstadoCaja();
				
		this.getCaja().setEstadoCaja(estadosCaja.get(0));
		this.getCaja().setUsuario(usuario);
		this.getCaja().setFecha(new Date());
		this.getCaja().setFechaHora(new Date());
		this.getCaja().setVentaEfectivo(BigDecimal.ZERO);
		this.getCaja().setIngresosVariosEfectivo(BigDecimal.ZERO);
		this.getCaja().setCuentaCorrienteCliente(BigDecimal.ZERO);
		this.getCaja().setCuentaCorrienteProveedor(BigDecimal.ZERO);
		this.getCaja().setCompras(BigDecimal.ZERO);
		this.getCaja().setGastosVariosEfectivo(BigDecimal.ZERO);
		this.getCaja().setTotalEfectivo(this.getCaja().getCajaInicial());
				
		this.cajaBO.save(this.getCaja());
				
		return this.render();
	}

		
	public String update() {
								
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		EstadoCaja estadoCaja = this.estadoCajaBO.getEstadoCaja(Long.valueOf(idEstadoCaja));
		
		this.getCaja().setFecha(this.getFecha());
		this.getCaja().setFechaHora(this.getFechaHora());
		this.getCaja().setEstadoCaja(estadoCaja);
		this.getCaja().setUsuario(usuario);
		this.getCaja().setVentaEfectivo(BigDecimal.ZERO);
		this.getCaja().setIngresosVariosEfectivo(BigDecimal.ZERO);
		this.getCaja().setCuentaCorrienteCliente(BigDecimal.ZERO);
		this.getCaja().setCuentaCorrienteProveedor(BigDecimal.ZERO);
		this.getCaja().setCompras(BigDecimal.ZERO);
		this.getCaja().setGastosVariosEfectivo(BigDecimal.ZERO);
		this.getCaja().setTotalEfectivo(this.getCaja().getCajaInicial());
		
		this.cajaBO.update(this.getCaja());
		
		return this.render();
	}
	
	public String cerrarCaja() {
		
		Date fechaDesde = new Date();
		Date fechaHasta = new Date();
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		String id = ServletActionContext.getRequest().getParameter("id");
		
		List<EstadoCaja> estadosCaja = this.estadoCajaBO.loadAllEstadoCaja();
		FormaDePago formaDePago = this.formaDePagoBO.loadAllFormaDePago().get(0);
		CuentaCorriente cuentaCorriente = this.cuentaCorrienteBO.getCuentaCorrienteById(Long.valueOf(id));
				
		this.caja = this.cajaBO.getCaja(Long.valueOf(id));
		
		this.getCaja().setEstadoCaja(estadosCaja.get(1));
		
		List<Venta> ventas= this.ventaBO.findVentaEfectivoByUsuario(fechaDesde, fechaHasta, formaDePago, usuario);
		List<IngresoVario> ingresosVarios = this.ingresoVarioBO.findByCriteria(fechaDesde, fechaHasta, null, null, usuario,null);
		List<MovimientoCuentaCorriente> ctaCteCliente = this.movimientoCuentaCorrienteBO.findMovimientoCtaCteByCriteria(cuentaCorriente, new Date(), null, usuario);
		List<Compra> compras = this.compraBO.findCompraEfectivoByUsuario(fechaDesde, fechaHasta, formaDePago, usuario);
		List<GastoVario> gastosVarios = this.gastoVarioBO.findByCriteria(fechaDesde, fechaHasta, null, null, usuario,null);
		List<MovimientoCuentaCorriente> ctaCorrienteProveedor = this.movimientoCuentaCorrienteBO.findMovimientoCtaCteByCriteria(cuentaCorriente, null, new Date(), usuario);
		
		this.setTotalVentasEfectivo(new BigDecimal("0.00"));
		this.setTotalIngresosVarios(new BigDecimal("0.00"));
		this.setTotalCtaCteCliente(new BigDecimal("0.00"));
		this.setTotalCompraEfectivo(new BigDecimal("0.00"));
		this.setTotalGastosVarios(new BigDecimal("0.00"));
		this.setTotalCtaCteProveedor(new BigDecimal("0.00"));
		this.setTotalEfectivo(this.getCaja().getCajaInicial());
		this.setCambio(this.getCaja().getCambio());
		
		//Ingresos
		for(Venta venta:ventas){
			this.totalVentasEfectivo = this.totalVentasEfectivo.add(venta.getTotal());
		}
					
		for(IngresoVario ingresoVario :ingresosVarios){
			this.totalIngresosVarios  = this.totalIngresosVarios.add(ingresoVario.getImporte());
		}
					
		for(MovimientoCuentaCorriente movCtaCteCliente :ctaCteCliente){
			this.totalCtaCteCliente = this.totalCtaCteCliente.add(movCtaCteCliente.getCobro());
		}
				
		//Salidas
		for(Compra compra : compras){
			this.totalCompraEfectivo = this.totalCompraEfectivo.add(compra.getTotal());
		}
					
		for(GastoVario gastoVario : gastosVarios){
			this.totalGastosVarios = this.totalGastosVarios.add(gastoVario.getImporte());
		}
				
		for(MovimientoCuentaCorriente movCtaCteCliente :ctaCorrienteProveedor){
			this.totalCtaCteProveedor = this.totalCtaCteProveedor.add(movCtaCteCliente.getPago());
		}
		
		BigDecimal totalIngresos = this.caja.getCajaInicial().add(this.totalVentasEfectivo).add(this.totalIngresosVarios).add(this.totalCtaCteCliente).add(this.cambio);
		BigDecimal totalSalidas = this.totalCompraEfectivo.add(this.totalGastosVarios).add(this.totalCtaCteProveedor);
					
		this.totalEfectivo = totalIngresos.subtract(totalSalidas);
		
		this.getCaja().setTotalEfectivo(this.totalEfectivo);
			
		this.cajaBO.update(this.getCaja());
		
		//Hace el backup de las tablas
		try {
			TemplateUtil tu = new TemplateUtil();
			
			String comando = this.getMySqldumPath()+this.getComando();
			Process p = Runtime.getRuntime().exec(comando);
			InputStream is = p.getInputStream();
			String pathArchivo = this.getPathBackup()+tu.generarNombreArchivo();
			
			FileOutputStream fos = new FileOutputStream(pathArchivo);
			
			byte[] buffer = new byte[1000];

			int leido = is.read(buffer);
			while (leido > 0) {
				fos.write(buffer, 0, leido);
				leido = is.read(buffer);
			}

			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return this.render();
	}
	
	public String render() {
		
		EstadoCaja estadoCaja = null;
		if(this.getEstadoCaja()!=null){
			if(Integer.valueOf(this.getEstadoCaja()).intValue()!=0){
				estadoCaja = this.estadoCajaBO.getEstadoCaja(Long.valueOf(this.getEstadoCaja()));
			}
		}
				
		this.listaCaja = this.cajaBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta(), estadoCaja);
		
		return "render";
	}
	
	
	
	public Caja getCaja() {
		return caja;
	}


	public void setCaja(Caja caja) {
		this.caja = caja;
	}


	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public List<Caja> getListaCaja() {
		return listaCaja;
	}
	public void setListaCaja(List<Caja> listaCaja) {
		this.listaCaja = listaCaja;
	}
	public List<EstadoCaja> getEstadosCaja() {
		return estadosCaja;
	}
	public void setEstadosCaja(List<EstadoCaja> estadosCaja) {
		this.estadosCaja = estadosCaja;
	}
	public void setCajaBO(CajaBO cajaBO) {
		this.cajaBO = cajaBO;
	}

	public void setEstadoCajaBO(EstadoCajaBO estadoCajaBO) {
		this.estadoCajaBO = estadoCajaBO;
	}

	public String getMostrar() {
		return mostrar;
	}

	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getIdEstadoCaja() {
		return idEstadoCaja;
	}

	public void setIdEstadoCaja(String idEstadoCaja) {
		this.idEstadoCaja = idEstadoCaja;
	}

	public String getCajaCerrada() {
		return cajaCerrada;
	}

	public void setCajaCerrada(String cajaCerrada) {
		this.cajaCerrada = cajaCerrada;
	}

	public String getEstadoCaja() {
		return estadoCaja;
	}

	public void setEstadoCaja(String estadoCaja) {
		this.estadoCaja = estadoCaja;
	}

	public String getDefaultEstadoCaja() {
		return defaultEstadoCaja;
	}

	public void setDefaultEstadoCaja(String defaultEstadoCaja) {
		this.defaultEstadoCaja = defaultEstadoCaja;
	}

	public void setVentaBO(VentaBO ventaBO) {
		this.ventaBO = ventaBO;
	}

	public void setIngresoVarioBO(IngresoVarioBO ingresoVarioBO) {
		this.ingresoVarioBO = ingresoVarioBO;
	}

	public void setCuentaCorrienteBO(CuentaCorrienteBO cuentaCorrienteBO) {
		this.cuentaCorrienteBO = cuentaCorrienteBO;
	}

	public void setCompraBO(CompraBO compraBO) {
		this.compraBO = compraBO;
	}

	public void setGastoVarioBO(GastoVarioBO gastoVarioBO) {
		this.gastoVarioBO = gastoVarioBO;
	}

	public BigDecimal getCajaDiaria() {
		return cajaDiaria;
	}

	public void setCajaDiaria(BigDecimal cajaDiaria) {
		this.cajaDiaria = cajaDiaria;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public BigDecimal getTotalVentasEfectivo() {
		return totalVentasEfectivo;
	}

	public void setTotalVentasEfectivo(BigDecimal totalVentasEfectivo) {
		this.totalVentasEfectivo = totalVentasEfectivo;
	}

	public BigDecimal getTotalIngresosVarios() {
		return totalIngresosVarios;
	}

	public void setTotalIngresosVarios(BigDecimal totalIngresosVarios) {
		this.totalIngresosVarios = totalIngresosVarios;
	}

	public BigDecimal getTotalCtaCteCliente() {
		return totalCtaCteCliente;
	}

	public void setTotalCtaCteCliente(BigDecimal totalCtaCteCliente) {
		this.totalCtaCteCliente = totalCtaCteCliente;
	}

	public BigDecimal getTotalCompraEfectivo() {
		return totalCompraEfectivo;
	}

	public void setTotalCompraEfectivo(BigDecimal totalCompraEfectivo) {
		this.totalCompraEfectivo = totalCompraEfectivo;
	}

	public BigDecimal getTotalGastosVarios() {
		return totalGastosVarios;
	}

	public void setTotalGastosVarios(BigDecimal totalGastosVarios) {
		this.totalGastosVarios = totalGastosVarios;
	}

	public BigDecimal getTotalCtaCteProveedor() {
		return totalCtaCteProveedor;
	}

	public void setTotalCtaCteProveedor(BigDecimal totalCtaCteProveedor) {
		this.totalCtaCteProveedor = totalCtaCteProveedor;
	}

	public BigDecimal getTotalEfectivo() {
		return totalEfectivo;
	}

	public void setTotalEfectivo(BigDecimal totalEfectivo) {
		this.totalEfectivo = totalEfectivo;
	}

	
	public void setFormaDePagoBO(FormaDePagoBO formaDePagoBO) {
		this.formaDePagoBO = formaDePagoBO;
	}

	public void setMovimientoCuentaCorrienteBO(
			MovimientoCuentaCorrienteBO movimientoCuentaCorrienteBO) {
		this.movimientoCuentaCorrienteBO = movimientoCuentaCorrienteBO;
	}

	public String getMySqldumPath() {
		return mySqldumPath;
	}

	public void setMySqldumPath(String mySqldumPath) {
		this.mySqldumPath = mySqldumPath;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public String getPathBackup() {
		return pathBackup;
	}

	public void setPathBackup(String pathBackup) {
		this.pathBackup = pathBackup;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal cambio) {
		this.cambio = cambio;
	}
	
	

}
