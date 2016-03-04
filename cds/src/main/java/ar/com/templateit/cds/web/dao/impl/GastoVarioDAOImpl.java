package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.GastoVarioDAO;
import ar.com.templateit.cds.web.entity.GastoVario;
import ar.com.templateit.cds.web.entity.TipoGastoVario;
import ar.com.templateit.cds.web.entity.Usuario;

public class GastoVarioDAOImpl extends HibernateDaoSupport implements GastoVarioDAO{

	@Override
	public void save(GastoVario gastoVario) {
		this.getHibernateTemplate().save(gastoVario);
		
	}

	@Override
	public void update(GastoVario gastoVario) {
		this.getHibernateTemplate().update(gastoVario);
		
	}

	@Override
	public void delete(GastoVario gastoVario) {
		this.getHibernateTemplate().delete(gastoVario);
		
	}

	@Override
	public GastoVario getGastoVario(Long id) {
		GastoVario gastoVario = (GastoVario) this.getHibernateTemplate().get(GastoVario.class, id);
		return gastoVario;
	}

	@Override
	public List<GastoVario> loadAllGastoVario() {
		List<GastoVario> gastosVarios = (List<GastoVario>)this.getHibernateTemplate().loadAll(GastoVario.class);
		return gastosVarios;
	}

	@Override
	public List<GastoVario> findByCriteria(Date fechaDesde, Date fechaHasta,
			String nombre, String observaciones, Usuario usuario,TipoGastoVario tipoGastoVario) {

		DetachedCriteria criteria = DetachedCriteria.forClass(GastoVario.class);
		
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
		
		if(tipoGastoVario!=null){  
			criteria.createAlias("tipoGastoVario", "tipoGastoVario").add(Restrictions.eq("tipoGastoVario", tipoGastoVario));
		
		}
		
		List<GastoVario> gastosVarios = (List<GastoVario>)this.getHibernateTemplate().findByCriteria(criteria);
		
		return gastosVarios;
	}
	
	

}
