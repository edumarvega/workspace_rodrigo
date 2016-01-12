package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Estadistica implements Serializable{

	private static final long serialVersionUID = -5971396102774529257L;
	private Long id;
	private String etiqueta;
	private BigDecimal valor;
	
	public Estadistica(){
	}
	
	public Estadistica(String etiqueta,BigDecimal valor){
	
		this.etiqueta = etiqueta;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
