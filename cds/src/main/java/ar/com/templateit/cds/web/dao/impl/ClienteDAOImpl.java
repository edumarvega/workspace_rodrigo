package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.ClienteDAO;
import ar.com.templateit.cds.web.entity.Cliente;

public class ClienteDAOImpl extends HibernateDaoSupport implements ClienteDAO{

	@Override
	public void save(Cliente cliente) {
		this.getHibernateTemplate().save(cliente);
		
	}

	@Override
	public void update(Cliente cliente) {
		this.getHibernateTemplate().update(cliente);
		
	}

	@Override
	public void delete(Cliente cliente) {
		this.getHibernateTemplate().delete(cliente);
		
	}

	@Override
	public Cliente getClienteById(Long id) {
		Cliente cliente = (Cliente) this.getHibernateTemplate().get(Cliente.class, id);
		return cliente;
	}

	@Override
	public List<Cliente> loadAllCliente() {
		List<Cliente> clientes = (List<Cliente>)this.getHibernateTemplate().loadAll(Cliente.class);
		return clientes;
	}

	@Override
	public List<Cliente> findByCriteria(String apellido, String nombres) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		
		if(apellido!=null && apellido.length()!=0){
			criteria.add(Restrictions.ilike("apellido", apellido, MatchMode.ANYWHERE));
		}
		else if(nombres!=null && nombres.length()!=0){
			criteria.add(Restrictions.ilike("nombres", nombres, MatchMode.ANYWHERE));
		}
		
		List<Cliente> clientes = (List<Cliente>)this.getHibernateTemplate().findByCriteria(criteria);
		return clientes;
	}

}
