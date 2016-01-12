package ar.com.templateit.cds.web.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class JsonProductoAction extends ActionSupport {
	private static final long serialVersionUID = 8693977464247776816L;
	
	private List<String> lista;
	
		
	public String getJsonProductos(){
//		String nombreRequest = ServletActionContext.getRequest().getParameter("term").trim();
//		this.listaProductos = this.productoBO.findByCriteria(null,nombreRequest, "");
		System.out.println("Haciendo json...");
		this.lista = new ArrayList<String>();
		lista.add("Manteca");
		lista.add("Mamadera");
		lista.add("Mermelada");
		lista.add("Mandioca");
		
		return SUCCESS;
	}
	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	
	

}
