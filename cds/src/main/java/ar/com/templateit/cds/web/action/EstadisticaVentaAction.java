package ar.com.templateit.cds.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.EstadisticaVentaBO;
import ar.com.templateit.cds.web.entity.Estadistica;
import ar.com.templateit.cds.web.util.TemplateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class EstadisticaVentaAction extends ActionSupport{

	private static final long serialVersionUID = -2481373503699610557L;
	private Date fechaDesde;
	private Date fechaHasta;
	private String selectOption;
	private List<Estadistica> ventas;
	
	private EstadisticaVentaBO estadisticaVentaBO;
	
	public String estadisticaVenta() {
		return "estadisticaVenta";
	}
	
	public String loadEstadisticaVenta() {
		return "loadEstadisticaVenta";
	}
	
	public String search(){
		List<Object> lista = new ArrayList<Object>();
		TemplateUtil tu = new TemplateUtil();
		int option = Integer.valueOf(this.selectOption).intValue();
		if(option==1){
			lista = this.estadisticaVentaBO.getVentasByProducto(this.fechaDesde, this.fechaHasta);
			this.ventas = tu.transformObjectProductoToEstadistica(lista);
		}
		else{
			lista = this.estadisticaVentaBO.getVentasByCategoria(this.fechaDesde, this.fechaHasta);
			this.ventas = tu.transformObjectCategoriaToEstadistica(lista);
		}
		
	    	                                             
	  return SUCCESS;
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
	
	public String getSelectOption() {
		return selectOption;
	}

	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
	}
		
	public List<Estadistica> getVentas() {
		return ventas;
	}

	public void setVentas(List<Estadistica> ventas) {
		this.ventas = ventas;
	}

	public void setEstadisticaVentaBO(EstadisticaVentaBO estadisticaVentaBO) {
		this.estadisticaVentaBO = estadisticaVentaBO;
	}


	
	

}
