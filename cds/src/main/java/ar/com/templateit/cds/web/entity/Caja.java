package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Caja implements Serializable{

	private static final long serialVersionUID = -1799902745334625508L;
	private Long id;
	private BigDecimal cajaInicial;
	private Date fecha;
	private Date fechaHora;
	private BigDecimal ventaEfectivo;
	private BigDecimal ingresosVariosEfectivo;
	private BigDecimal cuentaCorrienteCliente;
	private BigDecimal cuentaCorrienteProveedor;
	private BigDecimal compras;
	private BigDecimal gastosVariosEfectivo;
	private BigDecimal ventaTarjetaDeCredito;
	private BigDecimal ventaTarjetaDeDebito;
	private BigDecimal totalEfectivo;
	private EstadoCaja estadoCaja;
	private Usuario usuario;
	private BigDecimal cambio;
		
	
	public Caja(){
		
	}
	
	public Caja(BigDecimal cajaInicial,Date fecha,Date fechaHora,BigDecimal ventaEfectivo,BigDecimal ingresosVariosEfectivo,
			BigDecimal cuentaCorrienteCliente,BigDecimal cuentaCorrienteProveedor,BigDecimal compras,BigDecimal gastosVariosEfectivo, BigDecimal ventaTarjetaDeCredito,BigDecimal ventaTarjetaDeDebito,
			BigDecimal totalEfectivo,EstadoCaja estadoCaja,Usuario usuario, BigDecimal cambio){
		this.cajaInicial = cajaInicial;
		this.fecha = fecha;
		this.fechaHora = fechaHora;
		this.ventaEfectivo = ventaEfectivo;
		this.ingresosVariosEfectivo = ingresosVariosEfectivo;
		this.cuentaCorrienteCliente = cuentaCorrienteCliente;
		this.cuentaCorrienteProveedor = cuentaCorrienteProveedor;
		this.compras = compras;
		this.gastosVariosEfectivo = gastosVariosEfectivo;
		this.ventaTarjetaDeCredito = ventaTarjetaDeCredito;
		this.ventaTarjetaDeDebito = ventaTarjetaDeDebito;
		this.totalEfectivo = totalEfectivo;
		this.estadoCaja = estadoCaja;
		this.usuario = usuario;
		this.cambio = cambio;
				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCajaInicial() {
		return cajaInicial;
	}

	public void setCajaInicial(BigDecimal cajaInicial) {
		this.cajaInicial = cajaInicial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public BigDecimal getVentaEfectivo() {
		return ventaEfectivo;
	}

	public void setVentaEfectivo(BigDecimal ventaEfectivo) {
		this.ventaEfectivo = ventaEfectivo;
	}

	public BigDecimal getIngresosVariosEfectivo() {
		return ingresosVariosEfectivo;
	}

	public void setIngresosVariosEfectivo(BigDecimal ingresosVariosEfectivo) {
		this.ingresosVariosEfectivo = ingresosVariosEfectivo;
	}

	
	public BigDecimal getCompras() {
		return compras;
	}

	public void setCompras(BigDecimal compras) {
		this.compras = compras;
	}

	public BigDecimal getGastosVariosEfectivo() {
		return gastosVariosEfectivo;
	}

	public void setGastosVariosEfectivo(BigDecimal gastosVariosEfectivo) {
		this.gastosVariosEfectivo = gastosVariosEfectivo;
	}
	
	
	public BigDecimal getVentaTarjetaDeCredito() {
		return ventaTarjetaDeCredito;
	}

	public void setVentaTarjetaDeCredito(BigDecimal ventaTarjetaDeCredito) {
		this.ventaTarjetaDeCredito = ventaTarjetaDeCredito;
	}

	public BigDecimal getVentaTarjetaDeDebito() {
		return ventaTarjetaDeDebito;
	}

	public void setVentaTarjetaDeDebito(BigDecimal ventaTarjetaDeDebito) {
		this.ventaTarjetaDeDebito = ventaTarjetaDeDebito;
	}

	public BigDecimal getTotalEfectivo() {
		return totalEfectivo;
	}

	public void setTotalEfectivo(BigDecimal totalEfectivo) {
		this.totalEfectivo = totalEfectivo;
	}

	
	public EstadoCaja getEstadoCaja() {
		return estadoCaja;
	}

	public void setEstadoCaja(EstadoCaja estadoCaja) {
		this.estadoCaja = estadoCaja;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getCuentaCorrienteCliente() {
		return cuentaCorrienteCliente;
	}

	public void setCuentaCorrienteCliente(BigDecimal cuentaCorrienteCliente) {
		this.cuentaCorrienteCliente = cuentaCorrienteCliente;
	}

	public BigDecimal getCuentaCorrienteProveedor() {
		return cuentaCorrienteProveedor;
	}

	public void setCuentaCorrienteProveedor(BigDecimal cuentaCorrienteProveedor) {
		this.cuentaCorrienteProveedor = cuentaCorrienteProveedor;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal cambio) {
		this.cambio = cambio;
	}
	
	
	
		

}
