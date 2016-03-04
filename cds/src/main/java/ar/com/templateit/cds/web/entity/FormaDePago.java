package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class FormaDePago implements Serializable{
	
	private static final long serialVersionUID = -7484141207766121784L;

	private Long id;
	private String nombre;
	
	
	public FormaDePago(){
		
	}
	
	public FormaDePago(String nombre){
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
