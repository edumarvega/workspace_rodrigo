package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.ProvinciaDAO;
import ar.com.templateit.cds.web.entity.Provincia;

public class ProvinciaDAOImpl extends HibernateDaoSupport implements ProvinciaDAO{

	@Override
	public Provincia getProvincia(Long id) {
		Provincia provincia = (Provincia) this.getHibernateTemplate().load(Provincia.class, id);
		return provincia;
	}

	@Override
	public List<Provincia> loadAllProvincia() {
		List<Provincia> provincias = (List<Provincia>) this.getHibernateTemplate().loadAll(Provincia.class);
		return provincias;
	}

}
