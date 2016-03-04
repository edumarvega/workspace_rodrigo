package ar.com.templateit.cds.web.action;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ar.com.templateit.cds.web.bo.UsuarioBO;
import ar.com.templateit.cds.web.entity.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	private static final long serialVersionUID = 2869401357537806843L;
	private String userLoged;
	
	private UsuarioBO usuarioBO;

	public String execute() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String usuarioNombre = auth.getName();
	    
	    Usuario usuario = this.usuarioBO.loadUsuario(usuarioNombre);
	   
	    ActionContext.getContext().getSession().put("usuario", usuario);

		return "success";
	}

	public String getUserLoged() {
		return this.userLoged;
	}

	public void setUserLoged(String userLoged) {
		this.userLoged = userLoged;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

	
	
	
}
