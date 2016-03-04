package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.CuentaCorrienteBO;
import ar.com.templateit.cds.web.dao.CuentaCorrienteDAO;
import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;
import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

public class CuentaCorrienteBOImpl implements CuentaCorrienteBO{
	
	private CuentaCorrienteDAO cuentaCorrienteDAO;

	@Override
	public void save(CuentaCorriente cuentaCorriente) {
		this.cuentaCorrienteDAO.save(cuentaCorriente);
		
	}

	@Override
	public void update(CuentaCorriente cuentaCorriente) {
		this.cuentaCorrienteDAO.update(cuentaCorriente);
		
	}

	@Override
	public void delete(CuentaCorriente cuentaCorriente) {
		this.cuentaCorrienteDAO.delete(cuentaCorriente);
		
	}

	@Override
	public CuentaCorriente getCuentaCorrienteById(Long id) {
		CuentaCorriente cuentaCorriente = this.cuentaCorrienteDAO.getCuentaCorrienteById(id);
		return cuentaCorriente;
	}

	@Override
	public List<CuentaCorriente> loadAllCuentaCorriente() {
		List<CuentaCorriente> cuentasCorrientes = this.cuentaCorrienteDAO.loadAllCuentaCorriente();
		return cuentasCorrientes;
	}

	@Override
	public List<CuentaCorriente> findByCriteria(TipoCuentaCorriente tipoCuentaCorriente, Date fechaDesde,Date fechaHasta, String nombre,
							EstadoCuentaCorriente estadoCuentaCorriente,Usuario usuario) {
		List<CuentaCorriente> cuentasCorrientes = this.cuentaCorrienteDAO.findByCriteria(tipoCuentaCorriente, fechaDesde, fechaHasta, nombre, estadoCuentaCorriente,usuario);
		return cuentasCorrientes;
		
	}

	public void setCuentaCorrienteDAO(CuentaCorrienteDAO cuentaCorrienteDAO) {
		this.cuentaCorrienteDAO = cuentaCorrienteDAO;
	}

	@Override
	public CuentaCorriente getCuentaCorrienteByVenta(Venta venta) {
		
		return this.cuentaCorrienteDAO.getCuentaCorrienteByVenta(venta);
	}

	
}
