package ar.com.templateit.cds.web.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.UsuarioEcommerceDAO;
import ar.com.templateit.cds.web.entity.UsuarioEcommerce;

public class UsuarioEcommerceDAOImpl extends HibernateDaoSupport implements UsuarioEcommerceDAO{

	@Override
	public void save(UsuarioEcommerce usuario) {
		this.getHibernateTemplate().save(usuario);
		
	}

	@Override
	public void update(UsuarioEcommerce usuario) {
		this.getHibernateTemplate().update(usuario);
		
	}

	@Override
	public void delete(UsuarioEcommerce usuario) {
		this.getHibernateTemplate().delete(usuario);
		
	}

	@Override
	public UsuarioEcommerce getUsuarioEcommerceById(Long id) {
		UsuarioEcommerce usuario = (UsuarioEcommerce) this.getHibernateTemplate().get(UsuarioEcommerce.class, id);
		return usuario;
	}

	@Override
	public UsuarioEcommerce loadUsuarioEcommerce(String usuario,String password) {
		Criteria criteria = this.getSession().createCriteria(UsuarioEcommerce.class);
		
		if(usuario!=null && usuario.length()>0){
			criteria.add(Restrictions.eq("usuario", usuario));
		}
		
		if(password!=null && password.length()>0){
			criteria.add(Restrictions.eq("password", password));
		}
		
		UsuarioEcommerce user =(UsuarioEcommerce)criteria.uniqueResult();
		
		return user;
	}
	

}
