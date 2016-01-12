package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.UsuarioBO;
import ar.com.templateit.cds.web.dao.UsuarioDAO;
import ar.com.templateit.cds.web.entity.Usuario;

public class UsuarioBOImpl  implements UsuarioBO {
	
	private UsuarioDAO usuarioDAO;
	
	@Override
	public void save(Usuario usuario) {
		this.usuarioDAO.save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		this.usuarioDAO.update(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		this.usuarioDAO.delete(usuario);
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		Usuario usuario = this.usuarioDAO.getUsuarioById(id);
		return usuario;
	}

	@Override
	public List<Usuario> loadAllUsuario() {
		List<Usuario> usuarios = this.usuarioDAO.loadAllUsuario();
		return usuarios;
	}

	@Override
	public List<Usuario> findByCriteria(String usuario, String apellido,
			String nombre) {
		List<Usuario> usuarios = this.usuarioDAO.findByCriteria(usuario, apellido, nombre);
		return usuarios;
	}

	public boolean validarUsuario(String usuario, String password) {

		boolean usuarioValido = this.usuarioDAO.validarUsuario(usuario, password);

		return usuarioValido;
	}
	
	@Override
	public Usuario loadUsuario(String usuario){
		Usuario user = this.usuarioDAO.loadUsuario(usuario);
		return user;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	

}
