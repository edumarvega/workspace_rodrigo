package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.Producto;

public interface ProductoDAO {

	void save(Producto producto);
	
	void update(Producto producto);
	
	void delete(Producto producto);
	
	Producto getProducto(Long id);

	List<Producto> loadAllProducto();
	
	List<Producto> findByCriteria(Long codigo,String nombre,String descripcion,String marca,Categoria categoria);
	
	Producto findByCode(Long codigo);
		
}
