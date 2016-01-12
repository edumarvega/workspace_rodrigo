package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.MotivoAjuste;

public interface MotivoAjusteDAO {
	
	MotivoAjuste getMotivoAjuste(Long id);
	
	List<MotivoAjuste> loadAllMotivoAjuste();

}
