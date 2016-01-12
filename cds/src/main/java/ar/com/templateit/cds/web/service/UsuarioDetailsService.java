package ar.com.templateit.cds.web.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ar.com.templateit.cds.web.dao.UsuarioDAO;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.UsuarioRole;

public class UsuarioDetailsService implements UserDetailsService{

	private UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(final String usuarioNombre)
			throws UsernameNotFoundException {
				
		Usuario usuario = this.usuarioDAO.loadUsuario(usuarioNombre.trim());
				
		List<GrantedAuthority> authorities = buildUserAuthority(usuario.getUsuarioRole());
 
		return buildUserForAuthentication(usuario, authorities);
	}
	
	
	// Converts ar.com.templateit.cds.web.entity.Usuario usuario to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Usuario usuario, 
		List<GrantedAuthority> authorities) {
		return new User(usuario.getUsuario(), 
			usuario.getPassword(), usuario.isHabilitado(), 
                        true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(Set<UsuarioRole> usuarioRole) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (UsuarioRole ur : usuarioRole) {
			setAuths.add(new SimpleGrantedAuthority(ur.getRole()));
		}
 
		List<GrantedAuthority> lista = new ArrayList<GrantedAuthority>(setAuths);
 
		return lista;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	

}
