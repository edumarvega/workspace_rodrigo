package ar.com.templateit.cds.web.bo;

import java.util.Date;
import java.util.List;

public interface EstadisticaVentaBO {
	
	List<Object> getVentasByProducto(Date fechaDesde,Date fechaHasta);
	
	List<Object> getVentasByCategoria(Date fechaDesde,Date fechaHasta);

}
