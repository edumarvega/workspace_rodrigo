package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Venta implements Serializable{

	private static final long serialVersionUID = -5089044923508734808L;
	private Long id;
	private Date fechaAlta;
	private Date fechaVenta;
	private String nroTicketFactura;
	private BigDecimal total;
	private BigDecimal efectivo;
	private BigDecimal cambio;
	private List<DetalleVenta> items;
	private Usuario usuario;
	private String observaciones;
	private BigDecimal porcentajeDescuento;
	private BigDecimal descuento;
	private BigDecimal interesDebito;
	private BigDecimal interesCredito;
	private FormaDePago formaDePago;
	private String numeroTarjetaCredito;
	
	public Venta(){
	}
	
	public Venta(Date fechaVenta,String nroTicketFactura,BigDecimal total,
				BigDecimal efectivo,BigDecimal cambio,
				BigDecimal porcentajeDescuento, BigDecimal descuento,
				BigDecimal interesDebito,BigDecimal interesCredito,
			    List<DetalleVenta> items,Usuario usuario,String observaciones,Date fechaAlta,
				FormaDePago formaDePago, String numeroTarjetaCredito){
		this.fechaVenta = fechaVenta;
		this.nroTicketFactura = nroTicketFactura;
		this.total = total;
		this.efectivo = efectivo;
		this.cambio = cambio;
		this.porcentajeDescuento = porcentajeDescuento;
		this.descuento = descuento;
		this.interesDebito = interesDebito;
		this.interesCredito = interesCredito;
		this.items = items;
		this.usuario = usuario;
		this.observaciones = observaciones;
		this.fechaAlta = fechaAlta;
		this.formaDePago = formaDePago;
		this.numeroTarjetaCredito = numeroTarjetaCredito;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getNroTicketFactura() {
		return nroTicketFactura;
	}

	public void setNroTicketFactura(String nroTicketFactura) {
		this.nroTicketFactura = nroTicketFactura;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<DetalleVenta> getItems() {
		return items;
	}

	public void setItems(List<DetalleVenta> items) {
		this.items = items;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public BigDecimal getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(BigDecimal efectivo) {
		this.efectivo = efectivo;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal cambio) {
		this.cambio = cambio;
	}
		

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	public String getNumeroTarjetaCredito() {
		return numeroTarjetaCredito;
	}

	public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
		this.numeroTarjetaCredito = numeroTarjetaCredito;
	}
	
	

	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getInteresDebito() {
		return interesDebito;
	}

	public void setInteresDebito(BigDecimal interesDebito) {
		this.interesDebito = interesDebito;
	}

	public BigDecimal getInteresCredito() {
		return interesCredito;
	}

	public void setInteresCredito(BigDecimal interesCredito) {
		this.interesCredito = interesCredito;
	}
	
	
	
}
