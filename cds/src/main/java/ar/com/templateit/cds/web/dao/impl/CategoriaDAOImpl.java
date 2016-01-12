package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.CategoriaDAO;
import ar.com.templateit.cds.web.entity.Categoria;

public class CategoriaDAOImpl extends HibernateDaoSupport implements CategoriaDAO {
	
	@Override
	public void save(Categoria categoria) {
		this.getHibernateTemplate().save(categoria);
		
	}

	@Override
	public void update(Categoria categoria) {
		this.getHibernateTemplate().update(categoria);
		
	}

	@Override
	public void delete(Categoria categoria) {
		this.getHibernateTemplate().delete(categoria);
		
	}

	@Override
	public Categoria getCategoria(Long id) {
		Categoria categoria = (Categoria)this.getHibernateTemplate().get(Categoria.class, id);
		return categoria;
	}
	
	@Override
	public List<Categoria> loadAllCategoria() {
		List<Categoria> categorias = (List<Categoria>)this.getHibernateTemplate().loadAll(Categoria.class);
		return categorias;
	}

	@Override
	public List<Categoria> getCategoriByName(List<String> nombres) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Categoria.class);
		
		String[] categorias = new String[nombres.size()];
		categorias = nombres.toArray(categorias);
		
		criteria.add(Restrictions.in("nombre",categorias));
		
		List<Categoria> categoriasResult = (List<Categoria>)this.getHibernateTemplate().findByCriteria(criteria);
		
		return categoriasResult;
	}

	@Override
	public List<Categoria> findByCriteria(String nombre) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Categoria.class);
		
		if(nombre!=null && nombre.length()!=0){
			criteria.add(Restrictions.ilike("nombre", nombre, MatchMode.ANYWHERE));
		}
		List<Categoria> categorias = (List<Categoria>)this.getHibernateTemplate().findByCriteria(criteria);
		return categorias;
	}

	

}
