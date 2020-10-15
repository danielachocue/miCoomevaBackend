package com.cobenapp.dto;



public class ProveedoresDTO {

	
	private Integer idProvd;
	
	private String proveedor;
	
	public ProveedoresDTO() {
		
	}

	public ProveedoresDTO(Integer idProvd, String proveedor) {
		super();
		this.idProvd = idProvd;
		this.proveedor = proveedor;
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
	
	
	
	
}
