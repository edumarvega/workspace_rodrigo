package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.ProductoDAO;
import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.Producto;

public class ProductoDAOImpl extends HibernateDaoSupport implements ProductoDAO {

	@Override
	public void save(Producto producto) {
		this.getHibernateTemplate().save(producto);
	}
	
	@Override
	public void update(Producto producto) {
		this.getHibernateTemplate().update(producto);
	}

	@Override
	public void delete(Producto producto) {
		this.getHibernateTemplate().delete(producto);
		
	}
	
	@Override
	public Producto getProducto(Long id) {
		Producto producto = (Producto)this.getHibernateTemplate().get(Producto.class, id);
		return producto;
	}

	@Override
	public List<Producto> loadAllProducto() {
		List<Producto> productos = (List<Producto>) this.getHibernateTemplate().loadAll(Producto.class);
		return productos;
	}

	@Override
	public List<Producto> findByCriteria(Long codigo,String nombre,String descripcion,String marca,Categoria categoria) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Producto.class); 
		if(codigo!=null){
			criteria.add(Restrictions.eq("codigo",codigo));
		}
		if(nombre!=null && nombre.length()!=0){
			criteria.add(Restrictions.ilike("nombre", nombre, MatchMode.ANYWHERE));
		}
		if(descripcion!=null && descripcion.length()!=0){
			criteria.add(Restrictions.ilike("descripcion", descripcion, MatchMode.ANYWHERE));
		}
		if(marca!=null && marca.length()!=0){
			criteria.add(Restrictions.ilike("marca", marca, MatchMode.ANYWHERE));
		}
		if(categoria!=null){  
			criteria.createAlias("categoria", "categoria").add(Restrictions.eq("categoria", categoria));
		
		}
		List<Producto> productos = (List<Producto>)this.getHibernateTemplate().findByCriteria(criteria);
		return productos;
	}

	@Override
	public Producto findByCode(Long codigo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Producto.class);
		if(codigo!=null){
			criteria.add(Restrictions.eq("codigo",codigo));
		}
		List<Producto> productos = this.getHibernateTemplate().findByCriteria(criteria);
		Producto producto=null;
		
		if(!productos.isEmpty()){
			producto = (Producto) DataAccessUtils.requiredUniqueResult(productos);	
		}
		
		return producto;
	}
	
}
