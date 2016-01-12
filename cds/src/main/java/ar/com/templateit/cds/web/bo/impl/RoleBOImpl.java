package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.RoleBO;
import ar.com.templateit.cds.web.dao.RoleDAO;
import ar.com.templateit.cds.web.entity.Role;

public class RoleBOImpl implements RoleBO{
	
	private RoleDAO roleDAO;

	@Override
	public Role getRoleById(Long id) {
		
		return this.roleDAO.getRoleById(id);
	}

	@Override
	public List<Role> loadAllRole() {
		
		return this.roleDAO.loadAllRole();
	}

	@Override
	public Role getRoleByCriteriaNombre(String nombre) {
		
		return this.roleDAO.getRoleByCriteriaNombre(nombre);
	}
	
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	

	
}
