package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.FormaDePagoBO;
import ar.com.templateit.cds.web.dao.FormaDePagoDAO;
import ar.com.templateit.cds.web.entity.FormaDePago;

public class FormaDePagoBOImpl implements FormaDePagoBO{
	
	private FormaDePagoDAO formaDePagoDAO;

	@Override
	public FormaDePago getFormaDePago(Long id) {
		FormaDePago formaDePago = (FormaDePago)this.formaDePagoDAO.getFormaDePago(id);
		return formaDePago;
	}

	@Override
	public List<FormaDePago> loadAllFormaDePago() {
		List<FormaDePago> formasDePago = (List<FormaDePago>)this.formaDePagoDAO.loadAllFormaDePago();
		return formasDePago;
	}

	public void setFormaDePagoDAO(FormaDePagoDAO formaDePagoDAO) {
		this.formaDePagoDAO = formaDePagoDAO;
	}
	
	

}
