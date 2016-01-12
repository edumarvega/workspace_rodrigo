package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.Proveedor;

public interface ProveedorBO {
	
void save(Proveedor proveedor);
	
	void update(Proveedor proveedor);
	
	void delete(Proveedor proveedor);
	
	Proveedor getProveedor(Long id);

	List<Proveedor> loadAllProveedor();
	
	List<Proveedor> findByCriteria(Long cuit,String nombreRazonSocial);
	
	Proveedor findByCUIT(Integer cuit);

}
