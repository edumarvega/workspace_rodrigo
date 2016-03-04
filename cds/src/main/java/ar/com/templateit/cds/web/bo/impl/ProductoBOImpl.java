package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.ProductoBO;
import ar.com.templateit.cds.web.dao.ProductoDAO;
import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.Producto;

public class ProductoBOImpl implements ProductoBO {

	private ProductoDAO productoDAO;

	@Override
	public void save(Producto producto) {
		this.productoDAO.save(producto);
	}
	
	@Override
	public void update(Producto producto) {
		this.productoDAO.update(producto);
	}
	
	@Override
	public void delete(Producto producto) {
		this.productoDAO.delete(producto);
		
	}
	
	@Override
	public Producto getProducto(Long id) {
		Producto producto = this.productoDAO.getProducto(id);
		return producto;
	}

	@Override
	public List<Producto> loadAllProducto() {
		List<Producto> productos = this.productoDAO.loadAllProducto();
		return productos;
	}
	
	@Override
	public List<Producto> findByCriteria(Long codigo,String nombre,String descripcion,String marca,Categoria categoria) {
		List<Producto> productos = this.productoDAO.findByCriteria(codigo, nombre, descripcion,marca,categoria);
		return productos;
	}
	
	@Override
	public Producto findByCode(Long codigo) {
		Producto producto = this.productoDAO.findByCode(codigo);
		return producto;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	

	
}
