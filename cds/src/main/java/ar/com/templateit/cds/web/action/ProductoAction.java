package ar.com.templateit.cds.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.ProductoBO;
import ar.com.templateit.cds.web.entity.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class ProductoAction extends ActionSupport {
	private static final long serialVersionUID = 8693977464247776816L;
	private static final String PARAM_JSON = "term";
	private Long codigo;
	private String nombre;
	private String marca;
	private List<Producto> listaProductos;
	private ProductoBO productoBO;
	private List<String> lista;
	private String mensaje;
		
	public String loadFilterProducto() {
		this.listaProductos = this.productoBO.loadAllProducto();
		return "loadFilterProducto";
	}
	
	public String loadSearchProducto() {
		this.listaProductos = this.productoBO.loadAllProducto();
		return "loadSearchProducto";
	}
			
	public String search() {
		if(this.nombre==null){
			this.nombre ="";
		}
		this.listaProductos = this.productoBO.findByCriteria(this.codigo, this.nombre, "",this.marca,null);
		return "searchProducto";
	}
	
	public String searchProducto() {
		if(this.nombre==null){
			this.nombre ="";
		}
		this.listaProductos = this.productoBO.findByCriteria(this.codigo, this.nombre, "",this.marca,null);
		return "productos";
	}
	
	public String getJsonProductos(){
//		String nombreRequest = ServletActionContext.getRequest().getParameter("term").trim();
//		this.listaProductos = this.productoBO.findByCriteria(null,nombreRequest, "");
		System.out.println("Haciendo json...");
		this.lista = new ArrayList<String>();
		lista.add("Manteca");
		lista.add("Mamadera");
		lista.add("Mermelada");
		lista.add("Mandioca");
		
		return "myJson";
	}
	
	public String getNombreProducto(){
		String parametro = ServletActionContext.getRequest().getParameter(PARAM_JSON).trim();
		this.listaProductos = this.productoBO.findByCriteria(null,parametro, "","",null);
		return SUCCESS;
	}
	
	public String getDescripcionProducto(){
		String parametro = ServletActionContext.getRequest().getParameter(PARAM_JSON).trim();
		this.listaProductos = this.productoBO.findByCriteria(null,"",parametro,"",null);
		return SUCCESS;
	}
	
	public String verificarExisteProducto(){
		this.mensaje = "no";
		if(this.nombre==null){
			this.nombre ="";
		}
		this.listaProductos = this.productoBO.findByCriteria(this.codigo, this.nombre, "","",null);
		if(listaProductos!=null){
			if(!listaProductos.isEmpty()){
				this.mensaje = "si";
			}
		}
		return SUCCESS;
	}
	
	
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void setProductoBO(ProductoBO productoBO) {
		this.productoBO = productoBO;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	



}
