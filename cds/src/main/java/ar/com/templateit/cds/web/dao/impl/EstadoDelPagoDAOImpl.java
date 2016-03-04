package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.EstadoDelPagoDAO;
import ar.com.templateit.cds.web.entity.EstadoDelPago;

public class EstadoDelPagoDAOImpl extends HibernateDaoSupport implements EstadoDelPagoDAO{

	@Override
	public void save(EstadoDelPago estadoDelPago) {
		this.getHibernateTemplate().save(estadoDelPago);
		
	}

	@Override
	public void update(EstadoDelPago estadoDelPago) {
		this.getHibernateTemplate().update(estadoDelPago);
		
	}

	@Override
	public List<EstadoDelPago> loadAllEstadoDelPago() {
		List<EstadoDelPago> estadosDelPago = (List<EstadoDelPago>)this.getHibernateTemplate().loadAll(EstadoDelPago.class);
		return estadosDelPago;
	}

	@Override
	public EstadoDelPago getEstadoDelPago(Long id) {
		EstadoDelPago estadoDelPago = (EstadoDelPago)this.getHibernateTemplate().get(EstadoDelPago.class, id);
		return estadoDelPago;
	}

}
