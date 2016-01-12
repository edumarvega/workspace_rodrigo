package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.ProveedorBO;
import ar.com.templateit.cds.web.dao.ProveedorDAO;
import ar.com.templateit.cds.web.entity.Proveedor;

public class ProveedorBOImpl implements ProveedorBO{

	private ProveedorDAO proveedorDAO;
	
	@Override
	public void save(Proveedor proveedor) {
		this.proveedorDAO.save(proveedor);
		
	}

	@Override
	public void update(Proveedor proveedor) {
		this.proveedorDAO.update(proveedor);
		
	}

	@Override
	public void delete(Proveedor proveedor) {
		this.proveedorDAO.delete(proveedor);
		
	}

	@Override
	public Proveedor getProveedor(Long id) {
		Proveedor proveedor =this.proveedorDAO.getProveedor(id);
		return proveedor;
	}

	@Override
	public List<Proveedor> loadAllProveedor() {
		List<Proveedor> proveedores = this.proveedorDAO.loadAllProveedor();
		return proveedores;
	}

	@Override
	public List<Proveedor> findByCriteria(Long cuit, String nombreRazonSocial) {
		List<Proveedor> proveedores = this.proveedorDAO.findByCriteria(cuit, nombreRazonSocial);
		return proveedores;
	}

	@Override
	public Proveedor findByCUIT(Integer cuit) {
		Proveedor proveedor =this.proveedorDAO.findByCUIT(cuit);
		return proveedor;
	}

	public void setProveedorDAO(ProveedorDAO proveedorDAO) {
		this.proveedorDAO = proveedorDAO;
	}
	
	

}
