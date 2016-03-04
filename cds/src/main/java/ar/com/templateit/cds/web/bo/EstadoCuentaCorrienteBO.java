package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.EstadoCuentaCorriente;

public interface EstadoCuentaCorrienteBO {
	
	void save(EstadoCuentaCorriente estadoCuentaCorriente);
	
	void update(EstadoCuentaCorriente estadoCuentaCorriente);
	
	List<EstadoCuentaCorriente> loadAllEstadoCuentaCorriente();
			
	EstadoCuentaCorriente getEstadoCuentaCorriente(Long id);

}
