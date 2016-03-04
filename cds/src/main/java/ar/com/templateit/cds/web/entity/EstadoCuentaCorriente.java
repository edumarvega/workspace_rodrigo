package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class EstadoCuentaCorriente implements Serializable{

	private static final long serialVersionUID = 3881537649943127068L;
	private Long id;
	private String nombre;
	
	public EstadoCuentaCorriente(){
		
	}
	
	public EstadoCuentaCorriente(String nombre){
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
