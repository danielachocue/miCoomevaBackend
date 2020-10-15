package com.cobenapp.dto;


public class BeneficiosDTO {

	
	private Integer idBeneficio;

	private String beneficio;
	
	
	public BeneficiosDTO() {
		
	}

	

	public BeneficiosDTO(Integer idBeneficio, String beneficio) {
		super();
		this.idBeneficio = idBeneficio;
		this.beneficio = beneficio;
	}



	public Integer getIdBeneficio() {
		return idBeneficio;
	}


	public void setIdBeneficio(Integer idBeneficio) {
		this.idBeneficio = idBeneficio;
	}


	public String getBeneficio() {
		return beneficio;
	}


	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	
	
	
	
}
