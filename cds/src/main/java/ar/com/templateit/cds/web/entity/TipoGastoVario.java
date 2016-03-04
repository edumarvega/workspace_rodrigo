package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class TipoGastoVario implements Serializable{
	

	private static final long serialVersionUID = 487448003759601423L;
	private Long id;
	private String nombre;
	
	public TipoGastoVario(){
		
	}
	
	public TipoGastoVario(String nombre){
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
