package ar.com.templateit.cds.web.dao;

import java.util.Date;
import java.util.List;

public interface EstadisticaVentaDAO {
	
	List<Object> getVentasByProducto(Date fechaDesde,Date fechaHasta);
	
	List<Object> getVentasByCategoria(Date fechaDesde,Date fechaHasta);

}
