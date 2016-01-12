package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleVenta implements Serializable{

	private static final long serialVersionUID = 228299942567223054L;
	private Long id;
	private Long codigo;
	private String nombre;
	private String descripcion;
	private String categoria;
	private BigDecimal precioCompra;
	private BigDecimal precioVenta;
	private BigDecimal margenDeGanancia;
	private Integer cantidad;
	private BigDecimal subTotal;
	private Venta venta;

	public DetalleVenta(){
		
	}
	
	public DetalleVenta(Long codigo,String nombre,String descripcion,
						String categoria,BigDecimal precioCompra,BigDecimal precioVenta,
						BigDecimal margenDeGanancia, Integer cantidad,BigDecimal subTotal,Venta venta){
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.margenDeGanancia = margenDeGanancia;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
		this.venta = venta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getMargenDeGanancia() {
		return margenDeGanancia;
	}

	public void setMargenDeGanancia(BigDecimal margenDeGanancia) {
		this.margenDeGanancia = margenDeGanancia;
	}
	
	
	
	
}
