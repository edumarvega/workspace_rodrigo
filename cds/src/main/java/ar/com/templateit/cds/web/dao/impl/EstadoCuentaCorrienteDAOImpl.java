package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.EstadoCuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;

public class EstadoCuentaCorrienteDAOImpl extends HibernateDaoSupport implements EstadoCuentaCorrienteDAO{

	@Override
	public void save(EstadoCuentaCorriente estadoCuentaCorriente) {
		this.getHibernateTemplate().save(estadoCuentaCorriente);
		
	}

	@Override
	public void update(EstadoCuentaCorriente estadoCuentaCorriente) {
		this.getHibernateTemplate().update(estadoCuentaCorriente);
		
	}

	@Override
	public List<EstadoCuentaCorriente> loadAllEstadoCuentaCorriente() {
		 List<EstadoCuentaCorriente> estadosCuentaCorriente = ( List<EstadoCuentaCorriente>)this.getHibernateTemplate().loadAll(EstadoCuentaCorriente.class);
		return estadosCuentaCorriente;
	}

	@Override
	public EstadoCuentaCorriente getEstadoCuentaCorriente(Long id) {
		EstadoCuentaCorriente estadoCuentaCorriente = (EstadoCuentaCorriente) this.getHibernateTemplate().get(EstadoCuentaCorriente.class, id);
		return estadoCuentaCorriente;
	}

}
