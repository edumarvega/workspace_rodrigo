package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleCompra implements Serializable {

	private static final long serialVersionUID = 4989695293348363440L;
	private Long id;
	private Long codigo;
	private String nombre;
	private String descripcion;
	private BigDecimal precioDeCompra;
	private BigDecimal precioDeVenta;
	private Integer cantidad;
	private BigDecimal subTotal;
	private Compra compra;

	public DetalleCompra() {
	}

	public DetalleCompra(Long codigo,String nombre,String descripcion, 
						BigDecimal precioDeCompra,BigDecimal precioDeVenta, Integer cantiad,BigDecimal subTotal,Compra compra) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioDeCompra = precioDeCompra;
		this.precioDeVenta = precioDeVenta;
		this.cantidad = cantiad;
		this.subTotal = subTotal;
		this.compra = compra;
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

	public BigDecimal getPrecioDeCompra() {
		return precioDeCompra;
	}

	public void setPrecioDeCompra(BigDecimal precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}

	public BigDecimal getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(BigDecimal precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	

}
