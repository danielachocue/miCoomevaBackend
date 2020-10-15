package com.cobenapp.dto;


public class UbicacionBeneficiosDTO {

	
	private Integer idUb;
	

	private String latitud;
	
	private String longitud;

	public UbicacionBeneficiosDTO(Integer idUb, String latitud, String longitud) {
		super();
		this.idUb = idUb;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	
	public UbicacionBeneficiosDTO() {
		
	}


	public Integer getIdUb() {
		return idUb;
	}


	public void setIdUb(Integer idUb) {
		this.idUb = idUb;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	
	
	
}
