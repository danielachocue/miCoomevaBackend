package com.cobenapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="beneficios", schema="public")
public class Beneficios implements java.io.Serializable{

	
	private final static long serialVersionUID=1L;
	
	@Id
	@Column(name="idbeneficio", unique=true, nullable=false)
	private Integer idBeneficio;
	
	@Column(name="beneficio", unique=true, nullable=false)
	private String beneficio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idprovd")
	private Proveedores proveedores;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcat")
	private CategoriaBeneficios categoriaBeneficio;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficios")
	private List<Preferencias> preferencias = new ArrayList<Preferencias>(0);

	
	public Beneficios() {
		
	}


	public Beneficios(Integer idBeneficio, String beneficio, Proveedores proveedores,
			CategoriaBeneficios categoriaBeneficio, List<Preferencias> preferencias) {
		super();
		this.idBeneficio = idBeneficio;
		this.beneficio = beneficio;
		this.proveedores = proveedores;
		this.categoriaBeneficio = categoriaBeneficio;
		this.preferencias = preferencias;
	}


	public Integer getidBeneficio() {
		return idBeneficio;
	}


	public void setidBeneficio(Integer iBeneficio) {
		this.idBeneficio = iBeneficio;
	}


	public String getBeneficio() {
		return beneficio;
	}


	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}


	public Proveedores getProveedores() {
		return proveedores;
	}


	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}


	public CategoriaBeneficios getCategoriaBeneficio() {
		return categoriaBeneficio;
	}


	public void setCategoriaBeneficio(CategoriaBeneficios categoriaBeneficio) {
		this.categoriaBeneficio = categoriaBeneficio;
	}


	public List<Preferencias> getPreferencias() {
		return preferencias;
	}


	public void setPreferencias(List<Preferencias> preferencias) {
		this.preferencias = preferencias;
	}

	
	
	
	
}
