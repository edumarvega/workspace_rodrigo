package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.GastoVarioBO;
import ar.com.templateit.cds.web.bo.TipoGastoVarioBO;
import ar.com.templateit.cds.web.entity.GastoVario;
import ar.com.templateit.cds.web.entity.TipoGastoVario;
import ar.com.templateit.cds.web.entity.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GastoVarioAction extends ActionSupport{

	private static final long serialVersionUID = 799867105918649807L;
	private GastoVario gastoVario;
	private List<GastoVario> listaGastosVarios;
	private List<TipoGastoVario> tiposGastosVarios;
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fecha;
	private String filterNombre;
	private String observaciones;
	private String defaultTipoGastoVario;
	private String tipoGastoVario;
	private GastoVarioBO gastoVarioBO;
	private TipoGastoVarioBO tipoGastoVarioBO;
	private List<TipoGastoVario> filterTiposGastoVario;
	private String filterTipoGastoVario;
	private String defaultFilterTipoGastoVario;
	private BigDecimal totalGastosVarios;
	
	public String gastoVario() {
		
		List<TipoGastoVario> tmp = this.tipoGastoVarioBO.loadAllTipoGastoVario();
		
		this.filterTiposGastoVario = new ArrayList<TipoGastoVario>();
		
		TipoGastoVario tiv = new TipoGastoVario();
		tiv.setId(new Long(0));
		tiv.setNombre("Todos");
		
		this.filterTiposGastoVario.add(tiv);
		this.filterTiposGastoVario.addAll(tmp);
		
		this.setDefaultFilterTipoGastoVario(this.filterTiposGastoVario.get(0).toString());
		
		this.setFechaDesde(new Date());
		this.setFechaHasta(new Date());
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
			
		
		this.listaGastosVarios = this.gastoVarioBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta() , null, null, usuario,null);
		
		this.setTotalGastosVarios(new BigDecimal("0.00"));
		
		if(this.listaGastosVarios!=null){
			if(!this.listaGastosVarios.isEmpty()){
				for(GastoVario gv: this.listaGastosVarios){
					this.totalGastosVarios = this.totalGastosVarios.add(gv.getImporte());
				}
			}
		}
		
		return "gastoVario";
	}
	
	public String loadNewGastoVario() {
		
		this.tiposGastosVarios = this.tipoGastoVarioBO.loadAllTipoGastoVario();	
		
		this.gastoVario = new GastoVario();
		this.setFecha(new Date());
	
		setDefaultTipoGastoVario("-1");
		
		return "loadNewGastoVario";
	}
	
	public String loadEditGastoVario() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		
		this.tiposGastosVarios = this.tipoGastoVarioBO.loadAllTipoGastoVario();	
		this.gastoVario = this.gastoVarioBO.getGastoVario(Long.valueOf(id));
		
		setDefaultTipoGastoVario(this.gastoVario.getTipoGastoVario().getId().toString());
		
		this.setFecha(this.gastoVario.getFecha());
				
		return "loadEditGastoVario";
	}
	
	public String loadViewGastoVario() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		
		this.gastoVario = this.gastoVarioBO.getGastoVario(Long.valueOf(id));
				
		return "loadViewGastoVario";
	}

	public String search() {
		
		TipoGastoVario tipoGastoVario = null;
		if(Integer.valueOf(this.getFilterTipoGastoVario()).intValue()!=0){
			tipoGastoVario = this.tipoGastoVarioBO.getTipoGastoVario(Long.valueOf(this.getFilterTipoGastoVario()));
		}
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		this.listaGastosVarios = this.gastoVarioBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta() , this.filterNombre, this.observaciones, usuario,tipoGastoVario);
		
		this.setTotalGastosVarios(new BigDecimal("0.00"));
		if(this.listaGastosVarios!=null){
			if(!this.listaGastosVarios.isEmpty()){
				for(GastoVario gv: this.listaGastosVarios){
					this.totalGastosVarios = this.totalGastosVarios.add(gv.getImporte());
				}
			}
		}
		
		return "searchGastoVario";
	}

	public String save() {
								
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		TipoGastoVario tipoGastoVario = this.tipoGastoVarioBO.getTipoGastoVario(Long.valueOf(this.getTipoGastoVario()));
		
		this.getGastoVario().setTipoGastoVario(tipoGastoVario);
		this.getGastoVario().setFecha(new Date());
		this.getGastoVario().setUsuario(usuario);
		
		this.gastoVarioBO.save(this.getGastoVario());
				
		return this.render();
	}
	
	public String update() {
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		TipoGastoVario tipoGastoVario = this.tipoGastoVarioBO.getTipoGastoVario(Long.valueOf(this.getTipoGastoVario()));
		
		this.getGastoVario().setTipoGastoVario(tipoGastoVario);
		this.getGastoVario().setFecha(this.getFecha());
		this.getGastoVario().setUsuario(usuario);
		
		this.gastoVarioBO.update(this.getGastoVario());

		return this.render();
	}

	public String delete() {
		
		String[] ids = ServletActionContext.getRequest().getParameter("ids").split(",");
		for (int i = 0; i < ids.length; i++) {
			GastoVario gastoVario = this.gastoVarioBO.getGastoVario(Long.valueOf(ids[i]));
			this.gastoVarioBO.delete(gastoVario);
		}
		
		return this.render();
	}
	
	public String render() {
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		this.listaGastosVarios = this.gastoVarioBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta() , null, null, usuario,null);
		
		this.setTotalGastosVarios(new BigDecimal("0.00"));
		if(this.listaGastosVarios!=null){
			if(!this.listaGastosVarios.isEmpty()){
				for(GastoVario gv: this.listaGastosVarios){
					this.totalGastosVarios = this.totalGastosVarios.add(gv.getImporte());
				}
			}
		}
		
		return "render";
	}

	public GastoVario getGastoVario() {
		return gastoVario;
	}

	public void setGastoVario(GastoVario gastoVario) {
		this.gastoVario = gastoVario;
	}

	public List<GastoVario> getListaGastosVarios() {
		return listaGastosVarios;
	}

	public void setListaGastosVarios(List<GastoVario> listaGastosVarios) {
		this.listaGastosVarios = listaGastosVarios;
	}

	public List<TipoGastoVario> getTiposGastosVarios() {
		return tiposGastosVarios;
	}

	public void setTiposGastosVarios(List<TipoGastoVario> tiposGastosVarios) {
		this.tiposGastosVarios = tiposGastosVarios;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFilterNombre() {
		return filterNombre;
	}

	public void setFilterNombre(String filterNombre) {
		this.filterNombre = filterNombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDefaultTipoGastoVario() {
		return defaultTipoGastoVario;
	}

	public void setDefaultTipoGastoVario(String defaultTipoGastoVario) {
		this.defaultTipoGastoVario = defaultTipoGastoVario;
	}

	public String getTipoGastoVario() {
		return tipoGastoVario;
	}

	public void setTipoGastoVario(String tipoGastoVario) {
		this.tipoGastoVario = tipoGastoVario;
	}

	public void setGastoVarioBO(GastoVarioBO gastoVarioBO) {
		this.gastoVarioBO = gastoVarioBO;
	}

	public void setTipoGastoVarioBO(TipoGastoVarioBO tipoGastoVarioBO) {
		this.tipoGastoVarioBO = tipoGastoVarioBO;
	}

	public List<TipoGastoVario> getFilterTiposGastoVario() {
		return filterTiposGastoVario;
	}

	public void setFilterTiposGastoVario(List<TipoGastoVario> filterTiposGastoVario) {
		this.filterTiposGastoVario = filterTiposGastoVario;
	}

	public String getFilterTipoGastoVario() {
		return filterTipoGastoVario;
	}

	public void setFilterTipoGastoVario(String filterTipoGastoVario) {
		this.filterTipoGastoVario = filterTipoGastoVario;
	}

	public String getDefaultFilterTipoGastoVario() {
		return defaultFilterTipoGastoVario;
	}

	public void setDefaultFilterTipoGastoVario(String defaultFilterTipoGastoVario) {
		this.defaultFilterTipoGastoVario = defaultFilterTipoGastoVario;
	}

	public BigDecimal getTotalGastosVarios() {
		return totalGastosVarios;
	}

	public void setTotalGastosVarios(BigDecimal totalGastosVarios) {
		this.totalGastosVarios = totalGastosVarios;
	}
	
	

}
