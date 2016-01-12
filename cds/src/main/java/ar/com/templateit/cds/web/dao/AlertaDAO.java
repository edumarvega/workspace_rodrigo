package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.Alerta;

public interface AlertaDAO {

	void save(Alerta alerta);
	
	void update(Alerta alerta);
	
	void delete(Alerta alerta);

	List<Alerta> loadAllAlerta();
	
	Alerta getAlerta(Long id);
	
	Alerta findByCode(Long codigo);

}
