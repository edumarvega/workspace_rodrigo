package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.util.Date;

public class Alerta implements Serializable{

	private static final long serialVersionUID = 4801948594052930278L;
	private Long id;
	private Date fechaIngreso;
	private Long codigo;
	private String nombre;
	private String descripcion;
	private String marca;
	private String categoria;
	private Integer cantidadActual;
	private Usuario usuario;
	
	public Alerta(){
		
	}
	
	public Alerta(Date fechaIngreso,Long codigo,String nombre,String descripcion,
			       String marca,String categoria,Integer cantidadActual,Usuario usuario){
		this.fechaIngreso = fechaIngreso;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		this.cantidadActual = cantidadActual;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(Integer cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
