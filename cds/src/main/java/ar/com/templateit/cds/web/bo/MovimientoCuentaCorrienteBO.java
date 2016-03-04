package ar.com.templateit.cds.web.bo;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.CuentaCorriente;
import ar.com.templateit.cds.web.entity.MovimientoCuentaCorriente;
import ar.com.templateit.cds.web.entity.Usuario;

public interface MovimientoCuentaCorrienteBO {
	
	void save(MovimientoCuentaCorriente movimientoCuentaCorriente);
	
	void update(MovimientoCuentaCorriente movimientoCuentaCorriente);
	
	void delete(MovimientoCuentaCorriente movimientoCuentaCorriente);
	
	MovimientoCuentaCorriente getMovimientoCuentaCorrienteById(Long id);

	List<MovimientoCuentaCorriente> loadAllMovimientoCuentaCorriente();
	
	List<MovimientoCuentaCorriente> findByCriteria(CuentaCorriente cuentaCorriente,Date fechaCobro,Date fechaPago);
	
	List<MovimientoCuentaCorriente> findMovimientoCtaCteByCriteria(CuentaCorriente cuentaCorriente,Date fechaCobro,Date fechaPago,Usuario usuario);

}
