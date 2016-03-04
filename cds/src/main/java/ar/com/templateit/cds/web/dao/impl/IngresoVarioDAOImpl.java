package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.IngresoVarioDAO;
import ar.com.templateit.cds.web.entity.IngresoVario;
import ar.com.templateit.cds.web.entity.TipoIngresoVario;
import ar.com.templateit.cds.web.entity.Usuario;

public class IngresoVarioDAOImpl extends HibernateDaoSupport implements IngresoVarioDAO{

	@Override
	public void save(IngresoVario ingresoVario) {
		this.getHibernateTemplate().save(ingresoVario);
		
	}

	@Override
	public void update(IngresoVario ingresoVario) {
		this.getHibernateTemplate().update(ingresoVario);
		
	}

	@Override
	public void delete(IngresoVario ingresoVario) {
		this.getHibernateTemplate().delete(ingresoVario);
		
	}

	@Override
	public IngresoVario getIngresoVario(Long id) {
		IngresoVario ingresoVario = (IngresoVario)this.getHibernateTemplate().get(IngresoVario.class, id);
		return ingresoVario;
	}

	@Override
	public List<IngresoVario> loadAllIngresoVario() {
		List<IngresoVario> ingresosVarios = (List<IngresoVario>)this.getHibernateTemplate().loadAll(IngresoVario.class);
		return ingresosVarios;
	}

	@Override
	public List<IngresoVario> findByCriteria(Date fechaDesde, Date fechaHasta,
			String nombre, String observaciones,Usuario usuario,TipoIngresoVario tipoIngresoVario) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(IngresoVario.class);
		
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fecha",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fecha",fechaHasta));
		}
		
		if(nombre!=null){
			if(!nombre.isEmpty()){
				criteria.add(Restrictions.ilike("nombre", nombre.trim(), MatchMode.ANYWHERE));
			}	
		}
		
		if(observaciones!=null){
			if(!observaciones.isEmpty()){
				criteria.add(Restrictions.ilike("observaciones", observaciones.trim(), MatchMode.ANYWHERE));
			}	
		}
		
		if(usuario!=null){  
			criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario", usuario));
		
		}
		
		if(tipoIngresoVario!=null){  
			criteria.createAlias("tipoIngresoVario", "tipoIngresoVario").add(Restrictions.eq("tipoIngresoVario", tipoIngresoVario));
		
		}
		List<IngresoVario> ingresosVarios = (List<IngresoVario>)this.getHibernateTemplate().findByCriteria(criteria);
		
		return ingresosVarios;
	}

}
