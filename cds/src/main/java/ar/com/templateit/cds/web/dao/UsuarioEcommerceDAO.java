package ar.com.templateit.cds.web.dao;

import ar.com.templateit.cds.web.entity.UsuarioEcommerce;

public interface UsuarioEcommerceDAO {
	
	void save(UsuarioEcommerce usuario);
	
	void update(UsuarioEcommerce usuario);
	
	void delete(UsuarioEcommerce usuario);
	
	UsuarioEcommerce getUsuarioEcommerceById(Long id);
		
	UsuarioEcommerce loadUsuarioEcommerce(String usuario,String password);

}
