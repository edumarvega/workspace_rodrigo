package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.TipoCuentaCorrienteBO;
import ar.com.templateit.cds.web.dao.TipoCuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;

public class TipoCuentaCorrienteBOImpl implements TipoCuentaCorrienteBO{
	
	private TipoCuentaCorrienteDAO tipoCuentaCorrienteDAO;

	@Override
	public TipoCuentaCorriente getTipoCuentaCorriente(Long id) {
		TipoCuentaCorriente tipoCuentaCorriente = (TipoCuentaCorriente)this.tipoCuentaCorrienteDAO.getTipoCuentaCorriente(id);
		return tipoCuentaCorriente;
	}

	@Override
	public List<TipoCuentaCorriente> loadTipoCuentaCorriente() {
		List<TipoCuentaCorriente> tiposCuentaCorriente = (List<TipoCuentaCorriente>)this.tipoCuentaCorrienteDAO.loadTipoCuentaCorriente();
		return tiposCuentaCorriente;
	}

	public void setTipoCuentaCorrienteDAO(
			TipoCuentaCorrienteDAO tipoCuentaCorrienteDAO) {
		this.tipoCuentaCorrienteDAO = tipoCuentaCorrienteDAO;
	}
	
	

}
