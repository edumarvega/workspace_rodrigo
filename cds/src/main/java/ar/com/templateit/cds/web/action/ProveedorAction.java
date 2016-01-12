package ar.com.templateit.cds.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.ProveedorBO;
import ar.com.templateit.cds.web.entity.Proveedor;

import com.opensymphony.xwork2.ActionSupport;

public class ProveedorAction extends ActionSupport{
	
	static final long serialVersionUID = 1612818645570595953L;
	private static final String PARAM_JSON = "term";
	private List<Proveedor> listaProveedores;
	private ProveedorBO proveedorBO;
	
	
	public String getNombreRazonSocialProveedor(){
		String parametro = ServletActionContext.getRequest().getParameter(PARAM_JSON).trim();
		this.listaProveedores = this.proveedorBO.findByCriteria(null, parametro);
		return SUCCESS;
	}
	
	
	public List<Proveedor> getListaProveedores() {
		return listaProveedores;
	}
	public void setListaProveedores(List<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}


	public void setProveedorBO(ProveedorBO proveedorBO) {
		this.proveedorBO = proveedorBO;
	}
	
	
	
	

}
