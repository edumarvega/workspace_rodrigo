package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.CuentaCorrienteBO;
import ar.com.templateit.cds.web.bo.EstadoCuentaCorrienteBO;
import ar.com.templateit.cds.web.bo.TipoCuentaCorrienteBO;
import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;
import ar.com.templateit.cds.web.entity.MovimientoCuentaCorriente;
import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PagoProveedorAction extends ActionSupport{

	
	private static final long serialVersionUID = 7601026448213495488L;
	private CuentaCorriente cuentaCorriente;
	private List<CuentaCorriente> listaCuentaCorriente;
	private List<MovimientoCuentaCorriente> listaMovimientoCuentaCorriente;
	
	private Date fechaDesde;
	private Date fechaHasta;
	private String filterNombre;
	private String totalCompra;
	private String saldoAnterior;
	private String saldoActual;
	private String idCuentaCorriente;
	private String pago;
	
	private CuentaCorrienteBO cuentaCorrienteBO;
	private TipoCuentaCorrienteBO tipoCuentaCorrienteBO; 
	private EstadoCuentaCorrienteBO estadoCuentaCorrienteBO;
	private List<EstadoCuentaCorriente> filterEstadosCuentaCorriente;
	private String filterEstadoCuentaCorriente;
	private String defaultFilterEstadoCuentaCorriente;
	private BigDecimal totalPagar;
	
	
	public String pagoProveedor() {
				
		this.filterEstadosCuentaCorriente =new ArrayList<EstadoCuentaCorriente>();
		List<EstadoCuentaCorriente> tmp = this.estadoCuentaCorrienteBO.loadAllEstadoCuentaCorriente();
		
		EstadoCuentaCorriente estadoCuentaCorriente = new EstadoCuentaCorriente();
		estadoCuentaCorriente.setId(new Long(0));
		estadoCuentaCorriente.setNombre("Todos");
		
		this.filterEstadosCuentaCorriente.add(estadoCuentaCorriente);
		this.filterEstadosCuentaCorriente.addAll(tmp);
		
		this.setDefaultFilterEstadoCuentaCorriente(this.filterEstadosCuentaCorriente.get(0).toString());
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
				
		TipoCuentaCorriente tipoCuentaCorriente = this.tipoCuentaCorrienteBO.loadTipoCuentaCorriente().get(1);
				
		this.listaCuentaCorriente = this.cuentaCorrienteBO.findByCriteria(tipoCuentaCorriente, null, null, null, null,usuario);	
		
		this.setTotalPagar(new BigDecimal("0.00"));
		if(this.listaCuentaCorriente!=null){
			if(!this.listaCuentaCorriente.isEmpty()){
				for(CuentaCorriente cc : this.listaCuentaCorriente){
					this.totalPagar = this.totalPagar.add(cc.getSaldoDeudor());
				}
			}	
		}
		
		return "pagoProveedor";
	}
	
	public String loadNewPagoProveedor() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		CuentaCorriente cuentaCorriente = this.cuentaCorrienteBO.getCuentaCorrienteById(Long.valueOf(id));
		
		this.setTotalCompra(cuentaCorriente.getTotalCompra().toString());
		this.setSaldoActual(new BigDecimal("0.00").toString());
		
		if(cuentaCorriente.getSaldoDeudor()!=null){
			this.setSaldoAnterior(cuentaCorriente.getSaldoDeudor().toString());
		}
		else{
			this.setSaldoAnterior(new BigDecimal("0.00").toString());
		}
		
		this.setIdCuentaCorriente(id);
								
		return "loadNewPagoProveedor";
	}
	
	public String loadViewPagoProveedor() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		CuentaCorriente cuentaCorriente = this.cuentaCorrienteBO.getCuentaCorrienteById(Long.valueOf(id));
		
		if(cuentaCorriente.getMovimientosCuentaCorriente()!=null){
			this.listaMovimientoCuentaCorriente = cuentaCorriente.getMovimientosCuentaCorriente();
		}
		else{
			this.listaMovimientoCuentaCorriente = new ArrayList<MovimientoCuentaCorriente>();
		}
						
		return "loadViewPagoProveedor";
	}
	
	
	public String search() {
		EstadoCuentaCorriente estadoCuentaCorriente = null;
		if(Integer.valueOf(this.getFilterEstadoCuentaCorriente()).intValue()!=0){
			estadoCuentaCorriente = this.estadoCuentaCorrienteBO.getEstadoCuentaCorriente((Long.valueOf(this.getFilterEstadoCuentaCorriente())));
		}
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
	
		TipoCuentaCorriente tipoCuentaCorriente = this.tipoCuentaCorrienteBO.loadTipoCuentaCorriente().get(1);
		
		this.listaCuentaCorriente = this.cuentaCorrienteBO.findByCriteria(tipoCuentaCorriente, this.getFechaDesde(),this.getFechaHasta(), 
																			this.getFilterNombre(), estadoCuentaCorriente,usuario);	
		this.setTotalPagar(new BigDecimal("0.00"));
		if(this.listaCuentaCorriente!=null){
			if(!this.listaCuentaCorriente.isEmpty()){
				for(CuentaCorriente cc : this.listaCuentaCorriente){
					this.totalPagar = this.totalPagar.add(cc.getSaldoDeudor());
				}
			}	
		}
		
		return "searchPagoProveedor";
	}

	public String save() {
												
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		CuentaCorriente cuentaCorriente = this.cuentaCorrienteBO.getCuentaCorrienteById(Long.valueOf(this.getIdCuentaCorriente()));
		
		MovimientoCuentaCorriente movimientoCuentaCorriente = new MovimientoCuentaCorriente();
		movimientoCuentaCorriente.setCuentaCorriente(cuentaCorriente);
		movimientoCuentaCorriente.setFechaPago(new Date());
		movimientoCuentaCorriente.setMovimiento("PAGO");
		movimientoCuentaCorriente.setPago(new BigDecimal(this.getPago()));
		movimientoCuentaCorriente.setTotalCompra(cuentaCorriente.getTotalCompra());
		movimientoCuentaCorriente.setSaldoDeudor(new BigDecimal(this.getSaldoActual()));
		movimientoCuentaCorriente.setUsuario(usuario);
		
		cuentaCorriente.setFechaPago(new Date());
		cuentaCorriente.setSaldoDeudor(new BigDecimal(this.getSaldoActual()));
		cuentaCorriente.setFecha(new Date());
		
		if("0.00".equals(this.getSaldoActual())){
			EstadoCuentaCorriente estadoCuentaCorriente = this.estadoCuentaCorrienteBO.loadAllEstadoCuentaCorriente().get(1);
			cuentaCorriente.setEstadoCuentaCorriente(estadoCuentaCorriente);
		}
		
		if(cuentaCorriente.getMovimientosCuentaCorriente()!=null){
			cuentaCorriente.getMovimientosCuentaCorriente().add(movimientoCuentaCorriente);
		}
		else{
			cuentaCorriente.setMovimientosCuentaCorriente(new ArrayList<MovimientoCuentaCorriente>());
			cuentaCorriente.getMovimientosCuentaCorriente().add(movimientoCuentaCorriente);
		}
		
		this.cuentaCorrienteBO.update(cuentaCorriente);
				
		return this.render();
	}
		
	
	public String render() {
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		TipoCuentaCorriente tipoCuentaCorriente = this.tipoCuentaCorrienteBO.loadTipoCuentaCorriente().get(1);
		
		this.listaCuentaCorriente = this.cuentaCorrienteBO.findByCriteria(tipoCuentaCorriente, this.getFechaDesde(), this.getFechaHasta(), 
																			this.getFilterNombre(), null,usuario);	
		this.setTotalPagar(new BigDecimal("0.00"));
		if(this.listaCuentaCorriente!=null){
			if(!this.listaCuentaCorriente.isEmpty()){
				for(CuentaCorriente cc : this.listaCuentaCorriente){
					this.totalPagar = this.totalPagar.add(cc.getSaldoDeudor());
				}
			}	
		}
		
		return "render";
	}

	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public List<CuentaCorriente> getListaCuentaCorriente() {
		return listaCuentaCorriente;
	}

	public void setListaCuentaCorriente(List<CuentaCorriente> listaCuentaCorriente) {
		this.listaCuentaCorriente = listaCuentaCorriente;
	}

	public List<MovimientoCuentaCorriente> getListaMovimientoCuentaCorriente() {
		return listaMovimientoCuentaCorriente;
	}

	public void setListaMovimientoCuentaCorriente(
			List<MovimientoCuentaCorriente> listaMovimientoCuentaCorriente) {
		this.listaMovimientoCuentaCorriente = listaMovimientoCuentaCorriente;
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

	public String getFilterNombre() {
		return filterNombre;
	}

	public void setFilterNombre(String filterNombre) {
		this.filterNombre = filterNombre;
	}

	public void setCuentaCorrienteBO(CuentaCorrienteBO cuentaCorrienteBO) {
		this.cuentaCorrienteBO = cuentaCorrienteBO;
	}

	public void setTipoCuentaCorrienteBO(TipoCuentaCorrienteBO tipoCuentaCorrienteBO) {
		this.tipoCuentaCorrienteBO = tipoCuentaCorrienteBO;
	}

	
	public String getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(String totalCompra) {
		this.totalCompra = totalCompra;
	}

	public String getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(String saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public String getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(String saldoActual) {
		this.saldoActual = saldoActual;
	}

	public String getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(String idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public EstadoCuentaCorrienteBO getEstadoCuentaCorrienteBO() {
		return estadoCuentaCorrienteBO;
	}

	public void setEstadoCuentaCorrienteBO(
			EstadoCuentaCorrienteBO estadoCuentaCorrienteBO) {
		this.estadoCuentaCorrienteBO = estadoCuentaCorrienteBO;
	}

	public List<EstadoCuentaCorriente> getFilterEstadosCuentaCorriente() {
		return filterEstadosCuentaCorriente;
	}

	public void setFilterEstadosCuentaCorriente(
			List<EstadoCuentaCorriente> filterEstadosCuentaCorriente) {
		this.filterEstadosCuentaCorriente = filterEstadosCuentaCorriente;
	}

	public String getFilterEstadoCuentaCorriente() {
		return filterEstadoCuentaCorriente;
	}

	public void setFilterEstadoCuentaCorriente(String filterEstadoCuentaCorriente) {
		this.filterEstadoCuentaCorriente = filterEstadoCuentaCorriente;
	}

	public String getDefaultFilterEstadoCuentaCorriente() {
		return defaultFilterEstadoCuentaCorriente;
	}

	public void setDefaultFilterEstadoCuentaCorriente(
			String defaultFilterEstadoCuentaCorriente) {
		this.defaultFilterEstadoCuentaCorriente = defaultFilterEstadoCuentaCorriente;
	}

	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}
		
	
	

}
