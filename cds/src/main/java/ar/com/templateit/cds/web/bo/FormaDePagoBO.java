package ar.com.templateit.cds.web.bo;

import java.util.List;

import ar.com.templateit.cds.web.entity.FormaDePago;

public interface FormaDePagoBO {
	
	FormaDePago getFormaDePago(Long id);

	List<FormaDePago> loadAllFormaDePago();

}
