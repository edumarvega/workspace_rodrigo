package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.Proveedor;

public interface ProveedorDAO {
	
	void save(Proveedor proveedor);
	
	void update(Proveedor proveedor);
	
	void delete(Proveedor proveedor);
	
	Proveedor getProveedor(Long id);

	List<Proveedor> loadAllProveedor();
	
	List<Proveedor> findByCriteria(Long cuit,String nombreRazonSocial);
	
	Proveedor findByCUIT(Integer cuit);

}
