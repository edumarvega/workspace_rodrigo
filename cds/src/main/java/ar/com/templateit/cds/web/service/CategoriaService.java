package ar.com.templateit.cds.web.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ar.com.templateit.cds.web.entity.Categoria;

@WebService
public interface CategoriaService {
	
	@WebResult(name="getCategoria")
	public Categoria getCategoria(@WebParam(name="id") Long id);
	
	@WebResult(name="loadAllCategoria")
	public List<Categoria> loadAllCategoria();
			
	@WebResult(name="findByCriteria")
	public List<Categoria> findByCriteria(@WebParam(name="nombre") String nombre);

}
