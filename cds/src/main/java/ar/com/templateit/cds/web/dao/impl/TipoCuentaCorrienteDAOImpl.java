package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.TipoCuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;

public class TipoCuentaCorrienteDAOImpl extends HibernateDaoSupport implements TipoCuentaCorrienteDAO{

	@Override
	public TipoCuentaCorriente getTipoCuentaCorriente(Long id) {
		TipoCuentaCorriente tipoCuentaCorriente = (TipoCuentaCorriente)this.getHibernateTemplate().get(TipoCuentaCorriente.class, id);
		return tipoCuentaCorriente;
	}

	@Override
	public List<TipoCuentaCorriente> loadTipoCuentaCorriente() {
		List<TipoCuentaCorriente> tiposCuentaCorriente = (List<TipoCuentaCorriente>)this.getHibernateTemplate().loadAll(TipoCuentaCorriente.class);
		return tiposCuentaCorriente;
	}

}
