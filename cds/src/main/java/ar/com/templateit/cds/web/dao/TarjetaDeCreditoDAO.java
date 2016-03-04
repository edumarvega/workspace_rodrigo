package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.TarjetaDeCredito;

public interface TarjetaDeCreditoDAO {
	
	TarjetaDeCredito getTarjetaDeCredito(Long id);

	List<TarjetaDeCredito> loadAllTarjetaDeCredito();

}
