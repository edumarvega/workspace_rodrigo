package ar.com.templateit.cds.web.action;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.CategoriaBO;
import ar.com.templateit.cds.web.entity.Categoria;

import com.opensymphony.xwork2.ActionSupport;

public class CategoriaAction extends ActionSupport {
	private static final long serialVersionUID = 8693977464247776816L;
	private Categoria categoria;
	private CategoriaBO categoriaBO;


	
	public String obtenerCategoria(){
		String parametro = ServletActionContext.getRequest().getParameter("id");
		this.categoria = this.categoriaBO.getCategoria(new Long(parametro));
		
		return SUCCESS;
	}



	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public void setCategoriaBO(CategoriaBO categoriaBO) {
		this.categoriaBO = categoriaBO;
	}
	
	
	
	



}
