package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.EstadoCajaBO;
import ar.com.templateit.cds.web.dao.EstadoCajaDAO;
import ar.com.templateit.cds.web.entity.EstadoCaja;

public class EstadoCajaBOImpl implements EstadoCajaBO{
	
	private EstadoCajaDAO estadoCajaDAO;

	@Override
	public EstadoCaja getEstadoCaja(Long id) {
		EstadoCaja estadoCaja = this.estadoCajaDAO.getEstadoCaja(id);
		return estadoCaja;
	}

	@Override
	public List<EstadoCaja> loadAllEstadoCaja() {
		List<EstadoCaja> estadosCaja = this.estadoCajaDAO.loadAllEstadoCaja();
		return estadosCaja;
	}

	public void setEstadoCajaDAO(EstadoCajaDAO estadoCajaDAO) {
		this.estadoCajaDAO = estadoCajaDAO;
	}
	
	

		
	

}
