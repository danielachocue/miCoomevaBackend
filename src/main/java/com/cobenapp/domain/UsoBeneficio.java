package com.cobenapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="uso_beneficio", schema="public")
public class UsoBeneficio implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="iduso", nullable=false,unique=true)
	private Integer idUso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="documento")
	private Asociados asociado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idbeneficio")
	private Beneficios beneficios;
	
	@Column(name="fechauso", nullable=false)
	private Date fechaUso;
	
	
	
	public UsoBeneficio() {
		
	}



	public UsoBeneficio(Integer idUso, Asociados asociado, Beneficios beneficios, Date fechaUso) {
		super();
		this.idUso = idUso;
		this.asociado = asociado;
		this.beneficios = beneficios;
		this.fechaUso = fechaUso;
	}



	public Integer getIdUso() {
		return idUso;
	}



	public void setIdUso(Integer idUso) {
		this.idUso = idUso;
	}



	public Asociados getAsociado() {
		return asociado;
	}



	public void setAsociado(Asociados asociado) {
		this.asociado = asociado;
	}



	public Beneficios getBeneficios() {
		return beneficios;
	}



	public void setBeneficios(Beneficios beneficios) {
		this.beneficios = beneficios;
	}



	public Date getFechaUso() {
		return fechaUso;
	}



	public void setFechaUso(Date fechaUso) {
		this.fechaUso = fechaUso;
	}



	
	
	
}
