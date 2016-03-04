package ar.com.templateit.cds.web.dao;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.GastoVario;
import ar.com.templateit.cds.web.entity.TipoGastoVario;
import ar.com.templateit.cds.web.entity.Usuario;

public interface GastoVarioDAO {
	
	void save(GastoVario gastoVario);
	
	void update(GastoVario gastoVario);
	
	void delete(GastoVario gastoVario);
	
	GastoVario getGastoVario(Long id);

	List<GastoVario> loadAllGastoVario();
	
	List<GastoVario> findByCriteria(Date fechaDesde,Date fechaHasta,String nombre,String observaciones,Usuario usuario,TipoGastoVario tipoGastoVario);

}
