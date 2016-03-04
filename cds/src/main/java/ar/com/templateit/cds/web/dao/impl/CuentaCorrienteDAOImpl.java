package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.CuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;
import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

public class CuentaCorrienteDAOImpl extends HibernateDaoSupport implements CuentaCorrienteDAO{

	@Override
	public void save(CuentaCorriente cuentaCorriente) {
		this.getHibernateTemplate().save(cuentaCorriente);
		
	}

	@Override
	public void update(CuentaCorriente cuentaCorriente) {
		this.getHibernateTemplate().update(cuentaCorriente);
		
	}

	@Override
	public void delete(CuentaCorriente cuentaCorriente) {
		this.getHibernateTemplate().delete(cuentaCorriente);
		
	}

	@Override
	public CuentaCorriente getCuentaCorrienteById(Long id) {
		CuentaCorriente cuentaCorriente = (CuentaCorriente)this.getHibernateTemplate().get(CuentaCorriente.class, id);
		return cuentaCorriente;
	}

	@Override
	public List<CuentaCorriente> loadAllCuentaCorriente() {
		List<CuentaCorriente> cuentasCorrientes = (List<CuentaCorriente>)this.getHibernateTemplate().loadAll(CuentaCorriente.class);
		return cuentasCorrientes;
	}

	@Override
	public List<CuentaCorriente> findByCriteria(TipoCuentaCorriente tipoCuentaCorriente, Date fechaDesde,Date fechaHasta, String nombre,
			EstadoCuentaCorriente estadoCuentaCorriente,Usuario usuario) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(CuentaCorriente.class);
		
		if(fechaDesde!=null){
			criteria.add(Restrictions.ge("fecha",fechaDesde));
		}
		
		if(fechaHasta!=null){
			criteria.add(Restrictions.le("fecha",fechaHasta));
		}
		
//		if(fechaDesde==null && fechaHasta==null){
//			criteria.add(Restrictions.isNull("fecha"));
//		}
		
		if(tipoCuentaCorriente!=null){
			
			criteria.createAlias("tipoCuentaCorriente", "tipoCuentaCorriente").add(Restrictions.eq("tipoCuentaCorriente", tipoCuentaCorriente));
			
			if(tipoCuentaCorriente.getId().intValue()==1){
				if(nombre!=null && nombre.length()>0){
					criteria.createAlias("cliente", "cliente").add(Restrictions.ilike("cliente.nombres", nombre.trim(), MatchMode.ANYWHERE));
				}
			}
			else{
				if(nombre!=null && nombre.length()>0){
					criteria.createAlias("proveedor", "proveedor").add(Restrictions.ilike("proveedor.nombreRazonSocial", nombre.trim(), MatchMode.ANYWHERE));
				}
			}
		}
					
		
		if(estadoCuentaCorriente!=null){  
			criteria.createAlias("estadoCuentaCorriente", "estadoCuentaCorriente").add(Restrictions.eq("estadoCuentaCorriente", estadoCuentaCorriente));
		}
		
		if(usuario!=null){
			criteria.createAlias("usuario", "usuario").add(Restrictions.eq("usuario", usuario));
		}
				
		
		List<CuentaCorriente> cuentasCorrientes = (List<CuentaCorriente>)this.getHibernateTemplate().findByCriteria(criteria);
		
		return cuentasCorrientes;
	}

	@Override
	public CuentaCorriente getCuentaCorrienteByVenta(Venta venta) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(CuentaCorriente.class);
		if(venta!=null){
			criteria.createAlias("venta", "venta").add(Restrictions.eq("venta", venta));
		}
		List<CuentaCorriente> cuentasCorrientes = this.getHibernateTemplate().findByCriteria(criteria);
		
		CuentaCorriente cuentaCorriente=null;
		
		if(!cuentasCorrientes.isEmpty()){
			cuentaCorriente = (CuentaCorriente) DataAccessUtils.requiredUniqueResult(cuentasCorrientes);	
		}
		
		return cuentaCorriente;
				
	}

}
