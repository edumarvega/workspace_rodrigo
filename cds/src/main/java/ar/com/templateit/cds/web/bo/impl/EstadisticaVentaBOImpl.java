package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.EstadisticaVentaBO;
import ar.com.templateit.cds.web.dao.EstadisticaVentaDAO;

public class EstadisticaVentaBOImpl implements EstadisticaVentaBO{

	private EstadisticaVentaDAO estadisticaVentaDAO;
	@Override
	public List<Object> getVentasByProducto(Date fechaDesde, Date fechaHasta) {
		
		return this.estadisticaVentaDAO.getVentasByProducto(fechaDesde, fechaHasta);
	}

	@Override
	public List<Object> getVentasByCategoria(Date fechaDesde, Date fechaHasta) {
		
		return this.estadisticaVentaDAO.getVentasByCategoria(fechaDesde, fechaHasta);
	}

	public void setEstadisticaVentaDAO(EstadisticaVentaDAO estadisticaVentaDAO) {
		this.estadisticaVentaDAO = estadisticaVentaDAO;
	}

}
