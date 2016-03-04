package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.Cliente;

public interface ClienteBO {
	
	void save(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Cliente cliente);
	
	Cliente getClienteById(Long id);

	List<Cliente> loadAllCliente();
	
	List<Cliente> findByCriteria(String apellido,String nombres);

}
