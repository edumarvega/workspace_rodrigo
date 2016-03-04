package ar.com.templateit.cds.web.bo.impl;

import ar.com.templateit.cds.web.bo.UsuarioEcommerceBO;
import ar.com.templateit.cds.web.dao.UsuarioEcommerceDAO;
import ar.com.templateit.cds.web.entity.UsuarioEcommerce;

public class UsuarioEcommerceBOImpl implements UsuarioEcommerceBO{
	
	private UsuarioEcommerceDAO usuarioEcommerceDAO;

	@Override
	public void save(UsuarioEcommerce usuario) {
		this.usuarioEcommerceDAO.save(usuario);
		
	}

	@Override
	public void update(UsuarioEcommerce usuario) {
		this.usuarioEcommerceDAO.update(usuario);
		
	}

	@Override
	public void delete(UsuarioEcommerce usuario) {
		this.usuarioEcommerceDAO.delete(usuario);
		
	}

		@Override
	public UsuarioEcommerce getUsuarioEcommerceById(Long id) {
		
		return this.usuarioEcommerceDAO.getUsuarioEcommerceById(id);
	}

	@Override
	public UsuarioEcommerce loadUsuarioEcommerce(String usuario, String password) {
		
		return this.usuarioEcommerceDAO.loadUsuarioEcommerce(usuario, password);
	}

	public void setUsuarioEcommerceDAO(UsuarioEcommerceDAO usuarioEcommerceDAO) {
		this.usuarioEcommerceDAO = usuarioEcommerceDAO;
	}

	
	
}
