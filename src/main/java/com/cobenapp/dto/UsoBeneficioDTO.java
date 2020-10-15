package com.cobenapp.dto;

import java.util.Date;

public class UsoBeneficioDTO {

	private Integer idUso;
	
	private Date fechaUso;
	
	public UsoBeneficioDTO() {
		
	}

	public UsoBeneficioDTO(Integer idUso, Date fechaUso) {
		super();
		this.idUso = idUso;
		this.fechaUso = fechaUso;
	}

	public Integer getIdUso() {
		return idUso;
	}

	public void setIdUso(Integer idUso) {
		this.idUso = idUso;
	}

	public Date getFechaUso() {
		return fechaUso;
	}

	public void setFechaUso(Date fechaUso) {
		this.fechaUso = fechaUso;
	}
	
	
	
	
}
