package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.AjusteDAO;
import ar.com.templateit.cds.web.entity.Ajuste;

public class AjusteDAOImpl extends HibernateDaoSupport implements AjusteDAO{

	@Override
	public void save(Ajuste ajuste) {
		this.getHibernateTemplate().save(ajuste);
		
	}

	@Override
	public List<Ajuste> loadAllAjuste() {
		
		return (List<Ajuste>) this.getHibernateTemplate().loadAll(Ajuste.class);
	}

	@Override
	public List<Ajuste> findByCriteria(Date fechaDesde,Date fechaHasta, Long codigo,
			String nombre, String descripcion) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Ajuste.class);
		
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fechaAjuste",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fechaAjuste",fechaHasta));
		}
		else if(codigo!=null){
			criteria.add(Restrictions.eq("codigo",codigo));
		}
		else if(!nombre.isEmpty()){
			criteria.add(Restrictions.ilike("nombre", nombre, MatchMode.ANYWHERE));
		}
		else if(!descripcion.isEmpty()){
			criteria.add(Restrictions.ilike("descripcion", descripcion, MatchMode.ANYWHERE));
		}
	
		List<Ajuste> ajustes = (List<Ajuste>)this.getHibernateTemplate().findByCriteria(criteria);
		return ajustes;

	}

	@Override
	public Ajuste getAjuste(Long id) {
		Ajuste ajuste = (Ajuste)this.getHibernateTemplate().get(Ajuste.class, id);
		return ajuste;
	}

}
