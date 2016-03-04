package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.TipoGastoVarioBO;
import ar.com.templateit.cds.web.dao.TipoGastoVarioDAO;
import ar.com.templateit.cds.web.entity.TipoGastoVario;

public class TipoGastoVarioBOImpl implements TipoGastoVarioBO{
	
	private TipoGastoVarioDAO tipoGastoVarioDAO;

	@Override
	public TipoGastoVario getTipoGastoVario(Long id) {
		TipoGastoVario tipoGastoVario = (TipoGastoVario)this.tipoGastoVarioDAO.getTipoGastoVario(id);
		return tipoGastoVario;
	}

	@Override
	public List<TipoGastoVario> loadAllTipoGastoVario() {
		List<TipoGastoVario> tiposGastoVario = (List<TipoGastoVario>)this.tipoGastoVarioDAO.loadAllTipoGastoVario();
		return tiposGastoVario;
	}

	public void setTipoGastoVarioDAO(TipoGastoVarioDAO tipoGastoVarioDAO) {
		this.tipoGastoVarioDAO = tipoGastoVarioDAO;
	}
	
	

}
