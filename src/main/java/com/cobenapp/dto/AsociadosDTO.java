package com.cobenapp.dto;


public class AsociadosDTO {

	
	private String documento;
	
	
	private String nickname;
	

	private String nombre;


	private String apellido;
	
	private String contrasena;


	private String telefono;
	

	private String puntos;
	
	public AsociadosDTO() {
		
	}
	public AsociadosDTO(String documento, String nickname, String nombre, String apellido, String contrasena,
			String telefono, String puntos) {
		super();
		this.documento = documento;
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.puntos = puntos;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPuntos() {
		return puntos;
	}
	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}


	
	
	
}
