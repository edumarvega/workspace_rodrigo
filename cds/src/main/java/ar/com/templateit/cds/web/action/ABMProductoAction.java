package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.CategoriaBO;
import ar.com.templateit.cds.web.bo.ProductoBO;
import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class ABMProductoAction extends ActionSupport {
	private static final long serialVersionUID = 4320597057764063758L;
	private static final String ABM_PRODUCTO = "abmProducto";
	private static final String LOAD_NEW_EDIT_PRODUCTO = "loadNewEditProducto";
	private static final String LOAD_VIEW_PRODUCTO = "loadViewProducto";
	private static final String SEARCH_PRODUCTO = "searchProducto";
	private static final String RENDER = "render";
	private static final String RESULT = "result";
	private List<Producto> listaProductos;
	private Producto producto;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String marca;
	private String categoria;
	private List<Categoria> categorias;
	private String defaultCategoria;
	private String precio;
	private String stockCritico;
	private CategoriaBO categoriaBO;
	private ProductoBO productoBO;

	public String abmProducto() {
		this.listaProductos = this.productoBO.loadAllProducto();
		return "abmProducto";
	}

	public String loadNewProducto() {
		this.categorias = this.categoriaBO.loadAllCategoria();
		this.producto = new Producto();
		setDefaultCategoria("-1");
		return "loadNewProducto";
	}
	
	public String loadEditProducto() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.categorias = this.categoriaBO.loadAllCategoria();
		this.producto = this.productoBO.getProducto(Long.valueOf(id));
		
		setDefaultCategoria(this.producto.getCategoria().getId().toString());
		
		this.setPrecio(this.producto.getPrecio().toString());
		
		if(this.producto.getStockCritico()!=null){
			this.setStockCritico(this.producto.getStockCritico().toString());
		}
		return "loadEditProducto";
	}
		

	public String loadViewProducto() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.producto = this.productoBO.getProducto(Long.valueOf(id));
		return "loadViewProducto";
	}

	public String search() {
		Long codigo=null;
		
		if(this.codigo!=null && this.codigo.length()!=0){
			codigo = Long.valueOf(this.codigo);
		}
		
		this.listaProductos = this.productoBO.findByCriteria(codigo, this.nombre, this.descripcion);
		return "searchProducto";
	}

	public String save() {
		this.getProducto().setPrecioCompra(BigDecimal.ZERO);
		
		if(!this.getPrecio().isEmpty()){
			this.getProducto().setPrecio(new BigDecimal(this.getPrecio().trim()));
		}
		else{
			this.getProducto().setPrecio(BigDecimal.ZERO);
		}
				
		this.getProducto().setCantidad(new Integer(0));
		
		if(this.getProducto().getStockCritico()==null){
			this.getProducto().setStockCritico(new Integer(0));
		}
		Categoria categoria = this.categoriaBO.getCategoria(Long.valueOf(this.getCategoria()));
		this.getProducto().setCategoria(categoria);
		this.productoBO.save(this.getProducto());
		// ActionContext.getContext().getSession().put("listaProductos", this.listaProductos);
		return this.render();
	}
	
	public String update() {
		if(!this.getPrecio().isEmpty()){
			this.getProducto().setPrecio(new BigDecimal(this.getPrecio()));
		}
				
		if(!this.getStockCritico().isEmpty()){
			this.getProducto().setStockCritico(new Integer(this.getStockCritico()));
		}
				
		Categoria categoria = this.categoriaBO.getCategoria(Long.valueOf(this.getCategoria()));
		this.getProducto().setCategoria(categoria);
		this.productoBO.update(this.getProducto());
		return this.render();
	}

	public String delete() {
		String[] ids = ServletActionContext.getRequest().getParameter("ids").split(",");
		Producto producto=null;
		for (int i = 0; i < ids.length; i++) {
			 producto = this.productoBO.getProducto(Long.valueOf(ids[i]));
			 this.productoBO.delete(producto);
		}
		return this.render();
	}
	
	public String render() {
		this.listaProductos = this.productoBO.loadAllProducto();
		return "render";
	}

	public List<Producto> getListaProductos() {
		return this.listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getDefaultCategoria() {
		return this.defaultCategoria;
	}

	public void setDefaultCategoria(String defaultCategoria) {
		this.defaultCategoria = defaultCategoria;
	}

	public void setCategoriaBO(CategoriaBO categoriaBO) {
		this.categoriaBO = categoriaBO;
	}

	public void setProductoBO(ProductoBO productoBO) {
		this.productoBO = productoBO;
	}
	
	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getStockCritico() {
		return stockCritico;
	}

	public void setStockCritico(String stockCritico) {
		this.stockCritico = stockCritico;
	}
	
	
	
}
