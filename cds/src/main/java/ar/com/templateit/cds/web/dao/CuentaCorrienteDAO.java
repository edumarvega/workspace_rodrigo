package ar.com.templateit.cds.web.dao;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;
import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.Venta;

public interface CuentaCorrienteDAO {	
	
	void save(CuentaCorriente cuentaCorriente);
	
	void update(CuentaCorriente cuentaCorriente);
	
	void delete(CuentaCorriente cuentaCorriente);
	
	CuentaCorriente getCuentaCorrienteById(Long id);

	List<CuentaCorriente> loadAllCuentaCorriente();
	
	List<CuentaCorriente> findByCriteria(TipoCuentaCorriente tipoCuentaCorriente,Date fechaDesde,Date fechaHasta,String nombre,
			EstadoCuentaCorriente estadoCuentaCorriente,Usuario usuario);
	
	CuentaCorriente getCuentaCorrienteByVenta(Venta venta);

}
