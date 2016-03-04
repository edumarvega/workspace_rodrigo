package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.TipoGastoVario;

public interface TipoGastoVarioBO {
	
	TipoGastoVario getTipoGastoVario(Long id);

	List<TipoGastoVario> loadAllTipoGastoVario();
	
	

}
