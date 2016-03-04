package ar.com.templateit.cds.web.bo;

import java.util.Date;
import java.util.List;

import ar.com.templateit.cds.web.entity.IngresoVario;
import ar.com.templateit.cds.web.entity.TipoIngresoVario;
import ar.com.templateit.cds.web.entity.Usuario;

public interface IngresoVarioBO {
	
	void save(IngresoVario ingresoVario);
	
	void update(IngresoVario ingresoVario);
	
	void delete(IngresoVario ingresoVario);
	
	IngresoVario getIngresoVario(Long id);

	List<IngresoVario> loadAllIngresoVario();
	
	List<IngresoVario> findByCriteria(Date fechaDesde,Date fechaHasta,String nombre,String observaciones,Usuario usuario,TipoIngresoVario tipoIngresoVario);

}
