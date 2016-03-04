package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.IngresoVarioBO;
import ar.com.templateit.cds.web.dao.IngresoVarioDAO;
import ar.com.templateit.cds.web.entity.IngresoVario;
import ar.com.templateit.cds.web.entity.TipoIngresoVario;
import ar.com.templateit.cds.web.entity.Usuario;

public class IngresoVarioBOImpl implements IngresoVarioBO{
	
	private IngresoVarioDAO ingresoVarioDAO;

	@Override
	public void save(IngresoVario ingresoVario) {
		this.ingresoVarioDAO.save(ingresoVario);
		
	}

	@Override
	public void update(IngresoVario ingresoVario) {
		this.ingresoVarioDAO.update(ingresoVario);
		
	}

	@Override
	public void delete(IngresoVario ingresoVario) {
		this.ingresoVarioDAO.delete(ingresoVario);
		
	}

	@Override
	public IngresoVario getIngresoVario(Long id) {
		IngresoVario ingresoVario = this.ingresoVarioDAO.getIngresoVario(id);
		return ingresoVario;
	}

	@Override
	public List<IngresoVario> loadAllIngresoVario() {
		List<IngresoVario> ingresosVarios = this.ingresoVarioDAO.loadAllIngresoVario();
		return ingresosVarios;
	}

	@Override
	public List<IngresoVario> findByCriteria(Date fechaDesde, Date fechaHasta,
			String nombre, String observaciones, Usuario usuario,TipoIngresoVario tipoIngresoVario) {
		List<IngresoVario> ingresosVarios = this.ingresoVarioDAO.findByCriteria(fechaDesde, fechaHasta, nombre, observaciones,
																				usuario,tipoIngresoVario);
		return ingresosVarios;
	}

	public void setIngresoVarioDAO(IngresoVarioDAO ingresoVarioDAO) {
		this.ingresoVarioDAO = ingresoVarioDAO;
	}
	
	

}
