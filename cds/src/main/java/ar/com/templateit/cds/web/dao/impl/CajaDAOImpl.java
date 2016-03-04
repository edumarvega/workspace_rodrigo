package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.CajaDAO;
import ar.com.templateit.cds.web.entity.Caja;
import ar.com.templateit.cds.web.entity.EstadoCaja;
import ar.com.templateit.cds.web.entity.Usuario;

public class CajaDAOImpl extends HibernateDaoSupport implements CajaDAO{

	@Override
	public void save(Caja caja) {
		this.getHibernateTemplate().save(caja);
		
	}

	@Override
	public void update(Caja caja) {
		this.getHibernateTemplate().update(caja);
		
	}

	@Override
	public List<Caja> loadAllCaja() {
		List<Caja> cajas = (List<Caja>)this.getHibernateTemplate().loadAll(Caja.class);
		return cajas;
	}

	@Override
	public Caja getCaja(Long id) {
		Caja caja = (Caja)this.getHibernateTemplate().get(Caja.class, id);
		return caja;
	}

	@Override
	public boolean verificarCaja(Date fecha,Usuario usuario) {
		
		boolean existeCaja = false;
		
		Criteria criteria = this.getSession().createCriteria(Caja.class);
		
		criteria.add(Restrictions.eq("fecha", fecha));
		criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario", usuario));
		
		Caja caja =(Caja)criteria.uniqueResult();
		
		if(caja!=null){
			existeCaja = true; 
		}
		return existeCaja;
		
	}

	@Override
	public List<Caja> findByCriteria(Date fechaDesde, Date fechaHasta,
			EstadoCaja estadoCaja) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Caja.class);
		
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fecha",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fecha",fechaHasta));
		}
				
		if(estadoCaja!=null){  
			criteria.createAlias("estadoCaja", "estadoCaja").add(Restrictions.eq("estadoCaja", estadoCaja));
		
		}
		List<Caja> cajas = (List<Caja>)this.getHibernateTemplate().findByCriteria(criteria);
		
		return cajas;
	}

}
