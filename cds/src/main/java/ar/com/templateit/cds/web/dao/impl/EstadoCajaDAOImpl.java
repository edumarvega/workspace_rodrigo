package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.EstadoCajaDAO;
import ar.com.templateit.cds.web.entity.EstadoCaja;

public class EstadoCajaDAOImpl extends HibernateDaoSupport implements EstadoCajaDAO{

	@Override
	public EstadoCaja getEstadoCaja(Long id) {
		EstadoCaja estadoCaja = (EstadoCaja)this.getHibernateTemplate().get(EstadoCaja.class, id);
		return estadoCaja;
	}

	@Override
	public List<EstadoCaja> loadAllEstadoCaja() {
		List<EstadoCaja> estadosCaja = (List<EstadoCaja>)this.getHibernateTemplate().loadAll(EstadoCaja.class);
		return estadosCaja;
	}

}
