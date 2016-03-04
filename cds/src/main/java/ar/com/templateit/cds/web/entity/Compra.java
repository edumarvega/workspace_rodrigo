package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Compra implements Serializable {

	private static final long serialVersionUID = 8619973025721455101L;
	private Long id;
	private Date fechaAlta;
	private Date fechaCompra;
	private String nroTicketFactura;
	private String proveedor;
	private BigDecimal total;
	private List<DetalleCompra> items;
	private Usuario usuario;
	private FormaDePago formaDePago;

	public Compra() {
	}

	public Compra(Date fechaAlta,Date fechaCompra, String nroTicketFactura, String proveedor,
			BigDecimal total, List<DetalleCompra> items,Usuario usuario,FormaDePago formaDePago) {
		this.fechaAlta = fechaAlta;
		this.fechaCompra = fechaCompra;
		this.nroTicketFactura = nroTicketFactura;
		this.proveedor = proveedor;
		this.total = total;
		this.items = items;
		this.usuario = usuario;
		this.formaDePago = formaDePago;
	}
			
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<DetalleCompra> getItems() {
		return items;
	}

	public void setItems(List<DetalleCompra> items) {
		this.items = items;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
}
