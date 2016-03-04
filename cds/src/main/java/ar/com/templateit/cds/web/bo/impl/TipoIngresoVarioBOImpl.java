package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.TipoIngresoVarioBO;
import ar.com.templateit.cds.web.dao.TipoIngresoVarioDAO;
import ar.com.templateit.cds.web.entity.TipoIngresoVario;

public class TipoIngresoVarioBOImpl implements TipoIngresoVarioBO{
	
	private TipoIngresoVarioDAO tipoIngresoVarioDAO;

	@Override
	public TipoIngresoVario getTipoIngresoVario(Long id) {
		TipoIngresoVario tipoIngresoVario = (TipoIngresoVario)this.tipoIngresoVarioDAO.getTipoIngresoVario(id);
		return tipoIngresoVario;
	}

	@Override
	public List<TipoIngresoVario> loadAllTipoIngresoVario() {
		List<TipoIngresoVario> tiposIngresoVario = (List<TipoIngresoVario>)this.tipoIngresoVarioDAO.loadAllTipoIngresoVario();
		return tiposIngresoVario;
	}

	public void setTipoIngresoVarioDAO(TipoIngresoVarioDAO tipoIngresoVarioDAO) {
		this.tipoIngresoVarioDAO = tipoIngresoVarioDAO;
	}
	
	

}
