package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.TipoIngresoVario;

public interface TipoIngresoVarioDAO {
	
	TipoIngresoVario getTipoIngresoVario(Long id);

	List<TipoIngresoVario> loadAllTipoIngresoVario();

}
