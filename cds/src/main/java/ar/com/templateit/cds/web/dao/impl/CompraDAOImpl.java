package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.CompraDAO;
import ar.com.templateit.cds.web.entity.Compra;

public class CompraDAOImpl extends HibernateDaoSupport implements CompraDAO{

	@Override
	public void save(Compra compra) {
		this.getHibernateTemplate().save(compra);
	}
	
	@Override
	public void update(Compra compra) {
		this.getHibernateTemplate().update(compra);
	}

	@Override
	public List<Compra> loadAllCompra() {
		List<Compra> compras = (List<Compra>) this.getHibernateTemplate().loadAll(Compra.class);
		return compras;
	}

	@Override
	public List<Compra> findByCriteria(Date fechaDesde,Date fechaHasta,String nroTicketFactura,String proveedor) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Compra.class);
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fechaCompra",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fechaCompra",fechaHasta));
		}
		if(nroTicketFactura!=null){
			if(!nroTicketFactura.isEmpty()){
				criteria.add(Restrictions.ilike("nroTicketFactura", nroTicketFactura, MatchMode.ANYWHERE));
			}	
		}
		if(proveedor!=null){
			if(!proveedor.isEmpty()){
				criteria.add(Restrictions.ilike("proveedor", proveedor, MatchMode.ANYWHERE));
			}
		}
		List<Compra> compras = (List<Compra>)this.getHibernateTemplate().findByCriteria(criteria);
		return compras;
	}

	@Override
	public Compra getCompra(Long id) {
		Compra compra = (Compra)this.getHibernateTemplate().get(Compra.class, id);
		return compra;
	}
	

}
