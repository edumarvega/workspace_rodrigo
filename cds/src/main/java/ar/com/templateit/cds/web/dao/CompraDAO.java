package ar.com.templateit.cds.web.dao;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.Compra;

public interface CompraDAO {
	
	void save(Compra compra);
	
	void update(Compra compra);
	
	List<Compra> loadAllCompra();
	
	List<Compra> findByCriteria(Date fechaDesde,Date fechaHasta,String nroTicketFactura,String proveedor);
	
	Compra getCompra(Long id);

}
