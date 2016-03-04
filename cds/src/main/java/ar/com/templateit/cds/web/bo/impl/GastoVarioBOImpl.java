package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.GastoVarioBO;
import ar.com.templateit.cds.web.dao.GastoVarioDAO;
import ar.com.templateit.cds.web.entity.GastoVario;
import ar.com.templateit.cds.web.entity.TipoGastoVario;
import ar.com.templateit.cds.web.entity.Usuario;

public class GastoVarioBOImpl implements GastoVarioBO{
	
	private GastoVarioDAO gastoVarioDAO;

	@Override
	public void save(GastoVario gastoVario) {
		this.gastoVarioDAO.save(gastoVario);
		
	}

	@Override
	public void update(GastoVario gastoVario) {
		this.gastoVarioDAO.update(gastoVario);
		
	}

	@Override
	public void delete(GastoVario gastoVario) {
		this.gastoVarioDAO.delete(gastoVario);
		
	}

	@Override
	public GastoVario getGastoVario(Long id) {
		GastoVario gastoVario = (GastoVario)this.gastoVarioDAO.getGastoVario(id);
		return gastoVario;
	}

	@Override
	public List<GastoVario> loadAllGastoVario() {
		List<GastoVario> gastosVarios = (List<GastoVario>)this.gastoVarioDAO.loadAllGastoVario();
		return gastosVarios;
	}

	@Override
	public List<GastoVario> findByCriteria(Date fechaDesde, Date fechaHasta,
			String nombre, String observaciones, Usuario usuario,TipoGastoVario tipoGastoVario) {
		List<GastoVario> gastosVarios = (List<GastoVario>)this.gastoVarioDAO.findByCriteria(fechaDesde, fechaHasta, nombre, observaciones, usuario,tipoGastoVario);
		return gastosVarios;
	}

	public void setGastoVarioDAO(GastoVarioDAO gastoVarioDAO) {
		this.gastoVarioDAO = gastoVarioDAO;
	}

	
}
