package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.TipoIngresoVario;

public interface TipoIngresoVarioBO {
	
	TipoIngresoVario getTipoIngresoVario(Long id);

	List<TipoIngresoVario> loadAllTipoIngresoVario();

}
