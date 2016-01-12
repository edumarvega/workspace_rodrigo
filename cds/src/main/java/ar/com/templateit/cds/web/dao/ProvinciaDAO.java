package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.Provincia;

public interface ProvinciaDAO {
	
	Provincia getProvincia(Long id);
	
	List<Provincia> loadAllProvincia();

}
