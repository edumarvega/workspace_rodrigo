package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class TarjetaDeCredito implements Serializable{
	

	private static final long serialVersionUID = -2518072226236440682L;
	private Long id;
	private String nombre;
	
	public TarjetaDeCredito(){
		
	}
	
	public TarjetaDeCredito(String nombre){
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
