package ar.com.templateit.cds.web.action;

import java.util.List;

import ar.com.templateit.cds.web.bo.AlertaBO;
import ar.com.templateit.cds.web.entity.Alerta;

import com.opensymphony.xwork2.ActionSupport;

public class AlertaProductoAction extends ActionSupport{

	private static final long serialVersionUID = -2238039865024603936L;
	private List<Alerta> alertas;
	private AlertaBO alertaBO;
	String mostrar;
	
	
	public String alertaProducto(){
		return "alertaProducto";
	}
	
	public String loadAlertaProducto(){
		this.alertas = this.loadAlertas();
		return "loadAlertaProducto";
	}
	
	public String verificarAlertas(){
		this.mostrar = "no";
		List<Alerta> listaAlertas = this.loadAlertas();
		if(listaAlertas!=null){
			if(!listaAlertas.isEmpty()){
				this.mostrar = "si";
			}
		}
		return SUCCESS;
	}
	
	private List<Alerta> loadAlertas(){
		List<Alerta> listaAlertas = this.alertaBO.loadAllAlerta();
		return listaAlertas;
	}

	public List<Alerta> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<Alerta> alertas) {
		this.alertas = alertas;
	}
		
	public String getMostrar() {
		return mostrar;
	}

	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	public void setAlertaBO(AlertaBO alertaBO) {
		this.alertaBO = alertaBO;
	}
	
	
	
	

}
