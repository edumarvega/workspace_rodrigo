package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.TarjetaDeCreditoDAO;
import ar.com.templateit.cds.web.entity.TarjetaDeCredito;

public class TarjetaDeCreditoDAOImpl extends HibernateDaoSupport implements TarjetaDeCreditoDAO{

	@Override
	public TarjetaDeCredito getTarjetaDeCredito(Long id) {
		TarjetaDeCredito tarjetaDeCredito = (TarjetaDeCredito)this.getHibernateTemplate().get(TarjetaDeCredito.class, id);
		return tarjetaDeCredito;
	}

	@Override
	public List<TarjetaDeCredito> loadAllTarjetaDeCredito() {
		List<TarjetaDeCredito> tarjetasDeCredito = (List<TarjetaDeCredito>)this.getHibernateTemplate().loadAll(TarjetaDeCredito.class);
		return tarjetasDeCredito;
	}

}
