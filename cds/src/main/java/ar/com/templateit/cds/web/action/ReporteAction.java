package ar.com.templateit.cds.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.UsuarioBO;
import ar.com.templateit.cds.web.bo.VentaBO;
import ar.com.templateit.cds.web.entity.DetalleVenta;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

import com.opensymphony.xwork2.ActionSupport;

public class ReporteAction extends ActionSupport{

	private static final long serialVersionUID = 5490673122054054479L;
	private Venta venta;
	private DetalleVenta item;
	private List<DetalleVenta> items;
	private List<Venta> listaVenta;
	private Date fechaDesde;
	private Date fechaHasta;
	private String usuario;
	private String idUsuario;
	private BigDecimal totalVenta;
	private String nombreEmpresa;
	private String direccion;
	private String telefono;
	private String email;
	private BigDecimal totalVentaDiaria;
	private List<Usuario> listaUsuarios;
	private String defaultUsuario;
				
	private VentaBO ventaBO;
	private UsuarioBO usuarioBO;
		
	public String reporte() {
		
		this.listaUsuarios = new ArrayList<Usuario>();
		
		Usuario usuario = new Usuario();
		usuario.setId(new Long(0));
		usuario.setUsuario("Todos");
		
		this.listaUsuarios.add(usuario);
		
		List<Usuario> usuariosTmp = this.usuarioBO.loadAllUsuario();
		this.listaUsuarios.addAll(usuariosTmp);
		
		this.setDefaultUsuario(usuario.getId().toString());
		
		this.setTotalVentaDiaria(new BigDecimal("0.00"));
				
		this.setFechaDesde(new Date());
		this.setFechaHasta(new Date());
		
		this.listaVenta = this.ventaBO.findVentaByUsuario(this.fechaDesde, this.fechaHasta, null);
		
		if(this.listaVenta!=null){
			if(!this.listaVenta.isEmpty()){
				for(Venta venta : this.listaVenta){
					this.totalVentaDiaria = this.totalVentaDiaria.add(venta.getTotal());
				}
			}	
		}
		
		return "reporte";
	}
	
	
	public String search() {

		this.setTotalVentaDiaria(new BigDecimal("0.00"));
						
		Usuario usuario = null;
		
		if(this.usuario!=null){
			if(Integer.parseInt(this.usuario)!=0){
				usuario = this.usuarioBO.getUsuarioById(Long.valueOf(this.usuario));
			}
		}
		
		this.listaVenta = this.ventaBO.findVentaByUsuario(this.fechaDesde, this.fechaHasta, usuario);
		
		if(this.listaVenta!=null){
			if(!this.listaVenta.isEmpty()){
				for(Venta venta : this.listaVenta){
					this.totalVentaDiaria = this.totalVentaDiaria.add(venta.getTotal());
				}
			}	
		}
		
		return "searchVentaByUsuario";
	}
	
	
	public String imprimirVenta() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.venta = this.ventaBO.getVenta(Long.valueOf(id));
		
		return "imprimirVenta";
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

	

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public BigDecimal getTotalVenta() {
		return totalVenta;
	}


	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
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


	public BigDecimal getTotalVentaDiaria() {
		return totalVentaDiaria;
	}


	public void setTotalVentaDiaria(BigDecimal totalVentaDiaria) {
		this.totalVentaDiaria = totalVentaDiaria;
	}


	public void setVentaBO(VentaBO ventaBO) {
		this.ventaBO = ventaBO;
	}


	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}


	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	public String getDefaultUsuario() {
		return defaultUsuario;
	}


	public void setDefaultUsuario(String defaultUsuario) {
		this.defaultUsuario = defaultUsuario;
	}
		
			

}
