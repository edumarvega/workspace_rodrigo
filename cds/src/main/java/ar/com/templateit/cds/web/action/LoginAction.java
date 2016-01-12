package ar.com.templateit.cds.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import ar.com.templateit.cds.web.bo.UsuarioBO;
import ar.com.templateit.cds.web.entity.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 898216588793298426L;
	private static final String SUCCESS_HOME = "home";
	private String username;
	private String password;
	private String error;
	private String fechaHora;
	private UsuarioBO usuarioBO;

	public String execute() {
		return "success";
	}

	public String load() {
		return "loadLogint";
	}
	
	public String loadLogout() {
	    Date now = new Date();
	    SimpleDateFormat format = new SimpleDateFormat("EEEE MMMM dd HH:mm:ss yyyy");
	    this.fechaHora = "Fecha hora: "+ format.format(now);
		ActionContext.getContext().getSession().remove("usuario");
		return "loadLogout";
	}

	public String validateUser() {
			
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean flagUser = this.usuarioBO.validarUsuario(username.trim(),password.trim());
		if (flagUser) {
			Usuario usuario = this.usuarioBO.loadUsuario(this.username);
			ActionContext.getContext().getSession().put("usuario", usuario);
			return "home";
		} else {
			addActionError("usuario o password incorrecto!");
			this.setError("usuario o password incorrecto!");
			return "loadLogint";
		}

	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}
	
	
	
}
