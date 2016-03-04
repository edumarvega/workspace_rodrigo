package ar.com.templateit.cds.web.dao;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.Compra;
import ar.com.templateit.cds.web.entity.FormaDePago;
import ar.com.templateit.cds.web.entity.Usuario;

public interface CompraDAO {
	
	void save(Compra compra);
	
	void update(Compra compra);
	
	List<Compra> loadAllCompra();
	
	List<Compra> findByCriteria(Date fechaDesde,Date fechaHasta,String nroTicketFactura,String proveedor,FormaDePago formaDePago);
	
	Compra getCompra(Long id);
	
	List<Compra> findCompraEfectivoByUsuario(Date fechaDesde,Date fechaHasta,FormaDePago formaDePago,Usuario usuario);

}
