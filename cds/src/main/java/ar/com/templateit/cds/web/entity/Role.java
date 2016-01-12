package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

/**
 * @author Silvina Yarbi
 *
 */
public class Role implements Serializable{

	private static final long serialVersionUID = 7395235264083364451L;
	private Long id;
	private String nombre;
	private String descripcion;
		
	public Role(){
		
	}
	
	public Role(Long id, String nombre, String descripcion){
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
