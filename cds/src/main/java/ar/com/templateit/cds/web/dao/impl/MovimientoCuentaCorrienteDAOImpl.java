package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.MovimientoCuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.MovimientoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;

public class MovimientoCuentaCorrienteDAOImpl extends HibernateDaoSupport implements MovimientoCuentaCorrienteDAO{

	@Override
	public void save(MovimientoCuentaCorriente movimientoCuentaCorriente) {
		this.getHibernateTemplate().save(movimientoCuentaCorriente);
		
	}

	@Override
	public void update(MovimientoCuentaCorriente movimientoCuentaCorriente) {
		this.getHibernateTemplate().update(movimientoCuentaCorriente);
		
	}

	@Override
	public void delete(MovimientoCuentaCorriente movimientoCuentaCorriente) {
		this.getHibernateTemplate().update(movimientoCuentaCorriente);
		
	}

	@Override
	public MovimientoCuentaCorriente getMovimientoCuentaCorrienteById(Long id) {
		MovimientoCuentaCorriente movimientoCuentaCorriente = (MovimientoCuentaCorriente)this.getHibernateTemplate().get(MovimientoCuentaCorriente.class,id);
		
		return movimientoCuentaCorriente;
	}

	@Override
	public List<MovimientoCuentaCorriente> loadAllMovimientoCuentaCorriente() {
		List<MovimientoCuentaCorriente> lista = (List<MovimientoCuentaCorriente>)this.getHibernateTemplate().loadAll(MovimientoCuentaCorriente.class);
		return lista;
	}

	@Override
	public List<MovimientoCuentaCorriente> findByCriteria(
			CuentaCorriente cuentaCorriente, Date fechaCobro, Date fechaPago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovimientoCuentaCorriente> findMovimientoCtaCteByCriteria(
			CuentaCorriente cuentaCorriente, Date fechaCobro, Date fechaPago,
			Usuario usuario) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(MovimientoCuentaCorriente.class);
		
		
		if(cuentaCorriente!=null){
			criteria.createAlias("cuentaCorriente", "cuentaCorriente").add(Restrictions.eq("cuentaCorriente", cuentaCorriente));
		}
		if(fechaCobro!=null){
			criteria.add(Restrictions.eq("fechaCobro",fechaCobro));
		}
		if(fechaPago!=null){
			criteria.add(Restrictions.eq("fechaPago",fechaPago));
		}
						
		if(usuario!=null){
			criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario", usuario));
		}
		List<MovimientoCuentaCorriente> movimientoCtaCte = (List<MovimientoCuentaCorriente>)this.getHibernateTemplate().findByCriteria(criteria);
		return movimientoCtaCte;
	}

}
