package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.TipoGastoVario;

public interface TipoGastoVarioDAO {
	
	TipoGastoVario getTipoGastoVario(Long id);

	List<TipoGastoVario> loadAllTipoGastoVario();

}
