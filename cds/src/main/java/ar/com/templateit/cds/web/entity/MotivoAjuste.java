package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class MotivoAjuste implements Serializable{

	private static final long serialVersionUID = -9103069988554442871L;
	private Long id;
	private String nombre;
	
	public MotivoAjuste(){
	}

	public MotivoAjuste(Long id, String nombre){
		this.id = id;
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
