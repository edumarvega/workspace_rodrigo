package ar.com.templateit.cds.web.bo;

import ar.com.templateit.cds.web.entity.UsuarioEcommerce;

public interface UsuarioEcommerceBO {

	void save(UsuarioEcommerce usuario);
	
	void update(UsuarioEcommerce usuario);
	
	void delete(UsuarioEcommerce usuario);
	
	UsuarioEcommerce getUsuarioEcommerceById(Long id);
		
	UsuarioEcommerce loadUsuarioEcommerce(String usuario,String password);
}
