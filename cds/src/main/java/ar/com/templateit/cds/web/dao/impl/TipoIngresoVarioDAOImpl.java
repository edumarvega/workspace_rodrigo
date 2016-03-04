package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.TipoIngresoVarioDAO;
import ar.com.templateit.cds.web.entity.TipoIngresoVario;

public class TipoIngresoVarioDAOImpl extends HibernateDaoSupport implements TipoIngresoVarioDAO{

	@Override
	public TipoIngresoVario getTipoIngresoVario(Long id) {
		TipoIngresoVario tipoIngresoVario = (TipoIngresoVario)this.getHibernateTemplate().get(TipoIngresoVario.class, id);
		return tipoIngresoVario;
	}

	@Override
	public List<TipoIngresoVario> loadAllTipoIngresoVario() {
		List<TipoIngresoVario> tiposIngresoVario = (List<TipoIngresoVario>)this.getHibernateTemplate().loadAll(TipoIngresoVario.class);
		return tiposIngresoVario;
	}

}
