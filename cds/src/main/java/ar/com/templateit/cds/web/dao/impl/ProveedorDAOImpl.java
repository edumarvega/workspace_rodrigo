package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.ProveedorDAO;
import ar.com.templateit.cds.web.entity.Proveedor;

public class ProveedorDAOImpl extends HibernateDaoSupport implements ProveedorDAO{

	@Override
	public void save(Proveedor proveedor) {
		this.getHibernateTemplate().save(proveedor);
	}

	@Override
	public void update(Proveedor proveedor) {
		this.getHibernateTemplate().update(proveedor);
	}

	@Override
	public void delete(Proveedor proveedor) {
		this.getHibernateTemplate().delete(proveedor);
	}

	@Override
	public Proveedor getProveedor(Long id) {
		Proveedor proveedor = (Proveedor) this.getHibernateTemplate().get(Proveedor.class, id);
		return proveedor;
	}

	@Override
	public List<Proveedor> loadAllProveedor() {
		List<Proveedor> proveedores = (List<Proveedor>)this.getHibernateTemplate().loadAll(Proveedor.class); 
		return proveedores;
	}

	@Override
	public List<Proveedor> findByCriteria(Long cuit, String nombreRazonSocial) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Proveedor.class);
		if(cuit!=null){
			criteria.add(Restrictions.eq("cuit",cuit));
		}
		else if(nombreRazonSocial!=null && nombreRazonSocial.length()!=0){
			criteria.add(Restrictions.ilike("nombreRazonSocial", nombreRazonSocial, MatchMode.ANYWHERE));
		}
		List<Proveedor> proveedores = (List<Proveedor>)this.getHibernateTemplate().findByCriteria(criteria);
		return proveedores;
	}

	@Override
	public Proveedor findByCUIT(Integer cuit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Proveedor.class);
		if(cuit!=null){
			criteria.add(Restrictions.eq("cuit",cuit));
		}
		List<Proveedor> proveedores = this.getHibernateTemplate().findByCriteria(criteria);
		Proveedor proveedor=null;
		
		if(!proveedores.isEmpty()){
			proveedor = (Proveedor) DataAccessUtils.requiredUniqueResult(proveedores);	
		}
		
		return proveedor;
	}


}
