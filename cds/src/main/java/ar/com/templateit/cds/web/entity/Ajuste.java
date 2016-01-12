package ar.com.templateit.cds.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Silvina Yarbi
 *
 */
public class Ajuste implements Serializable {

	private static final long serialVersionUID = 8018618483227408175L;
	private Long id;
	private Date fechaAjuste;
	private Long codigo;
	private String nombre;
	private String descripcion;
	private String marca;
	private Integer cantidadConAjuste;
	private Integer cantidadSinAjuste;
	private MotivoAjuste motivoAjuste;
	private Usuario usuario;
	
	public Ajuste(){
	}
	
	public Ajuste(Long id,Date fechaAjuste,Long codigo,String nombre,
		              String descripcion,String marca,Integer cantidadConAjuste,
		              Integer cantidadSinAjuste,MotivoAjuste motivoAjuste,
		              Usuario usuario){
		this.id = id;
		this.fechaAjuste = fechaAjuste;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.cantidadConAjuste = cantidadConAjuste;
		this.cantidadSinAjuste = cantidadSinAjuste;
		this.motivoAjuste = motivoAjuste;
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ajuste other = (Ajuste) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Date getFechaAjuste() {
		return fechaAjuste;
	}

	public void setFechaAjuste(Date fechaAjuste) {
		this.fechaAjuste = fechaAjuste;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getCantidadConAjuste() {
		return cantidadConAjuste;
	}

	public void setCantidadConAjuste(Integer cantidadConAjuste) {
		this.cantidadConAjuste = cantidadConAjuste;
	}

	public Integer getCantidadSinAjuste() {
		return cantidadSinAjuste;
	}

	public void setCantidadSinAjuste(Integer cantidadSinAjuste) {
		this.cantidadSinAjuste = cantidadSinAjuste;
	}

	public MotivoAjuste getMotivoAjuste() {
		return motivoAjuste;
	}

	public void setMotivoAjuste(MotivoAjuste motivoAjuste) {
		this.motivoAjuste = motivoAjuste;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
