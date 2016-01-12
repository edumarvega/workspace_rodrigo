package ar.com.templateit.cds.web.entity;

import java.io.Serializable;

public class Proveedor implements Serializable {

	private static final long serialVersionUID = -4778163111195296514L;

	private Long id;
	private Long cuit;
	private String nombreRazonSocial;
	private String telefono;
	private String celular;
	private String fax;
	private String domicilio;
	private String numero;
	private String piso;
	private String dpto;
	private String localidadPartido;
	private String codigoPostal;
	private Provincia provincia;
	private String email;
	private String paginaWeb;
	private String direccionFacebook;
	private String direccionTwitter;
	private String observaciones;
	
	public Proveedor(){
		
	}
	
	public Proveedor(Long cuit,String nombreRazonSocial,String telefono,String celular,
		   String fax,String domicilio,String numero,String piso,String dpto,String localidadPartido,
		   String codigoPostal,Provincia provincia,String email,String paginaWeb,
		   String direccionFacebook,String direccionTwitter,String observaciones){
		this.cuit = cuit;
		this.nombreRazonSocial = nombreRazonSocial;
		this.telefono= telefono;
		this.celular = celular;
		this.fax = fax;
		this.domicilio = domicilio;
		this.numero = numero;
		this.piso = piso;
		this.dpto = dpto;
		this.localidadPartido = localidadPartido;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.email =email;
		this.paginaWeb =paginaWeb;
		this.direccionFacebook = direccionFacebook;
		this.direccionTwitter = direccionTwitter;
		this.observaciones = observaciones;
			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}

	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getLocalidadPartido() {
		return localidadPartido;
	}

	public void setLocalidadPartido(String localidadPartido) {
		this.localidadPartido = localidadPartido;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getDireccionFacebook() {
		return direccionFacebook;
	}

	public void setDireccionFacebook(String direccionFacebook) {
		this.direccionFacebook = direccionFacebook;
	}

	public String getDireccionTwitter() {
		return direccionTwitter;
	}

	public void setDireccionTwitter(String direccionTwitter) {
		this.direccionTwitter = direccionTwitter;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
