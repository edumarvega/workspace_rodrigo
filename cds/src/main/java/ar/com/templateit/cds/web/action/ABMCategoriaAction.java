package ar.com.templateit.cds.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.CategoriaBO;
import ar.com.templateit.cds.web.entity.Categoria;

import com.opensymphony.xwork2.ActionSupport;

public class ABMCategoriaAction extends ActionSupport {
	
	private static final long serialVersionUID = 4320597057764063758L;
	private String filterNombreCategoria;

	private Categoria categoria;
	private List<Categoria> listaCategorias;
	
	private CategoriaBO categoriaBO;
	
	

	public String abmCategoria() {
		this.listaCategorias = this.categoriaBO.loadAllCategoria();
		
		return "abmCategoria";
	}
	
	public String loadNewCategoria() {
			
		this.categoria = new Categoria();
				
		return "loadNewCategoria";
	}
	
	public String loadEditCategoria() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.categoria = this.categoriaBO.getCategoria(Long.valueOf(id));
						
		return "loadEditCategoria";
	}
	
	public String loadViewCategoria() {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.categoria = this.categoriaBO.getCategoria(Long.valueOf(id));
		
		return "loadViewCategoria";
	}

	public String search() {
	
		this.listaCategorias = this.categoriaBO.findByCriteria(filterNombreCategoria);
		
		return "searchCategoria";
	}

	public String save() {
						
		this.categoriaBO.save(this.getCategoria());
		
		return this.render();
	}
	
	public String update() {
				
		this.categoriaBO.update(this.getCategoria());

		return this.render();
	}

	public String delete() {
		
		String[] ids = ServletActionContext.getRequest().getParameter("ids").split(",");
		Categoria categoria=null;
		for (int i = 0; i < ids.length; i++) {
			categoria = this.categoriaBO.getCategoria(Long.valueOf(ids[i]));
			this.categoriaBO.delete(categoria);
		}
		
		return this.render();
	}
	
	public String render() {
		
		this.listaCategorias = this.categoriaBO.loadAllCategoria();
		
		return "render";
	}

	public String getFilterNombreCategoria() {
		return filterNombreCategoria;
	}

	public void setFilterNombreCategoria(String filterNombreCategoria) {
		this.filterNombreCategoria = filterNombreCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public void setCategoriaBO(CategoriaBO categoriaBO) {
		this.categoriaBO = categoriaBO;
	}

	
}
