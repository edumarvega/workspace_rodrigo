package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class Provincia implements Serializable{


	private static final long serialVersionUID = 74601710970627193L;
	
	private Long id;
	private String nombre;
	
	public Provincia(){
		
	}
	
	public Provincia(String nombre){
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
