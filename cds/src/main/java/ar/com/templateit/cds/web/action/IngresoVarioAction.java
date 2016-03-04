package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.IngresoVarioBO;
import ar.com.templateit.cds.web.bo.TipoIngresoVarioBO;
import ar.com.templateit.cds.web.entity.IngresoVario;
import ar.com.templateit.cds.web.entity.TipoIngresoVario;
import ar.com.templateit.cds.web.entity.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IngresoVarioAction extends ActionSupport{

	private static final long serialVersionUID = 799867105918649807L;
	private IngresoVario ingresoVario;
	private List<IngresoVario> listaIngresosVarios;
	private List<TipoIngresoVario> tiposIngresosVarios;
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fecha;
	private String filterNombre;
	private String observaciones;
	private String defaultTipoIngresoVario;
	private String tipoIngresoVario;
	private IngresoVarioBO ingresoVarioBO;
	private TipoIngresoVarioBO tipoIngresoVarioBO;
	private List<TipoIngresoVario> filterTiposIngresosVarios;
	private String filterTipoIngresoVario;
	private String defaultFilterTipoIngresoVario;
	private BigDecimal totalIngresosVarios;
	
	public String ingresoVario() {
		
		List<TipoIngresoVario> tmp = this.tipoIngresoVarioBO.loadAllTipoIngresoVario();
		
		this.filterTiposIngresosVarios = new ArrayList<TipoIngresoVario>();
		
		TipoIngresoVario tiv = new TipoIngresoVario();
		tiv.setId(new Long(0));
		tiv.setNombre("Todos");
		
		this.filterTiposIngresosVarios.add(tiv);
		this.filterTiposIngresosVarios.addAll(tmp);
		
		this.setDefaultFilterTipoIngresoVario(this.filterTiposIngresosVarios.get(0).toString());
		
		this.setFechaDesde(new Date());
		this.setFechaHasta(new Date());
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
				
		this.listaIngresosVarios = this.ingresoVarioBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta() , null, null, usuario,null);
		
		this.setTotalIngresosVarios(new BigDecimal("0.00"));
		if(this.listaIngresosVarios!=null){
			if(!this.listaIngresosVarios.isEmpty()){
				for(IngresoVario iv: this.listaIngresosVarios){
					this.totalIngresosVarios = this.totalIngresosVarios.add(iv.getImporte());
				}
			}
		}
		
		return "ingresoVario";
	}
	
	public String loadNewIngresoVario() {
		
		this.tiposIngresosVarios = this.tipoIngresoVarioBO.loadAllTipoIngresoVario();	
		
		this.ingresoVario = new IngresoVario();
		this.setFecha(new Date());
	
		setDefaultTipoIngresoVario("-1");
		
		return "loadNewIngresoVario";
	}
	
	public String loadEditIngresoVario() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		
		this.tiposIngresosVarios = this.tipoIngresoVarioBO.loadAllTipoIngresoVario();
		this.ingresoVario = this.ingresoVarioBO.getIngresoVario(Long.valueOf(id));
		setDefaultTipoIngresoVario(this.ingresoVario.getTipoIngresoVario().getId().toString());
		this.setFecha(this.ingresoVario.getFecha());
				
		return "loadEditIngresoVario";
	}
	
	public String loadViewIngresoVario() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.ingresoVario = this.ingresoVarioBO.getIngresoVario(Long.valueOf(id));
				
		return "loadViewIngresoVario";
	}

	public String search() {
		
		TipoIngresoVario tipoIngresoVario = null;
		if(Integer.valueOf(this.getFilterTipoIngresoVario()).intValue()!=0){
			tipoIngresoVario = this.tipoIngresoVarioBO.getTipoIngresoVario(Long.valueOf(this.getFilterTipoIngresoVario()));
		}
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		this.listaIngresosVarios = this.ingresoVarioBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta(), this.filterNombre, this.observaciones, usuario,tipoIngresoVario);
		
		this.setTotalIngresosVarios(new BigDecimal("0.00"));
		if(this.listaIngresosVarios!=null){
			if(!this.listaIngresosVarios.isEmpty()){
				for(IngresoVario iv: this.listaIngresosVarios){
					this.totalIngresosVarios = this.totalIngresosVarios.add(iv.getImporte());
				}
			}
		}
		
		return "searchIngresoVario";
	}

	public String save() {
								
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		TipoIngresoVario tipoIngresoVario = this.tipoIngresoVarioBO.getTipoIngresoVario(Long.valueOf(this.getTipoIngresoVario()));
		
		this.getIngresoVario().setTipoIngresoVario(tipoIngresoVario);
		this.getIngresoVario().setFecha(new Date());
		this.getIngresoVario().setUsuario(usuario);
		
		this.ingresoVarioBO.save(this.getIngresoVario());
				
		return this.render();
	}
	
	public String update() {
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		TipoIngresoVario tipoIngresoVario = this.tipoIngresoVarioBO.getTipoIngresoVario(Long.valueOf(this.getTipoIngresoVario()));
		
		this.getIngresoVario().setTipoIngresoVario(tipoIngresoVario);
		this.getIngresoVario().setFecha(this.getFecha());
		this.getIngresoVario().setUsuario(usuario);
		
		this.ingresoVarioBO.update(this.getIngresoVario());

		return this.render();
	}

	public String delete() {
		
		String[] ids = ServletActionContext.getRequest().getParameter("ids").split(",");
		for (int i = 0; i < ids.length; i++) {
			IngresoVario ingresoVario = this.ingresoVarioBO.getIngresoVario(Long.valueOf(ids[i]));
			this.ingresoVarioBO.delete(ingresoVario);
		}
		
		return this.render();
	}
	
	public String render() {
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		this.listaIngresosVarios = this.ingresoVarioBO.findByCriteria(this.getFechaDesde(), this.getFechaHasta(), null, null, usuario,null);
		
		this.setTotalIngresosVarios(new BigDecimal("0.00"));
		if(this.listaIngresosVarios!=null){
			if(!this.listaIngresosVarios.isEmpty()){
				for(IngresoVario iv: this.listaIngresosVarios){
					this.totalIngresosVarios = this.totalIngresosVarios.add(iv.getImporte());
				}
			}
		}
		
		return "render";
	}

	public IngresoVario getIngresoVario() {
		return ingresoVario;
	}

	public void setIngresoVario(IngresoVario ingresoVario) {
		this.ingresoVario = ingresoVario;
	}

	public List<IngresoVario> getListaIngresosVarios() {
		return listaIngresosVarios;
	}

	public void setListaIngresosVarios(List<IngresoVario> listaIngresosVarios) {
		this.listaIngresosVarios = listaIngresosVarios;
	}

	public List<TipoIngresoVario> getTiposIngresosVarios() {
		return tiposIngresosVarios;
	}

	public void setTiposIngresosVarios(List<TipoIngresoVario> tiposIngresosVarios) {
		this.tiposIngresosVarios = tiposIngresosVarios;
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

	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDefaultTipoIngresoVario() {
		return defaultTipoIngresoVario;
	}

	public void setDefaultTipoIngresoVario(String defaultTipoIngresoVario) {
		this.defaultTipoIngresoVario = defaultTipoIngresoVario;
	}

	public String getTipoIngresoVario() {
		return tipoIngresoVario;
	}

	public void setTipoIngresoVario(String tipoIngresoVario) {
		this.tipoIngresoVario = tipoIngresoVario;
	}

	public void setIngresoVarioBO(IngresoVarioBO ingresoVarioBO) {
		this.ingresoVarioBO = ingresoVarioBO;
	}

	public void setTipoIngresoVarioBO(TipoIngresoVarioBO tipoIngresoVarioBO) {
		this.tipoIngresoVarioBO = tipoIngresoVarioBO;
	}

	public List<TipoIngresoVario> getFilterTiposIngresosVarios() {
		return filterTiposIngresosVarios;
	}

	public void setFilterTiposIngresosVarios(
			List<TipoIngresoVario> filterTiposIngresosVarios) {
		this.filterTiposIngresosVarios = filterTiposIngresosVarios;
	}

	public String getFilterTipoIngresoVario() {
		return filterTipoIngresoVario;
	}

	public void setFilterTipoIngresoVario(String filterTipoIngresoVario) {
		this.filterTipoIngresoVario = filterTipoIngresoVario;
	}

	public String getDefaultFilterTipoIngresoVario() {
		return defaultFilterTipoIngresoVario;
	}

	public void setDefaultFilterTipoIngresoVario(
			String defaultFilterTipoIngresoVario) {
		this.defaultFilterTipoIngresoVario = defaultFilterTipoIngresoVario;
	}

	public BigDecimal getTotalIngresosVarios() {
		return totalIngresosVarios;
	}

	public void setTotalIngresosVarios(BigDecimal totalIngresosVarios) {
		this.totalIngresosVarios = totalIngresosVarios;
	}

		
	
	

}
