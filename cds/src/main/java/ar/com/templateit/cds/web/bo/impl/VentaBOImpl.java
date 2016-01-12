package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.VentaBO;
import ar.com.templateit.cds.web.dao.VentaDAO;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

public class VentaBOImpl implements VentaBO{

	private VentaDAO ventaDAO;
	
	@Override
	public void save(Venta venta) {
		this.ventaDAO.save(venta);
		
	}

	@Override
	public List<Venta> loadAllVenta() {
		List<Venta> ventas = this.ventaDAO.loadAllVenta();
		return ventas;
	}

	@Override
	public List<Venta> findByCriteria(Date fechaDesde, Date fechaHasta, String observaciones, String usuario) {
		List<Venta> ventas = this.ventaDAO.findByCriteria(fechaDesde, fechaHasta, observaciones,usuario);
		return ventas;
	}
	
	@Override
	public List<Venta> findVentaByUsuario(Date fechaDesde, Date fechaHasta,	Usuario usuario) {
		List<Venta> ventas = this.ventaDAO.findVentaByUsuario(fechaDesde, fechaHasta, usuario);
		return ventas;
	}
	
	@Override
	public Venta getVenta(Long id) {
		Venta venta = this.ventaDAO.getVenta(id);
		return venta;
	}
	

	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	

	
	

}
