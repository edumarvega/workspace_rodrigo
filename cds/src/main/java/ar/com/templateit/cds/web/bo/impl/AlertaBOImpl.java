package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.AlertaBO;
import ar.com.templateit.cds.web.dao.AlertaDAO;
import ar.com.templateit.cds.web.entity.Alerta;

public class AlertaBOImpl implements AlertaBO{
	
	private AlertaDAO alertaDAO;

	@Override
	public void save(Alerta alerta) {
		this.alertaDAO.save(alerta);
	}

	@Override
	public void update(Alerta alerta) {
		this.alertaDAO.update(alerta);
	}

	@Override
	public void delete(Alerta alerta) {
		this.alertaDAO.delete(alerta);
	}

	@Override
	public List<Alerta> loadAllAlerta() {
		List<Alerta> alertas = this.alertaDAO.loadAllAlerta();
		return alertas;
	}

	@Override
	public Alerta getAlerta(Long id) {
		Alerta alerta = this.alertaDAO.getAlerta(id);
		return alerta;
	}
	
	@Override
	public Alerta findByCode(Long codigo) {
		Alerta alerta = this.alertaDAO.findByCode(codigo);
		return alerta;
	}

	public void setAlertaDAO(AlertaDAO alertaDAO) {
		this.alertaDAO = alertaDAO;
	}



}
