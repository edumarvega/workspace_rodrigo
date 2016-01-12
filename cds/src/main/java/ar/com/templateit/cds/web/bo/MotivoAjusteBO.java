package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.MotivoAjuste;

public interface MotivoAjusteBO {
	
	MotivoAjuste getMotivoAjuste(Long id);
	
	List<MotivoAjuste> loadAllMotivoAjuste();

}
