package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class EstadoDelPago implements Serializable{
	

	private static final long serialVersionUID = -5482319450967111254L;
	private Long id;
	private String nombre;
	
	public EstadoDelPago(){
		
	}
	
	public EstadoDelPago(String nombre){
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
