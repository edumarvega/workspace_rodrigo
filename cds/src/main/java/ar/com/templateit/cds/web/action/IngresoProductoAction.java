package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.AlertaBO;
import ar.com.templateit.cds.web.bo.CompraBO;
import ar.com.templateit.cds.web.bo.ProductoBO;
import ar.com.templateit.cds.web.entity.Alerta;
import ar.com.templateit.cds.web.entity.Compra;
import ar.com.templateit.cds.web.entity.DetalleCompra;
import ar.com.templateit.cds.web.entity.Producto;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.util.TemplateUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IngresoProductoAction extends ActionSupport {

	private static final long serialVersionUID = -8266059090938765484L;
	private Compra compra;
	private DetalleCompra item;
	private String precioDeCompra;
	private String precioDeVenta;
	private String total;
	private List<DetalleCompra> items;
	private Date fechaCompra;
	private String nroTicketFactura;
	private String proveedor;
	private List<Compra> listaCompra;
	private Date fechaDesde;
	private Date fechaHasta;
	private String cantidad;
	
	
	private CompraBO compraBO;
	private ProductoBO productoBO;
	private AlertaBO alertaBO;

	public String ingresoProducto() {
		//this.listaCompra = this.compraBO.loadAllCompra();
		this.setFechaDesde(new Date());
		this.setFechaHasta(new Date());
		
		this.listaCompra = this.compraBO.findByCriteria(fechaDesde, fechaHasta, nroTicketFactura, proveedor);
		
		return "ingresoProducto";
	}

	public String loadIngresoProducto() {
		this.compra = new Compra();
		this.items = new ArrayList<DetalleCompra>();
		this.compra.setItems(items);
		ActionContext.getContext().getSession().put("items", this.items);
		return "loadIngresoProducto";
	}
	
	public String loadEditIngresoProducto() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.compra = this.compraBO.getCompra(Long.valueOf(id));
		this.total = this.compra.getTotal().toString();		
		ActionContext.getContext().getSession().put("items", this.compra.getItems());
		return "loadEditIngresoProducto";
	}
	
	public String loadViewIngresoProducto() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.compra = this.compraBO.getCompra(Long.valueOf(id));
		this.total = this.compra.getTotal().toString();
		ActionContext.getContext().getSession().put("items", this.compra.getItems());
		return "loadViewIngresoProducto";
	}
	
	public String loadAddProducto() {
		this.item = new DetalleCompra();
		return "loadAddProducto";
	}

	public String addProducto() {
		this.getItem().setPrecioDeCompra(new BigDecimal(this.getPrecioDeCompra()));
		this.getItem().setPrecioDeVenta(new BigDecimal(this.getPrecioDeVenta()));
		this.getItem().setSubTotal(new BigDecimal(this.getPrecioDeCompra()).multiply(new BigDecimal(Integer.parseInt(this.cantidad))));
		this.getItem().setCantidad(Integer.parseInt(this.cantidad));
		this.items = (List<DetalleCompra>)ActionContext.getContext().getSession().get("items");
		this.items.add(this.getItem());
		ActionContext.getContext().getSession().put("items", this.items);
		return "refreshItems";
	}
	
	public String deleteProducto() {
		String index = ServletActionContext.getRequest().getParameter("index");
		this.items = (List<DetalleCompra>)ActionContext.getContext().getSession().get("items");
		this.items.remove(Integer.parseInt(index));
		ActionContext.getContext().getSession().put("items", this.items);
		return "refreshItems";
	}

	public String save() {
		this.getCompra().setFechaAlta(new Date());
		this.getCompra().setTotal(new BigDecimal(this.getTotal()));
		this.items = (List<DetalleCompra>)ActionContext.getContext().getSession().get("items");
		this.getCompra().setItems(this.items);
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		this.getCompra().setUsuario(usuario);
		
		this.compraBO.save(this.getCompra());
		
		for(DetalleCompra dc : this.items){
			Producto producto = this.productoBO.findByCriteria(dc.getCodigo(),"", "").get(0);
			TemplateUtil tu = new TemplateUtil();
			producto.setCantidad(tu.calcularCantidad(producto.getCantidad(), dc.getCantidad()));
			producto.setPrecio(dc.getPrecioDeVenta());
			producto.setPrecioCompra(dc.getPrecioDeCompra());
			this.productoBO.update(producto);
		}
		
		this.actualizarAlertas(this.items,usuario);
		
		return this.render();
	}
	
	
	public String update() {
		this.getCompra().setFechaCompra(this.getFechaCompra());
		this.getCompra().setNroTicketFactura(this.getNroTicketFactura());
		this.getCompra().setProveedor(this.getProveedor());
		this.getCompra().setTotal(new BigDecimal(this.getTotal()));
		this.items = (List<DetalleCompra>)ActionContext.getContext().getSession().get("items");
		this.getCompra().setItems(this.items);
		this.compraBO.update(this.getCompra());
		return this.render();
	}
	
	public String search() {
		this.listaCompra = this.compraBO.findByCriteria(fechaDesde, fechaHasta, nroTicketFactura, proveedor);
		return "searchIngreso";
	}
			
	public String render() {
		this.listaCompra = this.compraBO.loadAllCompra();
		return "render";
	}
	
	private void actualizarAlertas(List<DetalleCompra> items,Usuario usuario){
		
		for(DetalleCompra dv : items){
			Producto producto = this.productoBO.findByCriteria(dv.getCodigo(),"", "").get(0);
			TemplateUtil tu = new TemplateUtil();
			Alerta alerta = this.alertaBO.findByCode(producto.getCodigo());
			Boolean stockCritico = tu.verificarStockCritico(producto.getCantidad(),producto.getStockCritico());
			if(stockCritico){
				if(alerta!=null){
					alerta.setNombre(producto.getNombre());
					alerta.setDescripcion(producto.getDescripcion());
					alerta.setMarca(producto.getMarca());
					alerta.setCategoria(producto.getCategoria().getNombre());
					alerta.setCantidadActual(producto.getCantidad());
					
					this.alertaBO.update(alerta);
				}
			}
			else{
				if(alerta!=null){
					this.alertaBO.delete(alerta);
				}	
			}
		}
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public DetalleCompra getItem() {
		return item;
	}

	public void setItem(DetalleCompra item) {
		this.item = item;
	}
	
	public List<DetalleCompra> getItems() {
		return items;
	}

	public void setItems(List<DetalleCompra> items) {
		this.items = items;
	}

	public String getPrecioDeCompra() {
		return precioDeCompra;
	}

	public void setPrecioDeCompra(String precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}

	public String getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(String precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setCompraBO(CompraBO compraBO) {
		this.compraBO = compraBO;
	}

	public void setProductoBO(ProductoBO productoBO) {
		this.productoBO = productoBO;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getNroTicketFactura() {
		return nroTicketFactura;
	}

	public void setNroTicketFactura(String nroTicketFactura) {
		this.nroTicketFactura = nroTicketFactura;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public List<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<Compra> listaCompra) {
		this.listaCompra = listaCompra;
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

	public void setAlertaBO(AlertaBO alertaBO) {
		this.alertaBO = alertaBO;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
		
}
