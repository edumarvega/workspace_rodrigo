package ar.com.templateit.cds.web.dao;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.Ajuste;

public interface AjusteDAO {

	void save(Ajuste ajuste);

	List<Ajuste> loadAllAjuste();
	
	Ajuste getAjuste(Long id);

	List<Ajuste> findByCriteria(Date fechaDesde,Date fechaHasta, Long codigo,
			String nombre, String descripcion);

}
