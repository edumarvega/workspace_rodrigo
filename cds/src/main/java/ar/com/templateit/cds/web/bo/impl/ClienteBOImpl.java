package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.ClienteBO;
import ar.com.templateit.cds.web.dao.ClienteDAO;
import ar.com.templateit.cds.web.entity.Cliente;

public class ClienteBOImpl implements ClienteBO{
	
	private ClienteDAO clienteDAO;

	@Override
	public void save(Cliente cliente) {
		this.clienteDAO.save(cliente);
		
	}

	@Override
	public void update(Cliente cliente) {
		this.clienteDAO.update(cliente);
		
	}

	@Override
	public void delete(Cliente cliente) {
		this.clienteDAO.delete(cliente);
		
	}

	@Override
	public Cliente getClienteById(Long id) {
		Cliente cliente = (Cliente)this.clienteDAO.getClienteById(id);
		return cliente;
	}

	@Override
	public List<Cliente> loadAllCliente() {
		List<Cliente> clientes = (List<Cliente>) this.clienteDAO.loadAllCliente();
		return clientes;
	}

	@Override
	public List<Cliente> findByCriteria(String apellido, String nombres) {
		List<Cliente> clientes = (List<Cliente>)this.clienteDAO.findByCriteria(apellido, nombres);
		return clientes;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	

}
