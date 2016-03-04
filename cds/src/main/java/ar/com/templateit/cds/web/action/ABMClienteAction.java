package ar.com.templateit.cds.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.ClienteBO;
import ar.com.templateit.cds.web.entity.Cliente;

import com.opensymphony.xwork2.ActionSupport;

public class ABMClienteAction extends ActionSupport {


	private static final long serialVersionUID = 3163170853161017713L;
	private static final String PARAM_JSON = "term";
	private String filterApellido;
	private String filterNombres;
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private ClienteBO clienteBO;
	
	

	public String abmCliente() {
		this.listaClientes = this.clienteBO.loadAllCliente();
		
		return "abmCliente";
	}
	
	public String loadNewCliente() {
		this.cliente = new Cliente();
		
		return "loadNewCliente";
	}
	
	public String loadEditCliente() {
				
		String id = ServletActionContext.getRequest().getParameter("id");
		this.cliente = this.clienteBO.getClienteById(Long.valueOf(id));
		
			
		return "loadEditCliente";
	}
	
	public String loadViewCliente() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.cliente = this.clienteBO.getClienteById(Long.valueOf(id));
		
		return "loadViewCliente";
	}

	public String search() {
		String apellido =null;
		String nombres = null;
		
				
		if(this.filterApellido!=null && this.filterApellido.length()!=0){
			apellido = this.filterApellido.trim();
		}
		
		if(this.filterNombres!=null && this.filterNombres.length()!=0){
			nombres = this.filterNombres.trim();
		}
		
		this.listaClientes = this.clienteBO.findByCriteria(apellido, nombres);
		
		return "searchCliente";
	}

	public String save() {
				
		this.clienteBO.save(this.getCliente());
		
		return this.render();
	}
	
	public String update() {
								
		this.clienteBO.update(this.getCliente());
		
		return this.render();
	}

	public String delete() {
		String[] ids = ServletActionContext.getRequest().getParameter("ids").split(",");
		Cliente cliente=null;
		for (int i = 0; i < ids.length; i++) {
			cliente = this.clienteBO.getClienteById(Long.valueOf(ids[i]));
			this.clienteBO.delete(cliente);
		}
		return this.render();
	}
	
	public String render() {
		this.listaClientes = this.clienteBO.loadAllCliente();
		return "render";
	}

	public String getNombreCliente(){
		String parametro = ServletActionContext.getRequest().getParameter(PARAM_JSON).trim();
		this.listaClientes = this.clienteBO.findByCriteria(parametro,null);
		return SUCCESS;
	}
	
	public String getFilterApellido() {
		return filterApellido;
	}

	public void setFilterApellido(String filterApellido) {
		this.filterApellido = filterApellido;
	}

	public String getFilterNombres() {
		return filterNombres;
	}

	public void setFilterNombres(String filterNombres) {
		this.filterNombres = filterNombres;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void setClienteBO(ClienteBO clienteBO) {
		this.clienteBO = clienteBO;
	}
	
	
		
}
