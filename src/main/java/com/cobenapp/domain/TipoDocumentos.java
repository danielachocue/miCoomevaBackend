package com.cobenapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento", schema="public")
public class TipoDocumentos implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="idTipo", unique=true, nullable=false)
	private Integer idTipo;
	
	@Column(name="tipo", nullable=false)
	private String tipo;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="tipo_documento")
	private List<Asociados> asociados = new ArrayList<Asociados>(0);


	public TipoDocumentos(Integer idTipo, String tipo, List<Asociados> asociados) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
		this.asociados = asociados;
	}
	
	public TipoDocumentos() {
		
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

	public List<Asociados> getAsociados() {
		return asociados;
	}

	public void setAsociados(List<Asociados> asociados) {
		this.asociados = asociados;
	}
	
	
	
	
	
	
	
	
}
