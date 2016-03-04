package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.EstadoCaja;

public interface EstadoCajaDAO {

	EstadoCaja getEstadoCaja(Long id);

	List<EstadoCaja> loadAllEstadoCaja();
	
}
