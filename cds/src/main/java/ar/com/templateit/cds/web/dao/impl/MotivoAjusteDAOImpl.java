package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.MotivoAjusteDAO;
import ar.com.templateit.cds.web.entity.MotivoAjuste;

public class MotivoAjusteDAOImpl extends HibernateDaoSupport implements MotivoAjusteDAO{

	@Override
	public MotivoAjuste getMotivoAjuste(Long id) {
		return (MotivoAjuste) this.getHibernateTemplate().get(MotivoAjuste.class, id);
	}

	@Override
	public List<MotivoAjuste> loadAllMotivoAjuste() {
		
		return (List<MotivoAjuste>) this.getHibernateTemplate().loadAll(MotivoAjuste.class);
	}

}
