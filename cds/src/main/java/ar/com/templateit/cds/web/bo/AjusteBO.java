package ar.com.templateit.cds.web.bo;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.Ajuste;

public interface AjusteBO {
	
	void save(Ajuste ajuste);

	List<Ajuste> loadAllAjuste();
	
	Ajuste getAjuste(Long id);

	public List<Ajuste> findByCriteria(Date fechaDesde,Date fechaHasta, Long codigo,
			String nombre, String descripcion);

}
