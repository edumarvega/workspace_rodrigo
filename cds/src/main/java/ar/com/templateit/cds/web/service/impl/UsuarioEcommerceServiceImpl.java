package ar.com.templateit.cds.web.service.impl;

import javax.jws.WebService;

import ar.com.templateit.cds.web.bo.UsuarioEcommerceBO;
import ar.com.templateit.cds.web.entity.UsuarioEcommerce;
import ar.com.templateit.cds.web.service.UsuarioEcommerceService;

@WebService(endpointInterface = "ar.com.templateit.cds.web.service.UsuarioEcommerceService")
public class UsuarioEcommerceServiceImpl implements UsuarioEcommerceService {
	
	private UsuarioEcommerceBO usuarioEcommerceBO;

	@Override
	public void save(UsuarioEcommerce usuario) {
		this.usuarioEcommerceBO.save(usuario);
		
	}

	@Override
	public void update(UsuarioEcommerce usuario) {
		this.usuarioEcommerceBO.update(usuario);
		
	}

	@Override
	public void delete(UsuarioEcommerce usuario) {
		this.usuarioEcommerceBO.delete(usuario);
		
	}

	@Override
	public UsuarioEcommerce getUsuarioEcommerceById(Long id) {
		
		return this.usuarioEcommerceBO.getUsuarioEcommerceById(id);
	}

	@Override
	public UsuarioEcommerce loadUsuarioEcommerce(String usuario, String password) {
		
		return this.usuarioEcommerceBO.loadUsuarioEcommerce(usuario, password);
	}

	public void setUsuarioEcommerceBO(UsuarioEcommerceBO usuarioEcommerceBO) {
		this.usuarioEcommerceBO = usuarioEcommerceBO;
	}
	
	

}
