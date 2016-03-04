package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class IngresoVario implements Serializable{
	
	private static final long serialVersionUID = -3900819371799835220L;
	private Long id;
	private Date fecha;
	private TipoIngresoVario tipoIngresoVario;
	private String nombre;
	private BigDecimal importe;
	private String observaciones;
	private Usuario usuario;
	
	public IngresoVario(){
		
	}
	
	public IngresoVario(Date fecha,TipoIngresoVario tipoIngresoVario,String nombre,BigDecimal importe,String observaciones,
						Usuario usuario){
		this.fecha = fecha;
		this.tipoIngresoVario = tipoIngresoVario;
		this.nombre = nombre;
		this.importe = importe;
		this.observaciones = observaciones;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public TipoIngresoVario getTipoIngresoVario() {
		return tipoIngresoVario;
	}

	public void setTipoIngresoVario(TipoIngresoVario tipoIngresoVario) {
		this.tipoIngresoVario = tipoIngresoVario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	

}
