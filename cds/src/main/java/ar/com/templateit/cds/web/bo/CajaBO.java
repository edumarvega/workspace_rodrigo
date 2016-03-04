package ar.com.templateit.cds.web.bo;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.Caja;
import ar.com.templateit.cds.web.entity.EstadoCaja;
import ar.com.templateit.cds.web.entity.Usuario;

public interface CajaBO {
	
	void save(Caja caja);
	
	void update(Caja caja);
	
	List<Caja> loadAllCaja();
			
	Caja getCaja(Long id);
	
	boolean verificarCaja(Date fecha,Usuario usuario);
	
	List<Caja> findByCriteria(Date fechaDesde,Date fechaHasta,EstadoCaja estadoCaja);

}
