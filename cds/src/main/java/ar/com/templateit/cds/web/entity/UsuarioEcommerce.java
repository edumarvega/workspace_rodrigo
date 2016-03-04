package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class UsuarioEcommerce implements Serializable{

	private static final long serialVersionUID = 5221139273535917611L;
	private Long id;
	private String apellido;
	private String nombres;
	private Long dni;
	private String direccion;
	private String telefono;
	private String email;
	private String usuario;
	private String password;
	
	public UsuarioEcommerce(){
		
	}
	
	public UsuarioEcommerce(String apellido,String nombres,Long dni,String direccion,String telefono,String email,
						String usuario,String password){
		this.apellido=apellido;
		this.nombres=nombres;
		this.dni=dni;
		this.direccion=direccion;
		this.telefono=telefono;
		this.email=email;
		this.usuario=usuario;
		this.password=password;
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

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	


}
