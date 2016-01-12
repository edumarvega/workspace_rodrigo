package ar.com.templateit.cds.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.ProveedorBO;
import ar.com.templateit.cds.web.bo.ProvinciaBO;
import ar.com.templateit.cds.web.entity.Proveedor;
import ar.com.templateit.cds.web.entity.Provincia;

import com.opensymphony.xwork2.ActionSupport;

public class ABMProveedorAction extends ActionSupport {
	private static final long serialVersionUID = 4320597057764063758L;
	private String cuit;
	private String filterCuit;
	private String filterNombreRazonSocial;
	private String provincia;
	private Proveedor proveedor;
	private List<Provincia> provincias;
	private String defaultProvincia;
	private List<Proveedor> listaProveedores;
	private ProvinciaBO provinciaBO;
	private ProveedorBO proveedorBO;
	

	public String abmProveedor() {
		this.listaProveedores = this.proveedorBO.loadAllProveedor();
		
		return "abmProveedor";
	}
	
	public String loadNewProveedor() {
		
		this.provincias = this.provinciaBO.loadAllProvincia();		
		this.proveedor = new Proveedor();
		setDefaultProvincia("-1");
		
		return "loadNewProveedor";
	}
	
	public String loadEditProveedor() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.provincias = this.provinciaBO.loadAllProvincia();
		this.proveedor = this.proveedorBO.getProveedor(Long.valueOf(id));
		this.cuit = this.proveedor.getCuit().toString();
		setDefaultProvincia(this.proveedor.getProvincia().getId().toString());
				
		return "loadEditProveedor";
	}
	
	public String loadViewProveedor() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.proveedor = this.proveedorBO.getProveedor(Long.valueOf(id));
		this.cuit = this.proveedor.getCuit().toString();
		return "loadViewProveedor";
	}

	public String search() {
		
		Long cuit=null;
		
		if(this.filterCuit!=null && this.filterCuit.length()!=0){
			cuit = Long.valueOf(this.filterCuit.trim());
		}
		this.listaProveedores = this.proveedorBO.findByCriteria(cuit, this.filterNombreRazonSocial);
		
		return "searchProveedor";
	}

	public String save() {
		
		this.getProveedor().setCuit(Long.valueOf(this.cuit.trim()));
		Provincia provincia = this.provinciaBO.getProvincia(Long.valueOf(this.getProvincia()));
		this.getProveedor().setProvincia(provincia);
		
		this.proveedorBO.save(this.getProveedor());
		
		return this.render();
	}
	
	public String update() {
		this.getProveedor().setCuit(Long.valueOf(this.cuit.trim()));
		Provincia provincia = this.provinciaBO.getProvincia(Long.valueOf(this.getProvincia()));
		this.getProveedor().setProvincia(provincia);
		this.proveedorBO.update(this.getProveedor());

		return this.render();
	}

	public String delete() {
		
		String[] ids = ServletActionContext.getRequest().getParameter("ids").split(",");
		Proveedor proveedor=null;
		for (int i = 0; i < ids.length; i++) {
			proveedor = this.proveedorBO.getProveedor(Long.valueOf(ids[i]));
			this.proveedorBO.delete(proveedor);
		}
		
		return this.render();
	}
	
	public String render() {
		
		this.listaProveedores = this.proveedorBO.loadAllProveedor();
		
		return "render";
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	public String getDefaultProvincia() {
		return this.defaultProvincia;
	}

	public void setDefaultProvincia(String defaultProvincia) {
		this.defaultProvincia = defaultProvincia;
	}

	public void setProvinciaBO(ProvinciaBO provinciaBO) {
		this.provinciaBO = provinciaBO;
	}


	public void setProveedorBO(ProveedorBO proveedorBO) {
		this.proveedorBO = proveedorBO;
	}


	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	
	public List<Proveedor> getListaProveedores() {
		return listaProveedores;
	}


	public void setListaProveedores(List<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getFilterCuit() {
		return filterCuit;
	}

	public void setFilterCuit(String filterCuit) {
		this.filterCuit = filterCuit;
	}

	public String getFilterNombreRazonSocial() {
		return filterNombreRazonSocial;
	}

	public void setFilterNombreRazonSocial(String filterNombreRazonSocial) {
		this.filterNombreRazonSocial = filterNombreRazonSocial;
	}
	
	
	
}
