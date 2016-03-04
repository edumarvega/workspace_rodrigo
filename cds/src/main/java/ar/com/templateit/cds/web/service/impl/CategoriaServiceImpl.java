package ar.com.templateit.cds.web.service.impl;

import java.util.List;

import javax.jws.WebService;

import ar.com.templateit.cds.web.bo.CategoriaBO;
import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.service.CategoriaService;

@WebService(endpointInterface = "ar.com.templateit.cds.web.service.CategoriaService")
public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaBO categoriaBO;

	@Override
	public Categoria getCategoria(Long id) {
		
		return this.categoriaBO.getCategoria(id);
	}

	@Override
	public List<Categoria> loadAllCategoria() {
		
		return this.categoriaBO.loadAllCategoria();
	}

	@Override
	public List<Categoria> findByCriteria(String nombre) {
		
		return this.categoriaBO.findByCriteria(nombre);
	}

	public void setCategoriaBO(CategoriaBO categoriaBO) {
		this.categoriaBO = categoriaBO;
	}

	
}
