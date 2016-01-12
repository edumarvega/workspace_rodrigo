package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.Role;

public interface RoleBO {
	
	Role getRoleById(Long id);
	
	List<Role> loadAllRole();
	
	Role getRoleByCriteriaNombre(String nombre);

}
