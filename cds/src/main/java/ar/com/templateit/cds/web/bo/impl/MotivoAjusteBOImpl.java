package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.MotivoAjusteBO;
import ar.com.templateit.cds.web.dao.MotivoAjusteDAO;
import ar.com.templateit.cds.web.entity.MotivoAjuste;

public class MotivoAjusteBOImpl implements MotivoAjusteBO{

	private MotivoAjusteDAO motivoAjusteDAO;
	@Override
	public MotivoAjuste getMotivoAjuste(Long id) {
		
		return this.motivoAjusteDAO.getMotivoAjuste(id);
	}

	@Override
	public List<MotivoAjuste> loadAllMotivoAjuste() {
		
		return this.motivoAjusteDAO.loadAllMotivoAjuste();
	}

	public void setMotivoAjusteDAO(MotivoAjusteDAO motivoAjusteDAO) {
		this.motivoAjusteDAO = motivoAjusteDAO;
	}

	
}
