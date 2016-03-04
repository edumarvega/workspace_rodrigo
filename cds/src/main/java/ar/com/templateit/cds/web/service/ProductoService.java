package ar.com.templateit.cds.web.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.Producto;

@WebService
public interface ProductoService {
	
	@WebResult(name="getProducto")
	public Producto getProducto(@WebParam(name="id") Long id);

	@WebResult(name="loadAllProducto")
	public List<Producto> loadAllProducto();
	
	@WebResult(name="findByCriteria")
	public List<Producto> findByCriteria(@WebParam(name="codigo") Long codigo,@WebParam(name="nombre") String nombre,
								@WebParam(name="descripcion") String descripcion,@WebParam(name="marca") String marca,@WebParam(name="categoria") Categoria categoria);


}
