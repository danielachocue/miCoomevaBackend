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
@Table(name="categoria_beneficio", schema="public")
public class CategoriaBeneficios implements java.io.Serializable{

	
	private final static long serialVersionUID=1L; 
	
	@Id
	@Column(name="idCat", unique=true, nullable=false)
	private Integer idCat;
	
	@Column(name="categoria", nullable=false)
	private String categoria;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria_beneficio")
	private List<Beneficios> beneficios = new ArrayList<Beneficios>(0);
	
	
	public CategoriaBeneficios() {
		
	}


	public CategoriaBeneficios(Integer idCat, String categoria, List<Beneficios> beneficios) {
		super();
		this.idCat = idCat;
		this.categoria = categoria;
		this.beneficios = beneficios;
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


	public List<Beneficios> getBeneficios() {
		return beneficios;
	}


	public void setBeneficios(List<Beneficios> beneficios) {
		this.beneficios = beneficios;
	}
	
	
	
	
}
