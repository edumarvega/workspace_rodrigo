package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.TipoCuentaCorriente;

public interface TipoCuentaCorrienteBO {
	
	TipoCuentaCorriente getTipoCuentaCorriente(Long id);

	List<TipoCuentaCorriente> loadTipoCuentaCorriente();

}
