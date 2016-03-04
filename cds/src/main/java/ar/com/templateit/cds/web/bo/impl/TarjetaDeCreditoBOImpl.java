package ar.com.templateit.cds.web.bo.impl;

import java.util.List;

import ar.com.templateit.cds.web.bo.TarjetaDeCreditoBO;
import ar.com.templateit.cds.web.dao.TarjetaDeCreditoDAO;
import ar.com.templateit.cds.web.entity.TarjetaDeCredito;

public class TarjetaDeCreditoBOImpl implements TarjetaDeCreditoBO{
	
	private TarjetaDeCreditoDAO tarjetaDeCreditoDAO;

	@Override
	public TarjetaDeCredito getTarjetaDeCredito(Long id) {
		TarjetaDeCredito tarjetaDeCredito = (TarjetaDeCredito)this.tarjetaDeCreditoDAO.getTarjetaDeCredito(id);
		return tarjetaDeCredito;
	}

	@Override
	public List<TarjetaDeCredito> loadAllTarjetaDeCredito() {
		List<TarjetaDeCredito> tarjetasDeCredito = (List<TarjetaDeCredito>)this.tarjetaDeCreditoDAO.loadAllTarjetaDeCredito();
		return tarjetasDeCredito;
	}

	public void setTarjetaDeCreditoDAO(TarjetaDeCreditoDAO tarjetaDeCreditoDAO) {
		this.tarjetaDeCreditoDAO = tarjetaDeCreditoDAO;
	}
	
	

}
