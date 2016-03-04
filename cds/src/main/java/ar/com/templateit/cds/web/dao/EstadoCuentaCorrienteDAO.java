package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;

public interface EstadoCuentaCorrienteDAO {
	
	void save(EstadoCuentaCorriente estadoCuentaCorriente);
	
	void update(EstadoCuentaCorriente estadoCuentaCorriente);
	
	List<EstadoCuentaCorriente> loadAllEstadoCuentaCorriente();
			
	EstadoCuentaCorriente getEstadoCuentaCorriente(Long id);

}
