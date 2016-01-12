package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.Provincia;

public interface ProvinciaBO {
	
	Provincia getProvincia(Long id);
	
	List<Provincia> loadAllProvincia();

}
