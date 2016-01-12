package ar.com.templateit.cds.web.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import ar.com.templateit.cds.web.bo.RoleBO;
import ar.com.templateit.cds.web.bo.UsuarioBO;
import ar.com.templateit.cds.web.entity.Role;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.UsuarioRole;
import ar.com.templateit.cds.web.util.TemplateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ABMUsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 6071027036320220776L;
	private String filterUsuario;
	private String filterApellido;
	private String filterNombre;
	private String id;
	private String username;
	private String apellido;
	private String nombres;
	private String password;
	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	private String permiso;
	private List<Role> permisos;
	private String defaultPermiso;
	private UsuarioBO usuarioBO;
	private RoleBO roleBO;
	

	public String abmUsuario() {
		this.listaUsuarios = this.usuarioBO.loadAllUsuario();
		return "abmUsuario";
	}
	
	public String loadNewUsuario() {
		this.permisos = this.roleBO.loadAllRole();
		this.setDefaultPermiso("-1");
		this.usuario = new Usuario();
		this.usuario.setUsuario("");
		this.usuario.setPassword("");
		this.usuario.setHabilitado(true);
		return "loadNewUsuario";
	}
	
	public String loadEditUsuario() {
		this.permisos = this.roleBO.loadAllRole();
		
		String id = ServletActionContext.getRequest().getParameter("id");
		this.usuario = this.usuarioBO.getUsuarioById(Long.valueOf(id));
		
		this.setId(this.usuario.getId().toString());
		this.setUsername(this.getUsuario().getUsuario());
		this.setApellido(this.getUsuario().getApellido());
		this.setNombres(this.getUsuario().getNombre());
		
		List<UsuarioRole> permisosTmp = new ArrayList<UsuarioRole>(this.usuario.getUsuarioRole());
		Role role = this.roleBO.getRoleByCriteriaNombre(permisosTmp.get(0).getRole());
		this.setDefaultPermiso(role.getId().toString());
		
		return "loadEditUsuario";
	}
	
	public String loadViewUsuario() {
		String id = ServletActionContext.getRequest().getParameter("id");
		this.usuario = this.usuarioBO.getUsuarioById(Long.valueOf(id));
		List<UsuarioRole> listaTmp = new ArrayList<UsuarioRole>(this.usuario.getUsuarioRole());
		this.permiso = listaTmp.get(0).getRole();
		return "loadViewUsuario";
	}

	public String search() {
		String usuario =null;
		String apellido =null;
		String nombre = null;
		
		if(this.filterUsuario!=null && this.filterUsuario.length()!=0){
			usuario = this.filterUsuario.trim();
		}
		
		if(this.filterApellido!=null && this.filterApellido.length()!=0){
			apellido = this.filterApellido.trim();
		}
		
		if(this.filterNombre!=null && this.filterNombre.length()!=0){
			nombre = this.filterNombre.trim();
		}
		
		this.listaUsuarios = this.usuarioBO.findByCriteria(usuario, apellido, nombre);
		
		return "searchUsuario";
	}

	public String save() {
		String userName = this.getUsuario().getUsuario();
		//Se encripta el password
		TemplateUtil tu = new TemplateUtil();
		String hashedPassword = tu.encriptarPassword(this.getUsuario().getPassword());
		
		this.getUsuario().setUsuario(userName.trim());
		this.getUsuario().setPassword(hashedPassword);
		this.getUsuario().setHabilitado(true);
		
		Role role = this.roleBO.getRoleById(Long.valueOf(this.getPermiso()));
		
		UsuarioRole usuarioRole = new UsuarioRole();
		usuarioRole.setUsuario(this.getUsuario());
		usuarioRole.setRole(role.getNombre());
		
		Set<UsuarioRole> usuarioRoles = new HashSet<UsuarioRole>();
		usuarioRoles.add(usuarioRole);
		
		this.getUsuario().setUsuarioRole(usuarioRoles);
		
		this.usuarioBO.save(this.getUsuario());
		
		return this.render();
	}
	
	public String update() {
		
		//Se encripta el password
		TemplateUtil tu = new TemplateUtil();
		String hashedPassword = tu.encriptarPassword(this.getPassword());
		
		this.usuario = this.usuarioBO.getUsuarioById(Long.valueOf(this.getId()));
		this.getUsuario().setUsuario(this.getUsername().trim());
		this.getUsuario().setApellido(this.getApellido().trim());
		this.getUsuario().setNombre(this.getNombres());
		this.getUsuario().setPassword(hashedPassword);
				
		Role role = this.roleBO.getRoleById(Long.valueOf(this.getPermiso()));
				
		List<UsuarioRole> listaTmp = new ArrayList<UsuarioRole>(this.usuario.getUsuarioRole());
		UsuarioRole usuarioRole = listaTmp.get(0);
		usuarioRole.setRole(role.getNombre());
		
		listaTmp.set(0, usuarioRole);
		
		Set<UsuarioRole> usuarioRoles = new HashSet<UsuarioRole>(listaTmp);
		this.getUsuario().setUsuarioRole(usuarioRoles);
				
		this.usuarioBO.update(this.getUsuario());
		return this.render();
	}

	public String delete() {
		String[] ids = ServletActionContext.getRequest().getParameter("ids").split(",");
		Usuario usuario=null;
		for (int i = 0; i < ids.length; i++) {
			usuario = this.usuarioBO.getUsuarioById(Long.valueOf(ids[i]));
			this.usuarioBO.delete(usuario);
		}
		return this.render();
	}
	
	public String render() {
		this.listaUsuarios = this.usuarioBO.loadAllUsuario();
		return "render";
	}

	public String getFilterUsuario() {
		return filterUsuario;
	}

	public void setFilterUsuario(String filterUsuario) {
		this.filterUsuario = filterUsuario;
	}

	public String getFilterApellido() {
		return filterApellido;
	}

	public void setFilterApellido(String filterApellido) {
		this.filterApellido = filterApellido;
	}

	public String getFilterNombre() {
		return filterNombre;
	}

	public void setFilterNombre(String filterNombre) {
		this.filterNombre = filterNombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

	public void setRoleBO(RoleBO roleBO) {
		this.roleBO = roleBO;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public List<Role> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Role> permisos) {
		this.permisos = permisos;
	}

	public String getDefaultPermiso() {
		return defaultPermiso;
	}

	public void setDefaultPermiso(String defaultPermiso) {
		this.defaultPermiso = defaultPermiso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
		
}
