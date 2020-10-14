package com.cobenapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ubicacion_beneficio", schema="public")
public class UbicacionBeneficios implements java.io.Serializable{

	
	
	private final static long serialVersionUID=1L;
	
	
	@Id
	@Column(name="idub", unique=true,nullable=false)
	private Integer idUb;
	
	
	@Column(name="latitud" , nullable=false)
	private String latitud;
	
	@Column(name="longitud" , nullable=false)
	private String longitud;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idbeneficio")
	private Beneficios beneficios;
	
	public UbicacionBeneficios() {
		
	}

	public UbicacionBeneficios(Integer idUb, String latitud, String longitud, Beneficios beneficios) {
		super();
		this.idUb = idUb;
		this.latitud = latitud;
		this.longitud = longitud;
		this.beneficios = beneficios;
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

	public Beneficios getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Beneficios beneficios) {
		this.beneficios = beneficios;
	}


	
	
	
	
	
}
