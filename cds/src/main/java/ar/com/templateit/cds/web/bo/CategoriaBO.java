package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.Categoria;

public interface CategoriaBO {

	void save(Categoria categoria);
	
	void update(Categoria categoria);
	
	void delete(Categoria categoria);
	
	Categoria getCategoria(Long id);
	
	List<Categoria> loadAllCategoria();
	
	List<Categoria> getCategoriByName(List<String> nombres);
	
	List<Categoria> findByCriteria(String nombre);
}
