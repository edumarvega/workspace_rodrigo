package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.MovimientoCuentaCorrienteBO;
import ar.com.templateit.cds.web.dao.MovimientoCuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.MovimientoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;

public class MovimientoCuentaCorrienteBOImpl implements MovimientoCuentaCorrienteBO{

	private MovimientoCuentaCorrienteDAO movimientoCuentaCorrienteDAO;
	
	@Override
	public void save(MovimientoCuentaCorriente movimientoCuentaCorriente) {
		this.movimientoCuentaCorrienteDAO.save(movimientoCuentaCorriente);
		
	}

	@Override
	public void update(MovimientoCuentaCorriente movimientoCuentaCorriente) {
		this.movimientoCuentaCorrienteDAO.update(movimientoCuentaCorriente);
		
	}

	@Override
	public void delete(MovimientoCuentaCorriente movimientoCuentaCorriente) {
		this.movimientoCuentaCorrienteDAO.update(movimientoCuentaCorriente);
		
	}

	@Override
	public MovimientoCuentaCorriente getMovimientoCuentaCorrienteById(Long id) {
		MovimientoCuentaCorriente movimientoCuentaCorriente = this.movimientoCuentaCorrienteDAO.getMovimientoCuentaCorrienteById(id);
		return movimientoCuentaCorriente;
	}

	@Override
	public List<MovimientoCuentaCorriente> loadAllMovimientoCuentaCorriente() {
		List<MovimientoCuentaCorriente> lista = this.movimientoCuentaCorrienteDAO.loadAllMovimientoCuentaCorriente();
		return lista;
	}

	@Override
	public List<MovimientoCuentaCorriente> findByCriteria(
			CuentaCorriente cuentaCorriente, Date fechaCobro, Date fechaPago) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<MovimientoCuentaCorriente> findMovimientoCtaCteByCriteria(
			CuentaCorriente cuentaCorriente, Date fechaCobro, Date fechaPago,
			Usuario usuario) {
		List<MovimientoCuentaCorriente> lista = this.movimientoCuentaCorrienteDAO.findMovimientoCtaCteByCriteria(cuentaCorriente, fechaCobro, fechaPago, usuario);
		return lista;

	}
	
	public void setMovimientoCuentaCorrienteDAO(
			MovimientoCuentaCorrienteDAO movimientoCuentaCorrienteDAO) {
		this.movimientoCuentaCorrienteDAO = movimientoCuentaCorrienteDAO;
	}


	
}
