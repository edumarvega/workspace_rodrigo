package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.EstadoCaja;

public interface EstadoCajaBO {
	
	EstadoCaja getEstadoCaja(Long id);

	List<EstadoCaja> loadAllEstadoCaja();

}
