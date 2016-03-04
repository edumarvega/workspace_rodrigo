package ar.com.templateit.cds.web.dao;

import java.util.List;

import ar.com.templateit.cds.web.entity.FormaDePago;

public interface FormaDePagoDAO {
	
	FormaDePago getFormaDePago(Long id);

	List<FormaDePago> loadAllFormaDePago();

}
