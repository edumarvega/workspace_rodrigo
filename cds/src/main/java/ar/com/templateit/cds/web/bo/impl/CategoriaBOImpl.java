package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.CategoriaBO;
import ar.com.templateit.cds.web.dao.CategoriaDAO;
import ar.com.templateit.cds.web.entity.Categoria;

public class CategoriaBOImpl implements CategoriaBO{

	private CategoriaDAO categoriaDAO;
	
	@Override
	public void save(Categoria categoria) {
		this.categoriaDAO.save(categoria);
		
	}
	
	@Override
	public void update(Categoria categoria) {
		this.categoriaDAO.update(categoria);
		
	}
	@Override
	public void delete(Categoria categoria) {
		this.categoriaDAO.delete(categoria);
		
	}
		
	@Override
	public Categoria getCategoria(Long id) {
		Categoria categoria = this.categoriaDAO.getCategoria(id);
		return categoria;
	}
	@Override
	public List<Categoria> loadAllCategoria() {
		List<Categoria> categorias = this.categoriaDAO.loadAllCategoria();
		return categorias;
	}
	
	@Override
	public List<Categoria> getCategoriByName(List<String> nombres) {
		List<Categoria> categorias = this.categoriaDAO.getCategoriByName(nombres);
		return categorias;
	}
	
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	@Override
	public List<Categoria> findByCriteria(String nombre) {
		List<Categoria> categorias = this.categoriaDAO.findByCriteria(nombre);
		return categorias;
	}
	
	

	
}
