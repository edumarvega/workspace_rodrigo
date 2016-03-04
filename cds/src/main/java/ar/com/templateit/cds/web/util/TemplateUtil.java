package ar.com.templateit.cds.web.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.com.templateit.cds.web.entity.Categoria;
import ar.com.templateit.cds.web.entity.Estadistica;
import ar.com.templateit.cds.web.entity.MotivoAjuste;
import ar.com.templateit.cds.web.entity.Producto;

public class TemplateUtil {
	
	public static final String EXTENSION_ARCHIVO = ".sql";
	
	public static Long generarId() {
		int numeroAleatorio = (int) (Math.random() * 100.0D + 1.0D);
		return Long.valueOf(Long.parseLong(String.valueOf(numeroAleatorio)));
	}

	public static List<Producto> getProductosMock() {
		Producto Producto1 = new Producto();
		Producto1.setId(generarId());
		Producto1.setCodigo(new Long(1111111111111L));
		Producto1.setNombre("Leche");
		Producto1.setDescripcion("Leche entera x 1lt");
		Producto1.setMarca("Sancor");
		Producto1.setCategoria((Categoria) getCategoriasMock().get(
				3));

		Producto Producto2 = new Producto();
		Producto2.setId(generarId());
		Producto2.setCodigo(new Long(2222222222222L));
		Producto2.setNombre("Gaseosa");
		Producto2.setDescripcion("Gaseosa light x 1lt.");
		Producto2.setMarca("Coca-Cola");
		Producto2.setCategoria((Categoria) getCategoriasMock().get(
				1));

		Producto Producto3 = new Producto();
		Producto3.setId(generarId());
		Producto3.setCodigo(new Long(3333333333333L));
		Producto3.setNombre("Pan");
		Producto3.setDescripcion("Pan lactal x 24uni.");
		Producto3.setMarca("Bimbo");
		Producto3.setCategoria((Categoria) getCategoriasMock().get(
				5));

		Producto Producto4 = new Producto();
		Producto4.setId(generarId());
		Producto4.setCodigo(new Long(4444444444444L));
		Producto4.setNombre("Queso");
		Producto4.setDescripcion("Queso cremoso x 1kg");
		Producto4.setMarca("La Serenisima");
		Producto4.setCategoria((Categoria) getCategoriasMock().get(
				3));

		Producto Producto5 = new Producto();
		Producto5.setId(generarId());
		Producto5.setCodigo(new Long(5555555555555L));
		Producto5.setNombre("Huevo");
		Producto5.setDescripcion("Maple de huevos x 36 uni.");
		Producto5.setMarca("La granja");
		Producto5.setCategoria((Categoria) getCategoriasMock().get(
				0));

		Producto Producto6 = new Producto();
		Producto6.setId(generarId());
		Producto6.setCodigo(new Long(6666666666666L));
		Producto6.setNombre("Detergente");
		Producto6.setDescripcion("Detergente magistral x 250 ml.");
		Producto6.setMarca("Magistral");
		Producto6.setCategoria((Categoria) getCategoriasMock().get(
				4));

		List<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(Producto1);
		listaProductos.add(Producto2);
		listaProductos.add(Producto3);
		listaProductos.add(Producto4);
		listaProductos.add(Producto5);
		listaProductos.add(Producto6);

		return listaProductos;
	}

	public static List<Categoria> getCategoriasMock() {
		Categoria categoria1 = new Categoria();
		categoria1.setId(Long.valueOf(0));
		categoria1.setNombre("ALMACEN");

		Categoria categoria2 = new Categoria();
		categoria2.setId(Long.valueOf(1));
		categoria2.setNombre("BEBIDAS");

		Categoria categoria3 = new Categoria();
		categoria3.setId(Long.valueOf(2));
		categoria3.setNombre("CARNES Y PROCESADOS");

		Categoria categoria4 = new Categoria();
		categoria4.setId(Long.valueOf(3));
		categoria4.setNombre("LACTEOS");

		Categoria categoria5 = new Categoria();
		categoria5.setId(Long.valueOf(4));
		categoria5.setNombre("LIMPIEZA");

		Categoria categoria6 = new Categoria();
		categoria6.setId(Long.valueOf(5));
		categoria6.setNombre("PANIFICADOS");

		Categoria categoria7 = new Categoria();
		categoria7.setId(Long.valueOf(6));
		categoria7.setNombre("PERFUMERIA");

		Categoria categoria8 = new Categoria();
		categoria8.setId(Long.valueOf(7));
		categoria8.setNombre("VERDULERIA");

		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias.add(categoria1);
		listaCategorias.add(categoria2);
		listaCategorias.add(categoria3);
		listaCategorias.add(categoria4);
		listaCategorias.add(categoria5);
		listaCategorias.add(categoria6);
		listaCategorias.add(categoria7);
		listaCategorias.add(categoria8);

		return listaCategorias;
	}
	
	public static List<MotivoAjuste> getMotivosMock() {
		
		MotivoAjuste motivo1 = new MotivoAjuste(1L, "VENTA");
		MotivoAjuste motivo2 = new MotivoAjuste(2L, "ROBO");
		MotivoAjuste motivo3 = new MotivoAjuste(3L, "RUPTURA");
		MotivoAjuste motivo4 = new MotivoAjuste(4L, "ERROR DE CARGA");
		MotivoAjuste motivo5 = new MotivoAjuste(5L, "NO IDENTIFICADO");
		MotivoAjuste motivo6 = new MotivoAjuste(6L, "DONACION");
		MotivoAjuste motivo7 = new MotivoAjuste(7L, "CONSUMO PERSONAL");
		
		List<MotivoAjuste> listaMotivos = new ArrayList<MotivoAjuste>();
		listaMotivos.add(motivo1);
		listaMotivos.add(motivo2);
		listaMotivos.add(motivo3);
		listaMotivos.add(motivo4);
		listaMotivos.add(motivo5);
		listaMotivos.add(motivo6);
		listaMotivos.add(motivo7);
		
		return listaMotivos;
	}
	
	public Integer calcularCantidad(Integer cantidadActual,Integer cantidadNueva){
		int valorActual;
		if(cantidadActual==null){
			valorActual = 0;
		}
		else{
			valorActual = cantidadActual;
		}
		int  valorTmp = valorActual + cantidadNueva.intValue();
		return new Integer(valorTmp);
	}
	
	public Integer decrementarStockActual(Integer cantidadActual,Integer cantidadQuitar){
		int valorActual;
		if(cantidadActual==null){
			valorActual = 0;
		}
		else{
			valorActual = cantidadActual;
		}
		int  valorTmp = valorActual - cantidadQuitar.intValue();
		return new Integer(valorTmp);
	}
	
	public List<Estadistica> transformObjectProductoToEstadistica(List<Object> lista){
		List<Estadistica> estadisticas = new ArrayList<Estadistica>();
		for(int i=0; i<lista.size();i++){
			Object[] object= (Object[])lista.get(i);
						
			Estadistica estadistica = new Estadistica();
			estadistica.setEtiqueta((String)object[1]);
			estadistica.setValor((BigDecimal)object[2]);
			
			estadisticas.add(estadistica);
		}
		return estadisticas;
	}
	
	public List<Estadistica> transformObjectCategoriaToEstadistica(List<Object> lista){
		List<Estadistica> estadisticas = new ArrayList<Estadistica>();
		for(int i=0; i<lista.size();i++){
			Object[] object= (Object[])lista.get(i);
						
			Estadistica estadistica = new Estadistica();
			estadistica.setEtiqueta((String)object[0]);
			estadistica.setValor((BigDecimal)object[2]);
			
			estadisticas.add(estadistica);
		}
		return estadisticas;
	}
	
	public Boolean verificarStockCritico(Integer cantidadActual,Integer stockCritico){
		Boolean respuesta = Boolean.FALSE;
		if(cantidadActual.intValue()<=stockCritico){
			respuesta = Boolean.TRUE;
		}
		return respuesta;
	}
	
	public String encriptarPassword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
	public String generarNombreArchivo(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String format = formatter.format(date);
		String nombreArchivo = format+EXTENSION_ARCHIVO;
		return nombreArchivo;
	}


}
