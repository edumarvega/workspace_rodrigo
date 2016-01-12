package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.AlertaBO;
import ar.com.templateit.cds.web.bo.CategoriaBO;
import ar.com.templateit.cds.web.bo.ProductoBO;
import ar.com.templateit.cds.web.bo.VentaBO;
import ar.com.templateit.cds.web.entity.Alerta;
import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.DetalleVenta;
import ar.com.templateit.cds.web.entity.Producto;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;
import ar.com.templateit.cds.web.util.TemplateUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EgresoProductoAction extends ActionSupport{

	private static final long serialVersionUID = 2248256274621496012L;
	private static final String MSG_NO_EXITE_PRODUCTO ="No existe el producto.";
	private static final String MSG_SIN_PRECIO ="El producto no tiene cargado el precio.";
	private static final String MSG_SIN_STOCK ="El producto no tiene cargado stock.";
	private static final String CODIGO ="código";
	private static final String NOMBRE ="nombre";
	private static final String PRECIO ="precio";
	private static final String EFECTIVO ="Efectivo";
	private static final String TARJETA_DEBITO ="Débito";
	private static final String TARJETA_CREDITO ="TarjetaCrédito";
	private Venta venta;
	private DetalleVenta item;
	private List<DetalleVenta> items;
	private String cantidad;
	private String codigo;
	private String nombre;
	private String precio;
	private List<Venta> listaVenta;
	private Date fechaDesde;
	private Date fechaHasta;
	private String nroTicketFactura;
	private String observaciones;
	private BigDecimal totalVenta;
	private String nombreEmpresa;
	private String direccion;
	private String telefono;
	private String email;
	private String mensajeError;
	private String categoria;
	private List<Categoria> categorias;
	private String defaultCategoria;
	private List<String> ventasPor;
	private List<String> mediosDePago;
	private String selectedVentaPor;
	private String selectedMedioDePago;
	private Map<Long,String>  categoriaSinCodigo;
	private String cambio;
	private String importe;
	private String ventaTotal;
	private String porcentajeDescuento;
	private String descuento;
	private String interesDebito;
	private String interesTarjetaCredito;
	private BigDecimal totalVentaDiaria;
				
	private VentaBO ventaBO;
	private ProductoBO productoBO;
	private AlertaBO alertaBO;
	private CategoriaBO categoriaBO;
	
	public String egresoProducto() {
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
//	    EgresoProductoAction epa = (EgresoProductoAction)context.getBean("egresoProductoAction");
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		this.mensajeError =null;
		
		this.setTotalVentaDiaria(new BigDecimal("0.00"));
		
		//this.listaVenta = this.ventaBO.loadAllVenta();
		this.setFechaDesde(new Date());
		this.setFechaHasta(new Date());
		
		this.listaVenta = this.ventaBO.findByCriteria(fechaDesde, fechaHasta, observaciones,usuario.getUsuario());
		
		if(this.listaVenta!=null){
			if(!this.listaVenta.isEmpty()){
				for(Venta venta : this.listaVenta){
					this.totalVentaDiaria = this.totalVentaDiaria.add(venta.getTotal());
				}
			}	
		}
		
		return "egresoProducto";
	}

	public String loadEgresoProducto() {
		
		this.ventasPor = new ArrayList<String>();
		this.ventasPor.add(CODIGO);
		this.ventasPor.add(NOMBRE);
		this.ventasPor.add(PRECIO);
				
		this.categorias = new ArrayList<Categoria>();
		
		//RECORRER EL MAP, CREAR OBJETOS Y AGREGARLOS A LA LISTA DE CATEGORIAS
		
		for (Entry<Long, String> e: categoriaSinCodigo.entrySet()) {
	        Categoria categoria = new Categoria();
	        categoria.setId(e.getKey());
	        categoria.setNombre(e.getValue());
	        this.categorias.add(categoria);
	    }
				
		setDefaultCategoria(this.categorias.get(0).getId().toString());
		
		this.venta = new Venta();
		this.items = new ArrayList<DetalleVenta>();
		this.venta.setItems(items);
		
		ActionContext.getContext().getSession().put("itemsVenta", this.items);
		ActionContext.getContext().getSession().put("totalVenta", new BigDecimal("0.00"));
		
		this.totalVenta = new BigDecimal("0.00");
		
		return "loadEgresoProducto";
	}
	
	public String loadImporteProducto() {
		this.totalVenta = (BigDecimal)ActionContext.getContext().getSession().get("totalVenta");
				
		String observaciones = (String) ServletActionContext.getRequest().getParameter("observaciones");
			
		this.mediosDePago = new ArrayList<String>();
		this.mediosDePago.add(EFECTIVO);
		this.mediosDePago.add(TARJETA_DEBITO);
		this.mediosDePago.add(TARJETA_CREDITO);
		
		ActionContext.getContext().getSession().put("observaciones", observaciones);
		
		return "loadImporteProducto";
	}
	
	public String search() {
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		this.setTotalVentaDiaria(new BigDecimal("0.00"));
		
		this.listaVenta = this.ventaBO.findByCriteria(fechaDesde, fechaHasta, observaciones,usuario.getUsuario());
		
		if(this.listaVenta!=null){
			if(!this.listaVenta.isEmpty()){
				for(Venta venta : this.listaVenta){
					this.totalVentaDiaria = this.totalVentaDiaria.add(venta.getTotal());
				}
			}	
		}
		
		return "searchEgreso";
	}
	
	public String addProducto(){
		
		this.totalVenta = (BigDecimal)ActionContext.getContext().getSession().get("totalVenta");
		String cantidad = ServletActionContext.getRequest().getParameter("cantidad");
		String codigo = ServletActionContext.getRequest().getParameter("codigo");
		
		Producto producto = this.productoBO.findByCode(Long.valueOf(codigo));
		//si no existe refresca la lista igual
		
		if(producto!=null){
			if(producto.getCantidad().intValue()==0){
				this.mensajeError =MSG_SIN_STOCK;
			}
			else if(producto.getPrecio().compareTo(BigDecimal.ZERO)==0){
				this.mensajeError =MSG_SIN_PRECIO;
			}
			else{
				this.item = new DetalleVenta();
				
				this.getItem().setCodigo(producto.getCodigo());
				this.getItem().setNombre(producto.getNombre());
				this.getItem().setDescripcion(producto.getDescripcion());
				this.getItem().setCategoria(producto.getCategoria().getNombre());
				this.getItem().setCantidad(Integer.valueOf(cantidad));
				this.getItem().setPrecioVenta(producto.getPrecio());
				this.getItem().setSubTotal(producto.getPrecio().multiply(new BigDecimal(Integer.parseInt(cantidad))));

				this.items = (List<DetalleVenta>)ActionContext.getContext().getSession().get("itemsVenta");
				this.items.add(this.getItem());
				
				ActionContext.getContext().getSession().put("itemsVenta", this.items);
				BigDecimal precioCantidad = producto.getPrecio().multiply(new BigDecimal(Integer.parseInt(cantidad)));
				
				this.totalVenta = this.totalVenta.add(precioCantidad);
				
				ActionContext.getContext().getSession().put("totalVenta", totalVenta);
				
				this.mensajeError =null;
			}
		}
		else{
			this.mensajeError =MSG_NO_EXITE_PRODUCTO;
		}
		return "refreshItems";
	}
	
	public String addProductoPorPrecio(){
			
			this.totalVenta = (BigDecimal)ActionContext.getContext().getSession().get("totalVenta");
			String cantidad = ServletActionContext.getRequest().getParameter("cantidad");
			String precio = ServletActionContext.getRequest().getParameter("precio");
			String categoria = ServletActionContext.getRequest().getParameter("categoria");
						
			String nombreCategoria = this.categoriaSinCodigo.get(Long.valueOf(categoria));
			Categoria cat = new Categoria();
			cat.setId(Long.valueOf(categoria));
			cat.setNombre(nombreCategoria);
			
			Producto producto = new Producto();
			producto.setCodigo(cat.getId());
			producto.setPrecio(new BigDecimal(precio));
			producto.setCategoria(cat);
			producto.setNombre(cat.getNombre());
			producto.setDescripcion(cat.getNombre());
			producto.setPrecio(new BigDecimal(precio));
						
						
			this.item = new DetalleVenta();
			this.getItem().setCodigo(producto.getCodigo());
			this.getItem().setNombre(producto.getNombre());
			this.getItem().setDescripcion(producto.getDescripcion());
			this.getItem().setCategoria(producto.getCategoria().getNombre());
			this.getItem().setCantidad(Integer.valueOf(cantidad));
			this.getItem().setPrecioCompra(producto.getPrecioCompra());
			this.getItem().setPrecioVenta(producto.getPrecio());
			this.getItem().setMargenDeGanancia( (producto.getPrecio().subtract(producto.getPrecio())).multiply(new BigDecimal(Integer.parseInt(cantidad))));
			this.getItem().setSubTotal(producto.getPrecio().multiply(new BigDecimal(Integer.parseInt(cantidad))));
			
			this.items = (List<DetalleVenta>)ActionContext.getContext().getSession().get("itemsVenta");
			this.items.add(this.getItem());
			ActionContext.getContext().getSession().put("itemsVenta", this.items);
			
			BigDecimal precioCantidad = producto.getPrecio().multiply(new BigDecimal(Integer.parseInt(cantidad)));
			
			this.totalVenta = this.totalVenta.add(precioCantidad);
			ActionContext.getContext().getSession().put("totalVenta", totalVenta);
		
		
		return "refreshItems";
	}
	
	public String deleteProducto() {
		String index = ServletActionContext.getRequest().getParameter("index");
		this.items = (List<DetalleVenta>)ActionContext.getContext().getSession().get("itemsVenta");
		totalVenta = (BigDecimal)ActionContext.getContext().getSession().get("totalVenta");
		BigDecimal precioCantidad = this.items.get(Integer.parseInt(index)).getPrecioVenta().multiply(
				                      new BigDecimal(this.items.get(Integer.parseInt(index)).getCantidad().intValue()));  
		
		this.totalVenta = this.totalVenta.subtract(precioCantidad);
		this.items.remove(Integer.parseInt(index));
		
		ActionContext.getContext().getSession().put("itemsVenta", this.items);
		ActionContext.getContext().getSession().put("totalVenta", totalVenta);
		
		return "refreshItems";
	}
	
	public String save() {
		String observaciones = (String)ActionContext.getContext().getSession().get("observaciones");
						
		this.venta= new Venta();
		
		this.getVenta().setFechaAlta(new Date());
		this.getVenta().setFechaVenta(new Date());
		this.getVenta().setNroTicketFactura(this.nroTicketFactura);
		this.getVenta().setTotal(new BigDecimal(this.getVentaTotal()));
		
		
		if(EFECTIVO.equals(this.getSelectedMedioDePago())){
			this.getVenta().setEfectivo(new BigDecimal(this.getImporte()));
			this.getVenta().setCambio(new BigDecimal(this.getCambio()));
			
			this.getVenta().setMedioDePago(new Integer(1));
			if(this.getPorcentajeDescuento()!=null && this.getPorcentajeDescuento().length()>0){
				this.getVenta().setPorcentajeDescuento(new BigDecimal(this.getPorcentajeDescuento()));
				this.getVenta().setDescuento(new BigDecimal(this.getDescuento()));
			}
			else{
				this.getVenta().setPorcentajeDescuento(BigDecimal.ZERO);
				this.getVenta().setDescuento(BigDecimal.ZERO);
			}
		}
		else if(TARJETA_DEBITO.equals(this.getSelectedMedioDePago())){
			this.getVenta().setEfectivo(BigDecimal.ZERO);
			this.getVenta().setCambio(BigDecimal.ZERO);
			
			this.getVenta().setMedioDePago(new Integer(2));
			if(this.getInteresDebito()!=null && this.getInteresDebito().length()>0){
				this.getVenta().setInteresDebito(new BigDecimal(this.getInteresDebito()));
			}
			else{
				this.getVenta().setInteresDebito(BigDecimal.ZERO);
			}
		}
		else{
			this.getVenta().setEfectivo(BigDecimal.ZERO);
			this.getVenta().setCambio(BigDecimal.ZERO);
			
			this.getVenta().setMedioDePago(new Integer(3));
			if(this.getInteresTarjetaCredito()!=null && this.getInteresTarjetaCredito().length()>0){
				this.getVenta().setInteresCredito(new BigDecimal(this.getInteresTarjetaCredito()));
			}
			else{
				this.getVenta().setInteresCredito(BigDecimal.ZERO);
			}
		}
		
		if(observaciones!=null){
			this.getVenta().setObservaciones(observaciones.trim());	
		}
		else{
			this.getVenta().setObservaciones("");
		}
				
		this.items = new ArrayList<DetalleVenta>();
		
		List<DetalleVenta> detalleVenta = (List<DetalleVenta>)ActionContext.getContext().getSession().get("itemsVenta");
		for(DetalleVenta dv: detalleVenta){
			dv.setVenta(this.getVenta());
			this.items.add(dv);
		}
				
		this.getVenta().setItems(this.items);
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		this.getVenta().setUsuario(usuario);

		this.ventaBO.save(this.getVenta());
		
		boolean esProductoConCodigo=true;
		
		for(DetalleVenta dv : this.items){
			for (Entry<Long, String> e: categoriaSinCodigo.entrySet()) {
				if(e.getKey().intValue()==dv.getCodigo().intValue()){
					esProductoConCodigo = false;
		        }
		    }
			
			if(esProductoConCodigo){
				Producto producto = this.productoBO.findByCriteria(dv.getCodigo(),"", "").get(0);
				TemplateUtil tu = new TemplateUtil();
				producto.setCantidad(tu.decrementarStockActual(producto.getCantidad(), dv.getCantidad()));
				this.productoBO.update(producto);
			}
			
		}
		
		this.cargarAlertas(this.items,usuario);
		
		return this.render();
	}
	
	public String render() {
		
		Usuario usuario = (Usuario)ActionContext.getContext().getSession().get("usuario");
		
		this.setTotalVentaDiaria(new BigDecimal("0.00"));
		
		this.listaVenta = this.ventaBO.findByCriteria(fechaDesde, fechaHasta, observaciones,usuario.getUsuario());
		
		if(this.listaVenta!=null){
			if(!this.listaVenta.isEmpty()){
				for(Venta venta : this.listaVenta){
					this.totalVentaDiaria = this.totalVentaDiaria.add(venta.getTotal());
				}
			}	
		}
		
		return "render";
	}
	
	private void cargarAlertas(List<DetalleVenta> items,Usuario usuario){
		
		boolean esProductoConCodigo=true;
				
		for(DetalleVenta dv : items){
			for (Entry<Long, String> e: categoriaSinCodigo.entrySet()) {
				if(e.getKey().intValue()==dv.getCodigo().intValue()){
					esProductoConCodigo = false;
		        }
		    }
			
			if(esProductoConCodigo){
				
				Producto producto = this.productoBO.findByCriteria(dv.getCodigo(),"", "").get(0);
				TemplateUtil tu = new TemplateUtil();
				Boolean stockCritico = tu.verificarStockCritico(producto.getCantidad(),producto.getStockCritico());
				if(stockCritico){
					Alerta alerta = this.alertaBO.findByCode(producto.getCodigo());
					if(alerta==null){
						Alerta alertaNueva = new Alerta();
						
						alertaNueva.setFechaIngreso(new Date());
						alertaNueva.setCodigo(producto.getCodigo());
						alertaNueva.setNombre(producto.getNombre());
						alertaNueva.setDescripcion(producto.getDescripcion());
						alertaNueva.setMarca(producto.getMarca());
						alertaNueva.setCategoria(producto.getCategoria().getNombre());
						alertaNueva.setCantidadActual(producto.getCantidad());			
						alertaNueva.setUsuario(usuario);
						
						this.alertaBO.save(alertaNueva);
					}
					else{
						alerta.setNombre(producto.getNombre());
						alerta.setDescripcion(producto.getDescripcion());
						alerta.setMarca(producto.getMarca());
						alerta.setCategoria(producto.getCategoria().getNombre());
						alerta.setCantidadActual(producto.getCantidad());
						
						this.alertaBO.update(alerta);
					}
				}
				
			}
			
		}
	}
	
	public String imprimirVenta() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.venta = this.ventaBO.getVenta(Long.valueOf(id));
		
		return "imprimirVenta";
	}
	
	public String imprimirTicketNoFiscal() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.venta = this.ventaBO.getVenta(Long.valueOf(id));
		
		return "imprimirTicketNoFiscal";
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public DetalleVenta getItem() {
		return item;
	}

	public void setItem(DetalleVenta item) {
		this.item = item;
	}
	
	public List<DetalleVenta> getItems() {
		return items;
	}

	public void setItems(List<DetalleVenta> items) {
		this.items = items;
	}

	
	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public List<Venta> getListaVenta() {
		return listaVenta;
	}

	public void setListaVenta(List<Venta> listaVenta) {
		this.listaVenta = listaVenta;
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

	public String getNroTicketFactura() {
		return nroTicketFactura;
	}

	public void setNroTicketFactura(String nroTicketFactura) {
		this.nroTicketFactura = nroTicketFactura;
	}
	
	
	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public void setVentaBO(VentaBO ventaBO) {
		this.ventaBO = ventaBO;
	}

	public void setProductoBO(ProductoBO productoBO) {
		this.productoBO = productoBO;
	}

	public void setAlertaBO(AlertaBO alertaBO) {
		this.alertaBO = alertaBO;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getDefaultCategoria() {
		return defaultCategoria;
	}

	public void setDefaultCategoria(String defaultCategoria) {
		this.defaultCategoria = defaultCategoria;
	}

	public void setCategoriaBO(CategoriaBO categoriaBO) {
		this.categoriaBO = categoriaBO;
	}

	public List<String> getVentasPor() {
		return ventasPor;
	}

	public void setVentasPor(List<String> ventasPor) {
		this.ventasPor = ventasPor;
	}
	

	public String getDefaultVentaPor(){
		return CODIGO;
	}

	public String getSelectedVentaPor() {
		return selectedVentaPor;
	}

	public void setSelectedVentaPor(String selectedVentaPor) {
		this.selectedVentaPor = selectedVentaPor;
	}


	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(String ventaTotal) {
		this.ventaTotal = ventaTotal;
	}

	public String getDefaultMediDePago(){
		return EFECTIVO;
	}

	public List<String> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(List<String> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	public String getSelectedMedioDePago() {
		return selectedMedioDePago;
	}

	public void setSelectedMedioDePago(String selectedMedioDePago) {
		this.selectedMedioDePago = selectedMedioDePago;
	}

	public String getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(String porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
		

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getInteresDebito() {
		return interesDebito;
	}

	public void setInteresDebito(String interesDebito) {
		this.interesDebito = interesDebito;
	}

	public String getInteresTarjetaCredito() {
		return interesTarjetaCredito;
	}

	public void setInteresTarjetaCredito(String interesTarjetaCredito) {
		this.interesTarjetaCredito = interesTarjetaCredito;
	}

	public Map<Long, String> getCategoriaSinCodigo() {
		return categoriaSinCodigo;
	}

	public void setCategoriaSinCodigo(Map<Long, String> categoriaSinCodigo) {
		this.categoriaSinCodigo = categoriaSinCodigo;
	}

	public BigDecimal getTotalVentaDiaria() {
		return totalVentaDiaria;
	}

	public void setTotalVentaDiaria(BigDecimal totalVentaDiaria) {
		this.totalVentaDiaria = totalVentaDiaria;
	}
		
	
	

}
