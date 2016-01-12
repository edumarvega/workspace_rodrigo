package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.Usuario;

public interface UsuarioDAO {
	
	void save(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Usuario usuario);
	
	Usuario getUsuarioById(Long id);

	List<Usuario> loadAllUsuario();
	
	List<Usuario> findByCriteria(String usuario,String apellido,String nombre);
		
	boolean validarUsuario(String usuario,String password);
	
	Usuario loadUsuario(String usuario);

}
