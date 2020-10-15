package com.cobenapp.dto;


public class CategoriaBeneficiosDTO {

	private Integer idCat;
	
	private String categoria;

	public CategoriaBeneficiosDTO() {
		
	}
	
	
	
	public CategoriaBeneficiosDTO(Integer idCat, String categoria) {
		super();
		this.idCat = idCat;
		this.categoria = categoria;
	}



	public Integer getIdCat() {
		return idCat;
	}

	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
}
