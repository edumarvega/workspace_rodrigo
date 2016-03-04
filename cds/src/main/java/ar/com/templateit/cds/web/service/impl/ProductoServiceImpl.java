package ar.com.templateit.cds.web.service.impl;

import java.util.List;

import javax.jws.WebService;

import ar.com.templateit.cds.web.bo.ProductoBO;
import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.Producto;
import ar.com.templateit.cds.web.service.ProductoService;

@WebService(endpointInterface = "ar.com.templateit.cds.web.service.ProductoService")
public class ProductoServiceImpl implements ProductoService{
	
	private ProductoBO productoBO;

	@Override
	public Producto getProducto(Long id) {
		
		return this.productoBO.getProducto(id);
	}

	@Override
	public List<Producto> loadAllProducto() {
		
		return this.productoBO.loadAllProducto();
	}

	@Override
	public List<Producto> findByCriteria(Long codigo, String nombre,
			String descripcion, String marca,Categoria categoria) {
		
		return this.productoBO.findByCriteria(codigo, nombre, descripcion, marca,categoria);
	}

	public void setProductoBO(ProductoBO productoBO) {
		this.productoBO = productoBO;
	}
	
	

}
