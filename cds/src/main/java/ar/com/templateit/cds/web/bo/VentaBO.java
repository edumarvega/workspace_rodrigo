package ar.com.templateit.cds.web.bo;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.FormaDePago;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

public interface VentaBO {

	void save(Venta venta);
	
	void delete(Venta venta);
	
	List<Venta> loadAllVenta();
	
	List<Venta> findByCriteria(Date fechaDesde,Date fechaHasta,String observaciones,String usuario,FormaDePago formaDePago);
	
	Venta getVenta(Long id);
	
	List<Venta> findVentaByUsuario(Date fechaDesde,Date fechaHasta,Usuario usuario);
	
	List<Venta> findVentaEfectivoByUsuario(Date fechaDesde,Date fechaHasta,FormaDePago formaDePago,Usuario usuario);
}
