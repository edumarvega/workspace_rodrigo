package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.CompraDAO;
import ar.com.templateit.cds.web.entity.Compra;
import ar.com.templateit.cds.web.entity.FormaDePago;
import ar.com.templateit.cds.web.entity.Usuario;

public class CompraDAOImpl extends HibernateDaoSupport implements CompraDAO{

	@Override
	public void save(Compra compra) {
		this.getHibernateTemplate().save(compra);
	}
	
	@Override
	public void update(Compra compra) {
		this.getHibernateTemplate().update(compra);
	}

	@Override
	public List<Compra> loadAllCompra() {
		List<Compra> compras = (List<Compra>) this.getHibernateTemplate().loadAll(Compra.class);
		return compras;
	}

	@Override
	public List<Compra> findByCriteria(Date fechaDesde,Date fechaHasta,String nroTicketFactura,String proveedor,FormaDePago formaDePago) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Compra.class);
		
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fechaCompra",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fechaCompra",fechaHasta));
		}
		if(nroTicketFactura!=null){
			if(!nroTicketFactura.isEmpty()){
				criteria.add(Restrictions.ilike("nroTicketFactura", nroTicketFactura, MatchMode.ANYWHERE));
			}	
		}
		if(proveedor!=null){
			if(!proveedor.isEmpty()){
				criteria.add(Restrictions.ilike("proveedor", proveedor, MatchMode.ANYWHERE));
			}
		}
		if(formaDePago!=null){  
			criteria.createAlias("formaDePago", "formaDePago").add(Restrictions.eq("formaDePago", formaDePago));
		
		}
		List<Compra> compras = (List<Compra>)this.getHibernateTemplate().findByCriteria(criteria);
		return compras;
	}

	@Override
	public Compra getCompra(Long id) {
		Compra compra = (Compra)this.getHibernateTemplate().get(Compra.class, id);
		return compra;
	}

	@Override
	public List<Compra> findCompraEfectivoByUsuario(Date fechaDesde,
			Date fechaHasta, FormaDePago formaDePago, Usuario usuario) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Compra.class);
		
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fechaCompra",fechaDesde));
		}
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fechaCompra",fechaHasta));
		}
			
		if(formaDePago!=null){
			criteria.createAlias("formaDePago", "formaDePago").add(Restrictions.eq("formaDePago", formaDePago));
		}
		
		if(usuario!=null){
			criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario", usuario));
		}
		List<Compra> compras = (List<Compra>)this.getHibernateTemplate().findByCriteria(criteria);
		return compras;
	}
	

}
