package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.RoleDAO;
import ar.com.templateit.cds.web.entity.Role;

public class RoleDAOImpl extends HibernateDaoSupport implements RoleDAO {

	@Override
	public Role getRoleById(Long id) {
		Role role = (Role) this.getHibernateTemplate().get(Role.class, id);
		return role;
	}

	@Override
	public List<Role> loadAllRole() {
		List<Role> roles = (List<Role>) this.getHibernateTemplate().loadAll(Role.class);
		return roles;
	}

	@Override
	public Role getRoleByCriteriaNombre(String nombre) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
		if(!nombre.isEmpty()){
			criteria.add(Restrictions.eq("nombre",nombre));
		}
		List<Role> roles = this.getHibernateTemplate().findByCriteria(criteria);
		Role role =null;
		
		if(!roles.isEmpty()){
			role = (Role) DataAccessUtils.requiredUniqueResult(roles);	
		}
		
		return role;
	}

}
