package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;

public interface TipoCuentaCorrienteDAO {
	
	TipoCuentaCorriente getTipoCuentaCorriente(Long id);

	List<TipoCuentaCorriente> loadTipoCuentaCorriente();

}
