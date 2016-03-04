package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class EstadoCaja implements Serializable{


	private static final long serialVersionUID = -62928741398000204L;
	private Long id;
	private String nombre;
	
	public EstadoCaja(){
		
	}
	
	public EstadoCaja(String nombre){
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
