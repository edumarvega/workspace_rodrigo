package ar.com.templateit.cds.web.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.templateit.cds.web.dao.EstadisticaVentaDAO;

public class EstadisticaVentaDAOImpl extends HibernateDaoSupport implements EstadisticaVentaDAO{

	@Override
	public List<Object> getVentasByProducto(Date fechaDesde, Date fechaHasta) {
		String sql = "select dv.codigo,dv.nombre , SUM(dv.subTotal) as total from DetalleVenta AS dv inner join dv.venta as v where v.fechaVenta between :fechaDesde and :fechaHasta group by dv.codigo";
		Query query = this.getSession().createQuery(sql);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		List list = query.list();
		return list;
	}

	@Override
	public List<Object> getVentasByCategoria(Date fechaDesde, Date fechaHasta) {
		String sql = "select dv.categoria,dv.categoria.descripcion,SUM(dv.subTotal) as total from DetalleVenta AS dv inner join dv.venta as v where v.fechaVenta between :fechaDesde and :fechaHasta group by dv.categoria";
		Query query = this.getSession().createQuery(sql);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		List list = query.list();
		return list;
	}

}
