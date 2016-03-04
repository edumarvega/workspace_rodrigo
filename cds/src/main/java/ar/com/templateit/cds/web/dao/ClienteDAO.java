package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.Cliente;

public interface ClienteDAO {

	void save(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Cliente cliente);
	
	Cliente getClienteById(Long id);

	List<Cliente> loadAllCliente();
	
	List<Cliente> findByCriteria(String apellido,String nombres);
		
}
