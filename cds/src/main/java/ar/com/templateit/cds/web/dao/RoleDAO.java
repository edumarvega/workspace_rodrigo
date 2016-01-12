package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.Role;

public interface RoleDAO {
	
	Role getRoleById(Long id);
	
	List<Role> loadAllRole();
	
	Role getRoleByCriteriaNombre(String nombre);
	

}
