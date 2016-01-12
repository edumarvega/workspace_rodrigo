package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

/**
 * @author Silvina Yarbi
 *
 */
public class UsuarioRole implements Serializable{

	private static final long serialVersionUID = -7322962521113266509L;
	private Long id;
	private Usuario usuario;
	private String role;
	
	
	public UsuarioRole(){
		
	}
	
	public UsuarioRole(Long id, Usuario usuario,String role){
		this.id = id;
		this.usuario = usuario;
		this.role = role;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

			
}
