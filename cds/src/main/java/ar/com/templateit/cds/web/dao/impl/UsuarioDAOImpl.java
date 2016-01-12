package ar.com.templateit.cds.web.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.UsuarioDAO;
import ar.com.templateit.cds.web.entity.Usuario;

public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO{
	
	@Override
	public void save(Usuario usuario) {
		this.getHibernateTemplate().save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		this.getHibernateTemplate().update(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		this.getHibernateTemplate().delete(usuario);
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		Usuario usuario = (Usuario) this.getHibernateTemplate().get(Usuario.class, id);
		return usuario;
	}

	@Override
	public List<Usuario> loadAllUsuario() {
		List<Usuario> usuarios = (List<Usuario>)this.getHibernateTemplate().loadAll(Usuario.class); 
		return usuarios;
	}

	@Override
	public List<Usuario> findByCriteria(String usuario, String apellido,
			String nombre) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
		if(usuario!=null && usuario.length()!=0){
			criteria.add(Restrictions.eq("usuario",usuario));
		}
		else if(apellido!=null && apellido.length()!=0){
			criteria.add(Restrictions.ilike("apellido", apellido, MatchMode.ANYWHERE));
		}
		else if(nombre!=null && nombre.length()!=0){
			criteria.add(Restrictions.ilike("nombre", nombre, MatchMode.ANYWHERE));
		}
		List<Usuario> usuarios = (List<Usuario>)this.getHibernateTemplate().findByCriteria(criteria);
		return usuarios;
	}


	public boolean validarUsuario(String usuario,String password) {
		boolean usuarioValido = false;
		Criteria criteria = this.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("password", password));
		Usuario user =(Usuario)criteria.uniqueResult();
		if(user!=null){
			usuarioValido = true; 
		}
		return usuarioValido;
	}

	@Override
	public Usuario loadUsuario(String usuario) {
		Criteria criteria = this.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		Usuario user =(Usuario)criteria.uniqueResult();
		return user;
	}

}

