package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.EstadoDelPagoBO;
import ar.com.templateit.cds.web.dao.EstadoDelPagoDAO;
import ar.com.templateit.cds.web.entity.EstadoDelPago;

public class EstadoDelPagoBOImpl implements EstadoDelPagoBO{
	
	private EstadoDelPagoDAO estadoDelPagoDAO;

	@Override
	public void save(EstadoDelPago estadoDelPago) {
		this.estadoDelPagoDAO.save(estadoDelPago);
		
	}

	@Override
	public void update(EstadoDelPago estadoDelPago) {
		this.estadoDelPagoDAO.update(estadoDelPago);
		
	}

	@Override
	public List<EstadoDelPago> loadAllEstadoDelPago() {
		List<EstadoDelPago> estadosDelPago = (List<EstadoDelPago>)this.estadoDelPagoDAO.loadAllEstadoDelPago();
		return estadosDelPago;
	}

	@Override
	public EstadoDelPago getEstadoDelPago(Long id) {
		EstadoDelPago estadoDelPago = (EstadoDelPago) this.estadoDelPagoDAO.getEstadoDelPago(id);
		return estadoDelPago;
	}

	public void setEstadoDelPagoDAO(EstadoDelPagoDAO estadoDelPagoDAO) {
		this.estadoDelPagoDAO = estadoDelPagoDAO;
	}

	
	
}
