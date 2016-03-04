package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MovimientoCuentaCorriente implements Serializable {
	

	private static final long serialVersionUID = 1426655896788361957L;
	private Long id;
	private CuentaCorriente cuentaCorriente;
	private Date fechaCobro;
	private Date fechaPago;
	private String movimiento;
	private BigDecimal saldoDeudor;
	private BigDecimal saldoAcreedor;
	private BigDecimal totalCompra;
	private BigDecimal totalVenta;
	private BigDecimal pago;
	private BigDecimal cobro;
	private Usuario usuario;
	
	public MovimientoCuentaCorriente(){
		
	}
	
	public MovimientoCuentaCorriente(CuentaCorriente cuentaCorriente, Date fechaCobro,Date fechaPago,
			                         String movimiento,BigDecimal saldoDeudor,BigDecimal saldoAcreedor,
			                         BigDecimal totalCompra,BigDecimal totalVenta,BigDecimal pago,
			                         BigDecimal cobro,Usuario usuario){
		this.cuentaCorriente = cuentaCorriente;
		this.fechaCobro = fechaCobro;
		this.fechaPago = fechaPago;
		this.movimiento = movimiento;
		this.saldoDeudor = saldoDeudor;
		this.saldoAcreedor = saldoAcreedor;
		this.totalCompra = totalCompra;
		this.totalVenta = totalVenta;
		this.pago = pago;
		this.cobro = cobro;
		this.usuario = usuario;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public Date getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	public BigDecimal getSaldoDeudor() {
		return saldoDeudor;
	}

	public void setSaldoDeudor(BigDecimal saldoDeudor) {
		this.saldoDeudor = saldoDeudor;
	}

	public BigDecimal getSaldoAcreedor() {
		return saldoAcreedor;
	}

	public void setSaldoAcreedor(BigDecimal saldoAcreedor) {
		this.saldoAcreedor = saldoAcreedor;
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public BigDecimal getPago() {
		return pago;
	}

	public void setPago(BigDecimal pago) {
		this.pago = pago;
	}

	public BigDecimal getCobro() {
		return cobro;
	}

	public void setCobro(BigDecimal cobro) {
		this.cobro = cobro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
