package ar.com.templateit.cds.web.bo.impl;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.bo.CompraBO;
import ar.com.templateit.cds.web.dao.CompraDAO;
import ar.com.templateit.cds.web.entity.Compra;

public class CompraBOImpl implements CompraBO{

	private CompraDAO compraDAO;
	
	@Override
	public void save(Compra compra) {
		this.compraDAO.save(compra);
	}
	
	@Override
	public void update(Compra compra) {
		this.compraDAO.update(compra);
	}

	@Override
	public List<Compra> loadAllCompra() {
		List<Compra> compras = this.compraDAO.loadAllCompra();
		return compras;
	}

	@Override
	public List<Compra> findByCriteria(Date fechaDesde,Date fechaHasta,String nroTicketFactura,String proveedor) {
		List<Compra> compras = this.compraDAO.findByCriteria(fechaDesde,fechaHasta,nroTicketFactura, proveedor);
		return compras;
	}
	
	@Override
	public Compra getCompra(Long id) {
		Compra compra = this.compraDAO.getCompra(id);
		
		return compra;
	}

	
	public void setCompraDAO(CompraDAO compraDAO) {
		this.compraDAO = compraDAO;
	}


}
