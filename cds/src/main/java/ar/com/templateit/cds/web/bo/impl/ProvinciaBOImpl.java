package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.ProvinciaBO;
import ar.com.templateit.cds.web.dao.ProvinciaDAO;
import ar.com.templateit.cds.web.entity.Provincia;

public class ProvinciaBOImpl implements ProvinciaBO{

	private ProvinciaDAO provinciaDAO;
	
	@Override
	public Provincia getProvincia(Long id) {
		
		return this.provinciaDAO.getProvincia(id);
	}

	@Override
	public List<Provincia> loadAllProvincia() {
		return this.provinciaDAO.loadAllProvincia();
	}

	public void setProvinciaDAO(ProvinciaDAO provinciaDAO) {
		this.provinciaDAO = provinciaDAO;
	}
	
	

}
