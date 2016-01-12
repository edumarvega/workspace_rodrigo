package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.AjusteBO;
import ar.com.templateit.cds.web.dao.AjusteDAO;
import ar.com.templateit.cds.web.entity.Ajuste;

public class AjusteBOImpl implements AjusteBO{

	private AjusteDAO ajusteDAO;
	
	@Override
	public void save(Ajuste ajuste) {
		this.ajusteDAO.save(ajuste);
		
	}

	@Override
	public List<Ajuste> loadAllAjuste() {
		List<Ajuste> ajustes = this.ajusteDAO.loadAllAjuste();
		return ajustes;
	}

	@Override
	public List<Ajuste> findByCriteria(Date fechaDesde, Date fechaHasta,
			Long codigo, String nombre, String descripcion) {
		List<Ajuste> ajustes = this.ajusteDAO.findByCriteria(fechaDesde, fechaHasta, codigo, 
								nombre, descripcion);
		return ajustes;
	}

	@Override
	public Ajuste getAjuste(Long id) {
		Ajuste ajuste = this.ajusteDAO.getAjuste(id);
		return ajuste;
	}
		
	public void setAjusteDAO(AjusteDAO ajusteDAO) {
		this.ajusteDAO = ajusteDAO;
	}	

	
}
