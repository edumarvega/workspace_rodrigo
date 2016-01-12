package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Silvina Yarbi
 *
 */
public class Producto implements Serializable {

	private static final long serialVersionUID = 8018618483227408175L;
	private Long id;
	private Long codigo;
	private String nombre;
	private String descripcion;
	private String marca;
	private Categoria categoria;
	private BigDecimal precio;
	private BigDecimal precioCompra;
	private Integer cantidad;
	private Integer stockCritico;
	
	public Producto(){
	}
	
	public Producto(Long id,Long codigo,String nombre,
		              String descripcion,String marca,Categoria categoria,BigDecimal precio,
		              BigDecimal precioCompra, Integer cantidad,Integer stockCritico){
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.stockCritico = stockCritico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getStockCritico() {
		return stockCritico;
	}

	public void setStockCritico(Integer stockCritico) {
		this.stockCritico = stockCritico;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	
	
}
