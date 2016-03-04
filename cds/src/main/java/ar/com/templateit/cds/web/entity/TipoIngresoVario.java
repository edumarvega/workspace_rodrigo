package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class TipoIngresoVario implements Serializable{


	private static final long serialVersionUID = 6906999342835030298L;
	private Long id;
	private String nombre;
	
	public TipoIngresoVario(){
		
	}
	
	public TipoIngresoVario(String nombre){
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
