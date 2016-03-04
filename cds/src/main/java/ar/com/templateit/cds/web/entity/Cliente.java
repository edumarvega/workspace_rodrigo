package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 7844804631131163464L;
	private Long id;
	private String apellido;
	private String nombres;
	private String direccion;
	private String telefono;
	private String celular;
	
	public Cliente(){
		
	}
	
	public Cliente(String apellido, String nombres, String direccion,String telefono,String celular){
		this.apellido = apellido;
		this.nombres = nombres;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	

}
