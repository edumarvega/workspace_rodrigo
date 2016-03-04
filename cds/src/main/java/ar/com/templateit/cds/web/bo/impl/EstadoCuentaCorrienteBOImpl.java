package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.EstadoCuentaCorrienteBO;
import ar.com.templateit.cds.web.dao.EstadoCuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;

public class EstadoCuentaCorrienteBOImpl implements EstadoCuentaCorrienteBO {
	
	private EstadoCuentaCorrienteDAO estadoCuentaCorrienteDAO;

	@Override
	public void save(EstadoCuentaCorriente estadoCuentaCorriente) {
		this.estadoCuentaCorrienteDAO.save(estadoCuentaCorriente);
		
	}

	@Override
	public void update(EstadoCuentaCorriente estadoCuentaCorriente) {
		this.estadoCuentaCorrienteDAO.update(estadoCuentaCorriente);
		
	}

	@Override
	public List<EstadoCuentaCorriente> loadAllEstadoCuentaCorriente() {
		List<EstadoCuentaCorriente> estadosCuentaCorriente = this.estadoCuentaCorrienteDAO.loadAllEstadoCuentaCorriente();
		return estadosCuentaCorriente;
	}

	@Override
	public EstadoCuentaCorriente getEstadoCuentaCorriente(Long id) {
		EstadoCuentaCorriente estadoCuentaCorriente = this.estadoCuentaCorrienteDAO.getEstadoCuentaCorriente(id);
		return estadoCuentaCorriente;
	}

	public void setEstadoCuentaCorrienteDAO(
			EstadoCuentaCorrienteDAO estadoCuentaCorrienteDAO) {
		this.estadoCuentaCorrienteDAO = estadoCuentaCorrienteDAO;
	}
	
	

}
