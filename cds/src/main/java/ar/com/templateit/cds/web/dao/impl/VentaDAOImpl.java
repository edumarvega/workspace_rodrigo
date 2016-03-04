package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.VentaDAO;
import ar.com.templateit.cds.web.entity.FormaDePago;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

public class VentaDAOImpl extends HibernateDaoSupport implements VentaDAO{

	@Override
	public void save(Venta venta) {
		this.getHibernateTemplate().save(venta);
		
	}
	
	@Override
	public void delete(Venta venta) {
		this.getHibernateTemplate().delete(venta);
		
	}

	@Override
	public List<Venta> loadAllVenta() {
		List<Venta> ventas = (List<Venta>) this.getHibernateTemplate().loadAll(Venta.class);
		return ventas;
	}

	@Override
	public List<Venta> findByCriteria(Date fechaDesde,Date fechaHasta,String observaciones,String usuario,FormaDePago formaDePago){
		DetachedCriteria criteria = DetachedCriteria.forClass(Venta.class);
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fechaVenta",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fechaVenta",fechaHasta));
		}
		if(observaciones!=null){
			if(!observaciones.isEmpty()){
				criteria.add(Restrictions.ilike("observaciones", observaciones.trim(), MatchMode.ANYWHERE));
			}	
		}
		
		if(usuario!=null){  
			criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario.usuario", usuario));
		
		}
		if(formaDePago!=null){  
			criteria.createAlias("formaDePago", "formaDePago").add(Restrictions.eq("formaDePago", formaDePago));
		
		}
		List<Venta> ventas = (List<Venta>)this.getHibernateTemplate().findByCriteria(criteria);
		return ventas;
	}

	@Override
	public Venta getVenta(Long id) {
		Venta venta = (Venta)this.getHibernateTemplate().get(Venta.class, id);
		return venta;
	}
	
	@Override
	public List<Venta> findVentaByUsuario(Date fechaDesde, Date fechaHasta,	Usuario usuario) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Venta.class);
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fechaVenta",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fechaVenta",fechaHasta));
		}
				
		if(usuario!=null){
			criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario", usuario));
		}
		List<Venta> ventas = (List<Venta>)this.getHibernateTemplate().findByCriteria(criteria);
		return ventas;
	}

	@Override
	public List<Venta> findVentaEfectivoByUsuario(Date fechaDesde,
			Date fechaHasta, FormaDePago formaDePago, Usuario usuario) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Venta.class);
		
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fechaVenta",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fechaVenta",fechaHasta));
		}
			
		if(formaDePago!=null){
			criteria.createAlias("formaDePago", "formaDePago").add(Restrictions.eq("formaDePago", formaDePago));
		}
		
		if(usuario!=null){
			criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario", usuario));
		}
		List<Venta> ventas = (List<Venta>)this.getHibernateTemplate().findByCriteria(criteria);
		return ventas;
	}

}
