package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.CajaBO;
import ar.com.templateit.cds.web.dao.CajaDAO;
import ar.com.templateit.cds.web.entity.Caja;
import ar.com.templateit.cds.web.entity.EstadoCaja;
import ar.com.templateit.cds.web.entity.Usuario;

public class CajaBOImpl implements CajaBO{
	
	private CajaDAO cajaDAO;

	@Override
	public void save(Caja caja) {
		this.cajaDAO.save(caja);
		
	}

	@Override
	public void update(Caja caja) {
		this.cajaDAO.update(caja);
		
	}

	@Override
	public List<Caja> loadAllCaja() {
		List<Caja> cajas = (List<Caja>)this.cajaDAO.loadAllCaja();
		return cajas;
	}

	@Override
	public Caja getCaja(Long id) {
		Caja caja = (Caja)this.cajaDAO.getCaja(id);
		return caja;
	}
	
	@Override
	public boolean verificarCaja(Date fecha, Usuario usuario) {
		boolean existeCaja = this.cajaDAO.verificarCaja(fecha, usuario);
		return existeCaja;
	}
	
	
	@Override
	public List<Caja> findByCriteria(Date fechaDesde, Date fechaHasta,
			EstadoCaja estadoCaja) {
		List<Caja> cajas = (List<Caja>)this.cajaDAO.findByCriteria(fechaDesde, fechaHasta, estadoCaja);
		return cajas;
	}
	
	public void setCajaDAO(CajaDAO cajaDAO) {
		this.cajaDAO = cajaDAO;
	}

	
	
	

}
