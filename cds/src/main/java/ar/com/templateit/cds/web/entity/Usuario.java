package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Silvina Yarbi
 *
 */
public class Usuario implements Serializable{

	private static final long serialVersionUID = -1264660298154372460L;
	private Long id;
	private String usuario;
	private String password;
	private String apellido;
	private String nombre;
	private boolean habilitado;
	private Set<UsuarioRole> usuarioRole = new HashSet<UsuarioRole>(0);
	
	
	public Usuario(){
		
	}
	
	public Usuario(Long id, String usuario,String password,String apellido,String nombre, boolean habilitado){
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.apellido = apellido;
		this.nombre = nombre;
		this.habilitado = habilitado;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Set<UsuarioRole> getUsuarioRole() {
		return usuarioRole;
	}

	public void setUsuarioRole(Set<UsuarioRole> usuarioRole) {
		this.usuarioRole = usuarioRole;
	}
		
	
}
