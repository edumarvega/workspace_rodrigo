package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CuentaCorriente implements Serializable{

	private static final long serialVersionUID = -2047954604144370926L;
	private Long id;
	private TipoCuentaCorriente tipoCuentaCorriente;
	private Cliente cliente;
	private Proveedor proveedor;
	private Date fecha;
	private Date fechaCreacion;
	private Date fechaPago;
	private Date fechaCobro;
	private BigDecimal saldoDeudor;
	private BigDecimal saldoAcreedor;
	private BigDecimal totalCompra;
	private BigDecimal totalVenta;
	private List<MovimientoCuentaCorriente> movimientosCuentaCorriente;
	private EstadoCuentaCorriente estadoCuentaCorriente;
	private Usuario usuario;
	private Venta venta;
	
	public CuentaCorriente(){
		
	}
	
	public CuentaCorriente(TipoCuentaCorriente tipoCuentaCorriente,Cliente cliente, Proveedor proveedor,
			              Date fecha,Date fechaCreacion,Date fechaPago,Date fechaCobro, BigDecimal saldoDeudor,BigDecimal saldoAcreedor,
			              BigDecimal totalCompra,BigDecimal totalVenta,List<MovimientoCuentaCorriente> movimientosCuentaCorriente,
			              EstadoCuentaCorriente estadoCuentaCorriente,Usuario usuario,Venta venta){
		
		this.tipoCuentaCorriente = tipoCuentaCorriente;
		this.cliente = cliente;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.fechaCreacion = fechaCreacion;
		this.fechaPago = fechaPago;
		this.fechaCobro = fechaCobro;
		this.saldoDeudor = saldoDeudor;
		this.saldoAcreedor = saldoAcreedor;
		this.totalCompra = totalCompra;
		this.totalVenta = totalVenta;
		this.movimientosCuentaCorriente = movimientosCuentaCorriente;
		this.estadoCuentaCorriente = estadoCuentaCorriente;
		this.usuario = usuario;
		this.venta = venta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoCuentaCorriente getTipoCuentaCorriente() {
		return tipoCuentaCorriente;
	}

	public void setTipoCuentaCorriente(TipoCuentaCorriente tipoCuentaCorriente) {
		this.tipoCuentaCorriente = tipoCuentaCorriente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
		

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
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

	public List<MovimientoCuentaCorriente> getMovimientosCuentaCorriente() {
		return movimientosCuentaCorriente;
	}

	public void setMovimientosCuentaCorriente(
			List<MovimientoCuentaCorriente> movimientosCuentaCorriente) {
		this.movimientosCuentaCorriente = movimientosCuentaCorriente;
	}

	public EstadoCuentaCorriente getEstadoCuentaCorriente() {
		return estadoCuentaCorriente;
	}

	public void setEstadoCuentaCorriente(EstadoCuentaCorriente estadoCuentaCorriente) {
		this.estadoCuentaCorriente = estadoCuentaCorriente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
	
}
