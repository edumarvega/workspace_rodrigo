package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.Alerta;

public interface AlertaBO {

	void save(Alerta alerta);
	
	void update(Alerta alerta);
	
	void delete(Alerta alerta);

	List<Alerta> loadAllAlerta();
	
	Alerta getAlerta(Long id);
	
	Alerta findByCode(Long codigo);

}
