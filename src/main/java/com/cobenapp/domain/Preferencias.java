package com.cobenapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="preferencias", schema="public")
public class Preferencias implements java.io.Serializable{
	
	private final static long serialVersionUID=1L;
	
	@Id
	@Column(name="idprfcs" , unique=true, nullable=false)
	private Integer idprdfcs;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="documento")
	private Asociados asociados;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idbeneficio")
	private Beneficios beneficios;
	
	
	
	public Preferencias() {
		
	
	}



	public Preferencias(Integer idprdfcs, Asociados asociados, Beneficios beneficios) {
		super();
		this.idprdfcs = idprdfcs;
		this.asociados = asociados;
		this.beneficios = beneficios;
	}



	public Integer getIdprdfcs() {
		return idprdfcs;
	}



	public void setIdprdfcs(Integer idprdfcs) {
		this.idprdfcs = idprdfcs;
	}



	public Asociados getAsociados() {
		return asociados;
	}



	public void setAsociados(Asociados asociados) {
		this.asociados = asociados;
	}



	public Beneficios getBeneficios() {
		return beneficios;
	}



	public void setBeneficios(Beneficios beneficios) {
		this.beneficios = beneficios;
	}
	
	
	
	
}
