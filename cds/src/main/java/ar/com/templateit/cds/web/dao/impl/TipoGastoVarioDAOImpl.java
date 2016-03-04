package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.TipoGastoVarioDAO;
import ar.com.templateit.cds.web.entity.TipoGastoVario;

public class TipoGastoVarioDAOImpl extends HibernateDaoSupport implements TipoGastoVarioDAO{

	@Override
	public TipoGastoVario getTipoGastoVario(Long id) {
		TipoGastoVario tipoGastoVario = (TipoGastoVario)this.getHibernateTemplate().get(TipoGastoVario.class, id);
		return tipoGastoVario;
	}

	@Override
	public List<TipoGastoVario> loadAllTipoGastoVario() {
		List<TipoGastoVario> tiposGastoVario = (List<TipoGastoVario>)this.getHibernateTemplate().loadAll(TipoGastoVario.class);
		return tiposGastoVario;
	}

}
