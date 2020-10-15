package com.cobenapp.dto;


public class TipoDocumentosDTO {
	
	
	
	private Integer idTipo;
	
	private String tipo;

	public TipoDocumentosDTO(Integer idTipo, String tipo) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
	}
	
	public TipoDocumentosDTO() {
		
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
