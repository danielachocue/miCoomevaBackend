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
@Table(name="proveedores", schema="public")
public class Proveedores implements java.io.Serializable{

	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idProvd", unique=true,nullable=false)
	private Integer idProvd;
	
	@Column(name="proveedor", nullable=false)
	private String proveedor;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "proveedores")
	private List<Beneficios> beneficios = new ArrayList<Beneficios>(0);

	public Proveedores() {
		
	}
	
	
	public Proveedores(Integer idProvd, String proveedor, List<Beneficios> beneficios) {
		super();
		this.idProvd = idProvd;
		this.proveedor = proveedor;
		this.beneficios = beneficios;
	}

	public Integer getIdProvd() {
		return idProvd;
	}

	public void setIdProvd(Integer idProvd) {
		this.idProvd = idProvd;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public List<Beneficios> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficios> beneficios) {
		this.beneficios = beneficios;
	}
	
	
	
	
	
	
}	



