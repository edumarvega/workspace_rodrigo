package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.FormaDePagoDAO;
import ar.com.templateit.cds.web.entity.FormaDePago;

public class FormaDePagoDAOImpl extends HibernateDaoSupport implements FormaDePagoDAO {

	@Override
	public FormaDePago getFormaDePago(Long id) {
		FormaDePago formaDePago = (FormaDePago)this.getHibernateTemplate().get(FormaDePago.class, id);
		return formaDePago;
	}

	@Override
	public List<FormaDePago> loadAllFormaDePago() {
		List<FormaDePago> formasDePago = (List<FormaDePago>)this.getHibernateTemplate().loadAll(FormaDePago.class);
		return formasDePago;
	}

}
