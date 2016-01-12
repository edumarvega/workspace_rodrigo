package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.AlertaDAO;
import ar.com.templateit.cds.web.entity.Alerta;
import ar.com.templateit.cds.web.entity.Producto;

public class AlertaDAOImpl extends HibernateDaoSupport implements AlertaDAO{

	@Override
	public void save(Alerta alerta) {
		this.getHibernateTemplate().save(alerta);
		
	}

	@Override
	public void update(Alerta alerta) {
		this.getHibernateTemplate().update(alerta);
		
	}

	@Override
	public void delete(Alerta alerta) {
		this.getHibernateTemplate().delete(alerta);
		
	}

	@Override
	public List<Alerta> loadAllAlerta() {
		List<Alerta> alertas = (List<Alerta>) this.getHibernateTemplate().loadAll(Alerta.class);
		return alertas;
	}

	@Override
	public Alerta getAlerta(Long id) {
		Alerta alerta = (Alerta)this.getHibernateTemplate().get(Alerta.class, id);
		return alerta;
	}

	@Override
	public Alerta findByCode(Long codigo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Alerta.class);
		if(codigo!=null){
			criteria.add(Restrictions.eq("codigo",codigo));
		}
		List<Alerta> alertas = this.getHibernateTemplate().findByCriteria(criteria);
		Alerta alerta=null;
		
		if(!alertas.isEmpty()){
			alerta = (Alerta) DataAccessUtils.requiredUniqueResult(alertas);	
		}
		
		return alerta;
	}

}
