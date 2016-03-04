package ar.com.templateit.cds.web.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ar.com.templateit.cds.web.entity.UsuarioEcommerce;

@WebService
public interface UsuarioEcommerceService {
	
	@WebResult(name="save")
	public void save(@WebParam(name="usuario") UsuarioEcommerce usuario);
	
	@WebResult(name="update")
	public void update(@WebParam(name="usuario") UsuarioEcommerce usuario);
	
	@WebResult(name="delete")
	public void delete(@WebParam(name="usuario") UsuarioEcommerce usuario);
	
	@WebResult(name="getUsuarioEcommerceById")
	public UsuarioEcommerce getUsuarioEcommerceById(@WebParam(name="id") Long id);
		
	@WebResult(name="loadUsuarioEcommerce")
	public UsuarioEcommerce loadUsuarioEcommerce(@WebParam(name="usuario") String usuario,@WebParam(name="password") String password);

}
