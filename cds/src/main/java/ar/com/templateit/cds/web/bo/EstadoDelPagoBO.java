package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.EstadoDelPago;

public interface EstadoDelPagoBO {
	
	void save(EstadoDelPago estadoDelPago);
	
	void update(EstadoDelPago estadoDelPago);
	
	List<EstadoDelPago> loadAllEstadoDelPago();
			
	EstadoDelPago getEstadoDelPago(Long id);

}
