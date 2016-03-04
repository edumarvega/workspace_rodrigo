package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.AlertaBO;
import ar.com.templateit.cds.web.bo.CompraBO;
import ar.com.templateit.cds.web.bo.CuentaCorrienteBO;
import ar.com.templateit.cds.web.bo.EstadoCuentaCorrienteBO;
import ar.com.templateit.cds.web.bo.FormaDePagoBO;
import ar.com.templateit.cds.web.bo.ProductoBO;
import ar.com.templateit.cds.web.bo.ProveedorBO;
import ar.com.templateit.cds.web.bo.TipoCuentaCorrienteBO;
import ar.com.templateit.cds.web.entity.Alerta;
import ar.com.templateit.cds.web.entity.Compra;
import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.DetalleCompra;
import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;
import ar.com.templateit.cds.web.entity.FormaDePago;
import ar.com.templateit.cds.web.entity.Producto;
import ar.com.templateit.cds.web.entity.Proveedor;
import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;
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
	private String precioDeVentaTmp;
	private String total;
	private List<DetalleCompra> items;
	private Date fechaCompra;
	private String nroTicketFactura;
	private String proveedor;
	private String idProveedor;
	private List<Compra> listaCompra;
	private Date fechaDesde;
	private Date fechaHasta;
	private String cantidad;
	private List<FormaDePago> listaFormaDePago;
	private String formaDePago;
	private String defaultFormaDePago;
	private String saldoCtaCte;
	private String importeContado;
	private String importeCtaCte;
	private BigDecimal totalCompra;
	private BigDecimal totalCompraTmp;
	private List<FormaDePago> filterFormasDePago;
	private String filterFormaDePago;
	private String defaultFilterFormaDePago;
	private BigDecimal totalCompraDiaria;
	
	
	private CompraBO compraBO;
	private ProductoBO productoBO;
	private AlertaBO alertaBO;
	private FormaDePagoBO formaDePagoBO;
	private TipoCuentaCorrienteBO tipoCuentaCorrienteBO;
	private ProveedorBO  proveedorBO;
	private EstadoCuentaCorrienteBO estadoCuentaCorrienteBO;
	private CuentaCorrienteBO cuentaCorrienteBO;
	
	
	public String ingresoProducto() {
		
		//this.listaCompra = this.compraBO.loadAllCompra();
		this.filterFormasDePago = new ArrayList<FormaDePago>();
		
		FormaDePago formaDePago = new FormaDePago();
		formaDePago.setId(new Long(0));
		formaDePago.setNombre("Todas");
		
		this.filterFormasDePago.add(formaDePago);
		List<FormaDePago> tmp = this.formaDePagoBO.loadAllFormaDePago();
		this.filterFormasDePago.addAll(tmp);
		
		this.setDefaultFilterFormaDePago(this.filterFormasDePago.get(0).toString());
		
		this.setFechaDesde(new Date());
		this.setFechaHasta(new Date());
				
		this.listaCompra = this.compraBO.findByCriteria(fechaDesde, fechaHasta, nroTicketFactura, proveedor,null);
		
		this.setTotalCompraDiaria(new BigDecimal("0.00"));
		if(this.listaCompra!=null){
			if(!this.listaCompra.isEmpty()){
				for(Compra compra:this.listaCompra){
					this.totalCompraDiaria = this.totalCompraDiaria.add(compra.getTotal());
				}
			}
		}
		
		return "ingresoProducto";
	}

	public String loadIngresoProducto() {
		this.compra = new Compra();
		this.items = new ArrayList<DetalleCompra>();
		this.compra.setItems(items);
		
		ActionContext.getContext().getSession().put("items", this.items);
		ActionContext.getContext().getSession().put("totalCompra", new BigDecimal("0.00"));
		ActionContext.getContext().getSession().put("totalCompraTmp", new BigDecimal("0.00"));
		
		this.totalCompra = new BigDecimal("0.00");
		this.totalCompraTmp = new BigDecimal("0.00");
		
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
		this.totalCompra = (BigDecimal)ActionContext.getContext().getSession().get("totalCompra");
		
		this.getItem().setPrecioDeCompra(new BigDecimal(this.getPrecioDeCompra()));
		this.getItem().setPrecioDeVenta(new BigDecimal(this.getPrecioDeVenta()));
		this.getItem().setSubTotal(new BigDecimal(this.getPrecioDeCompra()).multiply(new BigDecimal(this.getCantidad())));
		this.getItem().setCantidad(new Integer(this.getCantidad()));
		
		
		this.items = (List<DetalleCompra>)ActionContext.getContext().getSession().get("items");
		this.items.add(this.getItem());
		
		ActionContext.getContext().getSession().put("items", this.items);
		
		BigDecimal precioCantidad = new BigDecimal(this.getPrecioDeCompra()).multiply(new BigDecimal(this.getCantidad()));
		this.totalCompra = this.totalCompra.add(precioCantidad);
		this.totalCompraTmp = this.totalCompra;
		
		ActionContext.getContext().getSession().put("totalCompra", this.totalCompra);
		
		
		return "refreshItems";
	}
	
	public String deleteProducto() {
		String index = ServletActionContext.getRequest().getParameter("index");
		this.items = (List<DetalleCompra>)ActionContext.getContext().getSession().get("items");
		
		this.totalCompra = (BigDecimal)ActionContext.getContext().getSession().get("totalCompra");
		BigDecimal precioCantidad = this.items.get(Integer.parseInt(index)).getPrecioDeCompra().multiply(new BigDecimal(this.items.get(Integer.parseInt(index)).getCantidad().intValue()));  
		
		this.totalCompra = this.totalCompra.subtract(precioCantidad);
		this.totalCompraTmp = this.totalCompra;
		
		this.items.remove(Integer.parseInt(index));
		ActionContext.getContext().getSession().put("items", this.items);
		
		return "refreshItems";
	}
	
	public String loadFormaDePagoProducto() {
				
		this.listaFormaDePago = new ArrayList<FormaDePago>();
		
		List<FormaDePago> tmp = this.formaDePagoBO.loadAllFormaDePago();
		
		this.listaFormaDePago.add(tmp.get(0));
		this.listaFormaDePago.add(tmp.get(3));
		
		this.setDefaultFormaDePago(this.listaFormaDePago.get(0).toString());
		
		
		return "loadFormaDePagoProducto";
	}

	public String save() {
		
		this.compra = new Compra();
		
		Proveedor proveedor =  this.proveedorBO.getProveedor(Long.valueOf(this.getIdProveedor()));
		FormaDePago formaDePago = this.formaDePagoBO.getFormaDePago(Long.valueOf(this.getFormaDePago()));
		
		this.getCompra().setFechaAlta(new Date());
		this.getCompra().setFechaCompra(this.getFechaCompra());
		this.getCompra().setNroTicketFactura(this.getNroTicketFactura());
		this.getCompra().setProveedor(proveedor.getNombreRazonSocial());
		this.getCompra().setTotal(new BigDecimal(this.getTotal()));
		this.getCompra().setFormaDePago(formaDePago);
		
			
		this.items = new ArrayList<DetalleCompra>();
		List<DetalleCompra> tmp= (List<DetalleCompra>)ActionContext.getContext().getSession().get("items");
		
		for(DetalleCompra detalleCompra : tmp){
			detalleCompra.setCompra(this.getCompra());
			this.items.add(detalleCompra);
		}
		
		this.getCompra().setItems(this.items);
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		this.getCompra().setUsuario(usuario);
		
		this.compraBO.save(this.getCompra());
		
		for(DetalleCompra dc : this.items){
			Producto producto = this.productoBO.findByCriteria(dc.getCodigo(),"", "","",null).get(0);
			TemplateUtil tu = new TemplateUtil();
			producto.setCantidad(tu.calcularCantidad(producto.getCantidad(), dc.getCantidad()));
			producto.setPrecio(dc.getPrecioDeVenta());
			producto.setPrecioCompra(dc.getPrecioDeCompra());
			this.productoBO.update(producto);
		}
		
		
		//Crea un registro en cta cte como proveedor
		if(Integer.parseInt(this.getFormaDePago())==4){
			
			EstadoCuentaCorriente estadoCuentaCorriente = this.estadoCuentaCorrienteBO.loadAllEstadoCuentaCorriente().get(0);
			TipoCuentaCorriente tipoCuentaCorriente = this.tipoCuentaCorrienteBO.loadTipoCuentaCorriente().get(1);
			
			CuentaCorriente cuentaCorriente = new CuentaCorriente();
			cuentaCorriente.setProveedor(proveedor);
			cuentaCorriente.setEstadoCuentaCorriente(estadoCuentaCorriente);
			cuentaCorriente.setFechaCreacion(new Date());
			cuentaCorriente.setCliente(null);
			cuentaCorriente.setSaldoDeudor(new BigDecimal(this.getSaldoCtaCte()));
			cuentaCorriente.setTipoCuentaCorriente(tipoCuentaCorriente);
			cuentaCorriente.setTotalCompra(new BigDecimal(this.getTotal()));
			cuentaCorriente.setUsuario(usuario);
		
			this.cuentaCorrienteBO.save(cuentaCorriente);
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
		FormaDePago formaDePago = null;
		if(Integer.valueOf(this.getFilterFormaDePago()).intValue()!=0){
			formaDePago = this.formaDePagoBO.getFormaDePago(Long.valueOf(this.getFilterFormaDePago()));
		}
		
		this.listaCompra = this.compraBO.findByCriteria(fechaDesde, fechaHasta, nroTicketFactura, proveedor,formaDePago);
		
		this.setTotalCompraDiaria(new BigDecimal("0.00"));
		if(this.listaCompra!=null){
			if(!this.listaCompra.isEmpty()){
				for(Compra compra:this.listaCompra){
					this.totalCompraDiaria = this.totalCompraDiaria.add(compra.getTotal());
				}
			}
		}
		
		return "searchIngreso";
	}
			
	public String render() {
		this.listaCompra = this.compraBO.loadAllCompra();
		
		this.setTotalCompraDiaria(new BigDecimal("0.00"));
		if(this.listaCompra!=null){
			if(!this.listaCompra.isEmpty()){
				for(Compra compra:this.listaCompra){
					this.totalCompraDiaria = this.totalCompraDiaria.add(compra.getTotal());
				}
			}
		}
		
		return "render";
	}
	
	private void actualizarAlertas(List<DetalleCompra> items,Usuario usuario){
		
		for(DetalleCompra dv : items){
			Producto producto = this.productoBO.findByCriteria(dv.getCodigo(),"", "","",null).get(0);
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

	public String getPrecioDeVentaTmp() {
		return precioDeVentaTmp;
	}

	public void setPrecioDeVentaTmp(String precioDeVentaTmp) {
		this.precioDeVentaTmp = precioDeVentaTmp;
	}

	public List<FormaDePago> getListaFormaDePago() {
		return listaFormaDePago;
	}

	public void setListaFormaDePago(List<FormaDePago> listaFormaDePago) {
		this.listaFormaDePago = listaFormaDePago;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public String getDefaultFormaDePago() {
		return defaultFormaDePago;
	}

	public void setDefaultFormaDePago(String defaultFormaDePago) {
		this.defaultFormaDePago = defaultFormaDePago;
	}

	public void setFormaDePagoBO(FormaDePagoBO formaDePagoBO) {
		this.formaDePagoBO = formaDePagoBO;
	}

	public void setTipoCuentaCorrienteBO(TipoCuentaCorrienteBO tipoCuentaCorrienteBO) {
		this.tipoCuentaCorrienteBO = tipoCuentaCorrienteBO;
	}

	public void setProveedorBO(ProveedorBO proveedorBO) {
		this.proveedorBO = proveedorBO;
	}

	public void setEstadoCuentaCorrienteBO(
			EstadoCuentaCorrienteBO estadoCuentaCorrienteBO) {
		this.estadoCuentaCorrienteBO = estadoCuentaCorrienteBO;
	}

	public void setCuentaCorrienteBO(CuentaCorrienteBO cuentaCorrienteBO) {
		this.cuentaCorrienteBO = cuentaCorrienteBO;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getSaldoCtaCte() {
		return saldoCtaCte;
	}

	public void setSaldoCtaCte(String saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}

	public String getImporteContado() {
		return importeContado;
	}

	public void setImporteContado(String importeContado) {
		this.importeContado = importeContado;
	}

	public String getImporteCtaCte() {
		return importeCtaCte;
	}

	public void setImporteCtaCte(String importeCtaCte) {
		this.importeCtaCte = importeCtaCte;
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public BigDecimal getTotalCompraTmp() {
		return totalCompraTmp;
	}

	public void setTotalCompraTmp(BigDecimal totalCompraTmp) {
		this.totalCompraTmp = totalCompraTmp;
	}

	public List<FormaDePago> getFilterFormasDePago() {
		return filterFormasDePago;
	}

	public void setFilterFormasDePago(List<FormaDePago> filterFormasDePago) {
		this.filterFormasDePago = filterFormasDePago;
	}

	public String getFilterFormaDePago() {
		return filterFormaDePago;
	}

	public void setFilterFormaDePago(String filterFormaDePago) {
		this.filterFormaDePago = filterFormaDePago;
	}

	public String getDefaultFilterFormaDePago() {
		return defaultFilterFormaDePago;
	}

	public void setDefaultFilterFormaDePago(String defaultFilterFormaDePago) {
		this.defaultFilterFormaDePago = defaultFilterFormaDePago;
	}

	public BigDecimal getTotalCompraDiaria() {
		return totalCompraDiaria;
	}

	public void setTotalCompraDiaria(BigDecimal totalCompraDiaria) {
		this.totalCompraDiaria = totalCompraDiaria;
	}
	
			
}
